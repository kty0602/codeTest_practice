package day250310;

import java.util.*;

// 프로그래머스 공원 산책(172928)
/*
[문제 설명]
- 공원을 나타내는 문자열 배열 park, 수행할 명령이 담긴 routes 배열이 매개변수로 주어질 때, 최후에 놓인 위치의 좌표를 배열에 담아 return
- park배열은 다음과 같은 문자들로 이뤄져 있습니다. S : 시작지점, O: 이동 가능한 통로, X : 장애물
*/
public class n172928 {

    private static int[] solution(String[] park, String[] routes) {
        int x = -1;
        int y = -1;
        int height = park.length;
        int weight = park[0].length();

        for (int i = 0; i < height; i++) {
            if (park[i].indexOf('S') != -1) {
                x = park[i].indexOf('S');
                y = i;
                break;
            }
        }

        // 방향 설정 (동, 서, 남, 북)
        Map<String, int[]> directions = new HashMap<>();
        directions.put("E", new int[]{0, 1});  // 동쪽
        directions.put("W", new int[]{0, -1}); // 서쪽
        directions.put("S", new int[]{1, 0});  // 남쪽
        directions.put("N", new int[]{-1, 0}); // 북쪽

        for (String route : routes) {
            String[] split = route.split(" ");
            String dir = split[0]; // 방향
            int move = Integer.parseInt(split[1]); // 거리

            int[] d = directions.get(dir);
            int newX = x, newY = y;
            boolean isValid = true;

            for (int i = 1; i <= move; i++) {
                int tempX = x + d[0] * i;
                int tempY = y + d[1] * i;

                if (tempX < 0 || tempX >= height || tempY < 0 || tempY >= weight || park[tempX].charAt(tempY) == 'X') {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                x = x + d[0] * move;
                y = y + d[1] * move;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("park 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        List<String> list1 = new ArrayList<>();
        while (true) {
            System.out.print("공원 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list1.add(input);
        }

        System.out.println("routes 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        List<String> list2 = new ArrayList<>();
        while (true) {
            System.out.print("방향과 거리를 입력하세요. (Ex. E 2) : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list2.add(input);
        }

        String[] park = list1.stream().toArray(String[]::new);
        String[] routes = list2.stream().toArray(String[]::new);
        int[] result = solution(park, routes);
        System.out.println("답 : " + Arrays.toString(result));
    }
}
