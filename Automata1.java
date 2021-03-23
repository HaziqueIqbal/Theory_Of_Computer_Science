
package automata1;
import java.util.regex.Pattern;
import java.util.Scanner;
/**
 *
 * @author hazique
 */
public class Automata1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("__Enter String__");
        String input = sc.nextLine();
        Pattern p = Pattern.compile("((@|#)[a-zA-Z0-9]*?)|(#([a-zA-Z0-9]|@[a-zA-Z0-9])*)");
        if(p.matcher(input).matches()){
            System.out.println("This is valid in language A#.");
        }
        else{
            System.out.println("This is not valid in languange A#.");
        }
    }
    
}
