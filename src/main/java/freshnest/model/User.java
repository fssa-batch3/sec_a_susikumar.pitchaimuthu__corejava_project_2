package freshnest.model;

import java.sql.Date;

public class User {

	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int age;
	private long mobile_number;
	private Date dob;
	private String nationality;
	private String profile_image;
	private String gender;
	private boolean is_delete;

	public User(String email, String username, String password, String firstName, String lastName) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(String email, boolean is_delete) {
		this.email = email;
		this.is_delete = is_delete;
	}

	public User(String email, String username, String password, String firstName, String lastName, int age,
			long mobile_number, Date dob, String nationality, String profile_image, String gender) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.mobile_number = mobile_number;
		this.dob = dob;
		this.nationality = nationality;
		this.profile_image = profile_image;
		this.gender = gender;
	}

	public boolean getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
