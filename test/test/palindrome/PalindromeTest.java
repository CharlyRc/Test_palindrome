package test.palindrome;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import test.palindrome.utilities.VerificationPalindromeBuilder;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {

    @ParameterizedTest
    @ValueSource(strings = {"test", "epsi"})
    public void testMiroir(String chaine) {
        // ETANT DONNE une chaine n'étant pas un palindrome
        // QUAND on vérifie si c'est un palindrome
        String resultat = VerificationPalindromeBuilder.Default().Verifier(chaine, 2);

        // ALORS on obtient son miroir
        String inversion = new StringBuilder(chaine)
                .reverse()
                .toString();

        assertTrue(resultat.contains(inversion));
    }

    static Stream<Arguments> casTestPalindrome() {
        return Stream.of(
                Arguments.of(new LangueAnglaise(),  Expressions.WellSaid),
                Arguments.of(new LangueFrancaise(),  Expressions.BienDit)
        );
    }

    @ParameterizedTest
    @MethodSource("casTestPalindrome")
    public void testPalindrome(LangueInterface langue, String félicitations){
        // ETANT DONNE un palindrome
        String palindrome = "radar";

        // ET un utilisateur parlant une <langue>
        var vérificateur = new VerificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String resultat = vérificateur.Verifier(palindrome, 10);

        // ALORS la chaine est répétée, suivie de félicitations dans cette langue
        String attendu = palindrome + System.lineSeparator() + félicitations;
        assertTrue(resultat.contains(attendu));
    }

    @Test
    public void testPalindromeAnglais(){
        // ETANT DONNE un palindrome
        String palindrome = "radar";

        // ET un utilisateur parlant anglais
        LangueAnglaise langue = new LangueAnglaise();
        var vérificateur = new VerificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String resultat = vérificateur.Verifier(palindrome,15);

        // ALORS la chaine est répétée, suivie de "Well said !"
        String attendu = palindrome + System.lineSeparator() + Expressions.WellSaid;
        assertTrue(resultat.contains(attendu));
    }

    static Stream<Arguments> casTestBonjour() {
        return Stream.of(
                Arguments.of("test", new LangueFrancaise(), Expressions.Bonjour),
                Arguments.of("radar", new LangueFrancaise(), Expressions.Bonjour),
                Arguments.of("test", new LangueAnglaise(), Expressions.Hello),
                Arguments.of("radar", new LangueAnglaise(), Expressions.Hello)
        );
    }

    @ParameterizedTest
    @MethodSource("casTestBonjour")
    public void testBonjourFrancais(String chaine, LangueInterface langue, String salutations){
        // ETANT DONNE une chaine
        // ET un utilisateur parlant une <langue>
        var vérification = new VerificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String resultat =  vérification.Verifier(chaine,23);

        // ALORS toute réponse est précédée de <salutations> dans cette <langue>
        String[] lines = resultat.split(System.lineSeparator());
        assertEquals(salutations, lines[0]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    public void testAuRevoir(String chaine){
        // ETANT DONNE une chaine
        // QUAND on vérifie si c'est un palindrome
        String resultat =  VerificationPalindromeBuilder.Default().Verifier(chaine,12);

        // ALORS toute réponse est suivie de "Au Revoir"
        String[] lines = resultat.split(System.lineSeparator());
        String lastLine = lines[lines.length - 1];
        assertEquals(Expressions.AuRevoir, lastLine);
    }
}