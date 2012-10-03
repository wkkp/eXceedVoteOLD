package wkkp.exceedvote.model;

public class ProjectDescription {
	
	private String description;
	private String name;
	
	public ProjectDescription(String description, String name) {
		System.out.println(description);
		this.description = description; 
		this.name = name;
	}

	public String getDescription() {
		return this.description;	
	}
	
	public String getName() {
		return this.name;
	}
}
