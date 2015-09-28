package com.pure.lpedia;


public class Item_CardList {

    private int CardImage;
    private String CardTitle;
    private String CardSpeaker;
    private String CardContent;

    public Item_CardList(int CardImage, String CardTitle, String CardSpeaker, String CardContent) {
        super();
        this.CardImage = CardImage;
        this.CardTitle = CardTitle;
        this.CardSpeaker = CardSpeaker;
        this.CardContent = CardContent;
    }

    public int getCardImage() {
        return CardImage;
    }

    public void setCardImage(int cardImage) {
        CardImage = cardImage;
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
