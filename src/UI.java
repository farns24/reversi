import model.Position;
import java.util.Scanner;

/**
 * Created by michael on 5/13/17.
 */
public class UI {

    public void displayIntro(String bPlayer, String wPlayer, int boardSize, int depth)
    {
        System.out.printf("Beginning new game with:\n");
        System.out.printf("\tblack player as a %s\n", bPlayer);
        System.out.printf("\twhite player as a %s\n", wPlayer);
        System.out.printf("on a board of size: %d\n\n", boardSize);

        if (depth != -1) {
            System.out.printf("AI using depth = %d\n\n", depth);
        }
    }

    public Position getPlayerMove(int boardSize) {
        int x = getValue(boardSize, "x");
        int y = getValue(boardSize, "y");
        return new Position(x, y);
    }

    public int getValue(int boardSize, String name) {
        Scanner s = new Scanner(System.in);
        System.out.printf("Enter %s: ", name);

        int value = -1;
        try {
            while (value < 0 || value >= boardSize) {
                value = s.nextInt();
                if (value < 0 || value >= boardSize) {
                    System.out.printf("Must enter number between 0 and %d: ", boardSize-1);
                }
            }
        } catch (Exception e) {
            System.out.printf("Must enter number!\n");
            getPlayerMove(boardSize);
        }
        return value;
    }
}
