package org.example.Products;
public class Smartphone extends Product {

    protected String vendor;

    public Smartphone(int id, String title, int price, String vendor) {
        super(id, title, price);
        this.vendor = vendor;
    }

//    public String getVendor() {
    //       return vendor;
    //  }

    // public void setVendor(String vendor) {
    //      this.vendor = vendor;
    //  }
}