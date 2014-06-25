import java.util.ArrayList;

/**
 * Created by badcamel on 25.06.2014.
 */
public class SeaFightGame {

    public static final int SIZE_SHIP = 3;
    private int numOfGuesses = 0;
    private ArrayList<SeaShip> listShips = new ArrayList<SeaShip>();
    private GameHelper helper = new GameHelper();

    public static void main(String[] args) {

        SeaFightGame game = new SeaFightGame();

        game.setUpGame();

        game.playing();

    }

    private void setUpGame() {

        SeaShip ship1 = new SeaShip("Яценюк");
        listShips.add(ship1);
        SeaShip ship2 = new SeaShip("Турчинов");
        listShips.add(ship2);
        SeaShip ship3 = new SeaShip("Порошенко");
        listShips.add(ship3);

        boolean vAlign = false;

        for ( SeaShip ship : listShips ) {
            ArrayList<String> newLocation = helper.placeShip(SIZE_SHIP,vAlign);
            ship.setLocationCells(newLocation);

            vAlign = !vAlign;
        }

    }

    private void playing() {

        while (!listShips.isEmpty()) {
            checkUserGuess();
        }

        System.out.println("Вы потопили все корабли с " + numOfGuesses + " попыток(и)");

    }

    public void checkUserGuess() {

        String result = "Мимо";

        numOfGuesses++;

        String userGuess = helper.getUserInput("Введите координаты ячейки: ");

        for (SeaShip ship : listShips) {
            result =  ship.checkYourself(userGuess);

            if (result.equals("Попал")) {
                break;
            }

            if (result.equals("Потопил")) {
                listShips.remove(ship);
                break;
            }
        }

        if (!result.equals("Потопил")) {
            System.out.println(result);
        }
    }

}
