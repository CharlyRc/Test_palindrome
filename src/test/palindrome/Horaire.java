package test.palindrome;

import java.time.LocalDateTime;

public class Horaire {
    public static String verifHoraire(int time){

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
}
