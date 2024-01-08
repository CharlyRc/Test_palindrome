package test.palindrome.utilities;

import test.palindrome.LangueInterface;
import test.palindrome.VerificationPalindrome;

public class VerificationPalindromeBuilder {
    private LangueInterface langue = new LangueStub();

    public static VerificationPalindrome Default() {
        return new VerificationPalindromeBuilder().Build();
    }

    public VerificationPalindromeBuilder AyantPourLangue(LangueInterface langue){
        this.langue = langue;
        return this;
    }

    public VerificationPalindrome Build() {
        return new VerificationPalindrome(this.langue);
    }
}
