package wkkp.exceedvote.model;

/**
 * A description of each project contains name and description
 * 
 * @author Witsarut Suwanich
 */
public class ProjectDescription {
	
	/** description of project */
	private String description;
	/** name of project */
	private String name;
	
	/**
	 * Initialize the description of project
	 * @param description is a description of project
	 * @param name is a name of project
	 */
	public ProjectDescription(String description, String name) {
		System.out.println(description);
		this.description = description; 
		this.name = name;
	}

	/**
	 * @return description of this project
	 */
	public String getDescription() {
		return this.description;	
	}

	/**
	 * @return name of this project
	 */
	public String getName() {
		return this.name;
	}
}
