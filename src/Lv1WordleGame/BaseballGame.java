package Lv1WordleGame;

import java.util.LinkedHashSet;
import java.util.Random;

public class BaseballGame {
    public static void main(String[] args) {

    }
    private LinkedHashSet<Integer> inputArr = new LinkedHashSet<Integer>();
    private LinkedHashSet<Integer> randomAnswerArr = new LinkedHashSet<Integer>();

    // 객체 생성시 정답을 만들도록 함 (생성자)
    public BaseballGame() {
        makeRandomAnswer();
    }

    // 랜덤 값 생성 (메서드)
    public void makeRandomAnswer() {
        Random random = new Random();

        for (int i = 0; randomAnswerArr.size() < 3; i++) {
            int randomNumber = random.nextInt(9) + 1;
            randomAnswerArr.add(randomNumber);
        }

        System.out.println(randomAnswerArr);
    }


    public int play(int number) {
        boolean checkInput = false;

        while (!checkInput) {
            // 배열에 저장하기 위해 int -> String으로 변환
            String inputString = String.valueOf(number);


            // 배열에 저장
            for (int i = 0; i < 3; i++) {
                inputArr.add(inputString.charAt(i) - '0');
            }

            System.out.println(inputArr);
//            return 0;

            // 2. 올바른 입력값을 받았는지 검증
            if (inputArr.contains(0)) {
                System.out.println("0은 입력될 수 없습니다.");
            }

            // 3. 게임 진행횟수 증가
            // 4. 스트라이크 개수 계산
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출

            // 6. 볼 개수 계산
            // 7. 힌트 출력


        }
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

