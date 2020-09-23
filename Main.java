public class Main {
    public static void main(String[] args) {
        Player j1 = new Player();
        Player j2= new Player();

        j1.setPlayerName("Fede");
        j2.setPlayerName("Agus");

        Game game= new Game(j1,j2,30,30);

        game.startGame();

    }
}
