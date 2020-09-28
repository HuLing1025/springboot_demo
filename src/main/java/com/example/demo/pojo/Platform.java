package com.example.demo.pojo;

public class Platform {
    private int id;                 // 直播平台id
    private String livePlatformImg; // 直播平台图标
    private String livePlatform;    // 直播平台名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLivePlatformImg() {
        return livePlatformImg;
    }

    public void setLivePlatformImg(String livePlatformImg) {
        this.livePlatformImg = livePlatformImg;
    }

    public String getLivePlatform() {
        return livePlatform;
    }

    public void setLivePlatform(String livePlatform) {
        this.livePlatform = livePlatform;
    }
}
