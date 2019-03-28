package example.smyy.recyclersample;

public class Product {
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    private String productName;
    private String productDescription;
    private int imageID;

    public Product(int imageID, String productName, String productDescription) {
        this.imageID = imageID;
        this.productName = productName;
        this.productDescription = productDescription;
    }
}
