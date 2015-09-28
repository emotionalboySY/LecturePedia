package com.pure.lpedia;


public class Item_CardList {

    private String CardTitle;
    private String CardSpeaker;
    private String CardContent;

    public Item_CardList(String CardTitle, String CardSpeaker, String CardContent) {
        super();
        this.CardTitle = CardTitle;
        this.CardSpeaker = CardSpeaker;
        this.CardContent = CardContent;
    }

    public String getCardTitle() {
        return CardTitle;
    }

    public void setCardTitle(String cardTitle) {
        CardTitle = cardTitle;
    }

    public String getCardSpeaker() {
        return CardSpeaker;
    }

    public void setCardSpeaker(String cardSpeaker) {
        CardSpeaker = cardSpeaker;
    }

    public String getCardContent() {
        return CardContent;
    }

    public void setCardContent(String cardContent) {
        CardContent = cardContent;
    }
}
