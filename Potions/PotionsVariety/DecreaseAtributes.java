package Potions.PotionsVariety;

import Game.Atribute;
import Potions.Potion;

public class DecreaseAtributes extends Potion {

    public DecreaseAtributes(String name, Atribute ingredients) {
        super(name, ingredients);
    }

    @Override
    public int applyEffects(String atributeName, int atributeValue) {
        if ((this.getAtributeName()==null) ||
                atributeName.toLowerCase().equals(this.getAtributeName().toLowerCase())) {
            return (atributeValue-atributeValue*this.getAtributeValue()/100);
        }else{
            return atributeValue;
        }
    }
}
