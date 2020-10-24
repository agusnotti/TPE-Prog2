package Game;

import Strategy.Strategy;

public class Player {

    private String playerName;
    private Deck deck;
    private Strategy strategy;


    public Player(String name, Strategy strategy){
        this.playerName=name;
        deck = new Deck();
        this.strategy=strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    //AGREGA UNA CARTA AL MAZO DEL JUGADOR
    public void addCard(Card c){
            deck.add(c);
    }

    //DEVUELVE LA CARTA EN EL TOPE DEL MAZO
    public Card topCard(){
        return deck.topCard();
    }

    //REMUEVE LA CARTA EN EL TOPE DEL MAZO
    public void removeTopCard(){
        deck.removeCard();
    }

    // DEVUELVE UN ATRIBUTO ALEATOREAMENTE ENTRE LOS POSIBLES DE SU LISTA DE ATRIBUTOS
    public String selectAtribute(Card c){
        return strategy.selectAtribute(c);
    }

    public void shuffle(){
        this.deck.shuffle();
    }

    //DEVUELVE EL TAMAÑO DEL MAZO DEL JUGADOR
    public int getTotalCards() {
        return deck.size();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    //Equals de JUGADOR
    @Override
    public boolean equals(Object o){
        try{
            Player p= (Player) o;
           return p.getPlayerName().toLowerCase().equals(this.playerName.toLowerCase());
        }catch(Exception e){
            return false;
        }
    }
}


