package test.palindrome;

public class LangueFrancaise implements LangueInterface {
    @Override
    public String Feliciter() {
        return Expressions.BienDit;
    }

    @Override
    public String Saluer(int time) {
        if(time > 4 && time < 13){
            return Expressions.Bonjour;
        }else if(time >= 13 && time < 17){
            return Expressions.BonApresMidi;
        }else if(time >= 17 && time < 22){
            return Expressions.Bonsoir;
        }else{
            return Expressions.BonneNuit;
        }
    }

    @Override
    public String toString() {
        return "Langue Française";
    }
}
