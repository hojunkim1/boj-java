package week1;

import java.util.Scanner;

public class S11729 {

    public static void hanoi(int n, int from, int by, int to) {
        if (n == 1) {
            System.out.println(from + " " + to);
        } else {
            hanoi(n - 1, from, to, by);
            System.out.println(from + " " + to);
            hanoi(n - 1, by, from, to);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        System.out.println((int) Math.pow(2, n) - 1);
        hanoi(n, 1, 2, 3);
    }
}
