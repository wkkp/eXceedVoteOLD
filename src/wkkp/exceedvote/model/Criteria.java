package wkkp.exceedvote.model;

import java.util.List;

public class Criteria {
	
	private String criterion;
	private Choice choice;
	
	public Criteria(String criterion, Choice choice) {	
		this.criterion = criterion;
		this.choice = choice;
	}
	
	public String getCriterion() {
		return this.criterion;
	}
	
	public Choice getChoice() {
		return this.choice;
	}
	
	public int getChoiceSize() {
		return choice.getSize();
	}
}
