package wkkp.exceedvote.controller;

import java.util.ArrayList;
import java.util.List;

import wkkp.exceedvote.model.Choice;
import wkkp.exceedvote.model.Criteria;
import wkkp.exceedvote.model.ProjectList;

public class Admin {

	private ProjectList projectList;
	private List<Criteria> criteria;
	private List<Choice> choice;

	public Admin() {
		createProjectList();
		createChoice();
		createCriteria();
	}
	
	private void createProjectList() {
		projectList = new ProjectList();
		for (int i = 1; i <= 5; i++) {
			projectList.addProject("Project " + i + " description", "Project " + i);
		}
		System.out.println("created project");
	}
	
	private void createCriteria() {
		criteria = new ArrayList<Criteria>();
		criteria.add(new Criteria("Best Software", choice.get(0)));
		//criteria.add(new Criteria("Test 2"));
		System.out.println("created criteria");
	}
	
	private void createChoice() {
		choice = new ArrayList<Choice>();
		choice.add(new Choice(this.projectList));
		choice.add(new Choice(this.projectList));
		System.out.println("created choice");
	}
	
	public ProjectList getProjectList() {
		return this.projectList;	
	}
	
	public List<Criteria> getCriteria() {
		return this.criteria;
	}
	
	public List<Choice> getChoice() {
		return this.choice;
	}
}
