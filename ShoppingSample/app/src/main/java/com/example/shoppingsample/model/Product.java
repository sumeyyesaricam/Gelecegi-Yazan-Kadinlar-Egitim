package com.example.shoppingsample.model;

public class Product {
    int id;
    int productImage;
    String productName;
    int price;

    public Product(int id, int productImage, int price, String productName) {
        this.id = id;
        this.productImage = productImage;
        this.price = price;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
