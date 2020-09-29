import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        Player j1 = new Player();
        Player j2= new Player();


        //----CARTA MODELO---//


        //----------------------//

        Deck mazo= new Deck();

        j1.setPlayerName("Fede");
        j2.setPlayerName("Agus");

        //CARGO UN MAZO RANDOM
        //LoadDeck(mazo);

        Game game= new Game(j1,j2,500,mazo);

        //INICIO EL JUEGO
        String mazoPath = "./src/superheroes.json";
        LoadDeck(mazoPath,mazo);
        game.startGame();


    }


    public static void LoadDeck(String jsonFile,Deck mazo) {
        //URL url = getClass().getResource(jsonFile);
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                Card nuevaCarta = new Card(carta.getString("nombre"));
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                for (String nombreAtributo: atributos.keySet()) {
                    Atribute atribute= new Atribute(nombreAtributo,atributos.getInt(nombreAtributo));
                    nuevaCarta.addAtribute(atribute);
                }
                mazo.add(nuevaCarta);


                reader.close();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
