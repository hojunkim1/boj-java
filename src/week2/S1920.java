package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1920 {

    static int binarySearch(int[] cards, int n, int target) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (cards[mid] == target)
                return 1;
            else if (cards[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 1
        int num1 = Integer.parseInt(br.readLine());
        int[] cards = new int[num1];
        String[] nums1 = br.readLine().split(" ");
        for (int i = 0; i < num1; i++)
            cards[i] = Integer.parseInt(nums1[i]);

        // 입력 2
        int num2 = Integer.parseInt(br.readLine());
        int[] targets = new int[num2];
        int[] result = new int[num2];
        String[] nums2 = br.readLine().split(" ");
        for (int i = 0; i < num2; i++)
            targets[i] = Integer.parseInt(nums2[i]);

        // 정렬
        Arrays.sort(cards);

        // 탐색
        for (int i = 0; i < num2; i++)
            result[i] = binarySearch(cards, num1, targets[i]);

        // 출력
        for (int i = 0; i < num2; i++)
            System.out.println(result[i]);
    }
}
