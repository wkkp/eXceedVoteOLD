package wkkp.exceedvote.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectList is the list of project that's in the eXceed camp
 * 
 * @author Witsarut Suwanich
 */
public class ProjectList implements Cloneable {

	/** list of project */
	private List<Project> listOfProject;
	/** id of project */
	private static int idGenerate = 0;

	/**
	 * Initialize the ProjectList
	 */
	public ProjectList() {
		listOfProject = new ArrayList<Project>();
	}

	/**
	 * Add a new project (with specific ID) into a list of project
	 * @param description of project
	 * @param name of project
	 */
	public void addProject(String description, String name) {
		listOfProject.add(new Project(idGenerate, description, name));
		increaseID();
	}

	/**
	 * Receive the ID of project to find the project in projectList
	 * @param projectID is the id of the project
	 * @return a project
	 */
	public Project searchFromID(int projectID) {
		int i = 0;
		while (projectID != listOfProject.get(i).getProjectID()) {
			i++;
		}
		return listOfProject.get(i);
	}

	/**
	 * Increase ID when add a new project to make ID doesn't duplicate
	 */
	private void increaseID() {
		idGenerate++;
	}

	/**
	 * @return a size of the project list
	 */
	public int getSize() {
		return listOfProject.size();
	}

	/**
	 * @return all of project name
	 */
	public String[] getProjectName() {
		String projects[] = new String[this.getSize()];
		int i = 0;
		while (i < getSize()) {
			projects[i] = listOfProject.get(i).getName();
			i++;
		}
		return projects;
	}
	
	/**
	 * Get the description of the project with ID
	 * @param id of the project that we want to get the description
	 * @return description of the project
	 */
	public String getProjectDescription(int id) {
		Project search = searchFromID(id);
		return search.getProjectDescription();
	}
}