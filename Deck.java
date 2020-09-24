import java.util.ArrayList;
import java.util.List;

public class Deck {
    private ArrayList<Card> deck;
    private List<String> requiredAtributes;

    public Deck(){
        deck= new ArrayList<Card>();
        requiredAtributes= new ArrayList<>();
    }

    public void add(Card s){
      if (isValid(s)){
          deck.add(0,s);
      }
    }

    public boolean isValid(Card c){
        if(isEmpty()){
            return true;
        }else{
            if(deck.get(0).getNumberOfAtributes()==c.getNumberOfAtributes()){
                for(int i=0;i<requiredAtributes.size();i++){
                    if (!requiredAtributes.contains(c.getAtribute(i).getName())){
                        return false;
                    }
                }
                return true;
            }else{
                return false;
            }
      }
    }

    public void addrequiredAtribute(String a){
        requiredAtributes.add(a);
    }

    public int size(){
        return deck.size();
    }

    public boolean isEmpty(){
        return deck.size()==0;
    }

    public Card topCard(){
        if(!isEmpty()){
            return deck.get(deck.size()-1);
        }else{
            return null;
        }
    }

    public void removeCard(){
        if(!isEmpty()){
            deck.remove(deck.size()-1);
        }
    }

}
