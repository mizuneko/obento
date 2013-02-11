package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="r_shop")
public class Shop extends Model {

	@Id
	public String shopId;

	public String name;

	public String address;

	public String tel;

	public String payday;

	public Date nonWorkDateStart;

	public Date nonWorkDateEnd;

	public static Model.Finder<String,Shop> find = new Model.Finder<String, Shop>(String.class, Shop.class);

	public static List<Shop> findAll() {
        return find.all();
    }

	public static Shop findByShopId(String shopId) {
        return find.where().eq("shopId", shopId).findUnique();
    }

	public String toString() {
        return "Shop[shopId=" + shopId + "]";
    }
}
