import static org.junit.Assert.*;

import org.junit.Test;

import wkkp.exceedvote.model.Choice;
import wkkp.exceedvote.model.Criteria;
import wkkp.exceedvote.model.ProjectList;

/**
 * @author Kittinan Pongpianskul
 */
public class TestCriteria {

	/** original choice for create criterion */
	private Choice choice;
	
	public TestCriteria() {
		ProjectList prjList = new ProjectList();
		for (int i = 1; i <= 5; i++) {
			prjList.addProject("Description " + i, "Project " + i);
		}
		choice = new Choice(prjList);
	}
	
	/**
	 * Test to get the criterion 
	 */
	@Test
	public void testGetCriteriaName() {
		Criteria criterion = new Criteria("Best Graphic", choice);
		assertEquals("Best Graphic", criterion.getCriterion());
		Criteria criterion2 = new Criteria("Best Software", choice);
		assertEquals("Best Software", criterion2.getCriterion());
	}

	/**
	 * Test to get choice from each criterion 
	 */
	@Test
	public void testGetChoiceSize() {
		Criteria criterion = new Criteria("Best Software", choice);
		assertEquals(5, criterion.getChoiceSize());
		Criteria criterion2 = new Criteria("Beest Software", choice);
		assertEquals(5, criterion2.getChoiceSize());
	}
	
	/**
	 * Test to get choice from criterion and compare to the original choice
	 */
	@Test
	public void testGetChoice() {
		Criteria criterion = new Criteria("Beest Software", choice);
		Choice tempChoice = criterion.getChoice();
		assertEquals(choice, tempChoice);
	}
}
