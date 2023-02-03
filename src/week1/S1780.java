package week1;

import java.util.Scanner;

public class S1780 {

    public static boolean check(int[][] square) {
        int length = square[0].length;
        int first = square[0][0];

        // 주어진 사각형을 순차적으로 읽으며 다른 요소가 없는지 확인한다
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                if (square[i][j] != first)
                    return false;

        return true;
    }

    public static void divide(int[][] square, int[] results) {

        // 9등분된 사각형 한 변 길이
        int width = square.length / 3;

        // 9등분된 사각형들을 순차적으로 실행
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 9등분된 새로운 사각형 지정
                int[][] newSquare = new int[width][width];

                // 원래 사각형에서 작은 사각형 추출
                for (int k = 0; k < width; k++)
                    for (int l = 0; l < width; l++)
                        newSquare[k][l] = square[k + (i * width)][l + (j * width)];

                // 새로운 사각형이 올바른 형태인지 확인한다
                if (!check(newSquare))
                    divide(newSquare, results);
                else {
                    // 괜찮은 사각형이면 조건에 따라 숫자 증가
                    switch (newSquare[0][0]) {
                        case -1 -> results[0]++;
                        case 0 -> results[1]++;
                        case 1 -> results[2]++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int width = stdIn.nextInt();

        int[][] square = new int[width][width];

        // 주어진 사각형을 2차원 배열로 저장한다
        for (int i = 0; i < width; i++)
            for (int j = 0; j < width; j++)
                square[i][j] = stdIn.nextInt();

        int[] results = {0, 0, 0};

        // results 를 통째로 참조시켜 알고리즘 순환 과정에서 자동 증가되도록 한다
        divide(square, results);

        // 출력
        System.out.println(results[0]);
        System.out.println(results[1]);
        System.out.println(results[2]);
    }
}
