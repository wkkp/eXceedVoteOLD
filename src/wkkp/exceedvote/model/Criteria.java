package wkkp.exceedvote.model;

import java.util.List;

/** 
* The criteria of vote
*/
public class Criteria {
	/* a criterion to vote */
	private String criterion;
	/* choice for each criterion */
	private Choice choice;
	
	public Criteria(String criterion, Choice choice) {	
		this.criterion = criterion;
		this.choice = choice;
	}
	/**
	* To get the criterion
	* @return the criterion
	*/
	public String getCriterion() {
		return this.criterion;
	}

	/**
	* To get the choice of each criterion
	* @return choice of the criterion
	*/	
	public Choice getChoice() {
		return this.choice;
	}

	/**
	* To get the size of choice
	* @return size of choice
	*/
	public int getChoiceSize() {
		return choice.getSize();
	}
}
