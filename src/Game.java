import alpha_beta.AlphaBetaSolver;
import model.InvalidMoveException;
import model.Model;
import model.Player;
import model.Position;
import view.View;

/**
 * Created by michael on 5/13/17.
 */
public class Game {

    private UI ui = new UI();
    private String usage = "reversi <h/c> <h/c> <board size> [<depth>]";
    private int alphaBound = -50;
    private int betaBound = 50;

    public static void main(String[] args) {
        Game g = new Game();
        if (!g.verify(args)) {
            System.out.printf("Usage: %s\n", g.usage);
            System.out.println("For example, to start a game with human player as black against an AI white oppenent:");
            System.out.println("reversi h c 8 3");
            return;
        }

        int boardSize = Integer.parseInt(args[3]);
        int depth = 3;
        if (args.length == 5) depth = Integer.parseInt(args[4]);

        if (args[1].equals("c") && args[2].equals("c")) {
            g.ui.displayIntro("computer", "computer", boardSize, depth);
            g.playCvC(boardSize, depth);
        }
        if (args[1].equals("h") && args[2].equals("c")) {
            g.ui.displayIntro("human", "computer", boardSize, depth);
            g.playHvC(boardSize, depth);
        }
        if (args[1].equals("c") && args[2].equals("h")) {
            g.ui.displayIntro("computer", "human", boardSize, depth);
            g.playCvH(boardSize, depth);
        }
        if (args[1].equals("h") && args[2].equals("h")) {
            g.ui.displayIntro("human", "human", boardSize, -1);
            g.playHvH(boardSize);
        }
    }

    private boolean verify(String[] args) {
        if (args.length < 4 || args.length > 5) return false;
        if (!args[1].equals("h") && !args[1].equals("c")) return false;
        if (!args[2].equals("h") && !args[2].equals("c")) return false;
        int size;
        try {
            size = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            return false;
        }
        if (size%2 != 0) return false;

        if (args.length == 5) {
            int depth;
            try {
                depth = Integer.parseInt(args[4]);
            } catch (NumberFormatException e) {
                return false;
            }
            if (depth <= 0) return false;
        }

        return true;
    }

    public void playCvC(int boardSize, int depth) {
        Model m = new Model(boardSize);
        View v = new View(m);
        v.draw();

        AlphaBetaSolver solver = new AlphaBetaSolver();
        while (!m.isTerminal()) {
            if (m.canPlayerMove(Player.Black)) {
                System.out.println("Black to move...");
                m = solver.alphabeta(m, depth, alphaBound, betaBound, true, Player.Black).getModel();
                v.setModel(m);
                v.draw();
            }

            if (m.canPlayerMove(Player.White)) {
                System.out.println("White to move...");
                m = solver.alphabeta(m, depth, alphaBound, betaBound, true, Player.White).getModel();
                v.setModel(m);
                v.draw();
            }
        }
    }

    public void playHvC(int boardSize, int depth) {
        Model m = new Model(boardSize);
        View v = new View(m);
        v.draw();

        AlphaBetaSolver solver = new AlphaBetaSolver();
        while (!m.isTerminal()) {

            if (m.canPlayerMove(Player.Black)) {
                System.out.println("Black to move...");
                boolean flag = true;
                while (flag) {
                    Position p = ui.getPlayerMove(boardSize);
                    try {
                        m.move(p.x, p.y, Player.Black);
                        flag = false;
                    } catch (InvalidMoveException e) {
                        System.out.printf("Invalid move\n");
                    }
                }
                v.draw();
            }

            if (m.canPlayerMove(Player.White)) {
                System.out.println("White to move...");
                m = solver.alphabeta(m, depth, alphaBound, betaBound, true, Player.White).getModel();
                v.setModel(m);
                v.draw();
            }
        }
    }

    public void playCvH(int boardSize, int depth) {
        Model m = new Model(boardSize);
        View v = new View(m);
        v.draw();

        AlphaBetaSolver solver = new AlphaBetaSolver();
        while (!m.isTerminal()) {

            if (m.canPlayerMove(Player.Black)) {
                System.out.println("Black to move...");
                m = solver.alphabeta(m, depth, alphaBound, betaBound, true, Player.Black).getModel();
                v.setModel(m);
                v.draw();
            }

            if (m.canPlayerMove(Player.White)) {
                System.out.println("White to move...");
                boolean flag = true;
                while (flag) {
                    Position p = ui.getPlayerMove(boardSize);
                    try {
                        m.move(p.x, p.y, Player.White);
                        flag = false;
                    } catch (InvalidMoveException e) {
                        System.out.printf("Invalid move\n");
                    }
                }
                v.draw();
            }
        }
    }

    public void playHvH(int boardSize) {
        Model m = new Model(boardSize);
        View v = new View(m);
        v.draw();

        while (!m.isTerminal()) {

            if (m.canPlayerMove(Player.Black)) {
                System.out.println("Black to move...");
                boolean flag = true;
                while (flag) {
                    Position p = ui.getPlayerMove(boardSize);
                    try {
                        m.move(p.x, p.y, Player.Black);
                        flag = false;
                    } catch (InvalidMoveException e) {
                        System.out.printf("Invalid move\n");
                    }
                }
                v.draw();
            }

            if (m.canPlayerMove(Player.White)) {
                System.out.println("White to move...");
                boolean flag = true;
                while (flag) {
                    Position p = ui.getPlayerMove(boardSize);
                    try {
                        m.move(p.x, p.y, Player.White);
                        flag = false;
                    } catch (InvalidMoveException e) {
                        System.out.printf("Invalid move\n");
                    }
                }
                v.draw();
            }
        }

    }


}
