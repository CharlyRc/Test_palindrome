package test.palindrome;

public class LangueAnglaise implements LangueInterface {
    @Override
    public String Feliciter() {
        return Expressions.WellSaid;
    }

    @Override
    public String Saluer(int time) {
        if(time > 4 && time < 13){
            return Expressions.Hello;
        }else if(time >= 13 && time < 17){
            return Expressions.GoodAfternoon;
        }else if(time >= 17 && time < 22){
            return Expressions.GoodEvenning;
        }else{
            return Expressions.GoodNight;
        }
    }

    @Override
    public String toString() {
        return "Langue Anglaise";
    }
}
