package com.fssa.freshnest.model;

import java.time.LocalDate;

/**
 * The `User` class represents a user within the FreshNest application. It holds
 * information about user registration, login, profile details, and more.
 * 
 * @author SusikumarPitchaimuth
 */

public class User {

	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int age;
	private long mobileNumber;
	private LocalDate dob;
	private String nationality;
	private String profileImage;
	private String gender;
	private boolean isDelete;
	private int userId;
	private String userTheme;

	// Constructor

	// Default Constructor
	/**
	 * Creates a new User object with default values.
	 */

	public User() {

	}

	// User first registration constructor
	/**
	 * Creates a new User object for the first registration step.
	 *
	 * @param email        User's email address
	 * @param username     User's username
	 * @param password     User's password
	 * @param firstName    User's first name
	 * @param lastName     User's last name
	 * @param profileImage URL to the user's profile image
	 */

	// User first registration constructor
	public User(String email, String username, String password, String firstName, String lastName,
			String profileImage) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profileImage = profileImage;
	}

	// User second page registration constructor
	/**
	 * Creates a new User object for the second registration step.
	 *
	 * @param dob    User's date of birth
	 * @param gender User's gender
	 * @param email  User's email address
	 */
	// user second page registration constructor
	public User(LocalDate dob, String gender, String email) {
		this.dob = dob;
		this.gender = gender;
		this.email = email;
	}

	/**
	 * Creates a new User object for user login.
	 *
	 * @param email    User's email address
	 * @param password User's password
	 */
	// User login constructor
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	// User delete data constructor
	/**
	 * Creates a new User object for marking user data for deletion.
	 *
	 * @param email    User's email address
	 * @param isDelete Indicates if the user's account is marked for deletion
	 */
	public User(String email, boolean isDelete) {
		this.email = email;
		this.isDelete = isDelete;
	}

	// User update constructor
	/**
	 * Creates a new User object for updating user profile information.
	 *
	 * @param username     User's username
	 * @param firstName    User's first name
	 * @param lastName     User's last name
	 * @param mobileNumber User's mobile number
	 * @param dob          User's date of birth
	 * @param nationality  User's nationality
	 * @param gender       User's gender
	 */
	public User(String username, String firstName, String lastName, long mobileNumber, LocalDate dob,
			String nationality, String gender) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.dob = dob;
		this.nationality = nationality;
		this.gender = gender;
	}

	// Email constructor
	/**
	 * Creates a new User object based on email address.
	 *
	 * @param email User's email address
	 */
	public User(String email) {
		this.email = email;
	}

	// User profile update constructor
	/**
	 * Creates a new User object for updating the user's profile image.
	 *
	 * @param profileImage URL to the user's updated profile image
	 * @param userId       Unique identifier for the user
	 */
	public User(String profileImage, int userId) {
		this.profileImage = profileImage;
		this.userId = userId;
	}

	// Getters and setters

	/**
	 * Gets the unique identifier of the user.
	 *
	 * @return The unique identifier of the user
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the unique identifier of the user.
	 *
	 * @param userId The unique identifier of the user
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Checks if the user's account is marked for deletion.
	 *
	 * @return `true` if the user's account is marked for deletion, otherwise
	 *         `false`
	 */
	public boolean getIsDelete() {
		return isDelete;
	}

	/**
	 * Sets the flag indicating if the user's account is marked for deletion.
	 *
	 * @param isDelete `true` if the user's account is marked for deletion,
	 *                 otherwise `false`
	 */
	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * Gets the user's age.
	 *
	 * @return The user's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the user's age.
	 *
	 * @param age The user's age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the user's mobile number.
	 *
	 * @return The user's mobile number
	 */
	public long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Sets the user's mobile number.
	 *
	 * @param mobileNumber The user's mobile number
	 */
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Gets the user's date of birth.
	 *
	 * @return The user's date of birth
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * Sets the user's date of birth.
	 *
	 * @param dob The user's date of birth
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * Gets the user's nationality.
	 *
	 * @return The user's nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * Sets the user's nationality.
	 *
	 * @param nationality The user's nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * Gets the URL to the user's profile image.
	 *
	 * @return The URL to the user's profile image
	 */
	public String getProfileImage() {
		return profileImage;
	}

	/**
	 * Sets the URL to the user's profile image.
	 *
	 * @param profileImage The URL to the user's profile image
	 */
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	/**
	 * Gets the user's gender.
	 *
	 * @return The user's gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the user's gender.
	 *
	 * @param gender The user's gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the user's email address.
	 *
	 * @return The user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the user's email address.
	 *
	 * @param email The user's email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the user's username.
	 *
	 * @return The user's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the user's username.
	 *
	 * @param username The user's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the user's password.
	 *
	 * @return The user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the user's password.
	 *
	 * @param password The user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the user's first name.
	 *
	 * @return The user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the user's first name.
	 *
	 * @param firstName The user's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the user's last name.
	 *
	 * @return The user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the user's last name.
	 *
	 * @param lastName The user's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the user's chosen theme.
	 *
	 * @return The user's chosen theme
	 */
	public String getUserTheme() {
		return userTheme;
	}

	/**
	 * Sets the user's chosen theme.
	 *
	 * @param userTheme The user's chosen theme
	 */
	public void setUserTheme(String userTheme) {
		this.userTheme = userTheme;
	}

	/**
	 * Returns a string representation of the User object.
	 *
	 * @return A string containing the values of the user's fields
	 */

	@Override
	public String toString() {
		return "User{" + "email='" + email + '\'' + ", username='" + username + '\'' + ", password='" + password + '\''
				+ ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", userTheme='" + userTheme
				+ '\'' + ", age=" + age + ", mobileNumber=" + mobileNumber + ", dob='" + dob + '\'' + ", nationality='"
				+ nationality + '\'' + ", profileImage='" + profileImage + '\'' + ", gender='" + gender + '\''
				+ ", isDelete=" + isDelete + ", userId=" + userId +

				'}';
	}
}
