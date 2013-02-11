package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="e_charge")
public class Charge extends Model {

	@Id
	public Long historyNo;

	public String userId;

	public Date chargeDate;

	public Long amount;

	public Long balance;

	public boolean chargeFlg;

	public static Model.Finder<String,Charge> find = new Model.Finder<String, Charge>(String.class, Charge.class);

	public static List<Charge> findAll() {
        return find.all();
    }

	public static Charge findByUserId(String historyNo) {
        return find.where().eq("historyNo", historyNo).findUnique();
    }

	public String toString() {
        return "Charge[historyNo=" + historyNo + "]";
    }
}
