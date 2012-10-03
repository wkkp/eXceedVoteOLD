package wkkp.exceedvote.controller;

import java.util.List;

import org.apache.log4j.Logger;

import wkkp.exceedvote.model.Choice;
import wkkp.exceedvote.model.Criteria;
import wkkp.exceedvote.model.ProjectList;

public class Exceed {
	
	private ProjectList projectList;
	private List<Criteria> criteria;
	private List<Choice> choice;
	private static Logger log = Logger.getLogger(Exceed.class);
	
	public Exceed() {
		projectList = new ProjectList();
	}	
	
	public void setProjectList(ProjectList projectList) {
		this.projectList = projectList;
	}
	
	public void setCriteria(List<Criteria> criteria) {
		this.criteria = criteria;
	}
	
	public void setChoice(List<Choice> choice) {
		this.choice = choice;
	}
	
	public String[] getAllProjectName() {
		return projectList.getProjectName();
	}
	
	public String getProjectDescription(int id) {
		return projectList.getProjectDescription(id);
	}
	
	public String[] getCriteria() {
		String criterion [] = new String[criteria.size()];
		for (int i = 0; i < criteria.size(); i++) {
			criterion[i] = criteria.get(i).getCriterion();
		}
		return criterion;
	}
	
	public String[] getChoiceFromCriteria(int num) {
		return criteria.get(num).getChoice().getChoiceString();
	}
	
	public int getChoiceSize(int index) {
		return this.criteria.get(index).getChoiceSize();
	}
	
	public int getCriteriaSize() {
		return criteria.size();
	}
	
	public void saveVote(String name) {
		log.info(name);
	}
}