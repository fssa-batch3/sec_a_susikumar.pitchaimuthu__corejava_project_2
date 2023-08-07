package freshnest.model;

public class Invite {

	private int user_id;
	private String invite_type;
	private String invite_date;
	private String invite_time;
	private String special_person;
	private String invite_slogan;
	private String invite_explanation;
	private int invite_id;
	// Constructor

	// Invite create constructor
	public Invite(int user_id, String invite_type, String invite_date, String invite_time, String special_person,
			String invite_slogan, String invite_explanation) {
		this.user_id = user_id;
		this.invite_type = invite_type;
		this.invite_date = invite_date;
		this.invite_time = invite_time;
		this.special_person = special_person;
		this.invite_slogan = invite_slogan;
		this.invite_explanation = invite_explanation;
	}

	// Invite update constructor
	public Invite(int user_id, String invite_type, String invite_date, String invite_time, String special_person,
			String invite_slogan, String invite_explanation, int invite_id) {
		this.user_id = user_id;
		this.invite_type = invite_type;
		this.invite_date = invite_date;
		this.invite_time = invite_time;
		this.special_person = special_person;
		this.invite_slogan = invite_slogan;
		this.invite_explanation = invite_explanation;
		this.invite_id = invite_id;
	}

	// invite delete constructor

	public Invite(int invite_id) {
		this.invite_id = invite_id;
	}
	// Getters and letters

	public int getInvite_id() {
		return invite_id;
	}

	public void setInvite_id(int invite_id) {
		this.invite_id = invite_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getInvite_type() {
		return invite_type;
	}

	public void setInvite_type(String invite_type) {
		this.invite_type = invite_type;
	}

	public String getInvite_date() {
		return invite_date;
	}

	public void setInvite_date(String invite_date) {
		this.invite_date = invite_date;
	}

	public String getInvite_time() {
		return invite_time;
	}

	public void setInvite_time(String invite_time) {
		this.invite_time = invite_time;
	}

	public String getSpecial_person() {
		return special_person;
	}

	public void setSpecial_person(String special_person) {
		this.special_person = special_person;
	}

	public String getInvite_slogan() {
		return invite_slogan;
	}

	public void setInvite_slogan(String invite_slogan) {
		this.invite_slogan = invite_slogan;
	}

	public String getInvite_explanation() {
		return invite_explanation;
	}

	public void setInvite_explanation(String invite_explanation) {
		this.invite_explanation = invite_explanation;
	}

}
