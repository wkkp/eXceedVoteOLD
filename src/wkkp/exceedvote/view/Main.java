package wkkp.exceedvote.view;

import wkkp.exceedvote.controller.Admin;
import wkkp.exceedvote.controller.Exceed;
import wkkp.exceedvote.model.Project;
import wkkp.exceedvote.model.ProjectList;

public class Main {
	
	public static void main(String[] args) {
		Admin admin = new Admin();
		Exceed exceed = new Exceed();
		exceed.setProjectList(admin.getProjectList());
		exceed.setCriteria(admin.getCriteria());
		exceed.setChoice(admin.getChoice());
		WelcomePage wel = new  WelcomePage(exceed);
		wel.run();
	}
}
