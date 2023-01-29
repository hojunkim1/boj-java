package week1;

import java.util.Scanner;
import java.util.Stack;

public class S10994 {

    public static Stack<String> addStar(Stack<String> stars, int count) {
        int height = stars.size();
        Stack<String> newStars = new Stack<>();

        String newString1 = ("*".repeat(height + 4));
        String newString2 = ("*" + " ".repeat(height + 2) + "*");

        newStars.push(newString1);
        newStars.push(newString2);

        for (String star : stars) {
            String newString = "* " + star + " *";
            newStars.push(newString);
        }

        newStars.push(newString2);
        newStars.push(newString1);

        if (count - 1 == 0)
            return newStars;

        return addStar(newStars, count - 1);
    }

    public static String[] star(int repeat) {
        Stack<String> newStars = new Stack<>();
        newStars.push("*");

        if (repeat == 1)
            return newStars.toArray(new String[0]);

        return addStar(newStars, repeat - 1).toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int repeat = stdIn.nextInt();
        String[] stars = star(repeat);
        for (String s : stars) {
            System.out.println(s);
        }
    }
}
