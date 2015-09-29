package com.pure.lpedia;


public class Item_CardList_Snow {

    private String CardTitle;
    private String CardName;

    public Item_CardList_Snow(String CardTitle, String CardName) {
        super();
        this.CardTitle = CardTitle;
        this.CardName = CardName;
    }

    public String getCardTitle() {
        return CardTitle;
    }

    public void setCardTitle(String cardTitle) {
        CardTitle = cardTitle;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }
}
