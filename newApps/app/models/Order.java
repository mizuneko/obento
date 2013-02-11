package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.Model;

import com.avaje.ebean.validation.*;

@Entity
@Table(name = "e_order")
public class Order extends Model {

	@Id
    public Long orderNo;

	@NotNull
	public String orderMonth;

	@ManyToOne
    public User user = new User();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	public List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();

	public static Model.Finder<Long, Order> find = new Model.Finder<Long, Order>(Long.class, Order.class);

	public static boolean isMember(Long order, String user) {
        return find.where()
            .eq("user", user)
            .eq("orderNo", order)
            .findRowCount() > 0;
    }

	public static List<Order> findInvolving(String user) {
		return find.where()
			.eq("user.userId", user)
			.findList();
	}

	public String toString() {
		return "Order[orderNo=" + orderNo + "]";
	}
}
