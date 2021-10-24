package union;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Hazique
 */
public class Union {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of chars in DFA's = ");
        int total_number_of_chars = input.nextInt();
        String char1[] = new String[total_number_of_chars];
//        for (int i = 0; i < total_number_of_chars; i++) {
//            System.out.print("Enter char for index [" + i + "] = ");
//            char1[i] = input.next();
//        }
        char1[0] = "a";
        char1[1] = "b";

        System.out.print("Enter how many Row's in DFA-1 = ");
        int total_rows1 = input.nextInt();
        int transitions1[][] = new int[total_rows1][total_number_of_chars];
        System.out.println("==DFA-1==");
        System.out.print("Enter Initial state for DFA-1 = ");
        int initial_state1 = input.nextInt();
        System.out.print("Enter Final state for DFA-1 = ");
        int final_state1 = input.nextInt();
        transitions1[0][0] = 2;
        transitions1[0][1] = 1;
        transitions1[1][0] = 3;
        transitions1[1][1] = 1;
        transitions1[2][0] = 2;
        transitions1[2][1] = 1;
        transitions1[3][0] = 3;
        transitions1[3][1] = 3;

//        for (int i = 0; i < total_rows1; i++) {
//            for (int j = 0; j < total_number_of_chars; j++) {
//                System.out.print("Enter transition for Row[" + i + "] and for char [" + char1[j] + "] = ");
//                transitions1[i][j] = input.nextInt();
//            }
//        }
        System.out.print("Enter how many Row's in DFA-2 = ");
        int total_rows2 = input.nextInt();
        int transitions2[][] = new int[total_rows2][total_number_of_chars];
        System.out.println("==DFA-2==");
        System.out.print("Enter Initial state for DFA-2 = ");
        int initial_state2 = input.nextInt();
        System.out.print("Enter Final state for DFA-2 = ");
        int final_state2 = input.nextInt();
//        for (int i = 0; i < total_rows2; i++) {
//            for (int j = 0; j < total_number_of_chars; j++) {
//                System.out.print("Enter transition for Row[" + i + "] and for char [" + char1[j] + "] = ");
//                transitions2[i][j] = input.nextInt();
//            }
//        }
        transitions2[0][0] = 1;
        transitions2[0][1] = 2;
        transitions2[1][0] = 1;
        transitions2[1][1] = 3;
        transitions2[2][0] = 4;
        transitions2[2][1] = 2;
        transitions2[3][0] = 4;
        transitions2[3][1] = 2;
        transitions2[4][0] = 1;
        transitions2[4][1] = 3;


        int temp_x = initial_state1;
        int temp_y = initial_state2;

        ArrayList<transition> list1 = new ArrayList<>();
        transition t;
        transition temp;
        t = new transition(temp_x, temp_y);
        Queue<transition> s1 = new LinkedList<>();
        s1.add(t);
        list1.add(t);
        int temp1;
        int temp2;
        boolean check;

        while (!s1.isEmpty()) {
            check = false;
            temp = s1.peek();
            temp_x = temp.getX();
            temp_y = temp.getY();
            for (int i = 0; i < total_number_of_chars; i++) {
                check = false;
                temp1 = transitions1[temp_x][i];
                temp2 = transitions2[temp_y][i];
                t = new transition(temp1, temp2);
                for (transition li : list1) {
                    if (li.getX() == t.getX() && li.getY() == t.getY()) {
                        check = true;
                    }
                }
                if (!check) {
                    s1.add(t);
                    list1.add(t);
                }
            }
            s1.remove();
        }

        //OUTPUT
        int counter = 0;
        System.out.println("== Total-Transitions==");
        for (transition object : list1) {
            System.out.println("[z" + counter + "] ==> [x" + object.getX() + "] + [y" + object.getY() + "]");
            counter++;
        }
        counter = 0;
        System.out.println("=================================================");
        // INITIAL OR FINAL STATES
        int chk = 0;
        for (transition object1 : list1) {
            if (object1.getX() == initial_state1 && object1.getY() == initial_state2) {
                System.out.println("[z" + counter + "] ==> [x" + object1.getX() + "] + [y" + object1.getY() + "]  <-- INITIAL STATE");
                chk++;
            }
            if (object1.getX() == final_state1 || object1.getY() == final_state2) {
                System.out.println("[z" + counter + "] ==> [x" + object1.getX() + "] + [y" + object1.getY() + "]  <-- FINAL STATE");
                chk++;
            }
            if (chk == 0) {
                System.out.println("[z" + counter + "] ==> [x" + object1.getX() + "] + [y" + object1.getY() + "]");
            }
            counter++;
        }
    }

}

class transition {

    private final int x;
    private final int y;

    public transition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
