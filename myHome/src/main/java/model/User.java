package model;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotEmpty( message="계정 중복 검사를 해야합니다.")
	private String idChecked;
	
	private String user_id;
	@NotEmpty(message="암호를 입력하세요")
	private String user_pw;
	@NotEmpty(message="이름을 입력하세요")
	private String name;
	@NotEmpty(message="주소를 입력하세요")
	private String addr;
	@NotEmpty(message="연락처를 입력하세요")
	private String phone;
	@NotEmpty(message="성별을 선택하세요")
	private String gender;
	private Integer grade;
	@NotEmpty(message="이메일을 입력하세요")
	private String email;
	@NotEmpty(message="날짜를 선택하세요.")
	private String birth;
	private String job;
	
	
	public String getIdChecked() {
		return idChecked;
	}
	public void setIdChecked(String idChecked) {
		this.idChecked = idChecked;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
