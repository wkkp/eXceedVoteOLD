package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

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

	public static Model.Finder<String,User> find = new Model.Finder(String.class, User.class);

	public User() {

	}

	/**
     	 * Authenticate a User.
     	 */
    	public static User authenticate(String username, String password) {
        	return find.where()
            		.eq("username", username)
            		.eq("password", password)
        		.findUnique();
    	}

}