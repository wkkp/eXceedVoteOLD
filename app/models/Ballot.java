package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="ballot")
public class Ballot extends Model {

	@Id
	public Long id;
	public Long user_id;
	public Long project_id;
	public int score;
	private static final long serialVersionUID = 1L;

	public static Finder<Long,Ballot> find = new Finder(Long.class, Ballot.class);

	public Ballot() {
		super();	
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return this.score;
	}

}