package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S11724 {

    static int[][] nodes;
    static boolean[] visit;

    static void depthFirstSearch(int num) {
        for (int[] node : nodes) {
            if (node[0] == num && !visit[node[1]]) {
                visit[node[1]] = true;
                depthFirstSearch(node[1]);
            } else if (node[1] == num && !visit[node[0]]) {
                visit[node[0]] = true;
                depthFirstSearch(node[0]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 및 전역 데이터 초기화
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int m = Integer.parseInt(init[1]);
        nodes = new int[m][2];
        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            String[] node = br.readLine().split(" ");
            nodes[i][0] = Integer.parseInt(node[0]);
            nodes[i][1] = Integer.parseInt(node[1]);
        }

        // 깊이 우선 탐색
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                depthFirstSearch(i);
                result++;
            }
        }

        // 출력
        System.out.println(result - 1);
    }
}