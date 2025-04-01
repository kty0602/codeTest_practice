package day250331;

import java.util.*;

// 프로그래머스 주차 요금 계산(92341)
/*
[문제 설명]
- 주차장의 요금표와 차량이 들어오고 나간 기록이 주어질 때, 차량 별 주차 요금을 계산하려고 한다.
- 각 챠량의 요금을 정산하여라
*/
public class n92341 {

    private static int[] solution(int[] fees, String[] records) {
        // 차량별 주차 시간 저장
        Map<String, Integer> parkingTime = new HashMap<>();
        // 차량별 입차 시간 저장
        Map<String, Integer> inTime = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            int time = convertTime(parts[0]);
            String carNum = parts[1];
            String action = parts[2];

            if (action.equals("IN")) {
                inTime.put(carNum, time);
            } else {
                // 출차 시 총 주차 시간 누적
                int duration = time - inTime.get(carNum);
                parkingTime.put(carNum, parkingTime.getOrDefault(carNum, 0) + duration);
                inTime.remove(carNum);
            }
        }

        // 출차 기록이 없는 차량 23:59 출차 처리
        for (String carNumber : inTime.keySet()) {
            int duration = convertTime("23:59") - inTime.get(carNumber);
            parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + duration);
        }

        // 차량 번호 기준 오름차순 정렬
        List<String> carList = new ArrayList<>(parkingTime.keySet());
        Collections.sort(carList);

        // 요금 계산
        int[] answer = new int[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            answer[i] = calculateFee(parkingTime.get(carList.get(i)), fees[0], fees[1], fees[2], fees[3]);
        }
        return answer;
    }

    private static int convertTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static int calculateFee(int time, int basicTime, int basicFee, int unitTime, int unitFee) {
        if (time <= basicTime) return basicFee;
        return basicFee + (int) Math.ceil((double) (time - basicTime) / unitTime) * unitFee;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[]{"기본시간", "기본 요금", "단위 시간", "단위 요금"};
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " : ");
            String input = sc.nextLine();
            int fee = Integer.parseInt(input);
            list1.add(fee);
        }

        System.out.println("records 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<String> list2 = new ArrayList<>();
        while (true) {
            System.out.print("records : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list2.add(input);
        }

        int[] fees = list1.stream().mapToInt(i -> i).toArray();
        String[] records = list2.toArray(String[]::new);

        int[] result = solution(fees, records);
        System.out.print("답 : " + Arrays.toString(result));
    }
}
