package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import scala.reflect.generic.Trees.This;

import com.avaje.ebean.*;

@Entity
@Table(name="r_user")
public class User extends Model {

	@Id
    @Constraints.Required
    @Formats.NonEmpty
	public String userId;

	@Constraints.Required
	public String password;

	@Constraints.Required
	public String name;

	@Constraints.Required
	public Long chargeFix;

	@Constraints.Required
	public Long chargeTmp;

	@Constraints.Email
	public String mailAddress;

	public String phoneNo;

	public boolean adminFlg;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	public List<Order> user = new ArrayList<Order>();

	public static Model.Finder<String,User> find = new Model.Finder<String, User>(String.class, User.class);

	public static List<User> findAll() {
        return find.all();
    }

	public static User findByUserId(String userId) {
        return find.where().eq("userId", userId).findUnique();
    }

	public String toString() {
        return "User[userId=" + userId + "]";
    }

	public static User authenticate(String userId, String password) {
		return find.where()
            .eq("userId", userId)
            .eq("password", password)
            .findUnique();
    }
}
