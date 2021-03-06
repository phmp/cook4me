package com.cook4me.model;

/**
 * Created by Paweł Proc on 2016-11-29.
 */
public class Offer {

    private Long id;
    private String name;
    private String place;
    private String date;
    private String description;
    private String contact;

    public Offer(String name,
                 String place,
                 String date,
                 String description,
                 String contact) {
        this.name = name;
        this.place = place;
        this.date = date;
        this.description = description;
        this.contact = contact;
    }

    public Offer() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

}