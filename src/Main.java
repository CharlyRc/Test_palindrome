import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        if(dateTime.getHour()< 17){
            System.out.println("Bonjour");
        }else {
            System.out.println("Bonsoirr");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un mot :");
        String mot = sc.nextLine();

        if (pal(mot))
            System.out.println("Bien dit !!");
        else
            System.out.println("'"+mot + "' n'est pas un palindrome");
    }
    public static boolean pal(String mot){
        int i=0, longueur=mot.length()-1;
        boolean egale=true;

        while(i<longueur/2 && egale){
            if(mot.charAt(i)==mot.charAt(longueur-i))
                egale = true;
            else
                egale = false;
            i++;
        }
        return egale;
    }
}