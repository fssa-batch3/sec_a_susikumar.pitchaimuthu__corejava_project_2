package freshnest.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Still {
	private String still_url;
	private int user_id;
	private String still_name;
	private LocalDate still_date;
	private LocalTime still_time;
	private boolean is_favourite;
	private boolean is_delete;
	private int still_id;
	private boolean is_update;
	

	public Still(String still_url, int user_id, String still_name, LocalDate still_date, LocalTime still_time,
			boolean is_favourite, boolean is_delete) {
		this.still_url = still_url;
		this.user_id = user_id;
		this.still_name = still_name;
		this.still_date = still_date;
		this.still_time = still_time;
		this.is_favourite = is_favourite;
		this.is_delete = is_delete;
	}

	public Still(boolean is_favourite, int still_id) {
		this.is_favourite = is_favourite;
		this.still_id = still_id;
	}

	public Still(int still_id, boolean is_update) {
		this.still_id = still_id;
		this.is_update = is_update;
	}
	
	public Still(boolean is_delete , int still_id, int user_id) {
		this.is_delete = is_delete;
		this.still_id = still_id;
		this.user_id = user_id;
		
	}

	public Still(int id) {
		user_id = id;
	}

	public void set_still_id(int still_id) {
		this.still_id = still_id;

	}

	public int get_still_id() {
		return still_id;
	}

	public String getStill_url() {
		return still_url;
	}

	public void setStill_url(String still_url) {
		this.still_url = still_url;
	}

	public int getUser_id() {
		return user_id;
	}
	
	public void setIs_update(boolean is_update) {
		this.is_update = is_update;
	}
	
	public boolean getIs_update() {
		return is_update;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getStill_name() {
		return still_name;
	}

	public void setStill_name(String still_name) {
		this.still_name = still_name;
	}

	public LocalDate getStill_date() {
		return still_date;
	}

	public void setStill_date(LocalDate still_date) {
		this.still_date = still_date;
	}

	public LocalTime getStill_time() {
		return still_time;
	}

	public void setStill_time(LocalTime still_time) {
		this.still_time = still_time;
	}

	public boolean get_isfavourite() {
		return is_favourite;
	}

	public void setIs_favourite(boolean is_favourite) {
		this.is_favourite = is_favourite;
	}

	public boolean get_isdelete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}

}
