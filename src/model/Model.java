package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	
	private Piece[][] data;

	private int center;
	public Model(int size) {
		super();
		data = new Piece[size][size];
		center = (size/2);
	}
	
	public Model(Model other)
	{
		center = other.center;
		int size = other.data.length;
		data = new Piece[size][size];
		
		for (int i = 0; i <size; i++)
		{
			for (int j = 0; j<size;j++)
			{
				if (other.data[i][j] == null)
				{
					
				}
				else if (other.data[i][j] instanceof WhitePiece)
				{
					data[i][j] = new WhitePiece();
				}
				else
				{
					data[i][j] = new BlackPiece();
				}
				
			}
		}
	}

	public Score getScore()
	{
		int white = 0;
		int black = 0;
		for (int i = 0; i <data.length; i++)
		{
			for (int j = 0; j<data.length;j++)
			{
				if (data[i][j] == null)
				{
					
				}
				else if (data[i][j] instanceof WhitePiece)
				{
					white++;				
				}
				else
				{
					black++;
				}
				
			}
		}
		return new Score(white,black);
	}
	
	public Piece[][] getData() {
		return data;
	}

	public void setData(Piece[][] data) {
		this.data = data;
	}
	
	public void move(int x, int y, Player player) throws InvalidMoveException
	{
		//Move cannot be out of bounds
		if (x<0||y<0||x>=data.length||y>=data.length)
		{
			throw new InvalidMoveException("Coordinants are out of bounds");
		}
		//Piece cannot be placed on an occupied position
		 if (data[y][x]!=null)
		 {
			 throw new InvalidMoveException("Space already occupied");
		 }
		
		
		//first four moves must be in the center squares 
		if (!isCenterPosisition(x,y))
		{
			if (!centerFull())
			{
				throw new InvalidMoveException("Must fill center positions first");
			}
			//A piece must be placed in such a way that there exists a direct path to another position
			if (!pathToSameColorExists(x,y,player)&& centerFull())
			{
				throw new InvalidMoveException("There is no path that exists to the same color");
			}
		}
		
		//Finally, Update the board
		Piece piece= null;
		if (player == Player.Black)
		{
			piece = new BlackPiece();
		}
		else
		{
			piece = new WhitePiece();
		}
		
		data[y][x] = piece;
		
		//Check to see if game is over.
		
		
		
	}

	public boolean canPlayerMove(Player player)
	{
		int count = getPosFutures(player, true).size();
		return count>0;
	}
	
	private boolean pathToSameColorExists(int x, int y, Player player) {
	
		
		
		boolean pathExists = check4PathUp(x,y,player) |
		check4PathDown(x,y,player) |
		check4PathLeft(x,y,player) |
		check4PathRight(x,y,player) |
		Check4PathNW(x,y,player) |
		Check4PathNE(x,y,player) |
		Check4PathSW(x,y,player) |
		Check4PathSE(x,y,player);
		
		return pathExists;
	}

	private boolean Check4PathSE(int x, int y, Player player) {
		List<Position> piecesToflip = new ArrayList<Position>();
		OtherFinder otherFound = new OtherFinder();
		while(++x>data.length && ++y <data.length)
		{
			
			Outcome out = checkStep(x,y,otherFound, piecesToflip,player);
			switch (out)
			{
			case False:
				return false;
			case True:
				return true;
			
			}
		}
		
		return false;
	}

	private boolean Check4PathSW(int x, int y, Player player) {
		List<Position> piecesToflip = new ArrayList<Position>();
		OtherFinder otherFound = new OtherFinder();
		while(--x>-1 && ++y <data.length)
		{
			
			Outcome out = checkStep(x,y,otherFound, piecesToflip,player);
			switch (out)
			{
			case False:
				return false;
			case True:
				return true;
			
			}
		}
		
		return false;
	}

	private boolean Check4PathNE(int x, int y, Player player) {
		List<Position> piecesToflip = new ArrayList<Position>();
		OtherFinder otherFound = new OtherFinder();
		while(++x<data.length && --y >-1)
		{
			
			Outcome out = checkStep(x,y,otherFound, piecesToflip,player);
			switch (out)
			{
			case False:
				return false;
			case True:
				return true;
			
			}
		}
		
		return false;
	}

	private boolean Check4PathNW(int x, int y, Player player) {
		List<Position> piecesToflip = new ArrayList<Position>();
		OtherFinder otherFound = new OtherFinder();
		while(--x>-1 && --y >-1)
		{
			
			Outcome out = checkStep(x,y,otherFound, piecesToflip,player);
			switch (out)
			{
			case False:
				return false;
			case True:
				return true;
			
			}
		}
		
		return false;
	}

	private boolean check4PathRight(int x, int y, Player player) {
		List<Position> piecesToflip = new ArrayList<Position>();
		OtherFinder otherFound = new OtherFinder();
		while(++x<data.length)
		{
			
			Outcome out = checkStep(x,y,otherFound, piecesToflip,player);
			switch (out)
			{
			case False:
				return false;
			case True:
				return true;
			
			}
		}
		
		return false;
	}

	private boolean check4PathLeft(int x, int y, Player player) {
		List<Position> piecesToflip = new ArrayList<Position>();
		OtherFinder otherFound = new OtherFinder();
		while(--x>-1)
		{
			
			Outcome out = checkStep(x,y,otherFound, piecesToflip,player);
			switch (out)
			{
			case False:
				return false;
			case True:
				return true;
			
			}
		}
		
		return false;
	}

	private boolean check4PathDown(int x, int y, Player player) {
		List<Position> piecesToflip = new ArrayList<Position>();
		OtherFinder otherFound = new OtherFinder();
		while(++y<data.length)
		{
			
			Outcome out = checkStep(x,y,otherFound, piecesToflip,player);
			switch (out)
			{
			case False:
				return false;
			case True:
				return true;
			
			}
		}
		
		return false;
	}

	private boolean check4PathUp(int x, int y, Player player) {
		
		List<Position> piecesToflip = new ArrayList<Position>();
		
		OtherFinder otherFound = new OtherFinder();
		while(--y>-1)
		{
			Outcome out = checkStep(x,y,otherFound, piecesToflip,player);
			switch (out)
			{
			case False:
				return false;
			case True:
				return true;
			
			}
		}
		
		return false;
	}

	private Outcome checkStep(int x, int y, OtherFinder otherFound, List<Position> piecesToflip, Player player) {
		if (data[y][x]==null)
		{
			return Outcome.False;
		}
		else if (!data[y][x].isMyPiece(player))
		{
			piecesToflip.add(new Position(x, y));
			otherFound.setOtherFound(true);;
		}
		else if (data[y][x].isMyPiece(player)&&otherFound.isOtherFound())
		{
			for(Position p: piecesToflip)
			{
				data[p.y][p.x] = Piece.buildPiece(player);
			}
			
			return Outcome.True;
		}
		return Outcome.Inconclusive;
	}

	/**
	 * 
	 */
	private boolean centerFull() {
		
		return checkSpace(center,center) && checkSpace(center-1,center)&& checkSpace(center,center-1)&& checkSpace(center-1,center-1);
	}

	private boolean checkSpace(int x, int y) {
		return data[y][x]!=null;
	}

	private boolean isCenterPosisition(int x, int y) {
		
		return ( x==center || x == center-1 ) && ( y==center || y == center-1);
	}

	public boolean isTerminal() {
		
		return !canPlayerMove(Player.Black)&&!canPlayerMove(Player.White);
	}

	public List<Model> getPosFutures(Player player, Boolean maximizingPlayer) {
		
		List<Model> results = new ArrayList<Model>();
		for (int i = 0; i< data.length;i++)
		{
			for(int j = 0;j< data.length;j++)
			{
				Model posFuture = new Model(this);
				try {
					posFuture.move(i,j, player);
					results.add(posFuture);
				} catch (InvalidMoveException e) {
				
				}
			}
		}
		
		return results;
	}

	public int getScore(Player player) {
		
		Score score = getScore();
		
		if (player == Player.Black)
		{
			return score.blackScore;
		}
		return score.whiteScore;
	}
	
}
