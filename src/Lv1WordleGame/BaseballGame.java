package Lv1WordleGame;

import java.util.*;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    private final LinkedHashSet<Integer> inputHashSet = new LinkedHashSet<>();
    private final LinkedHashSet<Integer> randomHashSet = new LinkedHashSet<>();


    // 객체 생성시 정답을 만들도록 함 (생성자)
    public BaseballGame() {
        makeRandomAnswer();
    }

    // 랜덤 값 생성 (메서드)
    public void makeRandomAnswer() {
        Random random = new Random();

        for (int i = 0; randomHashSet.size() < 3; i++) {
            int randomNumber = random.nextInt(9) + 1;
            randomHashSet.add(randomNumber);
        }

        System.out.println("디버그 용 : " + randomHashSet); // 디버그용
    }

    public void play() {
        while (true) {

            // 1. 유저에게 입력값을 받음
            System.out.println("세자리 숫자를 입력하세요.");
            int number = sc.nextInt();

            // 배열에 저장하기 위해 int -> String으로 변환
            String inputString = String.valueOf(number);

            // 배열에 저장
            for (int i = 0; i < 3; i++) {
                inputHashSet.add(inputString.charAt(i) - '0');
            }

            ArrayList<Integer> randomArrayList = new ArrayList<Integer>(randomHashSet);
            System.out.println("디버그 용 : " + randomArrayList); //디버그 용


            ArrayList<Integer> inputArrayList = new ArrayList<Integer>(inputHashSet);
            System.out.println("디버그 용 : " + inputHashSet); //디버그 용


            // 2. 올바른 입력값을 받았는지 검증
            // 3. 게임 진행횟수 증가

            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (Arrays.equals(randomArrayList.toArray(), inputArrayList.toArray())) {
                System.out.println("축하합니다 정답입니다!!!");
                break;
            }


            // 4. 스트라이크 개수 계산
            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < 3; i++) {
                if (randomArrayList.get(i).equals(inputArrayList.get(i))) {
                    strikeCount++;
                } else if (randomArrayList.contains(inputArrayList.get(i))) {
                    ballCount++;
                }
            }
            System.out.println(strikeCount + " 스트라이크");
            System.out.println(ballCount + " 볼");


            // 6. 볼 개수 계산
//            int ballCount = 0;
//            for (int i = 0; i < 3; i++) {
//                if (randomArrayList.contains(inputArrayList.get(i))) {
//                    ballCount++;
//                }
//            }
//            System.out.println(ballCount + " 볼");

            // 7. 힌트 출력

            // 입력 인덱스 값 초기화
                inputHashSet.clear();
                inputArrayList.clear();
                System.out.println("---------------------------");
            }
        }


    public HashSet<Integer> getInputHashSet() {
        return inputHashSet;
    }

    public HashSet<Integer> getRandomAnswerArr() {
        return randomHashSet;
    }
}
// 게임 진행횟수 반환
//    }
//
//    protected boolean validateInput(String input) {
//
//    }
//
//    private int countStrike(String input) {
//
//    }
//
//    private int countBall(String input) {
//        for (int)
//    }

