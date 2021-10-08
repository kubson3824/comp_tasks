package com.kuba.comp.model.task2;

import javax.persistence.*;

@Entity
@Table
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deviceId;
    private int latitude;
    private int longitude;

    public Localisation(String deviceId, int latitude, int longitude) {
        this.deviceId = deviceId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Localisation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
