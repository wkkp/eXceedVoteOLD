import static org.junit.Assert.*;

import org.junit.Test;

import wkkp.exceedvote.model.Project;

/**
 * @author Piyoungoon Pavachansatit 
 */
public class TestProject {

	/**
	 * Test to get the project id, it must get the correct id 
	 */
	@Test
	public void testGetProjectID() {
		Project prj = new Project(1, "Description", "Project 1");
		assertEquals(1, prj.getProjectID());
	}

	/**
	 * Test to get a name of project 
	 */
	@Test
	public void testGetProjectName() {
		Project prj = new Project(1, "Description", "Project 1"); 
		assertEquals("Project 1", prj.getName());
	}

	/**
	 * Test to get a project description
	 */
	@Test
	public void testGetProjectDescription() {
		Project prj = new Project(1, "Description", "Project 1");	
		assertEquals("Description", prj.getProjectDescription());
	}
}
