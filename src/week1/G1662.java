package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G1662 {

    public static int rec(int tmp, Stack<Character> stack) {
        while (!stack.isEmpty()) {

            int top = stack.pop();

            if (top == ')') {
                tmp += rec(0, stack);
            } else if (top == '(') {
                int r = stack.pop();
                tmp *= r - '0';
                return tmp;
            } else {
                tmp++;
            }
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        int ans = rec(0, stack);

        System.out.println(ans);
    }
}