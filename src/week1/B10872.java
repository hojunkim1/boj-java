package week1;

import java.util.Scanner;

public class B10872 {

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        System.out.println(factorial(n));
    }
}
