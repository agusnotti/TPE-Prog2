package Potions.PotionsVariety;

import Game.Atribute;
import Potions.Potion;

public class ModifyAtribute extends Potion {

    public ModifyAtribute(String name, Atribute ingredients) {
        super(name, ingredients);
    }

    @Override
    public int applyEffects(String atributeName, int atributeValue) {
        if ((this.getAtributeName()==null) ||
                atributeName.toLowerCase().equals(this.getAtributeName().toLowerCase())) {
            return this.getAtributeValue();
        }else{
            return atributeValue;
        }
    }
}
