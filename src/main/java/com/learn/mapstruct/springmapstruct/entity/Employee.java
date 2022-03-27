package com.learn.mapstruct.springmapstruct.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.learn.mapstruct.springmapstruct.dto.Address;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private Long sal;
	private String gender;
	private Date dob;
	private int desk;
	private List<Address> empAddrList;
	
}
