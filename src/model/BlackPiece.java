package model;

public class BlackPiece extends Piece {

	@Override
	public boolean isMyPiece(Player player) {
		return Player.Black == player;
	}

}
