package watch.entity;
// Generated Nov 4, 2020 2:35:06 PM by Hibernate Tools 4.3.1


import java.io.Serializable;

/**
 * Images generated by hbm2java
 */
public class Images  implements java.io.Serializable {


     private int imageId;
     private Product product;
     private String imageLink;

    public Images() {
    }

	
    public Images(int imageId) {
        this.imageId = imageId;
    }
    public Images(int imageId, Product product, String imageLink) {
       this.imageId = imageId;
       this.product = product;
       this.imageLink = imageLink;
    }
   
    public int getImageId() {
        return this.imageId;
    }
    
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public String getImageLink() {
        return this.imageLink;
    }
    
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }




}


