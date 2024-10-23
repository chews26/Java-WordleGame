package WordleGame.leveling;

import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        RandomList randomList = new RandomList();
        GamePlay levelOne = new ThreeDigitGame();
        GamePlay levelTwo = new FourDigitGame();
        GamePlay levelThree = new FiveDigitGame();
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
                    int choiceLevel = sc.nextInt();
                    sc.nextLine();
                    switch (choiceLevel) {
                        case 1:
                            randomList.makeRandomAnswerLevel1();
                            levelOne.Gameplay();
                            continue;
                        case 2:
                            randomList.makeRandomAnswerLevel2();
                            levelTwo.Gameplay();
                            continue;
                        case 3:
                            randomList.makeRandomAnswerLevel3();
                            levelThree.Gameplay();
                            continue;
                    }
                case 2:
                    System.out.println("< Wordle 게임을 기록 보기 >");
                    levelOne.Gameresult();
                    levelTwo.Gameresult();
                    levelThree.Gameresult();
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

