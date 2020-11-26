package de.tekup.vue.models.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	
	private String name;
	private String email;
	private String password;
	// add these type to the Form
	private String gender;
	private String note;
	private boolean married;
	private LocalDate birthdate;
	private String profession;

}
