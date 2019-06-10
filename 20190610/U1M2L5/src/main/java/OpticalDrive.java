public class OpticalDrive{

    private String brand;
    private String driveLocation;
    private String driveType;
    private String mediaSupported;
    private String maxReadSpeeds;
    private String maxWriteSpeeds;
    private String maxRewriteSpeeds;

    public OpticalDrive(String brand,String driveLocation,String driveType,String mediaSupported,String maxReadSpeeds,String maxWriteSpeeds,String maximumRewriteSpeeds){
        this.brand=brand;
        this.driveLocation=driveLocation;
        this.driveType=driveType;
        this.mediaSupported=mediaSupported;
        this.maxReadSpeeds=maxReadSpeeds;
        this.maxWriteSpeeds=maxWriteSpeeds;
        this.maxRewriteSpeeds=maximumRewriteSpeeds;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDriveLocation() {
        return driveLocation;
    }

    public void setDriveLocation(String driveLocation) {
        this.driveLocation = driveLocation;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getMediaSupported() {
        return mediaSupported;
    }

    public void setMediaSupported(String mediaSupported) {
        this.mediaSupported = mediaSupported;
    }

    public String getMaxReadSpeeds() {
        return maxReadSpeeds;
    }

    public void setMaxReadSpeeds(String maxReadSpeeds) {
        this.maxReadSpeeds = maxReadSpeeds;
    }

    public String getMaxWriteSpeeds() {
        return maxWriteSpeeds;
    }

    public void setMaxWriteSpeeds(String maxWriteSpeeds) {
        this.maxWriteSpeeds = maxWriteSpeeds;
    }

    public String getMaxRewriteSpeeds() {
        return maxRewriteSpeeds;
    }

    public void setMaxRewriteSpeeds(String maxRewriteSpeeds) {
        this.maxRewriteSpeeds = maxRewriteSpeeds;
    }
}
