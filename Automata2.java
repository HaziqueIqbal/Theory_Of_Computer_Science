package automata2;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author hazique
 */
public class Automata2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("__Enter String__");
        String input = sc.nextLine();
        Pattern p = Pattern.compile("(\\(\\)|(\\((:|%|\\?|[a-zA-Z0-9]){1,6}\\)))|(\\^([a-zA-Z0-9]){1,6})|(\\[[0-9]((:|%|\\?|[a-zA-Z0-9]){1,5})?)");
        if (p.matcher(input).matches()) {
            System.out.println("Folder created!.");
        } else {
            System.out.println("Error in creating folder! Please try again...");
        }
    }

}
