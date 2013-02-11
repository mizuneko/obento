package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="r_lunch")
public class Lunch extends Model {

	@Id
	public String shopId;

	@Id
	public Long lunchNo;

	public String name;

	public Long unitCost;

	public static Model.Finder<String,Lunch> find = new Model.Finder<String, Lunch>(String.class, Lunch.class);

	public static List<Lunch> findAll() {
        return find.all();
    }

	public static Lunch findByUserId(String shopId, String lunchNo) {
        return find.where()
        	.eq("shopId", shopId)
        	.eq("lunchNo", lunchNo)
        	.findUnique();
    }

	public String toString() {
        return "Lunch[shopId=" + shopId + ", lunchNo=" + lunchNo + "]";
    }
}
