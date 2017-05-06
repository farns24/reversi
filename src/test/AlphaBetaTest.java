package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import alpha_beta.AlphaBetaResult;
import alpha_beta.AlphaBetaSolver;
import model.Model;
import model.Player;
import view.View;

public class AlphaBetaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAiGame() {
		Model m = new Model(8);
		View v = new View(m);
		
		AlphaBetaSolver solver = new AlphaBetaSolver();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.Black).getModel();
		m = solver.alphabeta(m, 3, -50, 50, true, Player.White).getModel();
		v.setModel(m);
		v.draw();
	}

}
