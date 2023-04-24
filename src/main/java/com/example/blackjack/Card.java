package com.example.blackjack;

public class Card {

    private final String card;

    private final int cardValue;

    private static String cardTail;
    private static String cardHead;
    private static String cardBody;

    private final static String[] CARDSHEAD = {"K", "P", "C", "H"};

    private final static String[] CARDSTAIL = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Card() {
        cardTail = CARDSTAIL[(int)(Math.random() * CARDSTAIL.length)];
        cardHead = CARDSHEAD[(int)(Math.random() * CARDSHEAD.length)];
        cardBody = cardHead + " " + cardTail;
        int cardValueT;
        cardBody = create(cardBody);
        if (cardTail.equals("J") ||
                cardTail.equals("Q") ||
                    cardTail.equals("K")) {
            cardValueT = 10;
        } else if (cardTail.equals("A") && Controller.cardsCountedValue + 11 > 21) {
            cardValueT = 1;
        } else if (cardTail.equals("A") && Controller.cardsCountedValue + 11 < 21) {
            cardValueT = 11;
        } else {
            cardValueT = Integer.parseInt(cardTail);
        }
        this.card = cardBody;
        this.cardValue = cardValueT;
    }

    public static String create(String s) {
        for (Card c : Controller.cards) {
            if (c.getName().equals(s)) {
                cardTail = CARDSTAIL[(int)(Math.random() * CARDSTAIL.length)];
                cardHead = CARDSHEAD[(int)(Math.random() * CARDSHEAD.length)];
                cardBody = cardHead + " " + cardTail;
                create(cardBody);
            }
        }
        for (Card d : Controller.cardsDealer) {
            if (d.getName().equals(s)) {
                cardTail = CARDSTAIL[(int)(Math.random() * CARDSTAIL.length)];
                cardHead = CARDSHEAD[(int)(Math.random() * CARDSHEAD.length)];
                cardBody = cardHead + " " + cardTail;
                create(cardBody);
            }
        }
        return cardBody;
    }

    public int getValue() {
        return this.cardValue;
    }

    public String getName() {
        return this.card;
    }
}
