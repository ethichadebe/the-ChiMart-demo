package com.example.chillersmarket.RecyclewViewItems;

public class MallItem {
    private String strPreview, strPrice, strHeading, strSeller;

    public MallItem(String strPreview, String strPrice, String strHeading, String strSeller) {
        this.strPreview = strPreview;
        this.strPrice = strPrice;
        this.strHeading = strHeading;
        this.strSeller = strSeller;
    }

    public String getStrHeading() {
        return strHeading;
    }

    public String getStrPreview() {
        return strPreview;
    }

    public String getStrPrice() {
        return strPrice;
    }

    public String getStrSeller() {
        return strSeller;
    }

    public void setStrPreview(String strPreview) {
        this.strPreview = strPreview;
    }

    public void setStrHeading(String strHeading) {
        this.strHeading = strHeading;
    }

    public void setStrPrice(String strPrice) {
        this.strPrice = strPrice;
    }

    public void setStrSeller(String strSeller) {
        this.strSeller = strSeller;
    }
}
