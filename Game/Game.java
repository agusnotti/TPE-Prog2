package Game;

import Potions.ElementPotion;

import java.util.ArrayList;

public class Game {
    private Deck deck; //MAZO DEL JUEGO
    private Player playerOne; // JUGADOR 1
    private Player playerTwo; // JUGADOR 2
    private Player roundWinner; // GANADOR DE LA RONDA
    private int maxRounds; // MAXIMO DE RONDAS A JUGAR
    private ArrayList<ElementPotion> potions;
    private ArrayList<String> logs;


    // CONSTRUCTOR
    public Game(Player p1, Player p2, int maxRounds, Deck mazo) {
        deck = mazo;
        playerOne = p1;
        playerTwo = p2;
        this.maxRounds = maxRounds;
        roundWinner = p1;
        this.potions = new ArrayList<>();
        this.logs = new ArrayList<>();
    }


    // COMIENZA EL JUEGO
    public void startGame() {
        distributeDeck();  // DISTRIBUYE EN MAZO ENTRE LOS 2 JUGADORES
        play(); // JUEGA
    }

    private void play() {
        int i = 0;
        // MIENTRAS QUE NO HAYA JUGADO EL MAXIMO DE RONDAS
        // Y LOS JUGADORES TENGAN MAS DE 0 CARTAS
        while (i < maxRounds && playerOne.getTotalCards() > 0 && playerTwo.getTotalCards() > 0) {
            i++;
            logs.add("------ Ronda " + i + " ------");
            runRound();
        }
        //SALGO DEL WHILE Y COMPRUEBO EL GANADOR
        checkWinner(i);

    }

    public void addPotion(ElementPotion p){
        potions.add(p);
    }

    private void distributeDeck() {
        int totalCards = deck.size();
        deck.shuffle();
        for (int i = 0; i < totalCards; i++) {
            Card topCard = deck.topCard(); //Guarda la carta del TOPE
            deck.removeCard(); //REMUEVE DEL DECK
            if (potions.size() > 0) {
                topCard.setPotion(potions.get(0));
                potions.remove(0);
            }
            if (i % 2 == 0) { // SI ES PAR LE DA LA CARTA AL JUGADOR 1
                playerOne.addCard(topCard); //AGREGA CARTA J1
            } else {// SI ES IMPAR SE LA DA AL JUGADOR 2
                playerTwo.addCard(topCard); // AGREGA CARTA J2
            }
        }
        playerOne.shuffle();
        playerTwo.shuffle();
    }


    private void runRound() { // EJECUTA UNA RONDA DEL JUEGO
        // roundWinnerAtribute VA A GUARDAR EL String SELECCIONADO POR EL JUGADOR.
        String roundWinnerAtribute = roundWinner.selectAtribute(roundWinner.topCard());
        logs.add("El jugador " + roundWinner.getPlayerName() + " selecciona competir por el atributo " + roundWinnerAtribute);
        logs.add("La carta de " + playerOne.getPlayerName() + " es " + playerOne.topCard().getName() + " con " + playerOne.topCard().getAtribute(roundWinnerAtribute).getName() + " " + playerOne.topCard().getAtribute(roundWinnerAtribute).getValue()+playerOne.topCard().appliedPotion(roundWinnerAtribute));
        logs.add("La carta de " + playerTwo.getPlayerName() + " es " + playerTwo.topCard().getName() + " con " + playerTwo.topCard().getAtribute(roundWinnerAtribute).getName() + " " + playerTwo.topCard().getAtribute(roundWinnerAtribute).getValue()+playerTwo.topCard().appliedPotion(roundWinnerAtribute));
        // LLAMO A PELEAR
        fight(roundWinnerAtribute);

    }

    private void fight(String roundWinnerAtribute) {
        //SI J1 LE GANA A J2
        Atribute p1=playerOne.topCard().getAtribute(roundWinnerAtribute);
        Atribute p2=playerTwo.topCard().getAtribute(roundWinnerAtribute);
        if (playerOne.topCard().getAppliedEffects(p1.getName(),p1.getValue()) > playerTwo.topCard().getAppliedEffects(p2.getName(),p2.getValue())) {
            //RESUELVO LA PELEA ANUNCIANDO QUE HUBO UN GANADOR CON TRUE
            resolveFightWinner(playerOne, playerTwo);
            logs.add("Gana la ronda " + playerOne.getPlayerName());
            logs.add(playerOne.getPlayerName() + " posee ahora " + playerOne.getTotalCards() + " cartas y " + playerTwo.getPlayerName() + " posee ahora " + playerTwo.getTotalCards() + " cartas");
        } else if (playerOne.topCard().getAppliedEffects(p1.getName(),p1.getValue()) < playerTwo.topCard().getAppliedEffects(p2.getName(),p2.getValue())) {
            //SI J2 LE GANA A J1
            // roundWinner pasa a ser PlayerTwo
            resolveFightWinner(playerTwo, playerOne);
            logs.add("Gana la ronda " + playerTwo.getPlayerName());
            logs.add(playerOne.getPlayerName() + " posee ahora " + playerOne.getTotalCards() + " cartas y " + playerTwo.getPlayerName() + " posee ahora " + playerTwo.getTotalCards() + " cartas");
        } else {
            logs.add("La ronda fue un empate");
            // AL EMPATAR RESUELVO LA PELEA ANUNCIANDO QUE NO HUBO GANADOR CON FALSE
            resolveFightTie();
            logs.add(playerOne.getPlayerName() + " posee ahora " + playerOne.getTotalCards() + " cartas y " + playerTwo.getPlayerName() + " posee ahora " + playerTwo.getTotalCards() + " cartas");
        }
    }

    private void resolveFightWinner(Player winner, Player loser) {
        roundWinner = winner;
        //EL GANADOR SE QUEDA CON AMBAS CARTAS DEL TOPE Y LAS PONE ABAJO DEL MAZO
        winner.addCard(winner.topCard());
        winner.addCard(loser.topCard());
        loser.removeTopCard();
        winner.removeTopCard();
    }

    private void resolveFightTie() {
        // SI FUE UN EMPATE CADA JUGADOR PONE SU CARTA DEL TOPE ABAJO DEL MAZO
        playerOne.addCard(playerOne.topCard());
        playerTwo.addCard(playerTwo.topCard());
        playerOne.removeTopCard();
        playerTwo.removeTopCard();
    }


    // ACA SE COMPRUEBA QUIEN GANA EL JUEGO
    private void checkWinner(int i) {
        logs.add("------ El juego ha terminado ------");
        //SI J1 tiene mas cartas que J2 , GANA J1
        if (playerOne.getTotalCards() > playerTwo.getTotalCards()) {
            logs.add("El ganador es " + playerOne.getPlayerName() + " !");
        } else {
            //SI J2 tiene mas cartas que J1, GANA J2
            if (playerTwo.getTotalCards() > playerOne.getTotalCards()) {
                logs.add("El ganador es " + playerTwo.getPlayerName() + " !");
            } else {
                //SINO ES EMPATE
                logs.add("La partida ha finalizado en empate!");
            }
        }

    }

    public ArrayList<String> getLogs(){
        return new ArrayList<>(logs);
    }

}
