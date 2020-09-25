import java.util.ArrayList;
import java.util.List;

public class Card {
    private String name;
    //LISTA DE ATRIBUTOS DE UNA CARTA
    private List<Atribute> atributes;

    public Card(String name) {
        this.name = name;
        atributes = new ArrayList<>();
    }

    // SI EL ATRIBUTO NO ESTA CONTENIDO LO AGREGO
    public void addAtribute(Atribute a) {
        if (!atributes.contains(a)) {
            atributes.add(a);
        }
    }

    //DEVUELVE EL TOTAL DE ATRIBUTOS DE UNA CARTA
    public int getNumberOfAtributes() {
        return atributes.size();
    }

    //OBTENGO UN ATRIBUTO SEGUN LA POSICION EN LA LISTA
    public Atribute getAtribute(int position) {
        if (position < atributes.size()) {
            return atributes.get(position);
        } else {
            return null;
        }
    }

    //OBTENGO UN ATRIBUTO SEGUN EL NOMBRE
    public Atribute getAtribute(String name) {
        for (int i = 0; i < atributes.size(); i++) {
            if (atributes.get(i).getName().equals(name)) {
                return atributes.get(i);
            }
        }
        return null;
    }

    //COMPARO QUE UNA CARTA TENGA LOS MISMOS ATRIBUTOS QUE OTRA
    public boolean sameAtributes(Card c) {
        if (this.getNumberOfAtributes() == c.getNumberOfAtributes()) { //MISMA CANT DE ATRIBUTOS
            for (int i = 0; i < atributes.size(); i++) {
                if (!atributes.contains(c.getAtribute(i))) { //ATRIBUTOS CONTENGA CADA ATRIBUTO DE C
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }
        // GETTER DEL NOMBRE
        public String getName () {
            return name;
        }


    }


