package Potions;

import Game.Atribute;

public abstract class Potion implements ElementPotion {
    private String name;
    private Atribute ingredients;


    public Potion(String name, Atribute ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    protected int getAtributeValue() {
        return ingredients.getValue();
    }

    protected String getAtributeName() {
        return ingredients.getName();
    }

    public String getName() {
        return name;
    }



    @Override
    public abstract int applyEffects(String atributeName, int atributeValue);

    @Override
    public String getAppliedPotions(String atributeName) {
        if ((ingredients.getName()==null)||
                atributeName.toLowerCase().equals(ingredients.getName().toLowerCase())) {
            return this.getName()+", ";
        }
        else return "";
    }
}
