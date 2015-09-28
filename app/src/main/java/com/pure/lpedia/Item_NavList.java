package com.pure.lpedia;

public class Item_NavList {

    private String title;
    private int resIcon;

    public Item_NavList(String title, int resIcon) {
        super();
        this.title = title;
        this.resIcon = resIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }
}
