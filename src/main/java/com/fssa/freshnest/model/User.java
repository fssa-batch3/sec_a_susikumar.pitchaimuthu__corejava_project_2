package com.fssa.freshnest.model;

public class User {

    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private long mobileNumber;
    private String dob;
    private String nationality;
    private String profileImage;
    private String gender;
    private boolean isDelete;
    private int userId;

    // User first registration contrustor
    public User(String email, String username, String password, String firstName, String lastName,
                String profileImage) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
    }

    // user second page resgistration constructor
    public User(String dob, String gender, String email) {
        this.dob = dob;
        this.gender = gender;
        this.email = email;
    }

    // User login constructor
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // User delete data constructor
    public User(String email, boolean isDelete) {
        this.email = email;
        this.isDelete = isDelete;
    }

    // User update constructor
    public User(String email, String username, String password, String firstName, String lastName, int age,
                long mobileNumber, String dob, String nationality, String gender) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.dob = dob;
        this.nationality = nationality;
        this.gender = gender;
    }

    // User profile update constructor
    public User(String profileImage, int userId) {
        this.profileImage = profileImage;
        this.userId = userId;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIs_delete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
