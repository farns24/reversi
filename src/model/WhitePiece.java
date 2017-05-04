package model;

public class WhitePiece extends Piece{

	@Override
	public boolean isMyPiece(Player player) {
		// TODO Auto-generated method stub
		return player == Player.White;
	}

}
