package wkkp.exceedvote.model;

import java.util.List;

/**
 * The criteria of vote
 * 
 * @author Witsarut Suwanich
 */
public class Criteria {
	/* a criterion to vote */
	private String criterion;
	/* choice for each criterion */
	private Choice choice;

	/**
	 * Initialize each of criteria
	 * @param criterion 
	 * @param choice that use with this criteria
	 */
	public Criteria(String criterion, Choice choice) {	
		this.criterion = criterion;
		this.choice = choice;
	}
	/**
	* @return the criterion
	*/
	public String getCriterion() {
		return this.criterion;
	}

	/**
	* @return choice of the criterion
	*/	
	public Choice getChoice() {
		return this.choice;
	}

	/**
	* @return size of choice
	*/
	public int getChoiceSize() {
		return choice.getSize();
	}
}
