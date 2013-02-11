package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="e_order_detail")
public class OrderDetail extends Model {

	@Id
	public Long orderDetailNo;

	@ManyToOne
	@JoinColumn(name = "orderNo")
	public Order order;

	public Long lunchNo;

	public String shopId;

	public Date beginDate;

	public Long num;

	public Date orderDate;

	public Long unitCost;

	public static Model.Finder<String, OrderDetail> find = new Model.Finder<String, OrderDetail>(String.class, OrderDetail.class);

	public static List<OrderDetail> findAll() {
        return find.all();
    }

	public static OrderDetail findByPrimaryKeys(String orderDetailNo, String orderNo) {
        return find.where()
        		.eq("orderDetailNo", orderDetailNo)
        		.eq("order.orderNo", orderNo)
        		.findUnique();
    }

	public String toString() {
        return "OrderDetail[orderDetailNo=" + orderDetailNo + ", orderNo=" + order.orderNo + "]";
    }
}
