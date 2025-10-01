package com.example.demo.dto;

public class UserProfileResponse {
    private Long id;
    private String name;
    private String email;
    private String role;
    private String phoneNumber;
    private String address;
    private String imageUrl;

    public UserProfileResponse(Long id, String name, String email, String role, String phoneNumber, String address, String imageUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.imageUrl = imageUrl;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getImageUrl() { return imageUrl; }
}
