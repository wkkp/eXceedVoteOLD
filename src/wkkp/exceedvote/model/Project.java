package wkkp.exceedvote.model;

/**
 * Project in eXceedVote which contains project id and project description
 * 
 * @author Witsarut Suwanich
 */
public class Project {	
	/* an id of each project */
	private int id;
	/* a description of each project */
	private ProjectDescription description;
	
	public Project(int id, String description, String name) {
		this.description = new ProjectDescription(description, name);
		this.id = id;
	}
	
	/**
	* @return an project id
	*/
	public int getProjectID() {
		return this.id;
	}
	
	/**
	* @return a project description
	*/
	public String getProjectDescription() {
		return this.description.getDescription();
	}
	
	/**
	* @return a project name
	*/
	public String getName() {
		return this.description.getName();
	}
}
