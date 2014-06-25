import java.util.ArrayList;

/**
 * Created by badcamel on 25.06.2014.
 */
public class SeaShip {

    private String name = null;

    private int palubaCount = 3;

    private ArrayList<String> locationCells = new ArrayList<String>();

    public SeaShip() {
        super();
    }

    public SeaShip(String name) {
        this();
        this.name = name;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String checkYourself(String userGuess) {

        String result = "Мимо";

        int index = locationCells.indexOf(userGuess);

        if (index >= 0) {

            locationCells.remove(index);

            if (locationCells.isEmpty()) {

                result = "Потопил";

                System.out.println("Ой! Вы потопили корабль \"" + name + "\"");

            } else {

                result = "Попал";

            }

        }

        return result;
    }
}
