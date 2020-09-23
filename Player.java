public class Player {

    private String playerName;
    private Deck deck;
    private int totalCards;


    public Player(){
        deck = new Deck();
        this.totalCards=0;
    }

    public void addCard(Card c){
        deck.add(c);
        totalCards++;
    }




    public Card topCard(){
        return deck.topCard();
    }

    public void removeTopCard(){
        deck.removeCard();
        totalCards--;
    }

    public int getTotalCards() {
        return totalCards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean equals(Object o){
        try{
            Player p= (Player) o;
           return p.getPlayerName().equals(this.playerName);
        }catch(Exception e){
            return false;
        }
    }
}


