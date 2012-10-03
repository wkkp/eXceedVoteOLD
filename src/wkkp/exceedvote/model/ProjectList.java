package wkkp.exceedvote.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectList implements Cloneable {

	private List<Project> listOfProject;
	private static int idGenerate = 0;

	public ProjectList() {
		listOfProject = new ArrayList<Project>();
	}

	public void addProject(String description, String name) {
		listOfProject.add(new Project(idGenerate, description, name));
		increaseID();
	}

	public Project searchFromID(int projectID) {
		int i = 0;
		while (projectID != listOfProject.get(i).getProjectID()) {
			i++;
		}
		return listOfProject.get(i);
	}

	private void increaseID() {
		idGenerate++;
	}

	public int getSize() {
		return listOfProject.size();
	}

	public String[] getProjectName() {
		String projects[] = new String[this.getSize()];
		int i = 0;
		while (i < getSize()) {
			projects[i] = listOfProject.get(i).getName();
			i++;
		}
		return projects;
	}
	
	public String getProjectDescription(int id) {
		Project search = searchFromID(id);
		return search.getProjectDescription();
	}
}