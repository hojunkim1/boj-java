package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] nums1 = br.readLine().split(" ");
        int n = Integer.parseInt(nums1[0]);
        int m = Integer.parseInt(nums1[1]);
        String[] nums2 = br.readLine().split(" ");
        long[] heights = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            long height = Integer.parseInt(nums2[i]);
            if (height > max) max = height;
            heights[i] = height;
        }

        // 이진 검색
        long left = 0;
        long right = max + 1;
        while (left < right) {
            long mid = (left + right) / 2;
            long total = 0;
            for (long height : heights) {
                long rest = height - mid;
                if (rest > 0) total += rest;
            }
            if (total < m)
                right = mid;
            else
                left = mid + 1;
        }

        // 출력
        System.out.println(left - 1);
    }
}
