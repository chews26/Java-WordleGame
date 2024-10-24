package WordleGame.leveled;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

public class RandomList {
    Scanner sc = new Scanner(System.in);
    protected final LinkedHashSet<Integer> inputHashSet = new LinkedHashSet<>();
    protected final LinkedHashSet<Integer> randomHashSet1 = new LinkedHashSet<>();
    protected final LinkedHashSet<Integer> randomHashSet2 = new LinkedHashSet<>();
    protected final LinkedHashSet<Integer> randomHashSet3 = new LinkedHashSet<>();
    protected final ArrayList<Integer> tryCountArr1 = new ArrayList<>();
    protected final ArrayList<Integer> tryCountArr2 = new ArrayList<>();
    protected final ArrayList<Integer> tryCountArr3 = new ArrayList<>();

    // 객체 생성시 정답을 만들도록 함 (생성자)
    public RandomList() {
        makeRandomAnswerLevel1();
        makeRandomAnswerLevel2();
        makeRandomAnswerLevel3();
    }

    // 랜덤 값 생성 (메서드)
    public void makeRandomAnswerLevel1() {
        Random random1 = new Random();
        for (int i = 0; randomHashSet1.size() < 3; i++) {
            int randomNumber = random1.nextInt(9) + 1;
            randomHashSet1.add(randomNumber);
        }
    }

    public void makeRandomAnswerLevel2() {
        Random random2 = new Random();
        for (int i = 0; randomHashSet2.size() < 4; i++) {
            int randomNumber = random2.nextInt(9) + 1;
            randomHashSet2.add(randomNumber);
        }
    }

    public void makeRandomAnswerLevel3() {
        Random random3 = new Random();
        for (int i = 0; randomHashSet3.size() < 5; i++) {
            int randomNumber = random3.nextInt(9) + 1;
            randomHashSet3.add(randomNumber);
        }
    }
}



