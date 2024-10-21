package Lv1WordleGame;

import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        BaseballGame baseballGamest = new BaseballGame();

        Scanner sc = new Scanner(System.in);
        // 1. 유저에게 입력값을 받기

        System.out.println("<<<<Wordle 게임을 시작합니다.>>>>");
        baseballGamest.play();
    }
}

