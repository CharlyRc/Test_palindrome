package test.palindrome.utilities;

import test.palindrome.Horaire;
import test.palindrome.LangueInterface;

public class LangueStub implements LangueInterface {
    @Override
    public String Feliciter() {
        return "";
    }

    @Override
    public String Saluer(int time) {
        return Horaire.verifHoraire(time);
    }
}
