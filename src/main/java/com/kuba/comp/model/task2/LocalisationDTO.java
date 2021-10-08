package com.kuba.comp.model.task2;

public class LocalisationDTO {
    private String deviceId;
    private int latitude;
    private int longitude;


    public LocalisationDTO(String deviceId, int latitude, int longitude) {
        this.deviceId = deviceId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocalisationDTO() {
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
