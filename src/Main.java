
public class Main {

    public static void main(String[] args) {
        BattleField bf = new Sea(10,10);

        bf.PrintBattleField();

        bf.shootAtBattleField("55");

        bf.PrintBattleField();
    }

}
