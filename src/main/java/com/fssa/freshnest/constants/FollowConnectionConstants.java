package com.fssa.freshnest.constants;

public class FollowConnectionConstants {
	private static final String INVALID_FOLLOW_REQUEST = "Invalid follow request";
	private static final String INVALID_FOLLOW_REQUEST_TYPE = "Invalid follow request type";
	private static final String INVALID_FOLLOW_BACK_REQUEST = "Invalid follow back request";

	private static final String INVALID_FOLLOW_REQUEST_ID = "Invalid follow request id";
	private static final String INVALID_FOLLOW_RECEIVER_ID = "Invalid follow receiver id";
	private static final String INVALID_USER_ID = "Invalid user id";

	public static String getInvalidUserId() {

		return INVALID_USER_ID;
	}

	public static String getInvalidFollowRequest() {
		return INVALID_FOLLOW_REQUEST;
	}

	public static String getInvalidFollowBackRequest() {
		return INVALID_FOLLOW_BACK_REQUEST;
	}

	public static String getInvalidFollowRequestId() {
		return INVALID_FOLLOW_REQUEST_ID;
	}

	public static String getInvalidFollowReceiverId() {
		return INVALID_FOLLOW_RECEIVER_ID;
	}

	public static String getInvalidFollowRequestType() {
		return INVALID_FOLLOW_REQUEST_TYPE;
	}

}
