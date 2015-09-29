package com.pure.lpedia;


public class Item_CardList_Ted {

    private String CardTitle;
    private String CardDate;

    public Item_CardList_Ted(String CardTitle, String CardDate) {
        super();
        this.CardTitle = CardTitle;
        this.CardDate = CardDate;
    }

    public String getCardTitle() {
        return CardTitle;
    }

    public void setCardTitle(String cardTitle) {
        CardTitle = cardTitle;
    }

    public String getCardDate() {
        return CardDate;
    }

    public void setCardDate(String cardDate) {
        CardDate = cardDate;
    }
}
