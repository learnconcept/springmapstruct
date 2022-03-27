package com.learn.mapstruct.springmapstruct.mapper;

import java.util.List;
import java.util.UUID;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.learn.mapstruct.springmapstruct.dto.EmployeeDto;
import com.learn.mapstruct.springmapstruct.entity.Employee;


@Mapper(componentModel="spring")
public interface EmployeeMapper {
	
	EmployeeMapper instance = Mappers.getMapper(EmployeeMapper.class);
	
	@Mapping(source="employee.name",target="empName", defaultValue="TestName")
	public EmployeeDto entityToDto(Employee employee);
	
	public List<EmployeeDto> entitysToDtos(List<Employee> employee);
	@InheritInverseConfiguration
	public Employee DtoToEntity(EmployeeDto employeeDto);
	
}
