package com.wuutec.RMS.Models;

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
@Table(name = "Category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long CategoryId;

	@Column(nullable = false, length = 25)
	public String CategoryName;
	
	@Column(nullable = false,length = 200)
	public String CategoryPicturePath;

	@JoinColumn(name = "CategoryId")
	@ManyToOne(fetch = FetchType.LAZY)
	public Restaurant Restaurant;

	@JoinColumn(name = "ProductId")
	@OneToMany(fetch = FetchType.LAZY)
	public List<Product> Products;
}
