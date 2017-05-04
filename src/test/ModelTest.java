package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.InvalidMoveException;
import model.Model;
import model.Player;
import view.View;

public class ModelTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void game1()
	{
		Player black = Player.Black;
		Player white = Player.White;
		Model m = new Model(8);
		View v = new View(m);
		v.draw();
		
		//Black goes first
		try {
			m.move(3, 3, black);
		} catch (InvalidMoveException e) {
			fail("Should have allowed move");
			e.printStackTrace();
		}
		v.draw();
		
		//White tries same spot
		try {
			m.move(3, 3, white);
			fail("Should have blocked move");
		} catch (InvalidMoveException e) {
			
		}
		v.draw();
		//White tries spot outside
		try {
			m.move(2, 2, white);
			fail("Should have blocked move");
		} catch (InvalidMoveException e) {
			
		}
		v.draw();
		//White tries same spot
		try {
			m.move(3, 4, white);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
			e.printStackTrace();
		}
		v.draw();
		//Black fills 4,3
		try {
			m.move(4, 3, black);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
			e.printStackTrace();
		}
		v.draw();
		//White fills 4,4
		try {
			m.move(4, 4, white);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
			e.printStackTrace();
		}
		
		//Black tries to move in a place it cannot: 3,2
		v.draw();
		try {
			m.move(3, 2, black);
			fail("Should have blocked move");
		} catch (InvalidMoveException e) {
		
		}
		v.draw();
		try {
			m.move(2, 5, black);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
		}
		
		v.draw();
		try {
			m.move(2, 4, white);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
		}
		
		v.draw();
		try {
			m.move(5, 5, black);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
		}
		
		v.draw();
		
		try {
			m.move(4, 2, white);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
		}
		
		v.draw();
		
		try {
			m.move(2, 3, black);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
		}
		
		v.draw();
		
		try {
			m.move(1, 5, white);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
		}
		
		v.draw();
		
		try {
			m.move(1, 4, black);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
		}
		
		v.draw();
		
		try {
			m.move(1, 3, white);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
		}
		
		v.draw();
		
		try {
			m.move(0, 3, black);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
		}
		
		v.draw();
		
		try {
			m.move(5, 4, white);
			
		} catch (InvalidMoveException e) {
			fail("Should have blocked move");
		}
		
		v.draw();
		
		try {
			m.move(0, 6, white);
			fail("White Should not be allowed to make this move");
		} catch (InvalidMoveException e) {
			
		}
		
		v.draw();
		
	}
	

}
