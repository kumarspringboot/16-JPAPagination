package com.alt.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name="employee")
//following annotations all are presentin Data lombok annotation.
//@Setter
//@Getter
//@NoArgsConstructor
//@ToString
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="empid",nullable=false,length=100)
	private int id;
	private String name;
	private String stream;
	@Column(name="mobile_no",updatable = false)
	private Long contactNo;
	private String address;
	private int salary;
	@CreationTimestamp
	@Column(insertable = true)
	private Date recordCreated;
}
