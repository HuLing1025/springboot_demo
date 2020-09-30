package com.example.demo.pojo;

public class Suggest {
    private int suggestId;          // 建议id
    private String suggestContact;  // 联系方式
    private String suggestView;     // 建议内容
    private int suggestTime;        // 建议提交时间

    public int getSuggestId() {
        return suggestId;
    }

    public void setSuggestId(int id) {
        this.suggestId = id;
    }

    public String getSuggestContact() {
        return suggestContact;
    }

    public void setSuggestContact(String suggestContact) {
        this.suggestContact = suggestContact;
    }

    public String getSuggestView() {
        return suggestView;
    }

    public void setSuggestView(String suggestView) {
        this.suggestView = suggestView;
    }

    public int getSuggestTime() {
        return suggestTime;
    }

    public void setSuggestTime(int suggestTime) {
        this.suggestTime = suggestTime;
    }
}
