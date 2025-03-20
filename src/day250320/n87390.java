package day250320;

import java.util.*;

// 프로그래머스 n^2 배열 자르기(87390)
/*
[문제 설명]
- n, left, right가 주어집니다. 다음 과정을 거쳐 1차원 배열을 만들고자 합니다.
- 1. n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
- 2. i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다. 1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
- 3. 1행, 2행, ... , n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
- 4. 새로운 1차원 배열을 arr이라고 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
*/
public class n87390 {

    // 개선한 코드 (메모리 초과 문제) 2차원 배열 -> 1차원 배열 변환 과정 생략
    private static int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            long index = left + i;
            int row = (int) (index / n);
            int col = (int) (index % n);
            result[i] = Math.max(row + 1, col + 1);
        }

        return result;
    }

    // 작성한 코드 (메모리 초과로 인한 실패)
//    private static int[] solution(int n, long left, long right) {
//        int[][] array = new int[n][n];
//
//        // 조건에 맞도록 값 채워 넣기
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                array[i][j] = Math.max(i+1, j+1);
//            }
//        }
//
//        int arr[] = new int[n*n];
//
//        int index = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[index++] = array[i][j];
//            }
//        }
//
//        int[] result = new int[(int) (right-left+1)];
//        int index2 = 0;
//        for (int i = (int) left; i <= right; i++) {
//            result[index2++] = arr[i];
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n 입력 : ");
        int n = sc.nextInt();

        System.out.print("left 입력 : ");
        long left = sc.nextLong();

        System.out.print("right 입력 : ");
        long right = sc.nextLong();

        int[] result = solution(n, left, right);
        System.out.print("답 : " + Arrays.toString(result));
    }
}
