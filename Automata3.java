
package automata3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author hazique
 */
public class Automata3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("__Enter String__");
        String input = sc.nextLine();
        Pattern p = Pattern.compile("((\\(([a-zA-Z0-9]|\\+|\\-|\\*|\\/|[a-zA-Z0-9])*\\))|([a-zA-Z0-9]|\\+|\\-|\\*|\\/|[a-zA-Z0-9])*)*");
        if (p.matcher(input).matches()) {
            System.out.println("Valid airthmatic expression!.");
        } else {
            System.out.println("Invalid expression! Please try again...");
        }
    }
    
}
