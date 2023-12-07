package test.palindrome;

import java.util.Scanner;

public class VerificationPalindrome {
    private final LangueInterface langue;

    public VerificationPalindrome(LangueInterface langue) {
        this.langue = langue;
    }

    public String Verifier(String chaîne, int time) {
        String miroir =  new StringBuilder(chaîne)
                .reverse()
                .toString();

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(this.langue.Saluer(time));
        resultBuilder.append(System.lineSeparator());
        resultBuilder.append(miroir);
        resultBuilder.append(System.lineSeparator());

        if(miroir.equals(chaîne)) {
            resultBuilder.append(this.langue.Feliciter());
            resultBuilder.append(System.lineSeparator());
        }

        resultBuilder.append(Expressions.AuRevoir);
        return resultBuilder.toString();
    }
}