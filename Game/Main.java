package Game;

import Potions.CockTail;
import Potions.Potion;
import Potions.PotionsVariety.DecreaseAtributes;
import Potions.PotionsVariety.IncreaseAtributes;
import Potions.PotionsVariety.ModifyAtribute;
import Strategy.StrategyAmbicioso;
import Strategy.StrategyObstinado;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player j1 = new Player("Fede",new StrategyAmbicioso());
        Player j2= new Player("Agus",new StrategyObstinado());

        ArrayList<String> logs = new ArrayList<>();

        //----CARTA MODELO---//


        //----------------------//

        Deck mazo= new Deck();

        ;

        //CARGO UN MAZO RANDOM
        //LoadDeck(mazo);

        Game game= new Game(j1,j2,500,mazo);

        /*ATRIBUTOS DE POCIONES*/
        Atribute atribute1= new Atribute(20);
        Atribute atribute2= new Atribute(25);
        Atribute atribute3= new Atribute(0);
        Atribute atribute4= new Atribute(70);
        Atribute atribute5= new Atribute(25);
        Atribute atribute6= new Atribute(30);
        Atribute atribute7= new Atribute(55);
        Atribute atribute8= new Atribute(75);
        Atribute atribute9= new Atribute(4);
        Atribute atribute10= new Atribute(3);
        Atribute atribute11= new Atribute(23);
        Atribute atribute12= new Atribute(7);
        Atribute atribute13= new Atribute("Fuerza",35);
        Atribute atribute14= new Atribute("Fuerza",45);
        Atribute atribute15= new Atribute("Peso",43);
        Atribute atribute16= new Atribute("Peso",50);

        /*POCIONES*/
        Potion potion1= new IncreaseAtributes("Fortalecedora",atribute1);
        Potion potion2= new IncreaseAtributes("Fortalecedora",atribute2);
        Potion potion3= new IncreaseAtributes("Fortalecedora Plus",atribute3);
        Potion potion4= new IncreaseAtributes("Fortalecedora Plus",atribute4);
        Potion potion5= new DecreaseAtributes("Kriptonita",atribute5);
        Potion potion6= new DecreaseAtributes("Kriptonita",atribute6);
        Potion potion7= new DecreaseAtributes("Reductor de Plomo",atribute7);
        Potion potion8= new DecreaseAtributes("Reductor de Plomo",atribute8);
        Potion potion9= new ModifyAtribute("Quiero vale cuatro",atribute9);
        Potion potion10= new ModifyAtribute("Quiero retruco",atribute10);
        Potion potion11= new ModifyAtribute("Número Mágico",atribute11);
        Potion potion12= new ModifyAtribute("Número Mágico",atribute12);
        Potion potion13= new IncreaseAtributes("Pócima Selectiva Fuerza",atribute13);
        Potion potion14= new IncreaseAtributes("Pócima Selectiva Fuerza",atribute14);
        Potion potion15= new IncreaseAtributes("Pócima Selectiva Peso",atribute15);
        Potion potion16= new IncreaseAtributes("Pócima Selectiva Peso",atribute16);

        /*COCKTAILS*/
        CockTail cocktail1 = new CockTail();
        CockTail cocktail2 = new CockTail();
        cocktail1.addPotion(potion1);
        cocktail1.addPotion(potion13);
        cocktail1.addPotion(potion15);

        cocktail2.addPotion(potion2);
        cocktail2.addPotion(potion14);
        cocktail2.addPotion(potion16);
        cocktail2.addPotion(cocktail1);


        game.addPotion(potion1);
        game.addPotion(potion2);
        game.addPotion(potion3);
        game.addPotion(potion4);
        game.addPotion(potion5);
        game.addPotion(potion6);
        game.addPotion(potion7);
        game.addPotion(potion8);
        game.addPotion(potion9);
        game.addPotion(potion10);
        game.addPotion(potion11);
        game.addPotion(potion12);
        game.addPotion(potion13);
        game.addPotion(potion14);
        game.addPotion(potion15);
        game.addPotion(potion16);
        game.addPotion(cocktail1);
        game.addPotion(cocktail2);


        //INICIO EL JUEGO
        String mazoPath = "./src/superheroes.json";
        LoadDeck(mazoPath,mazo);
        game.startGame();
        logs= game.getLogs();
        imprimirLogs(logs);

    }


    public static void LoadDeck(String jsonFile, Deck mazo) {
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
                //String nombreCarta = carta.getString("nombre");
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

    public static void imprimirLogs(ArrayList<String> logs){
        for (int i=0;i<logs.size();i++){
            System.out.println(logs.get(i));
        }
    }



}
