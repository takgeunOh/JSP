package org.comstudy21.saram.model;

public class SaramDto {
	private int no;
	private String name, phone, email;
	
	public SaramDto() {
		this(0,"","","");
	}

	public SaramDto(int no, String name, String phone, String email) {
		this.no = no;
		this.name = name;
		this.phone = phone;
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
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SaramDto [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(no < 0) result = prime * result + name.hashCode();
		else result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SaramDto) {
			SaramDto other = (SaramDto) obj;
			if(no >= 0) {
				if (no == other.getNo()) {
					return true;
				}
			}else {
				if(name!=null && name.equals(other.getName()) ) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return new SaramDto(no, name, phone, email);
	}

	
}
