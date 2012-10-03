package wkkp.exceedvote.model;

public class Project {	

	private int id;
	private ProjectDescription description;
	
	public Project(int id, String description, String name) {
		this.description = new ProjectDescription(description, name);
		this.id = id;
	}
	
	public int getProjectID() {
		return this.id;
	}
	
	public String getProjectDescription() {
		return this.description.getDescription();
	}
	
	public String getName() {
		return this.description.getName();
	}
}
