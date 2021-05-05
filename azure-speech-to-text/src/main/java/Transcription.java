import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Transcription {
    private  String recognitionStatus;
    private  String displayText;
    private  String offset;
    private  String duration;

    @JsonProperty("RecognitionStatus")
    public String getRecognitionStatus() {
        return recognitionStatus;
    }

    public void setRecognitionStatus(String name) {
        this.recognitionStatus = recognitionStatus;
    }

    @JsonProperty("DisplayText")
    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayName) {
        this.displayText = displayName;
    }

    @JsonProperty("Offset")
    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    @JsonProperty("Duration")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }



}
