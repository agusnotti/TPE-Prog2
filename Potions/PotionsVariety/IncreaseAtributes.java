package Potions.PotionsVariety;

import Game.Atribute;
import Potions.Potion;

public class IncreaseAtributes extends Potion {



    public IncreaseAtributes(String name, Atribute ingredients) {
        super(name, ingredients);
    }

    @Override
    public int applyEffects(String atributeName, int atributeValue) {
        if ((this.getAtributeName()==null) ||
                atributeName.toLowerCase().equals(this.getAtributeName().toLowerCase())) {
            return (atributeValue+atributeValue*this.getAtributeValue()/100);
        }else{
            return atributeValue;
        }
    }


}
