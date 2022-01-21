package com.example.chillersmarket.RecyclewViewItems;

public class CartItem {
    private String strIcon, strName, strSeller, strPrice;
    private int intQuantity;

    public CartItem(String strIcon, String strName, String strSeller, String strPrice, int intQuantity) {
        this.strIcon = strIcon;
        this.strName = strName;
        this.strSeller = strSeller;
        this.strPrice = strPrice;
        this.intQuantity = intQuantity;
    }

    public String getStrIcon() {
        return strIcon;
    }

    public void setStrIcon(String strIcon) {
        this.strIcon = strIcon;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrSeller() {
        return strSeller;
    }

    public void setStrSeller(String strSeller) {
        this.strSeller = strSeller;
    }

    public String getStrPrice() {
        return strPrice;
    }

    public void setStrPrice(String strPrice) {
        this.strPrice = strPrice;
    }

    public int getIntQuantity() {
        return intQuantity;
    }

    public void setIntQuantity(int intQuantity) {
        this.intQuantity = intQuantity;
    }
}
