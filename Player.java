public class Player {

    private String playerName;
    private Deck deck;


    public Player(){
        deck = new Deck();
    }

    public void addCard(Card c){
        deck.add(c);
    }

    public Card topCard(){
        return deck.topCard();
    }

    public void removeTopCard(){
        deck.removeCard();
    }

    public Atribute selectRandomAtribute(Card c){
        int randomNumber= (int)Math.floor(Math.random()*c.getNumberOfAtributes());
        return c.getAtribute(randomNumber);
    }

    public int getTotalCards() {
        return deck.size();
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


