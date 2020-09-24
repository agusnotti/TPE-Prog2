public class Game {
    private Deck deck;
    private Player playerOne;
    private Player playerTwo;
    private Player roundWinner;
    private int maxRounds;



    public Game(Player p1,Player p2,int maxRounds,Deck mazo){
        deck=mazo;
        playerOne=p1;
        playerTwo=p2;
        this.maxRounds=maxRounds;
        roundWinner=p1;
    }



    public void startGame(){
        distributeDeck();
        play();
    }

    private void play(){
        int i=0;

        while (i<maxRounds && playerOne.getTotalCards()>0 && playerTwo.getTotalCards()>0){
            i++;
            System.out.println("------ Ronda "+i+" ------");
            runRound();
        }

        checkWinner(i);

    }



    private void distributeDeck(){
        int totalCards=deck.size();
        for(int i=0;i<totalCards;i++){
            if(i%2==0){
                playerOne.addCard(deck.topCard());
                deck.removeCard();
            }else{
                playerTwo.addCard(deck.topCard());
                deck.removeCard();
            }
        }
    }



    private void runRound(){
        Player roundLoser;
        Atribute roundWinnerAtribute = roundWinner.selectRandomAtribute(roundWinner.topCard());
        System.out.println("El jugador "+roundWinner.getPlayerName()+" selecciona competir por el atributo "+roundWinnerAtribute.getName());
        System.out.println("La carta de "+roundWinner.getPlayerName()+" es "+roundWinner.topCard().getName()+" con "+roundWinnerAtribute.getName()+" "+roundWinnerAtribute.getValue());
        if(roundWinner.equals(playerOne)){
            roundLoser=playerTwo;
            Atribute roundLoserAtribute = roundLoser.topCard().getAtributebyName(roundWinnerAtribute.getName());
            System.out.println("La carta de "+roundLoser.getPlayerName()+" es "+roundLoser.topCard().getName()+" con "+ roundLoserAtribute.getName() +" "+roundLoserAtribute.getValue());
            fight(roundWinnerAtribute,roundLoser,roundLoserAtribute);
        }else{
            roundLoser=playerOne;
            Atribute roundLoserAtribute = roundLoser.topCard().getAtributebyName(roundWinnerAtribute.getName());
            System.out.println("La carta de "+roundLoser.getPlayerName()+" es "+roundLoser.topCard().getName()+" con "+roundLoserAtribute.getName() +" "+roundLoserAtribute.getValue());
            fight(roundWinnerAtribute,roundLoser,roundLoserAtribute);
        }

    }

    private void fight(Atribute roundWinnerAtribute,Player roundLoser,Atribute roundLoserAtribute){
        if(roundWinnerAtribute.getValue()>roundLoserAtribute.getValue()){
            resolveFight(roundLoser,true);
            System.out.println("Gana la ronda "+roundWinner.getPlayerName());
            System.out.println(playerOne.getPlayerName()+" posee ahora "+playerOne.getTotalCards()+" cartas y "+playerTwo.getPlayerName()+" posee ahora "+playerTwo.getTotalCards()+" cartas");
        }else if(roundWinnerAtribute.getValue()<roundLoserAtribute.getValue()){
            Player aux = roundLoser;
            roundLoser=roundWinner;
            roundWinner=aux;
            resolveFight(roundLoser,true);
            System.out.println("Gana la ronda "+roundWinner.getPlayerName());
            System.out.println(playerOne.getPlayerName()+" posee ahora "+playerOne.getTotalCards()+" cartas y "+playerTwo.getPlayerName()+" posee ahora "+playerTwo.getTotalCards()+" cartas");
        }else{
            System.out.println("La ronda fue un empate");
            resolveFight(roundLoser,false);
            System.out.println(playerOne.getPlayerName()+" posee ahora "+playerOne.getTotalCards()+" cartas y "+playerTwo.getPlayerName()+" posee ahora "+playerTwo.getTotalCards()+" cartas");
        }
    }

    private void resolveFight(Player roundLoser,boolean winner){
        if (winner){
            roundWinner.addCard(roundWinner.topCard());
            roundWinner.addCard(roundLoser.topCard());
            roundLoser.removeTopCard();
            roundWinner.removeTopCard();
        }else{
            roundWinner.addCard(roundWinner.topCard());
            roundLoser.addCard(roundLoser.topCard());
            roundWinner.removeTopCard();
            roundLoser.removeTopCard();
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
