package com.fssa.freshnest.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Still {
	private String stillUrl;
	private int userId;
	private String stillName;
	private LocalDate stillDate;
	private LocalTime stillTime;
	private boolean isFavourite;
	private boolean isDelete;
	private int stillId;
	private boolean isUpdate;
	

	public Still(String stillUrl, int userId, String stillName, LocalDate stillDate, LocalTime stillTime,
			boolean isFavourite, boolean isDelete) {
		this.stillUrl = stillUrl;
		this.userId = userId;
		this.stillName = stillName;
		this.stillDate = stillDate;
		this.stillTime = stillTime;
		this.isFavourite = isFavourite;
		this.isDelete = isDelete;
	}

	public Still(boolean isFavourite, int stillId) {
		this.isFavourite = isFavourite;
		this.stillId = stillId;
	}

	public Still(int stillId, boolean isUpdate) {
		this.stillId = stillId;
		this.isUpdate = isUpdate;
	}
	
	public Still(boolean isDelete , int stillId, int userId) {
		this.isDelete = isDelete;
		this.stillId = stillId;
		this.userId = userId;
		
	}

	public Still(int id) {
		userId = id;
	}

	public void set_still_id(int stillId) {
		this.stillId = stillId;

	}

	public int getStillId() {
		return stillId;
	}

	public String getStillUrl() {
		return stillUrl;
	}

	public void setStillUrl(String stillUrl) {
		this.stillUrl = stillUrl;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStillName() {
		return stillName;
	}

	public void setStillName(String stillName) {
		this.stillName = stillName;
	}

	public LocalDate getStillDate() {
		return stillDate;
	}

	public void setStillDate(LocalDate stillDate) {
		this.stillDate = stillDate;
	}

	public LocalTime getStillTime() {
		return stillTime;
	}

	public void setStill_time(LocalTime stillTime) {
		this.stillTime = stillTime;
	}

	public boolean getIsFavourite() {
		return isFavourite;
	}

	public void setIsFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

}
