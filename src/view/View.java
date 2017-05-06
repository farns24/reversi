package view;

import javax.swing.plaf.basic.BasicScrollPaneUI.ViewportChangeHandler;

import model.BlackPiece;
import model.Model;
import model.Piece;
import model.WhitePiece;

public class View {

	public View(Model model) {
		super();
		this.model = model;
	}
	private Model model;
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public void draw()
	{
		System.out.println("Board");
		for (Piece[] row : model.getData())
		{
			for (Piece square : row)
			{
				if (square == null)
				{
					System.out.print(" - ");
				}
				else if (square instanceof WhitePiece)
				{
					System.out.print(" w ");
				}
				else if (square instanceof BlackPiece)
				{
					System.out.print(" b ");
				}
			}
			System.out.println("");
		}
		System.out.printf("White: %d    Black: %d", model.getScore().getWhiteScore(),model.getScore().getBlackScore());
	}
}
