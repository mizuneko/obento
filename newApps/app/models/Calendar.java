package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.Model;

import com.avaje.ebean.validation.*;

@Entity
@Table(name = "r_calendar")
public class Calendar extends Model {

	@Id
	public String day;

	public boolean holidayFlg;

	public static Model.Finder<String, Calendar> find = new Model.Finder<String, Calendar>(String.class, Calendar.class);

	public static List<Calendar> findAll() {
        return find.all();
    }

	public static Calendar findByDay(String day) {
        return find.where().eq("day", day).findUnique();
    }

	public String toString() {
        return "Calendar[day=" + day + "]";
    }
}
