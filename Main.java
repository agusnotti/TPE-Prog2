public class Main {
    public static void main(String[] args) {
        Player j1 = new Player();
        Player j2= new Player();
        Deck mazo= new Deck();

        mazo.addrequiredAtribute("Fuerza");
        mazo.addrequiredAtribute("Agilidad");
        mazo.addrequiredAtribute("Carisma");
        mazo.addrequiredAtribute("Velocidad");
        mazo.addrequiredAtribute("Peso");
        j1.setPlayerName("Fede");
        j2.setPlayerName("Agus");

        LoadDeck(mazo);

        Game game= new Game(j1,j2,20,mazo);

        game.startGame();

    }

    private static int randomValue(){
        return (int) (Math.random()*5)+1;
    }
    private static void LoadDeck(Deck mazo){
        for(int i=0; i<6;i++){
            String nombre= "Carta Numero: "+String.valueOf(i+1);
            Atribute atribute1=new Atribute("Fuerza",randomValue());
            Atribute atribute2=new Atribute("Agilidad",randomValue());
            Atribute atribute3=new Atribute("Carisma",randomValue());
            Atribute atribute4=new Atribute("Velocidad",randomValue());
            Atribute atribute5=new Atribute("Peso",randomValue());

            Card card= new Card(nombre);
            card.addAtribute(atribute1);
            card.addAtribute(atribute2);
            card.addAtribute(atribute3);
            card.addAtribute(atribute4);
            card.addAtribute(atribute5);
            mazo.add(card);
        }
    }

}
