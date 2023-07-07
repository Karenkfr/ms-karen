package br.com.karen.payrollapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Double hourlyPrice;
}
