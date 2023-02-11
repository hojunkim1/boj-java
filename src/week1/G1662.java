package week1;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class G1662 {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        String[] s = stdIn.nextLine().split("");
        Stack<Integer> stack = new Stack<>();

        int answer = 0;
        for (int i = 0; i < s.length; i++) {
            if (Objects.equals(s[i], "(")) {
                stack.push(-1);
            } else if (Objects.equals(s[i], ")")) {
                int temp = 0;
                int repeat = 0;
                while (stack.peek() != -1) {
                    temp += stack.pop();
                    repeat++;
                }
                stack.pop();
                int toAdd = temp * Integer.parseInt(s[i - repeat - 2]);
                stack.pop();
                stack.push(toAdd);
            } else {
                stack.push(1);
            }
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}
