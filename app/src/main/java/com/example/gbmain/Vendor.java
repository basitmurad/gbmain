package com.example.gbmain;

public class Vendor {
    private String adminFcm, email, ownerAccountName, ownerAccountNo, ownerContact, ownerName, ownerShopName, shopAddress, vendorId;

    // Default constructor required for Firebase
    public Vendor() {
    }

    public Vendor(String adminFcm, String email, String ownerAccountName, String ownerAccountNo, String ownerContact,
                  String ownerName, String ownerShopName, String shopAddress, String vendorId) {
        this.adminFcm = adminFcm;
        this.email = email;
        this.ownerAccountName = ownerAccountName;
        this.ownerAccountNo = ownerAccountNo;
        this.ownerContact = ownerContact;
        this.ownerName = ownerName;
        this.ownerShopName = ownerShopName;
        this.shopAddress = shopAddress;
        this.vendorId = vendorId;
    }

    // Getters and Setters
    public String getAdminFcm() {
        return adminFcm;
    }

    public void setAdminFcm(String adminFcm) {
        this.adminFcm = adminFcm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOwnerAccountName() {
        return ownerAccountName;
    }

    public void setOwnerAccountName(String ownerAccountName) {
        this.ownerAccountName = ownerAccountName;
    }

    public String getOwnerAccountNo() {
        return ownerAccountNo;
    }

    public void setOwnerAccountNo(String ownerAccountNo) {
        this.ownerAccountNo = ownerAccountNo;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerShopName() {
        return ownerShopName;
    }

    public void setOwnerShopName(String ownerShopName) {
        this.ownerShopName = ownerShopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }
}
