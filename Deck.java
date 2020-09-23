import java.util.ArrayList;
import java.util.List;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        deck= new ArrayList<Card>();
    }

    public void add(Card s){
        deck.add(0,s);
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
