import java.util.List;

public interface Ship {
    List<String> getCoordinates();
    void shootAtShip(String fireCoordinates);

}
