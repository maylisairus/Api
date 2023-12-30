package org.example;

public class User {
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;

    public User(String name, String username, String email, String phone, String website, Address address, Company company) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.address = address;
        this.company = company;
    }
}
