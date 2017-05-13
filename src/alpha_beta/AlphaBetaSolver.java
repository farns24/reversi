package alpha_beta;

import java.util.List;

import model.Model;
import model.Player;

public class AlphaBetaSolver {

	/**
	 * Modeled after Wikipedia psudocode
	 * @param model
	 * @param depth
	 * @param alphaBound
	 * @param betaBound
	 * @param maximizingPlayer
	 * @param player
	 * @return
	 */
	public AlphaBetaResult alphabeta(Model model, int depth, int alphaBound, int betaBound, Boolean maximizingPlayer,Player player) {
		int v;
		if (depth == 0 || model.isTerminal()) {
			return new AlphaBetaResult(model.getScore(player),model);
		}
		if (maximizingPlayer) {
			v = Integer.MIN_VALUE;
			Model bestChild = null;
			List<Model> posFutures = model.getPosFutures(player,maximizingPlayer);
			if (posFutures.size()==0) {
				return new AlphaBetaResult(0, model);
			}
			if (posFutures.size()==1)
			{
				return new AlphaBetaResult(0, posFutures.get(0));
			}
			for (Model child : posFutures) {

				//Look deeper if considering corner
//				depth += child.getInterestingLevel();
				int score = alphabeta(child, depth - 1, alphaBound, betaBound, false,player).getValue();
				if (score>v)
				{
					bestChild = child;
					v = score;
					alphaBound = max(alphaBound, v);
					if (betaBound <= alphaBound) {
						break;
					}
				}
				
				//
				//v = max(v, alphabeta(child, depth - 1, alphaBound, betaBound, false,player));
				
				//Find out which child produced the best answer
				
			}
			return new AlphaBetaResult(v, bestChild);
		} else {
			v = Integer.MAX_VALUE;
			Model bestChild = null;
			List<Model> posFutures =model.getPosFutures(player,maximizingPlayer);
			if (posFutures.size()==0) {
				return new AlphaBetaResult(0, model);
			}
			if (posFutures.size()==1)
			{
				return new AlphaBetaResult(0, posFutures.get(0));
			}
			
			
			for (Model child : posFutures) {
				
				int score = alphabeta(child, depth - 1, alphaBound, betaBound, true,player).getValue();
				
				if (score<v)
				{
					v= score;
					bestChild = child;
					betaBound = min(betaBound, v);
					if (betaBound <= alphaBound) {
						break;
					}

				}
	//			v = min(v, alphabeta(child, depth - 1, alphaBound, betaBound, true,player));
				
//				return v;
			}
			return new AlphaBetaResult(v, bestChild);
		}
	}

	private int min(int v, int alphabeta) {

		if (v < alphabeta) {
			return v;
		}

		return alphabeta;
	}

	private int max(int v, int alphabeta) {
		if (v > alphabeta) {
			return v;
		}
		return alphabeta;
	}
}