package Lv1WordleGame;

import java.util.*;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    private final LinkedHashSet<Integer> inputHashSet = new LinkedHashSet<>();
    private final LinkedHashSet<Integer> randomHashSet = new LinkedHashSet<>();
    private final ArrayList<Integer> tryCountArr = new ArrayList<>();
    private int tryCount = 0;


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

//        System.out.println("디버그 용 : " + randomHashSet); // 디버그용
    }

    // 게임 플레이
    public void play() {
        while (true) {
            try {
                // 1. 유저에게 입력값을 받음
                System.out.println("세자리 숫자를 입력하세요.");
                int number = sc.nextInt();

                // 세자리 숫자가 아닐 경우 알림
                if (number < 100 || number > 999) {
                    throw new Exception("세자리 숫자가 아닌 값은 입력할 수 없습니다..");
                }

                // 배열에 저장하기 위해 int -> String으로 변환
                String inputString = String.valueOf(number);

                // Hashset 배열에 저장 후 정수로 변환
                for (int i = 0; i < 3; i++) {
                    int value = inputString.charAt(i) - '0';
                    // 중복된 값이 있을 경우 알림
                    if (inputHashSet.contains(value)) {
                        throw new Exception("중복된 숫자가 있습니다. 서로 다른 숫자를 입력해주세요.");
                    } else {
                    inputHashSet.add(value);
                }
                    }


                // 배열 입력값 중 0이 포함되어 있을 경우 알림
                if (inputHashSet.contains(0)) {
                    throw new Exception("입력값에 0이 포함될 수 없습니다.");
                }

                ArrayList<Integer> randomArrayList = new ArrayList<>(randomHashSet);
//                System.out.println("디버그 용 : " + randomArrayList); //디버그 용


                ArrayList<Integer> inputArrayList = new ArrayList<>(inputHashSet);
//                System.out.println("디버그 용 : " + inputHashSet); //디버그 용


                // 2. 올바른 입력값을 받았는지 검증
                // 3. 게임 진행횟수 증가

                // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
                if (Arrays.equals(randomArrayList.toArray(), inputArrayList.toArray())) {
                    System.out.println("축하합니다 정답입니다!!!");
                    System.out.println("===============================================");
                    inputHashSet.clear();
                    randomHashSet.clear();
                    sc.nextLine();
                    tryCountArr.add(tryCount);
                    tryCount = 0;
//                    System.out.println("디버그용 : " + tryCountArr.toString()); // 디버그용
                    break;
                }


                // 4. 스트라이크, 볼 개수 계산
                String out = "";
                int strikeCount = 0;
                int ballCount = 0;
                for (int i = 0; i < 3; i++) {
                    if (randomArrayList.get(i).equals(inputArrayList.get(i))) {
                        strikeCount++;
                    } else if (randomArrayList.contains(inputArrayList.get(i))) {
                        ballCount++;
                    } else {
                        out = "아웃";
                    }
                }

                // 7. 힌트 출력
                if (strikeCount == 0 && ballCount == 0) {
                    System.out.println(out);
                } else {
                    System.out.println(strikeCount + " 스트라이크");
                    System.out.println(ballCount + " 볼");
                }


                // try count 구하기
                tryCount++;
//                System.out.println("디버그용 : " + tryCountArr.toString()); // 디버그용


                // 입력 인덱스 값 초기화
                inputHashSet.clear();
                inputArrayList.clear();
                System.out.println("---------------------------");


                // 에러 출력
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 입력입니다. 숫자를 입력하세요");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }

    //게임 진행횟수 반환
    protected void validateInput() {
//        System.out.println(correctAnswerCountArr + " " + tryCountArr); // 디버그용
        for (int i = 0; i < tryCountArr.size(); i++) {
            System.out.println((i + 1) + "번째 게임 : " + tryCountArr.get(i) + "회 시도 후 성공");
            System.out.println("===============================================");
        }
    }
}

//
//    private int countStrike(String input) {
//
//    }
//
//    private int countBall(String input) {
//        for (int)
//    }
//}

