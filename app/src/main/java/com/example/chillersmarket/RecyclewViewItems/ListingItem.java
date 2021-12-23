package com.example.chillersmarket.RecyclewViewItems;

public class ListingItem {
    private String strPreview, strBusinessName, strShrtDescript, strLocation, strNumber,
            strCategory, strStatus;

    public ListingItem(String strPreview, String strBusinessName, String strShrtDescript,
                       String strLocation, String strNumber, String strCategory, String strStatus) {
        this.strPreview = strPreview;
        this.strBusinessName = strBusinessName;
        this.strShrtDescript = strShrtDescript;
        this.strLocation = strLocation;
        this.strNumber = strNumber;
        this.strCategory = strCategory;
        this.strStatus = strStatus;
    }

    public String getStrPreview() {
        return strPreview;
    }

    public void setStrPreview(String strPreview) {
        this.strPreview = strPreview;
    }

    public String getStrBusinessName() {
        return strBusinessName;
    }

    public void setStrBusinessName(String strBusinessName) {
        this.strBusinessName = strBusinessName;
    }

    public String getStrShrtDescript() {
        return strShrtDescript;
    }

    public void setStrShrtDescript(String strShrtDescript) {
        this.strShrtDescript = strShrtDescript;
    }

    public String getStrLocation() {
        return strLocation;
    }

    public void setStrLocation(String strLocation) {
        this.strLocation = strLocation;
    }

    public String getStrNumber() {
        return strNumber;
    }

    public void setStrNumber(String strNumber) {
        this.strNumber = strNumber;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrStatus() {
        return strStatus;
    }

    public void setStrStatus(String strStatus) {
        this.strStatus = strStatus;
    }
}
