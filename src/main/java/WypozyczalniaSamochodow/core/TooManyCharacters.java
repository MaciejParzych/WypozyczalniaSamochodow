package WypozyczalniaSamochodow.core;

public class TooManyCharacters extends Exception{

    public TooManyCharacters() {

    }


    @Override
    public String toString() {
        return "TooManyCharacters Error";
    }
}
