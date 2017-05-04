package model;

public abstract class Piece {

	public abstract boolean isMyPiece(Player player);

	public static Piece buildPiece(Player player) {
		if (player == Player.Black)
		{
			return new BlackPiece();
		}
		else
		{
			return new WhitePiece();
		}
	}

}
