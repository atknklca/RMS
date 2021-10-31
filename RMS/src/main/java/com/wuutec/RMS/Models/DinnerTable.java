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
@Table(name = "DinnerTable")
@NoArgsConstructor
@AllArgsConstructor
public class DinnerTable {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long DinnerTableId;
	
	@Column(length = 20,nullable = false)
	public String DinnerTableName;
	
	@Column
	public boolean IsAvaliable;

	@JoinColumn(name = "OrderId")
	@OneToMany(fetch = FetchType.LAZY)
	public List<Order> Orders;
	
	@JoinColumn(name = "DinnerTableId")
	@ManyToOne(fetch = FetchType.LAZY)
	public Restaurant Restaurant;

}
