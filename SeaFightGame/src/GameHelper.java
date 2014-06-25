import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by badcamel on 25.06.2014.
 */
public class GameHelper {

    private static final String ALPHABET = "abcdefg";
    private static final int GRID_LENGTH = 7; // Длина ряда
    private static final int GRID_SIZE = 49;  // при размере поля 7х7
    private int[] grid = new int[GRID_SIZE];

    public ArrayList<String> placeShip(int sizeShip, boolean vDirection) {

        boolean isSucces = false;

        int[] coord = new int[sizeShip];

        int increment = 1;

        if (vDirection) {
            increment = GRID_LENGTH;
        }

        while (!isSucces) {

            int location = (int) (Math.random() * GRID_SIZE);

            //System.out.println("Debug: случайное значение " + location);

            int x = 0; //индекс первой ячейки

            isSucces = true;

            while (isSucces && (x < sizeShip)) {

                if (grid[location] == 0) {

                    coord[x] = location;

                    x++;

                    if (x > 0) {
                        location += increment;

                        // Проверяем не выходят ли за границу ряда игрового поля
                        // следующие за первой ячейки
                        if ((location % GRID_LENGTH) == 0) {
                            isSucces = false;
                        }
                        // Проверяем не выходят ли за границу игрового поля
                        // следующие за первой ячейки
                        if (location >= GRID_SIZE) {
                            isSucces = false;
                        }

                    }
                } else {
                    isSucces = false;
                }

            }

        }

        // Преобразуем найденные координаты в буквенно цифровой вид
        ArrayList<String> alphaLocation = new ArrayList<String>();

        for (int x = 0; x < sizeShip; x++) {
            grid[coord[x]] = 1;         // Помечаем найденное расположение как используемые значения поля

            int row = (int) coord[x]/GRID_LENGTH;

            String tempStr = "" + ALPHABET.charAt(row) + (coord[x]%GRID_LENGTH);

            alphaLocation.add(tempStr);
        }

        System.out.println("Debug: координаты " + alphaLocation.toString());

        return alphaLocation;
    }

    public String getUserInput(String prefix) {

        String result = null;

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print(prefix);

            result = reader.readLine();

            if (result.length() == 0) {
                result = null;
            }

        } catch (IOException e) {
            System.out.println("IOerror: " + e);
        }

        return result.toLowerCase();
    }
}
