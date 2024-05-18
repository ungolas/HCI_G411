package com.example.m3;

public class Termin {
    private String doctorName;
    private String serviceTags;
    private String date;
    private String time;
    private String address;
    private String contact;

    public Termin(String doctorName, String serviceTags, String date, String time, String address, String contact) {
        this.doctorName = doctorName;
        this.serviceTags = serviceTags;
        this.date = date;
        this.time = time;
        this.address = address;
        this.contact = contact;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getServiceTags() {
        return serviceTags;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }
}
