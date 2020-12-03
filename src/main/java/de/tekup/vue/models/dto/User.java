package de.tekup.vue.models.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	private LocalDate birthDate = LocalDate.now();
	private String profession;
	
	
	public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate);
	}
	
	public String getBirthDate() {
		return birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

}
