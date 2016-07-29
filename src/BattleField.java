
public interface BattleField {

    int getBattleFieldRows();

    int getBattleFieldCols();

    void addShip(Ship ship);

    void shootAtBattleField(String coordinates);

    void PrintBattleField();

    void refreshBattleField();
}
