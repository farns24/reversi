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
	public int alphabeta(Model model, int depth, int alphaBound, int betaBound, Boolean maximizingPlayer,Player player) {
		int v;
		if (depth == 0 || model.isTerminal()) {
			return model.getScore(player);
		}
		if (maximizingPlayer) {
			v = Integer.MIN_VALUE;
			List<Model> posFutures = model.getPosFutures(player,maximizingPlayer);
			for (Model child : posFutures) {
				v = max(v, alphabeta(child, depth - 1, alphaBound, betaBound, false,player));
				alphaBound = max(alphaBound, v);
				if (betaBound <= alphaBound) {
					break;
				}
			}
			return v;
		} else {
			v = Integer.MAX_VALUE;

			for (Model child : model.getPosFutures(player,maximizingPlayer)) {
				v = min(v, alphabeta(child, depth - 1, alphaBound, betaBound, true,player));
				betaBound = min(betaBound, v);
				if (betaBound <= alphaBound) {
					break;
				}

				return v;
			}
		}
		return v;
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