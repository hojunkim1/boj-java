package week1;

import java.util.Scanner;

public class S10994 {

    public static String[] addStar(String[] stars) {
        int height = stars.length;
        String[] newStars = new String[height + 4];

        StringBuilder newString1 = new StringBuilder();
        StringBuilder newString2 = new StringBuilder();

        newString1.append("*".repeat(height + 4));
        newString2.append("*").append(" ".repeat(height + 2)).append("*");

        newStars[0] = newString1.toString();
        newStars[1] = newString2.toString();

        for (int i = 0; i < height; i++) {
            String newString = "* " + stars[i] + " *";
            newStars[i + 2] = newString;
        }

        newStars[height + 2] = newString2.toString();
        newStars[height + 3] = newString1.toString();

        return newStars;
    }

    public static String[] star(int repeat) {
        String[] newStars = {"*"};
        for (int i = 0; i < repeat - 1; i++)
            newStars = addStar(newStars);
        return newStars;
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
