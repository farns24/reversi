package model;

public class Score {

	int whiteScore = 0;
	int blackScore = 0;
	public Score(int white, int black) {
		this.whiteScore = white;
		this.blackScore = black;
	}
	public int getWhiteScore() {
		return whiteScore;
	}
	public void setWhiteScore(int whiteScore) {
		this.whiteScore = whiteScore;
	}
	public int getBlackScore() {
		return blackScore;
	}
	public void setBlackScore(int blackScore) {
		this.blackScore = blackScore;
	}
}
