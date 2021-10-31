package com.wuutec.RMS.Models;

import java.math.BigDecimal;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long ProductId;

	@Column(length = 25, nullable = false)
	public String ProductName;

	@Column(length = 200)
	public String ProductDescription;

	@Column(nullable = false)
	public BigDecimal ProductPrice;

	@Column(nullable = false)
	public Integer ProductOrderCount;
	
	@Column(nullable = false)
	public String ProductPicturePath;
	
	@Column
	public boolean IsThereForProduct;

	@JoinColumn(name = "ProductId")
	@ManyToOne(fetch = FetchType.LAZY)
	public Category Category;
	
	@JoinColumn(name = "ProductId")
	@ManyToOne(fetch = FetchType.LAZY)
	public Restaurant Restaurant;
	
	@JoinColumn(name = "OrderDetailId")
	@OneToMany(fetch = FetchType.LAZY)
	public List<OrderDetail> OrderDetails;

}
