package plannermain;

import java.util.Scanner;

public class UserInput {

    public static String getString(int min, int max) {//provides boundries for length of a string
        Scanner i = new Scanner(System.in);
        String a = i.nextLine();
        int size = a.length();
        if (size < 0 || size > 101) {
            System.out.println("Not a valid String size.");
            a = getString(min, max);
        }
        return a;

    }

    public static int getInt() { // protects from wrong int input
        Scanner i = new Scanner(System.in);
        int a;
        if (i.hasNextInt()) {
            a = i.nextInt();
        } else {
            System.out.println("Not a valid integer value.");
            a = getInt();
        }
        return a;
    }
}
