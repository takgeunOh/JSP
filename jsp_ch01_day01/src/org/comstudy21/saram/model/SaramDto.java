package org.comstudy21.saram.model;

public class SaramDto {
	int no;
	String name;
	String Phone;
	String email;
	
	SaramDto() {
		this(0,"","","");
	}
	
	public SaramDto(int no, String name, String Phone, String email) {
		this.no = no;
		this.name = name;
		this.Phone = Phone;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", name=" + name + ", Phone=" + Phone + ", email=" + email + "]";
	}
	
	
}
