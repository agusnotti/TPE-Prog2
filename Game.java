public class Game {
    private Deck deck;
    private Player playerOne;
    private Player playerTwo;
    private Player turn;
    private int maxRounds;
    private int deckSize;

    public Game(Player p1,Player p2){
        deck=new Deck();
        playerOne=p1;
        playerTwo=p2;
        deckSize=20;
        maxRounds=100;
        turn=p1;
    }

    public Game(Player p1,Player p2,int maxRounds){
        deck=new Deck();
        playerOne=p1;
        playerTwo=p2;
        deckSize=20;
        this.maxRounds=maxRounds;
        turn=p1;
    }

    public Game(Player p1,Player p2,int maxRounds,int deckSize){
        deck=new Deck();
        playerOne=p1;
        playerTwo=p2;
        this.deckSize=deckSize;
        this.maxRounds=maxRounds;
        turn=p1;
    }

    public void startGame(){
        LoadDeck();
        distributeDeck();
        play();
    }

    private void play(){
        int i=0;

        while (i<maxRounds && playerOne.getTotalCards()>0 && playerTwo.getTotalCards()>0){
            i++;
            System.out.println("------ Ronda "+i+" ------");
            runRound();
            i++;
        }

        checkWinner(i);

    }

    private void LoadDeck(){
        for(int i=0; i<deckSize;i++){
            String nombre= "Carta Numero: "+String.valueOf(i+1);
            Atribute atribute1=new Atribute("Fuerza",randomValue());
            Atribute atribute2=new Atribute("Agilidad",randomValue());
            Atribute atribute3=new Atribute("Carisma",randomValue());
            Atribute atribute4=new Atribute("Velocidad",randomValue());
            Atribute atribute5=new Atribute("Peso",randomValue());

            Card card= new Card(nombre,atribute1,atribute2,atribute3,atribute4,atribute5);
            deck.add(card);
        }
    }

    private void distributeDeck(){
        for(int i=0;i<deckSize;i++){
            if(i%2==0){
                playerOne.addCard(deck.topCard());
                deck.removeCard();
            }else{
                playerTwo.addCard(deck.topCard());
                deck.removeCard();
            }
        }
    }

    private int randomValue(){
        return (int) (Math.random()*5)+1;
    }

    private void runRound(){
        int atribute= randomValue();
        if(turn.equals(playerOne)){
            System.out.println("El jugador "+playerOne.getPlayerName()+" selecciona competir por el atributo "+playerOne.topCard().selectAtribute(atribute).getName());
            System.out.println("La carta de "+playerOne.getPlayerName()+" es "+playerOne.topCard().getName()+" con "+playerOne.topCard().selectAtribute(atribute).getName()+" "+playerOne.topCard().selectAtribute(atribute).getValue());
            System.out.println("La carta de "+playerTwo.getPlayerName()+" es "+playerTwo.topCard().getName()+" con "+playerTwo.topCard().selectAtribute(atribute).getName()+" "+playerTwo.topCard().selectAtribute(atribute).getValue());
            fight(atribute);

        }else{
            System.out.println("El jugador "+playerTwo.getPlayerName()+" selecciona competir por el atributo "+playerTwo.topCard().selectAtribute(atribute).getName());
            System.out.println("La carta de "+playerOne.getPlayerName()+" es "+playerOne.topCard().getName()+" con "+playerOne.topCard().selectAtribute(atribute).getName()+" "+playerOne.topCard().selectAtribute(atribute).getValue());
            System.out.println("La carta de "+playerTwo.getPlayerName()+" es "+playerTwo.topCard().getName()+" con "+playerTwo.topCard().selectAtribute(atribute).getName()+" "+playerTwo.topCard().selectAtribute(atribute).getValue());
            fight(atribute);

        }

    }

    private void fight(int atribute){
        if(playerOne.topCard().selectAtribute(atribute).getValue()>playerTwo.topCard().selectAtribute(atribute).getValue()){
            playerOne.addCard(playerOne.topCard());
            playerOne.addCard(playerTwo.topCard());
            playerTwo.removeTopCard();
            playerOne.removeTopCard();
            System.out.println("Gana la ronda "+playerOne.getPlayerName());
            System.out.println(playerOne.getPlayerName()+" posee ahora "+playerOne.getTotalCards()+" cartas y "+playerTwo.getPlayerName()+" posee ahora "+playerTwo.getTotalCards()+" cartas");

        }else if(playerOne.topCard().selectAtribute(atribute).getValue()<playerTwo.topCard().selectAtribute(atribute).getValue()){
            playerTwo.addCard(playerTwo.topCard());
            playerTwo.addCard(playerOne.topCard());
            playerOne.removeTopCard();
            playerTwo.removeTopCard();
            System.out.println("Gana la ronda "+playerTwo.getPlayerName());
            System.out.println(playerOne.getPlayerName()+" posee ahora "+playerOne.getTotalCards()+" cartas y "+playerTwo.getPlayerName()+" posee ahora "+playerTwo.getTotalCards()+" cartas");

        }else{
            System.out.println("La ronda fue un empate");
            playerTwo.addCard(playerTwo.topCard());
            playerOne.addCard(playerOne.topCard());
            playerOne.removeTopCard();
            playerTwo.removeTopCard();
            System.out.println(playerOne.getPlayerName()+" posee ahora "+playerOne.getTotalCards()+" cartas y "+playerTwo.getPlayerName()+" posee ahora "+playerTwo.getTotalCards()+" cartas");
        }
    }

    private void checkWinner(int i){
            System.out.println("------ El juego ha terminado ------");
            if(playerOne.getTotalCards()>playerTwo.getTotalCards()){
                System.out.println("El ganador es "+playerOne.getPlayerName()+" !");
            }else{
                if(playerTwo.getTotalCards()> playerOne.getTotalCards()){
                    System.out.println("El ganador es "+playerTwo.getPlayerName()+" !");
                }else {
                    System.out.println("La partida ha finalizado en empate!");
                }
            }

    }



}
