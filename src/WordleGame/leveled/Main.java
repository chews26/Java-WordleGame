package WordleGame.leveled;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RandomList randomList = new RandomList();
        GamePlay levelOne = new Level1Game();
        GamePlay levelTwo = new Level2Game();
        GamePlay levelThree = new Level3Game();
        Scanner sc = new Scanner(System.in);

        System.out.println("============ 숫자 야구 게임! ============");

        game:
        while (true) {
            System.out.println("< 환영합니다. 원하시는 번호를 입력해주세요. >");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기, 3. 종료하기.");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("< 숫자 야구 게임을 시작합니다. >");
                    System.out.println("게임 난이도를 설정해주세요.");
                    System.out.println("1. level1   2. level2   3. level3 ");
                    int choiceLevel = sc.nextInt();
                    sc.nextLine();
                    switch (choiceLevel) {
                        case 1:
                            randomList.makeRandomAnswerLevel1();
                            levelOne.gamePlay();
                            continue;
                        case 2:
                            randomList.makeRandomAnswerLevel2();
                            levelTwo.gamePlay();
                            continue;
                        case 3:
                            randomList.makeRandomAnswerLevel3();
                            levelThree.gamePlay();
                            continue;
                    }
                case 2:
                    System.out.println("< Wordle 게임을 기록 보기 >");
                    levelOne.gameResult();
                    levelTwo.gameResult();
                    levelThree.gameResult();
                    System.out.println("===============================================");
                    continue;
                case 3:
                    System.out.println("< 게임을 종료합니다. >");
                    break game;
            }
        }
        System.out.println("---------------------------");
    }
}

