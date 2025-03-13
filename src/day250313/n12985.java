package day250313;

import java.util.Scanner;

public class n12985 {

    private static int solution(int N, int A, int B) {
        int round = 0;

        while (A != B) {
            A = (A + 1) / 2;
            B = (B + 1) / 2;
            round ++;
        }
        return round;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N : ");
        int N = sc.nextInt();
        System.out.print("A : ");
        int A = sc.nextInt();
        System.out.print("B : ");
        int B = sc.nextInt();

        int result = solution(N, A, B);
        System.out.println("답 : " + result);
    }
}
