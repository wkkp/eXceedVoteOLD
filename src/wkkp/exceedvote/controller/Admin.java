package wkkp.exceedvote.controller;

import java.util.ArrayList;
import java.util.List;

import wkkp.exceedvote.model.Choice;
import wkkp.exceedvote.model.Criteria;
import wkkp.exceedvote.model.ProjectList;

/**
 * Administrator system (temporary) for create all of project, criteria and choice to vote
 * 
 * @author Witsarut Suwanich
 */
public class Admin {

	/** all of project */
	private ProjectList projectList;
	/** list of criteria in ballot */
	private List<Criteria> criteria;
	/** list of choice in ballot */
	private List<Choice> choice;

	/**
	 * Initialize a projectlist, criteria and choice in ballot
	 */
	public Admin() {
		createProjectList();
		createChoice();
		createCriteria();
	}
	
	/*
	 * Create all of project and add in the list of project
	 */
	private void createProjectList() {
		projectList = new ProjectList();
		for (int i = 1; i <= 5; i++) {
			projectList.addProject("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean at metus purus. In vitae augue augue. Vestibulum quis pretium lectus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sit amet lorem ut augue aliquam eleifend et sed libero. Nam nec purus augue, in rutrum sapien. Etiam mollis est at nisi consectetur sit amet euismod sem pulvinar. Etiam aliquet fringilla mi eget pellentesque. Pellentesque nulla orci, iaculis sed facilisis vitae, euismod aliquet felis. Nullam semper erat at lectus adipiscing vel faucibus purus congue. Integer luctus commodo lacus ac tempor. Nunc mauris mi, ullamcorper tristique aliquet vitae, malesuada nec ipsum.", "Project " + i);
		}
		System.out.println("created project");
	}
	
	/**
	 * Create criteria for ballot
	 */
	private void createCriteria() {
		criteria = new ArrayList<Criteria>();
		criteria.add(new Criteria("Best Software", choice.get(0)));
		criteria.add(new Criteria("Best Graphic", choice.get(0)));
		//criteria.add(new Criteria("Best ", choice.get(0)));
		//criteria.add(new Criteria("Test 2"));
		System.out.println("created criteria");
	}

	/**
	 * Create choice for ballot
	 */
	private void createChoice() {
		choice = new ArrayList<Choice>();
		choice.add(new Choice(this.projectList));
		choice.add(new Choice(this.projectList));
		System.out.println("created choice");
	}

	/**
	 * @return list of the project
	 */
	public ProjectList getProjectList() {
		return this.projectList;	
	}

	/**
	 * @return list of criteria
	 */
	public List<Criteria> getCriteria() {
		return this.criteria;
	}

	/**
	 * @return list of choice
	 */
	public List<Choice> getChoice() {
		return this.choice;
	}
}
