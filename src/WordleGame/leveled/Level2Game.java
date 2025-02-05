package WordleGame.leveled;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Level2Game extends GamePlay {
    @Override
    public void gamePlay() {
        int levelNum = 4;

        while (true) {
            try {
                // 유저에게 입력값을 받음
                System.out.println("네자리 숫자를 입력하세요.");
                int number = sc.nextInt();

                // 네자리 숫자가 아닐 경우 알림
                if (number < 1000 || number > 9999) {
                    System.out.println("네자리 숫자가 아닌 값은 입력할 수 없습니다.");
                    System.out.println("---------------------------");
                    continue;
                }

                // 배열에 저장하기 위해 int -> String으로 변환
                String inputString = String.valueOf(number);


                // Hashset 배열에 저장 후 정수로 변환
                for (int i = 0; i < levelNum; i++) {
                    int value = inputString.charAt(i) - '0';
                    inputHashSet.add(value);
                }

                // 중복 값 알림
                if (inputHashSet.size() < levelNum) {
                    System.out.println("중복된 숫자가 있습니다. 서로 다른 숫자를 입력해주세요.");
                    System.out.println("---------------------------");
                    inputHashSet.clear();
                    continue;
                }

                if (inputHashSet.contains(0)) {
                    System.out.println("입력값에 0이 포함될 수 없습니다.");
                    System.out.println("---------------------------");
                    inputHashSet.clear();
                    continue;
                }

                ArrayList<Integer> randomArrayList = new ArrayList<>(randomHashSet2);
                ArrayList<Integer> inputArrayList = new ArrayList<>(inputHashSet);

                if (Arrays.equals(randomArrayList.toArray(), inputArrayList.toArray())) {
                    System.out.println("축하합니다 정답입니다!!!");
                    System.out.println("===============================================");
                    inputHashSet.clear(); // 입력값 배열 초기화
                    randomHashSet2.clear(); // 랜덤값 배열 초기화
                    sc.nextLine(); // 버퍼 삭제
                    makeRandomAnswerLevel2(); // 랜덤값 재생성

                    super.tryCountArr2.add(super.tryCount);
                    super.tryCount = 0;
                    break;
                }

                // 스트라이크, 볼 개수 계산
                String out = "";
                int strikeCount = 0;
                int ballCount = 0;
                for (int i = 0; i < levelNum; i++) {
                    if (randomArrayList.get(i).equals(inputArrayList.get(i))) {
                        strikeCount++;
                    } else if (randomArrayList.contains(inputArrayList.get(i))) {
                        ballCount++;
                    } else {
                        out = "아웃";
                    }
                }

                // 힌트 출력
                if (strikeCount == 0 && ballCount == 0) {
                    System.out.println(out);
                } else {
                    System.out.println(strikeCount + " 스트라이크");
                    System.out.println(ballCount + " 볼");
                }

                // try count 구하기
                super.tryCount++;

                // 입력 인덱스 값 초기화
                inputHashSet.clear();
                inputArrayList.clear();
                System.out.println("---------------------------");

                // 에러 출력
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 입력입니다. 숫자를 입력하세요.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
    public void gameResult() {
        System.out.println("Lv2 게임기록");
        for (int i = 0; i < super.tryCountArr2.size(); i++) {
            System.out.println((i + 1) + "번째 게임 : " + super.tryCountArr2.get(i) + "회 시도 후 성공");
        }
    }
}

