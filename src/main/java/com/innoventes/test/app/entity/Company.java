package com.innoventes.test.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.innoventes.test.app.dto.EvenNumberOrZero;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
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
	@EvenNumberOrZero
	private Integer strength;

	@Column(name = "company_code")
	@UniqueElements
	@Pattern(regexp = "[A-Za-z][2]\\d{2}[EeNn]")
	private String companyCode ;

	@Column(name = "website_url")
	private String webSiteURL;
}
