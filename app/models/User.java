package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public int type_id;
	public String username;
	public String password;
	//private String nontri_account;
	private static final long serialVersionUID = 1L;

	public User() {

	}

}