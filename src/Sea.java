import java.util.ArrayList;
import java.util.List;

public class Sea implements BattleField {
    private List<Ship> shipList;
    private int battleFieldRows;
    private int battleFieldCols;
    private String[][] battleField;

    public Sea(int battleFieldRows, int battleFieldCols) {
        this.shipList = new ArrayList<>();
        this.setBattleFieldRows(battleFieldRows);
        this.setBattleFieldCols(battleFieldCols);
        this.setBattleField(this.getBattleFieldRows(), this.getBattleFieldCols());
    }

    private void setBattleField(int battleFieldRows, int battleFieldCols) {
        this.battleField = new String[battleFieldRows][battleFieldCols];
        for (int row = 0; row < battleFieldRows; row++) {
            for (int col = 0; col < battleFieldCols; col++) {
                this.battleField[row][col] = "~";
            }
        }
    }

    private void setBattleFieldRows(int battleFieldRows) {
        this.battleFieldRows = battleFieldRows;
    }

    private void setBattleFieldCols(int battleFieldCols) {
        this.battleFieldCols = battleFieldCols;
    }


    @Override
    public int getBattleFieldCols() {
        return this.battleFieldCols;
    }

    @Override
    public int getBattleFieldRows() {
        return this.battleFieldRows;
    }


    @Override
    public void addShip(Ship ship) {
        this.shipList.add(ship);
    }

    @Override
    public void shootAtBattleField(String fireCoordinates) {
        String[] in = fireCoordinates.split("");
        int row = Integer.valueOf(in[0]);
        int col = Integer.valueOf(in[1]);
        boolean hit = false;
        for (Ship ship : shipList) {
            List<String> shipCoordinates = ship.getCoordinates();
            for (String shipCoordinate : shipCoordinates) {
                if (shipCoordinate.equals(fireCoordinates)) {
                    System.out.printf("You've got me!\n" +
                            "You hit %s!", ship.getClass().getName());
                    hit = true;
                    this.battleField[row][col] = "X";
                    ship.shootAtShip(fireCoordinates);
                }
            }
        }
        if (!hit) {
            System.out.println(Messages.MISS);
            this.battleField[row][col] = "o";
        }

    }

    @Override
    public void PrintBattleField() {
        for (int row = 0; row < this.battleFieldRows; row++) {
            for (int col = 0; col < this.battleFieldCols; col++) {
                System.out.print(this.battleField[row][col]);
            }
            System.out.println();
        }
    }

    @Override
    public void refreshBattleField() {

    }
}
