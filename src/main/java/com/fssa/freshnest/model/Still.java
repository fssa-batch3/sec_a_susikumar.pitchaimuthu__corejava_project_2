package com.fssa.freshnest.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The `Still` class represents a photographic still captured by a user within
 * the FreshNest application. It encapsulates information such as the image URL,
 * user details, name, date, time, and various flags indicating whether the
 * still is a favorite, marked for deletion, or subject to updates.
 *
 * @author SusikumarPitchaimuth
 */
public class Still {
	private String stillUrl;
	private User user;
	private String stillName;
	private LocalDate stillDate;
	private LocalTime stillTime;
	private boolean isFavourite;
	private boolean isDelete;
	private int stillId;

	private LocalDate formDate;

	private LocalDate toDate;

	// Constructors
	// Default Constructor
	public Still() {
		// Default constructor with no arguments
	}

	/**
	 * Constructs a `Still` object with specified details.
	 *
	 * @param stillUrl    URL of the still image
	 * @param user        User who captured the still
	 * @param stillName   Name or title of the still
	 * @param stillDate   Date when the still was captured
	 * @param stillTime   Time when the still was captured
	 * @param isFavourite Indicates whether the still is marked as a favorite
	 * @param isDelete    Indicates whether the still is marked for deletion
	 */
	public Still(String stillUrl, User user, String stillName, LocalDate stillDate, LocalTime stillTime,
			boolean isFavourite, boolean isDelete) {
		// Constructor with specified details
		this.stillUrl = stillUrl;
		this.user = user;
		this.stillName = stillName;
		this.stillDate = stillDate;
		this.stillTime = stillTime;
		this.isFavourite = isFavourite;
		this.isDelete = isDelete;
	}

	/**
	 * Constructs a `Still` object for updating the favorite status.
	 *
	 * @param isFavourite Indicates whether the still is marked as a favorite
	 * @param stillId     Unique identifier of the still
	 */
	public Still(boolean isFavourite, int stillId) {
		// Constructor for updating favorite status
		this.isFavourite = isFavourite;
		this.stillId = stillId;
	}

	/**
	 * Constructs a `Still` object for marking for deletion.
	 *
	 * @param isDelete Indicates whether the still is marked for deletion
	 * @param stillId  Unique identifier of the still
	 * @param user     User who captured the still
	 */
	public Still(boolean isDelete, int stillId, User user) {
		// Constructor for marking for deletion
		this.isDelete = isDelete;
		this.stillId = stillId;
		this.user = user;
	}

	/**
	 * Constructs a `Still` object with the associated user.
	 *
	 * @param user User who captured the still
	 */
	public Still(User user) {
		// Constructor with associated user
		this.user = user;
	}

	/**
	 * Constructs a `Still` object with the specified identifier.
	 *
	 * @param stillId Unique identifier of the still
	 */
	public Still(int stillId) {
		// Constructor with specified identifier
		this.stillId = stillId;
	}

	public Still(LocalDate from, LocalDate to, User user) {
		this.formDate = from;
		this.user = user;
		this.toDate = to;
	}

	/**
	 * Gets the unique identifier of the still.
	 *
	 * @return The unique identifier of the still
	 */
	public int getStillId() {
		return stillId;
	}

	/**
	 * Sets the unique identifier of the still.
	 *
	 * @param stillId The unique identifier of the still
	 */
	public void setStillId(int stillId) {
		this.stillId = stillId;
	}

	/**
	 * Gets the URL of the image representing the still.
	 *
	 * @return The URL of the still image
	 */
	public String getStillUrl() {
		return stillUrl;
	}

	/**
	 * Sets the URL of the image representing the still.
	 *
	 * @param stillUrl The URL of the still image
	 */
	public void setStillUrl(String stillUrl) {
		this.stillUrl = stillUrl;
	}

	/**
	 * Gets the user who captured the still.
	 *
	 * @return The user who captured the still
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user who captured the still.
	 *
	 * @param user The user who captured the still
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the name or title of the still.
	 *
	 * @return The name or title of the still
	 */
	public String getStillName() {
		return stillName;
	}

	/**
	 * Sets the name or title of the still.
	 *
	 * @param stillName The name or title of the still
	 */
	public void setStillName(String stillName) {
		this.stillName = stillName;
	}

	/**
	 * Gets the date when the still was captured.
	 *
	 * @return The date when the still was captured
	 */
	public LocalDate getStillDate() {
		return stillDate;
	}

	/**
	 * Sets the date when the still was captured.
	 *
	 * @param stillDate The date when the still was captured
	 */
	public void setStillDate(LocalDate stillDate) {
		this.stillDate = stillDate;
	}

	/**
	 * Gets the time when the still was captured.
	 *
	 * @return The time when the still was captured
	 */
	public LocalTime getStillTime() {
		return stillTime;
	}

	/**
	 * Sets the time when the still was captured.
	 *
	 * @param stillTime The time when the still was captured
	 */
	public void setStillTime(LocalTime stillTime) {
		this.stillTime = stillTime;
	}

	/**
	 * Checks if the still is marked as a favorite.
	 *
	 * @return `true` if the still is marked as a favorite, otherwise `false`
	 */
	public boolean getIsFavourite() {
		return isFavourite;
	}

	/**
	 * Sets the flag indicating whether the still is marked as a favorite.
	 *
	 * @param isFavourite `true` if the still is marked as a favorite, otherwise
	 *                    `false`
	 */
	public void setIsFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	/**
	 * Checks if the still is marked for deletion.
	 *
	 * @return `true` if the still is marked for deletion, otherwise `false`
	 */
	public boolean getIsDelete() {
		return isDelete;
	}

	/**
	 * Sets the flag indicating whether the still is marked for deletion.
	 *
	 * @param isDelete `true` if the still is marked for deletion, otherwise `false`
	 */
	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * Returns a string representation of the `Still` object.
	 *
	 * @return A string containing the values of the still's fields
	 */

	public LocalDate getFormDate() {
		return formDate;
	}

	public void setFormDate(LocalDate formDate) {
		this.formDate = formDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "Still{" + "stillUrl='" + stillUrl + '\'' + ", userId=" + user + ", stillName='" + stillName + '\''
				+ ", stillDate=" + stillDate + ", stillTime=" + stillTime + ", isFavourite=" + isFavourite
				+ ", isDelete=" + isDelete + ", stillId=" + stillId;
	}
}
