package model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "B_SEQ")
	@SequenceGenerator(sequenceName = "bill_seq", allocationSize = 1, name = "B_SEQ")
	private Long billId;
	private LocalDateTime billDate;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="orderId")
	private OrderDetails order;
	private int totalItem;
	private double totalCost;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(Long billId, LocalDateTime billDate, OrderDetails order, int totalItem, double totalCost) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.order = order;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
	}
	public Long getBillId() {
		return billId;
	}
	public void setBillId(Long billId) {
		this.billId = billId;
	}
	public LocalDateTime getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}
	public OrderDetails getOrder() {
		return order;
	}
	public void setOrder(OrderDetails order) {
		this.order = order;
	}
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	

}
