package com.pure.lpedia;


public class Item_CardList_Snow {

    private String CardTitle;
    private String CardName;
    private String CardDate;

    public Item_CardList_Snow(String CardTitle, String CardName, String CardDate) {
        super();
        this.CardTitle = CardTitle;
        this.CardName = CardName;
        this.CardDate = CardDate;
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

    public String getCardDate() {
        return CardDate;
    }

    public void setCardDate(String cardDate) {
        CardDate = cardDate;
    }
}
