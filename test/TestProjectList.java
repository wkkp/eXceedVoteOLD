import static org.junit.Assert.*;

import org.junit.Test;

import wkkp.exceedvote.model.ProjectList;

/**
 * @author Witsarut Suwanich
 */
public class TestProjectList {

	/**
	 * Test create a project and add into a project list
	 */
	@Test
	public void testCreateProject() {
		ProjectList prjList = new ProjectList();
		prjList.addProject("Description 1", "Project 1");
		assertEquals(1, prjList.getSize());
		prjList.addProject("Description 2", "Project 2");
		assertEquals(2, prjList.getSize());
		prjList.addProject("Description 3", "Project 3");
		assertEquals(3, prjList.getSize());
	}

	/**
	 * Test to get all the project name in project list
	 */
	@Test
	public void testGetProjectName() {
		ProjectList prjList = new ProjectList();
		prjList.addProject("Description 1", "Project 1");
		prjList.addProject("Description 2", "Project 2");
		prjList.addProject("Description 3", "Project 3");
		String prjName[] = prjList.getProjectName();
		for (int i = 0; i < prjList.getSize(); i++) {
			assertEquals("Project " + (i+1), prjName[i]);
		}
	}

}
