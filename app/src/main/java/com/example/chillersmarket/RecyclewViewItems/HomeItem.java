package com.example.chillersmarket.RecyclewViewItems;

import android.graphics.drawable.Icon;

public class HomeItem {
    private String strRetail;
    private Integer icon;

    public HomeItem(String strRetail, Integer icon) {
        this.strRetail = strRetail;
        this.icon = icon;
    }

    public String getStrRetail() {
        return strRetail;
    }

    public void setStrRetail(String strRetail) {
        this.strRetail = strRetail;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }
}
