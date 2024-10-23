package WordleGame.leveling;

// 게임 플레이를 실행하는 추상메서드
// 추상메서드로 게임 레벨별로 분기가 가능하게 설정
abstract class GamePlay extends RandomList {

    protected int tryCount1 = 0;
    protected int tryCount2 = 0;
    protected int tryCount3 = 0;

    public abstract void Gameresult();

    public abstract void Gameplay();
}
