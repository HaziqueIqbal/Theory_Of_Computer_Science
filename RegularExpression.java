package regularexpression;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Hazique
 */
public class RegularExpression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input from user
        System.out.println("== Please Enter String ==");
        String input = sc.nextLine();
        String inputArray[];
        //split input by space
        inputArray = input.split(" ");
        //all reserved keywords
        String keywords[] = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while"};
        //check for airthmatic operators and Uniary operators are also included
        String airthmaticOperators[] = {"+", "-", "*", "^", "/", "%", "++", "--"}; 
        //Assignment operators
        String assignmentoperator[] = {"=", "+=", "-=", "*=", "/=", "%="};
        //Pattern for identifier
        Pattern identifier = Pattern.compile("([A-Za-z][_]?|_)([A-Za-z0-9]+[_]?)*");
        //Pattern for integer constant
        Pattern integerConstant = Pattern.compile("[+-]?[0-9]+");
        //Pattern for float constant
        Pattern floatConstant = Pattern.compile("[+-]?[0-9]*.[0-9]+");
        //Pattern for string constant
        Pattern stringConstant = Pattern.compile("^\"[^\"\\\\]*(\\\\.[^\"\\\\]*)*\"");
        //Pattern for char constant
        Pattern charConstant = Pattern.compile("(\\')([^\\\\\\'\\n]|(\\\\.))(\\')");

        //Main Loop
        for (int i = 0; i < inputArray.length; i++) {
            //check for keywords
            for (String keyword : keywords) {
                if (inputArray[i] == null ? keyword == null : inputArray[i].equals(keyword)) {
                    System.out.println("'" + inputArray[i] + "' is a keyword!");
                    i++;
                    break;
                }
            }
            //check for identifiers
            if (identifier.matcher(inputArray[i]).matches()) {
                System.out.println("'" + inputArray[i] + "' is an Identifier!");
            }
            
            //check for airthmatic operators
            for (String am : airthmaticOperators) {
                if (inputArray[i] == null ? am == null : inputArray[i].equals(am)) {
                    System.out.println("'" + inputArray[i] + "' is an Airthmatic Operator or may be Uninary Operator!");
                    break;
                }
            }
            //check for assignment operators
            for (String asm : assignmentoperator) {
                if (inputArray[i] == null ? asm == null : inputArray[i].equals(asm)) {
                    System.out.println("'" + inputArray[i] + "' is an Assignment Operator!");
                    break;
                }
            }
            //check for integer constant
            if (integerConstant.matcher(inputArray[i]).matches()) {
                System.out.println("'" + inputArray[i] + "' is an Integer Constant!");     
            }
            //check for float constant
            if (floatConstant.matcher(inputArray[i]).matches()) {
                System.out.println("'" + inputArray[i] + "' is an Float Constant!");     
            }
            //check for string constant
            if (stringConstant.matcher(inputArray[i]).matches()) {
                System.out.println(inputArray[i] + " is an String Constant!");     
            }
            //check for char constant
            if (charConstant.matcher(inputArray[i]).matches()) {
                System.out.println(inputArray[i] + " is an Char Constant!");     
            }
            //check for semi-colon
            if (";".equals(inputArray[i])) {
                System.out.println("'" + inputArray[i] + "' Semi-Colon!");
            }
        }

    }

}
