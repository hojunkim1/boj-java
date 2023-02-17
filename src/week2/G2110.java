package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int c = Integer.parseInt(nums[1]);
        int[] locations = new int[n];
        for (int i = 0; i < n; i++)
            locations[i] = Integer.parseInt(br.readLine());

        // 정렬
        Arrays.sort(locations);

        // 이진 검색
        int left = 1;
        int right = locations[n - 1];
        while (left <= right) {
            int mid = (left + right) / 2;

            // 공유기 설치
            int setup = 1;
            int recent = locations[0];
            for (int i = 1; i < n; i++) {
                if (locations[i] - recent >= mid) {
                    setup++;
                    recent = locations[i];
                }
            }

            if (setup >= c)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // 출력
        System.out.println(left - 1);
    }
}
