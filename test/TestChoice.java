import static org.junit.Assert.*;

import org.junit.Test;

import wkkp.exceedvote.model.Choice;
import wkkp.exceedvote.model.ProjectList;

/**
 * @author Kanisorn Wirutkul
 */
public class TestChoice {

	/** project list that use for create choice */
	private ProjectList prjList;
	
	public TestChoice() {
		prjList = new ProjectList();
		for (int i = 1; i <= 5; i++) {
			prjList.addProject("Description " + i, "Project " + i);
		}	
	}

	/**
	 * Compare size from getSize and the original size of project list
	 */
	@Test
	public void testGetChoiceSize() {
		Choice choice = new Choice(prjList);
		assertEquals(5, choice.getSize());
	}

	/**
	 * Test to get a choice name
	 */
	@Test
	public void testGetChoiceName() {
		Choice choice = new Choice(prjList);
		String choiceName[] = choice.getChoiceString();
		for (int i = 0; i < choice.getSize(); i++) {
			assertEquals("Project " + (i+1), choiceName[i]);
		}
	}
}
