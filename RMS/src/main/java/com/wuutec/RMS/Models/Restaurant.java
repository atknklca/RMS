package com.wuutec.RMS.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Restaurant")
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long Id;
	
	@Column(name = "CompanyName", length = 50, nullable = false)
	public String CompanyName;
	
	@Column(name = "Address")
	public String Address;
	
	@Column
	public String Phone;
	
	@Column(nullable = false)
	public String RestaurantLogoPath;
	
	@JoinColumn(name = "DinnerTableId")
	@OneToMany(fetch = FetchType.LAZY)
	public List<DinnerTable> DinnerTables;
	
	@JoinColumn(name = "CategoryId")
	@OneToMany(fetch = FetchType.LAZY)
	public List<Category> Categories;
	
	@JoinColumn(name = "ProductId")
	@OneToMany(fetch = FetchType.LAZY)
	public List<Product> Products;

}
