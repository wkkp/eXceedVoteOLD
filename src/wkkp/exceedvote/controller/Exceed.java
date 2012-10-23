package wkkp.exceedvote.controller;

import java.util.List;

import org.apache.log4j.Logger;

import wkkp.exceedvote.model.Choice;
import wkkp.exceedvote.model.Criteria;
import wkkp.exceedvote.model.ProjectList;

/**
 * A controller for the exceed vote
 * @author Witsarut Suwanich
 */
public class Exceed {
	/* the project list in eXceed Vote */
	private ProjectList projectList;
	/* the criteria to vote */
	private List<Criteria> criteria;
	/* the choice of each criteria */
	private List<Choice> choice;
	/* Logger */
	private static Logger log = Logger.getLogger(Exceed.class);

	/**
	 * Initialize the controller
	 */
	public Exceed() {
		projectList = new ProjectList();
	}
	
	/**
	 * To set the project list to the eXceedVote
 	 * @param projectList for vote that created by admin
	 */
	public void setProjectList(ProjectList projectList) {
		this.projectList = projectList;
	}
	
	/**
	 * To set the criteria to the eXceedVote
	 * @param criteria for vote that created by admin
	 */
	public void setCriteria(List<Criteria> criteria) {
		this.criteria = criteria;
	}
	
	/**
	 * To set the choice to the eXceedVote
	 * @param choice for criteria that created by admin
	 */
	public void setChoice(List<Choice> choice) {
		this.choice = choice;
	}
	
	/**
	 * @return the project name
	 */
	public String[] getAllProjectName() {
		return projectList.getProjectName();
	}
	
	/**
	 * To get the project description
	 * @param id for get the project description
	 * @return the project description
	 */
	public String getProjectDescription(int id) {
		return projectList.getProjectDescription(id);
	}
	
	/**
	 * @return the criteria for vote
	 */
	public String[] getCriteria() {
		String criterion [] = new String[criteria.size()];
		for (int i = 0; i < criteria.size(); i++) {
			criterion[i] = criteria.get(i).getCriterion();
		}
		return criterion;
	}
	
	/**
	 * To get the size of criteria
	 * @param index of the criteria reference to the choice
	 * @return the choice
	 */
	public String[] getChoiceFromCriteria(int index) {
		return criteria.get(index).getChoice().getChoiceString();
	}
	
	/**
	 * To get the size of choice
	 * @param index of the criteria reference to the choice
	 * @return the size of choice
	 */
	public int getChoiceSize(int index) {
		return this.criteria.get(index).getChoiceSize();
	}
	
	/**
	 * To get the size of criteria
	 * @return the size of the criteria
	 */
	public int getCriteriaSize() {
		return criteria.size();
	}
	
	/**
	 * To save the result from voter and name of voter
	 * @param name the voter
	 */
	public void saveVote(String name) {
		log.info(name);
	}
}