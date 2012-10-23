package wkkp.exceedvote.view;

import wkkp.exceedvote.controller.Admin;
import wkkp.exceedvote.controller.Exceed;

/**
 * 
 * @author Witsarut Suwanich
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		Exceed exceed = new Exceed();
		exceed.setProjectList(admin.getProjectList());
		exceed.setCriteria(admin.getCriteria());
		exceed.setChoice(admin.getChoice());
		WelcomePage welcome = new WelcomePage(exceed);
		welcome.run();
	}

}
