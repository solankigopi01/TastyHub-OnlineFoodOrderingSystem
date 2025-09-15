package com.example.demo.entities;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int u_id;

	private String uname;
	private String uemail;
	private String upassword;
	private Long unumber;
	
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Orders> orders;
	
}