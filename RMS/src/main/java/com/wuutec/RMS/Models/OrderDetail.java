package com.wuutec.RMS.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "OrderDetail")
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long OrderDetailId;
	
	@Column(nullable = false,length = 2)
	public Integer ProductQuantity;

	@JoinColumn(name = "OrderDetailId")
	@ManyToOne
	public Order Order;
	
	@JoinColumn(name = "OrderDetailId")
	@ManyToOne(fetch = FetchType.LAZY)
	public Product Product;
}
