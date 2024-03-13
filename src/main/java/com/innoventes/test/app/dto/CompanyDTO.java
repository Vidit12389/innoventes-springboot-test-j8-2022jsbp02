package com.innoventes.test.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDTO {




	private Long id;

	@NotEmpty(message = "Field is mandatory")
	@Size(min = 5, message = "company Name should have at least 5 characters")
	@Column(name = "company_name")
	private String companyName;

	@NotEmpty(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	@Column(name = "email")
	private String email;

	@PositiveOrZero(message = "Strength should be a positive number or zero")
	@Column(name = "strength")
	private Integer strength;

	@Column(name = "company_code")
	@UniqueElements
	@Pattern(regexp = "[A-Za-z][2]\\d{2}[EeNn]")
	private String companyCode ;
	
	private String webSiteURL;
}
