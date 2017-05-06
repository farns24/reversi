package alpha_beta;

import model.Model;

public class AlphaBetaResult {

	private int value;
	private Model model;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public AlphaBetaResult(int value, Model model) {
		super();
		this.value = value;
		this.model = model;
	}
	
}
