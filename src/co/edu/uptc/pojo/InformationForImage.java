package co.edu.uptc.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InformationForImage {
    @SerializedName("imgBytes")
    private byte[] imgBytes;

    public byte[] getImgBytes() {
        return imgBytes;
    }

    public void setImgBytes(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }
}

