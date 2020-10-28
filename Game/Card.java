package Game;

import Potions.ElementPotion;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private String name;
    //LISTA DE ATRIBUTOS DE UNA CARTA
    private List<Atribute> atributes;
    private ElementPotion potion;

    public Card(String name) {
        this.name = name;
        atributes = new ArrayList<>();
        this.potion=null;
    }

    // SI EL ATRIBUTO NO ESTA CONTENIDO LO AGREGO
    public void addAtribute(Atribute a) {
        if (!atributes.contains(a)) {
            atributes.add(a);
        }
    }

    public void setPotion(ElementPotion potion) {
        this.potion = potion;
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

    public int getValue(String atributeName){
        Atribute a1=this.getAtribute(atributeName);
        if(potion!=null){
            return getAppliedEffects(a1.getName(),a1.getValue());
        }else{
            return a1.getValue();
        }

    }

    public int getAppliedEffects(String atributeName,int atributeValue){
            return potion.applyEffects(atributeName,atributeValue);
    }

    public String appliedPotion(String atributeName){
        if(potion!=null){
            Atribute aux= this.getAtribute(atributeName);
            int value=this.getAppliedEffects(atributeName,aux.getValue());
            if(aux.getValue()==value){
                return "";
            }else {
                return " ,se aplicó pócima "+potion.getAppliedPotions(atributeName)+"valor resultante "+this.getAppliedEffects(atributeName,aux.getValue());
            }
        }else{
            return "";
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
                if(c.getAtribute(atributes.get(i).getName())==null) { //ATRIBUTOS CONTENGA CADA ATRIBUTO DE C
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


