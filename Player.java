public class Player {

    private String playerName;
    private Deck deck;


    public Player(){
        deck = new Deck();
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
    public String selectRandomAtribute(Card c){
        int randomNumber= (int)Math.floor(Math.random()*c.getNumberOfAtributes());
        return c.getAtribute(randomNumber).getName();
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


