package com.pure.lpedia;

public class Item_NavList {

    private String title;
    private String exp;
    private int resIcon;

    public Item_NavList(String title, String exp, int resIcon) {
        super();
        this.title = title;
        this.exp = exp;
        this.resIcon = resIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }
}
