import com.fasterxml.jackson.databind.ObjectMapper;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ImagesHostingAPI {
    private static final String URL_ImageHosting_KEY = "cb8d513b1bc35f7f9c126b39d4f5ca66";
    private static final String URL_ImageHosting_API = "https://api.imgbb.com/1/upload";
    private static HttpURLConnection httpURLConnection = null;
    private static File[] arrImages;
    private static List<ResponsePhotoHosting> responsePhotoHostingList = new ArrayList<>();

    public static List<ResponsePhotoHosting> getResponsePhotoHostingList() {
        return responsePhotoHostingList;
    }

    public static File[] getArrImages() {
        return arrImages;
    }

    public void searchImageInResources() {
        File directoryResources = new File("src/main/resources");
        arrImages = directoryResources.listFiles((file, name) -> name.matches("\\w+\\.png"));
        Arrays.sort(arrImages);
    }

    public String imageToBase64(File file) throws IOException {
        BufferedImage img = ImageIO.read(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        baos.flush();
        String encodedImage= Base64.getEncoder().encodeToString(baos.toByteArray());
        baos.close();
        encodedImage = java.net.URLEncoder.encode(encodedImage, "ISO-8859-1");
        return encodedImage;
    }

    public void APIRequest(String imgBase64, String fileName) throws IOException {
        URL url = new URL(URL_ImageHosting_API);
        String urlParameters  = "key=" + URL_ImageHosting_KEY + "&image=" + imgBase64 + "&name=" + fileName.substring(0, fileName.length()-4);
        byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true); // set POST
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.connect();

        try( DataOutputStream wr = new DataOutputStream(  httpURLConnection.getOutputStream())) {
            wr.write( postData );
        }
        for (Map.Entry<String, List<String>> header : httpURLConnection.getHeaderFields().entrySet()) {
            System.out.println(header.getKey() + "=" + header.getValue());
        }
    }

    public String getResponse() throws IOException {
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

    public void parseJSON(String jsonArray) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ResponsePhotoHosting responsePhotoHosting = mapper.readValue(jsonArray, ResponsePhotoHosting.class);
        responsePhotoHostingList.add(responsePhotoHosting);
    }
}

//curl --location --request POST "https://api.imgbb.com/1/upload?expiration=600&key=646b80508c6f5e98a65d3218aefa1c24" --form "image=R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7"