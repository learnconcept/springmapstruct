package com.learn.mapstruct.springmapstruct.dto;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDto {
	
	private int id;
	private String empName;
	private Long sal;
	private String gender;
	private String dob;
	private int desk;
	private List<Address> empAddrList;

}
