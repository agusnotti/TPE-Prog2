public class Game {
    private Deck deck; //MAZO DEL JUEGO
    private Player playerOne; // JUGADOR 1
    private Player playerTwo; // JUGADOR 2
    private Player roundWinner; // GANADOR DE LA RONDA
    private int maxRounds; // MAXIMO DE RONDAS A JUGAR


    // CONSTRUCTOR
    public Game(Player p1,Player p2,int maxRounds,Deck mazo){
        deck=mazo;
        playerOne=p1;
        playerTwo=p2;
        this.maxRounds=maxRounds;
        roundWinner=p1;
    }


    // COMIENZA EL JUEGO
    public void startGame(){
        distributeDeck();  // DISTRIBUYE EN MAZO ENTRE LOS 2 JUGADORES
        play(); // JUEGA
    }

    private void play(){
        int i=0;
        // MIENTRAS QUE NO HAYA JUGADO EL MAXIMO DE RONDAS
        // Y LOS JUGADORES TENGAN MAS DE 0 CARTAS
        while (i<maxRounds && playerOne.getTotalCards()>0 && playerTwo.getTotalCards()>0){
            i++;
            System.out.println("------ Ronda "+i+" ------");
            runRound();
        }
        //SALGO DEL WHILE Y COMPRUEBO EL GANADOR
        checkWinner(i);

    }



    private void distributeDeck(){
        int totalCards=deck.size();
        for(int i=0;i<totalCards;i++){
            if(i%2==0){ // SI ES PAR LE DA LA CARTA AL JUGADOR 1
                playerOne.addCard(deck.topCard()); //AGREGA CARTA J1
                deck.removeCard(); //REMUEVE DEL DECK
            }else{// SI ES IMPAR SE LA DA AL JUGADOR 2
                playerTwo.addCard(deck.topCard()); // AGREGA CARTA J2
                deck.removeCard(); // REMUEVE DEL DECK
            }
        }
    }



    private void runRound(){ // EJECUTA UNA RONDA DEL JUEGO
        // roundWinnerAtribute VA A GUARDAR EL String SELECCIONADO POR EL JUGADOR.
        String roundWinnerAtribute = roundWinner.selectRandomAtribute(roundWinner.topCard());
        System.out.println("El jugador "+roundWinner.getPlayerName()+" selecciona competir por el atributo "+roundWinnerAtribute);
        System.out.println("La carta de "+playerOne.getPlayerName()+" es "+playerOne.topCard().getName()+" con "+ playerOne.topCard().getAtribute(roundWinnerAtribute).getName()+ " "+playerOne.topCard().getAtribute(roundWinnerAtribute).getValue());
        System.out.println("La carta de "+playerTwo.getPlayerName()+" es "+playerTwo.topCard().getName()+" con "+ playerTwo.topCard().getAtribute(roundWinnerAtribute).getName()+ " "+playerTwo.topCard().getAtribute(roundWinnerAtribute).getValue());
        // LLAMO A PELEAR
        fight(roundWinnerAtribute);

    }

    private void fight(String roundWinnerAtribute){
            //SI J1 LE GANA A J2
        if(playerOne.topCard().getAtribute(roundWinnerAtribute).getValue()>playerTwo.topCard().getAtribute(roundWinnerAtribute).getValue()){
            //RESUELVO LA PELEA ANUNCIANDO QUE HUBO UN GANADOR CON TRUE
            resolveFight(playerOne,playerTwo,true);
            System.out.println("Gana la ronda "+playerOne.getPlayerName());
            System.out.println(playerOne.getPlayerName()+" posee ahora "+playerOne.getTotalCards()+" cartas y "+playerTwo.getPlayerName()+" posee ahora "+playerTwo.getTotalCards()+" cartas");
        }else if(playerOne.topCard().getAtribute(roundWinnerAtribute).getValue()<playerTwo.topCard().getAtribute(roundWinnerAtribute).getValue()){
           //SI J2 LE GANA A J1
            // roundWinner pasa a ser PlayerTwo
            roundWinner=playerTwo;
            resolveFight(playerTwo,playerOne,true);
            System.out.println("Gana la ronda "+playerTwo.getPlayerName());
            System.out.println(playerOne.getPlayerName()+" posee ahora "+playerOne.getTotalCards()+" cartas y "+playerTwo.getPlayerName()+" posee ahora "+playerTwo.getTotalCards()+" cartas");
        }else{
            System.out.println("La ronda fue un empate");
            // AL EMPATAR RESUELVO LA PELEA ANUNCIANDO QUE NO HUBO GANADOR CON FALSE
            resolveFight(playerOne,playerTwo,false);
            System.out.println(playerOne.getPlayerName()+" posee ahora "+playerOne.getTotalCards()+" cartas y "+playerTwo.getPlayerName()+" posee ahora "+playerTwo.getTotalCards()+" cartas");
        }
    }

    private void resolveFight(Player winner,Player loser,boolean anywinner){
        // SI HUBO UN GANADOR   anywinner=true;
        if (anywinner){
            //EL GANADOR SE QUEDA CON AMBAS CARTAS DEL TOPE Y LAS PONE ABAJO DEL MAZO
            winner.addCard(winner.topCard());
            winner.addCard(loser.topCard());
            loser.removeTopCard();
            winner.removeTopCard();
        }else{
            // ACA anywinner=false; PORQUE NO HUBO GANADOR
            // SI FUE UN EMPATE CADA JUGADOR PONE SU CARTA DEL TOPE ABAJO DEL MAZO
            winner.addCard(winner.topCard());
            loser.addCard(loser.topCard());
            winner.removeTopCard();
            loser.removeTopCard();
        }
    }

    // ACA SE COMPRUEBA QUIEN GANA EL JUEGO
    private void checkWinner(int i){
            System.out.println("------ El juego ha terminado ------");
            //SI J1 tiene mas cartas que J2 , GANA J1
            if(playerOne.getTotalCards()>playerTwo.getTotalCards()){
                System.out.println("El ganador es "+playerOne.getPlayerName()+" !");
            }else{
                //SI J2 tiene mas cartas que J1, GANA J2
                if(playerTwo.getTotalCards()> playerOne.getTotalCards()){
                    System.out.println("El ganador es "+playerTwo.getPlayerName()+" !");
                }else {
                    //SINO ES EMPATE
                    System.out.println("La partida ha finalizado en empate!");
                }
            }

    }



}
