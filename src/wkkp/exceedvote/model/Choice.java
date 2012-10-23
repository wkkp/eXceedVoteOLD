package wkkp.exceedvote.model;

/**
 * Choice in the ballot for vote
 * 
 * @author Witsarut Suwanich 
 */
public class Choice {

	/** list of choice comes from list of project */
	private ProjectList listOfChoice;
	
	/**
	 * Initialize choice
	 * @param listOfChoice is a list of project that will use to be a choice
	 */
	public Choice(ProjectList listOfChoice) {
		this.listOfChoice = listOfChoice; 
	}

	/**
	 * @return a list of all choice as a string
	 */
	public String[] getChoiceString() {
		return listOfChoice.getProjectName();
	}

	/**
	 * @return a size of choice
	 */
	public int getSize() {
		return listOfChoice.getSize();
	}
}
