package Game;

public class Atribute {
    private String name;
    private int value;

    //UN ATRIBUTO TIENE UN NOMBRE Y UN VALOR
    public Atribute(String name,int value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    //EQUALS DEL ATRIBUTO
    @Override
    public boolean equals(Object o1){
        try{ Atribute aux = (Atribute) o1;
            return this.getName().toLowerCase().equals(aux.getName().toLowerCase());
        }catch(Exception e){
            return false;
        }
    }
}
