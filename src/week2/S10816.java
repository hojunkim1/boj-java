package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S10816 {

    static int upperBoundBinarySearch(int[] cards, int n, int target) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target >= cards[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int lowerBoundBinarySearch(int[] cards, int n, int target) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 1
        int num1 = Integer.parseInt(br.readLine());
        int[] cards = new int[num1];
        String[] nums1 = br.readLine().split(" ");
        for (int i = 0; i < num1; i++)
            cards[i] = Integer.parseInt(nums1[i]);

        // 정렬
        Arrays.sort(cards);

        // 입력 2
        int num2 = Integer.parseInt(br.readLine());
        int[] targets = new int[num2];
        int[] result = new int[num2];
        String[] nums2 = br.readLine().split(" ");
        for (int i = 0; i < num2; i++)
            targets[i] = Integer.parseInt(nums2[i]);

        // 탐색
        for (int i = 0; i < num2; i++) {
            int up = upperBoundBinarySearch(cards, num1, targets[i]);
            int low = lowerBoundBinarySearch(cards, num1, targets[i]);
            result[i] = up - low;
        }

        // 출력
        for (int i = 0; i < num2; i++)
            System.out.print(result[i] + " ");
    }
}