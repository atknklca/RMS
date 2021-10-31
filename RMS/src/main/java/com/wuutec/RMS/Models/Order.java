package com.wuutec.RMS.Models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Order")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long OrderId;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date CreatedDate;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date ExpiredDate;
	
	@Column(nullable = false)
	public BigDecimal TotalPrice;
	
	@JoinColumn(name = "OrderDetailId")
	@OneToMany(fetch = FetchType.LAZY)
	public List<OrderDetail> OrderDetails;
	
	@JoinColumn(name = "OrderId")
	@ManyToOne(fetch = FetchType.LAZY)
	public DinnerTable DinnerTable;;
	
}
