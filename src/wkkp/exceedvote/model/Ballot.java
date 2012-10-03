package wkkp.exceedvote.model;

import java.util.List;

public class Ballot {
	
	private List<Criteria> listOfCriteria;
	
	public Ballot() {
		
	}
	
	public void addCriteria(Criteria criteria) {
		listOfCriteria.add(criteria);
	}
}
