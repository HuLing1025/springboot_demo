package com.example.demo.pojo;

public class User {
    private int id;
    private String name;
    private String password;
    private String mailbox;
    private String website;
    private long goldconis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getGoldconis() {
        return goldconis;
    }

    public void setGoldconis(long goldconis) {
        this.goldconis = goldconis;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", website='" + website + '\'' +
                ", goldconis=" + goldconis +
                '}';
    }
}
