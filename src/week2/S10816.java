package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 해시맵
        HashMap<Integer, Integer> map = new HashMap<>();

        // 입력 1
        int num1 = Integer.parseInt(br.readLine());
        String[] nums1 = br.readLine().split(" ");

        // 매핑
        for (int i = 0; i < num1; i++) {
            int num = Integer.parseInt(nums1[i]);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 입력 2
        int num2 = Integer.parseInt(br.readLine());
        String[] nums2 = br.readLine().split(" ");

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num2; i++) {
            int num = Integer.parseInt(nums2[i]);
            if (map.containsKey(num)) {
                sb.append(map.get(num)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}