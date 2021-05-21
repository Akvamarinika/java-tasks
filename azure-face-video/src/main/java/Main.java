import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.axet.vget.VGet;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final String URL_VIDEO = "https://www.youtube.com/watch?v=kvcFK7criFc";
    private static final String PATH_SAVE_VIDEO = "src/main/resources";
    private static final String URL_FOR_APIRequest = "https://westeurope.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&recognitionModel=recognition_04&returnRecognitionModel=false&detectionModel=detection_03&faceIdTimeToLive=86400";
    private static HttpURLConnection httpURLConnection = null;
    private static final String KEY = "01f0026ec4bc4880b6b8713dbd581e97";
    private static List<Face> faceCoordinatesList = new ArrayList<>();

    public static void main(String[] args) {
        String urlImage;
        try {
            //downloadVideo();
            splitVideoIntoFrames();
            uploadImagesToHosting();
           for (ResponsePhotoHosting responsePhotoHostingObject : ImagesHostingAPI.getResponsePhotoHostingList()){
               urlImage = responsePhotoHostingObject.getData().getUrl();
               APIRequest();
               uploadJSON(urlImage);
               String json = getResponse();
               System.out.println(json);
               parseJSON(json);
           }

         croppingAnImage();
         File folder = new File("C:\\Users\\Akvamarinika\\IdeaProjects\\java-tasks\\azure-face-video");
            File[] listOfFiles = folder.listFiles((file, name) -> name.matches("\\w+\\.png"));
            imagesToGif( listOfFiles );



        } catch (IOException | FrameGrabber.Exception e) {    //
              e.printStackTrace();
        }

    }

    public static void downloadVideo(){
        try {
            VGet vGet = new VGet(new URL(URL_VIDEO), new File(PATH_SAVE_VIDEO));
            System.out.println("Download video . . .");
            vGet.download();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void splitVideoIntoFrames() throws FrameGrabber.Exception, IOException {
            FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber("src/main/resources/The_Basics_of_Spring_Framework.mp4");
            Java2DFrameConverter bimConverter = new Java2DFrameConverter();
            frameGrabber.start();
            for (int i = 0 ; i < 300; i++) {
                if (i % 15 != 0){
                    frameGrabber.grabImage();
                    continue;
                }
                ImageIO.write(bimConverter.convert(frameGrabber.grabImage()), "png", new File("src/main/resources/" + System.currentTimeMillis() + ".png"));
            }
    }

    public static void uploadImagesToHosting() throws IOException {
        ImagesHostingAPI imagesHostingAPI = new ImagesHostingAPI();
        imagesHostingAPI.searchImageInResources();
        File[] imagesArray = ImagesHostingAPI.getArrImages();
        String json;
        for (File file : imagesArray){
            String encodedImgBase64 = imagesHostingAPI.imageToBase64(file);
            imagesHostingAPI.APIRequest(encodedImgBase64, file.getName());
            json = imagesHostingAPI.getResponse();
            System.out.println(json);
            imagesHostingAPI.parseJSON(json);
            //break;
        }

        //ImagesHostingAPI.getResponsePhotoHostingList().get(0).getData().getUrl();
    }

    public static void APIRequest() throws IOException {
        URL url = new URL(URL_FOR_APIRequest);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true); // set POST
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-type", "application/json");
        httpURLConnection.setRequestProperty("charset", "utf-8");
        httpURLConnection.setRequestProperty("Ocp-Apim-Subscription-Key", KEY);
        httpURLConnection.connect();
    }

    private static void uploadJSON(String urlImage) throws IOException {
        String JSONContent = "{\"url\": \"" + urlImage + "\"}";
        try ( OutputStreamWriter  writer = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8")) {
            writer.write(JSONContent);
            writer.close();

            System.out.println(httpURLConnection.getResponseMessage());
            //for (Map.Entry<String, List<String>> header : httpURLConnection.getHeaderFields().entrySet()) {
           //     System.out.println(header.getKey() + "=" + header.getValue());
           // }
        }
    }

    public static String getResponse() throws IOException {
        InputStream input = httpURLConnection.getInputStream();
        BufferedInputStream bufferIn = new BufferedInputStream(input);
        StringBuilder builder = new StringBuilder();
        byte[] array = new byte[1024];
        int count = bufferIn.read(array);
        while (count > 0){
            builder.append(new String(array, 0, count));
            count = bufferIn.read(array);
        }
        httpURLConnection.disconnect();
        return builder.toString();
    }

    public static void parseJSON(String jsonArray) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Face> faceSpeaker = mapper.readValue(jsonArray, new TypeReference <List <Face>>(){});
        faceCoordinatesList.add(faceSpeaker.get(0));
    }

    public static void croppingAnImage() throws IOException {
        String imgPath;
        String imgFormat;
        File file;
        BufferedImage img;
        BufferedImage dstImg;
        int y;
        int x;
        int width;
        int height;
        int j = 1;
        File[] imagesArray = ImagesHostingAPI.getArrImages();
        for (int i = 0; i < faceCoordinatesList.size(); i++){
            imgPath = imagesArray[i].getAbsolutePath();
            imgFormat = imgPath.substring(imgPath.indexOf(".") + 1);
            file = imagesArray[i];
            img= ImageIO.read(file);
            y =  Integer.parseInt(faceCoordinatesList.get(i).getFaceRectangle().getTop());
            x = Integer.parseInt(faceCoordinatesList.get(i).getFaceRectangle().getLeft());
            width = Integer.parseInt(faceCoordinatesList.get(i).getFaceRectangle().getWidth());
            height = Integer.parseInt(faceCoordinatesList.get(i).getFaceRectangle().getHeight());
            dstImg = img.getSubimage(x - height - 11, y - width/3, (width * 4)-10, (height * 5)-15);
            ImageIO.write(dstImg, imgFormat, new File(file.getName().substring(0, file.getName().length()-4) + j + "." + imgFormat));
            j++;
        }
    }


    public static void imagesToGif(File[] images) throws IOException {
        BufferedImage first = ImageIO.read(images[0]);
        ImageOutputStream output = new FileImageOutputStream(new File("speaker.gif"));
        GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 250, true);

        for (File image : images) {
            BufferedImage next = ImageIO.read(image);
            writer.writeToSequence(next);
        }

        writer.close();
        output.close();
    }








}
