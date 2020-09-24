import java.util.ArrayList;
import java.util.List;

public class Card {
    private String name;
    private List<Atribute> atributes;

    public Card(String name) {
        this.name = name;
        atributes= new ArrayList<>();
    }

    public void addAtribute(Atribute a){
        atributes.add(a);
    }

    public int getNumberOfAtributes(){
        return atributes.size();
    }

    public Atribute getAtribute(int position){
        if(position<atributes.size()){
            return atributes.get(position);
        }else{
            return null;
        }
    }

    public Atribute getAtributebyName(String name){
        for(int i=0; i< atributes.size();i++){
            if(atributes.get(i).getName().equals(name)){
                return atributes.get(i);
            }
        }
        return null;
    }

    public Atribute selectAtribute(int i) {
       int random=(int) Math.floor((Math.random()*atributes.size()));
       return atributes.get((random));
    }

    public String getName() {
        return name;
    }



}

