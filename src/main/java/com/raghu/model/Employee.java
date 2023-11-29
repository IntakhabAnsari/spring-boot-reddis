package com.raghu.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 private String empName;
	 private Double empSal;
	 
}
