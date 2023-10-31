package com.fssa.freshnest.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents an invitation entity that contains information about an invitation
 * event, including its type, date, time, participants, and associated actions.
 * This class provides constructors and methods to manage different aspects of
 * an invitation.
 *
 * @author SusikumarPitchaimuth
 */

public class Invite {

    private User user;
    private String inviteType;
    private LocalDate inviteDate;
    private LocalTime inviteTime;
    private String specialPerson;
    private String inviteSlogan;
    private String inviteExplanation;
    private int inviteId;
    private String inviteImage;

    // Constructor

   

	/**
     * Default constructor for creating an empty Invite object.
     */
    
    // Default Constructor
    public Invite() {

    }

    /**
     * Constructor for creating an Invite object with specified user and invitation
     * details.
     *
     * @param user              The user associated with the invitation.
     * @param inviteType        The type of the invitation.
     * @param inviteDate        The date of the invitation.
     * @param inviteTime        The time of the invitation.
     * @param specialPerson     Name of the special person (if applicable).
     * @param inviteSlogan      Slogan or message for the invitation.
     * @param inviteExplanation Explanation or details about the invitation.
     */

    // Invite create constructor
    public Invite(User user, String inviteType, LocalDate inviteDate, LocalTime inviteTime, String specialPerson,
                  String inviteSlogan, String inviteExplanation) {
        this.user = user;
        this.inviteType = inviteType;
        this.inviteDate = inviteDate;
        this.inviteTime = inviteTime;
        this.specialPerson = specialPerson;
        this.inviteSlogan = inviteSlogan;
        this.inviteExplanation = inviteExplanation;
    }

    /**
     * Constructor for updating an existing invitation with new details.
     *
     * @param inviteType        The updated type of the invitation.
     * @param inviteDate        The updated date of the invitation.
     * @param inviteTime        The updated time of the invitation.
     * @param specialPerson     The updated name of the special person (if
     *                          applicable).
     * @param inviteSlogan      The updated slogan or message for the invitation.
     * @param inviteExplanation The updated explanation or details about the
     *                          invitation.
     * @param inviteId          The unique identifier of the invitation being
     *                          updated.
     */
    // Invite update constructor
    public Invite(String inviteType, LocalDate inviteDate, LocalTime inviteTime, String specialPerson,
                  String inviteSlogan, String inviteExplanation, int inviteId) {
        this.inviteType = inviteType;
        this.inviteDate = inviteDate;
        this.inviteTime = inviteTime;
        this.specialPerson = specialPerson;
        this.inviteSlogan = inviteSlogan;
        this.inviteExplanation = inviteExplanation;
        this.inviteId = inviteId;
    }

    /**
     * Constructor for marking an invitation for deletion.
     *
     * @param inviteId The unique identifier of the invitation to be deleted.
     */
    public Invite(int inviteId) {
        this.inviteId = inviteId;
    }

    /**
     * Constructor for creating an Invite object with a specified user.
     *
     * @param user The user associated with the invitation.
     */
    public Invite(User user) {
        this.user = user;
    }
    // Getters and setters

    /**
     * Retrieves the unique identifier of the invitation.
     *
     * @return The unique identifier of the invitation.
     */
    public int getInviteId() {
        return inviteId;
    }

    /**
     * Sets the unique identifier of the invitation.
     *
     * @param inviteId The unique identifier of the invitation.
     */
    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
    }

    /**
     * Retrieve the user object to get the user id.
     *
     * @return The object of user details.
     */
    // Getter for user
    public User getUser() {
        return user;
    }

    /**
     * Sets the user object details.
     *
     * @param user The object of the user.
     */

    // Setter for user
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Retrieves the type of the invitation.
     *
     * @return The type of the invitation.
     */
    public String getInviteType() {
        return inviteType;
    }

    /**
     * Sets the type of the invitation.
     *
     * @param inviteType The type of the invitation.
     */
    public void setInviteType(String inviteType) {
        this.inviteType = inviteType;
    }

    /**
     * Retrieves the date of the invitation.
     *
     * @return The date of the invitation.
     */
    public LocalDate getInviteDate() {
        return inviteDate;
    }

    /**
     * Sets the date of the invitation.
     *
     * @param inviteDate The date of the invitation.
     */
    public void setInviteDate(LocalDate inviteDate) {
        this.inviteDate = inviteDate;
    }

    /**
     * Retrieves the time of the invitation.
     *
     * @return The time of the invitation.
     */
    public LocalTime getInviteTime() {
        return inviteTime;
    }

    /**
     * Sets the time of the invitation.
     *
     * @param inviteTime The time of the invitation.
     */
    public void setInviteTime(LocalTime inviteTime) {
        this.inviteTime = inviteTime;
    }

    /**
     * Retrieves the name of the special person associated with the invitation.
     *
     * @return The name of the special person.
     */
    public String getSpecialPerson() {
        return specialPerson;
    }

    /**
     * Sets the name of the special person associated with the invitation.
     *
     * @param specialPerson The name of the special person.
     */
    public void setSpecialPerson(String specialPerson) {
        this.specialPerson = specialPerson;
    }

    /**
     * Retrieves the slogan or message for the invitation.
     *
     * @return The slogan or message for the invitation.
     */
    public String getInviteSlogan() {
        return inviteSlogan;
    }

    /**
     * Sets the slogan or message for the invitation.
     *
     * @param inviteSlogan The slogan or message for the invitation.
     */
    public void setInviteSlogan(String inviteSlogan) {
        this.inviteSlogan = inviteSlogan;
    }

    /**
     * Retrieves the explanation or details about the invitation.
     *
     * @return The explanation or details about the invitation.
     */
    public String getInviteExplanation() {
        return inviteExplanation;
    }

    /**
     * Sets the explanation or details about the invitation.
     *
     * @param inviteExplanation The explanation or details about the invitation.
     */
    public void setInviteExplanation(String inviteExplanation) {
        this.inviteExplanation = inviteExplanation;
    }

    /**
     * Generates a string representation of the Invite object, including its
     * attributes.
     *
     * @return A string containing information about the Invite object.
     */

    public String getInviteImage() {
        return inviteImage;
    }

    public void setInviteImage(String inviteImage) {
        this.inviteImage = inviteImage;
    }


    @Override
    public String toString() {
        return "Invite{" +
                "user=" + user +
                ", inviteType='" + inviteType + '\'' +
                ", inviteDate=" + inviteDate +
                ", inviteTime=" + inviteTime +
                ", specialPerson='" + specialPerson + '\'' +
                ", inviteSlogan='" + inviteSlogan + '\'' +
                ", inviteExplanation='" + inviteExplanation + '\'' +
                ", inviteId=" + inviteId +
                ", inviteImage='" + inviteImage + '\'' +
                '}';
    }
}
