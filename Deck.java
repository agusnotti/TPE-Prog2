import java.util.ArrayList;
import java.util.List;

public class Deck {

    //PARA EL DISEÑO DEL MAZO SE PLANTEA UNA ESTRUCTURA DE FILA
    private ArrayList<Card> deck;
    private Card cartaModelo;

    public Deck(){

        deck= new ArrayList<>();
        cartaModelo=new Card("modelo"); //CARTA MODELO PARA COMPROBAR
    }

    public void setCartaModelo(Card cartaModelo) {
        this.cartaModelo = cartaModelo;
    }

    // SI LA CARTA ES VALIDA, LA AGREGO A LA FILA (SERIA EN EL FONDO DEL MAZO)
    public void add(Card s){
        if(isEmpty()){
          cartaModelo=s; //SI ESTA VACIO, LA PRIMER CARTA AGREGADA ES LA MODELO
        }
        if (isValid(s)){
            deck.add(0,s);
        }
    }

    // DETERMINA SI UNA CARTA ES VALIDA PARA EL MAZO
    public boolean isValid(Card c){
               if(c.sameAtributes(cartaModelo)){ // COMPARA UNA CARTA CUALQUIERA CON LA MODELO (ATRIBUTOS)
                   return true;
               }else{
                   return false;
               }

    }



    //DEVUELVE EL TAMAÑO DEL MAZO
    public int size(){
        return deck.size();
    }

    // SI ESTA VACIO EL MAZO RETORNA TRUE
    public boolean isEmpty(){
        return deck.size()==0;
    }

    // DEVUELVE LA CARTA EN EL TOPE DEL MAZO SI NO ESTA VACIO
    public Card topCard(){
        if(!isEmpty()){
            return deck.get(deck.size()-1);
        }else{
            return null;
        }
    }

    //REMUEVE LA CARTA DEL TOPE DEL MAZO SI NO ESTA VACIO
    public void removeCard(){
        if(!isEmpty()){
            deck.remove(deck.size()-1);
        }
    }

    public Card getCartaModelo(){
        return cartaModelo;
    }

}
