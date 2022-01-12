package com.example.chillersmarket.RecyclewViewItems;

public class ReviewItem {
    private String strIcon, strName, strDate, strReview;

    public ReviewItem(String strIcon, String strName, String strDate, String strReview) {
        this.strIcon = strIcon;
        this.strName = strName;
        this.strDate = strDate;
        this.strReview = strReview;
    }

    public String getStrIcon() {
        return strIcon;
    }

    public String getStrName() {
        return strName;
    }

    public String getStrDate() {
        return strDate;
    }

    public String getStrReview() {
        return strReview;
    }

    public void setStrIcon(String strIcon) {
        this.strIcon = strIcon;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public void setStrReview(String strReview) {
        this.strReview = strReview;
    }
}
