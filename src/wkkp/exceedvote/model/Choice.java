package wkkp.exceedvote.model;

public class Choice {

	private ProjectList listOfChoice;
	
	public Choice(ProjectList listOfChoice) {
		this.listOfChoice = listOfChoice; 
	}
	
	public String[] getChoiceString() {
		return listOfChoice.getProjectName();
	}
	
	public int getSize() {
		return listOfChoice.getSize();
	}
}
