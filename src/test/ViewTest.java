package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.InvalidMoveException;
import model.Model;
import model.Player;
import view.View;

public class ViewTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Model m1 = new Model(5);
		View v = new View(m1);
		v.draw();
		
		try {
			m1.move(0, 0, Player.Black);
		} catch (InvalidMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		v.draw();
		try {
			m1.move(0, 1, Player.White);
		} catch (InvalidMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		v.draw();
		
	}

}
