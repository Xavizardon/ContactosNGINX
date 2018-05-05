package com.example.deryancruz.contactosnginx;

public class Call {
    private String Name;
    private String Phone;
    private String Type;
    private String Duration;

    public Call(String name, String phone, String type, String duration) {
        Name = name;
        Phone = phone;
        Type = type;
        Duration = duration;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }
}
