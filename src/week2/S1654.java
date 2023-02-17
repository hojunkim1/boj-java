package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] nums = br.readLine().split(" ");
        int k = Integer.parseInt(nums[0]);
        int n = Integer.parseInt(nums[1]);
        int[] lines = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            int line = Integer.parseInt(br.readLine());
            if (line > max) max = line;
            lines[i] = line;
        }

        // 이진 탐색
        long left = 0;
        long right = max + 1;
        while (left < right) {
            long mid = (left + right) / 2;
            int total = 0;
            for (int line : lines)
                total += (line / mid);
            if (total < n)
                right = mid;
            else
                left = mid + 1;
        }

        // 출력
        System.out.println(left - 1);
    }
}
