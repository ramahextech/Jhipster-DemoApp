package com.ahextech.web.rest.util;

public class CustomMessages {
	  public static final String USER_BASIC_INFO = "userBasicInfo";// will be
		 // saved in
		 // session.
public static final String VALID_DATE_TYPE_MSG = "Check date formate(dd-MM-yyyy)";
public static final String VALID_SESSION_CHECK_MSG = "No valid session found";
public static final String CASE_SEED_SEARCH_KEYWORD_VALIDATION_MSG = "Search keyword cannot be less than 5";
public static final String SEARCH_KEYWORD_VALIDATION_MSG = "Search keyword length should atleast be 5 characters.";
public static final String SEARCH_KEYWORD_VALIDATION_THREE_CHAR_MSG = "Search keyword length should atleast be 3 characters.";
public static final Integer DEFAULT_PAGE_NUMBER = 1;
public static final Integer DEFAULT_PAGE_SIZE = 10;
public static final String CASE_SEED_SEED_MSG = "check the json format";
public static final String CASE_SEED_SEED_DELETE_MSG = "Case deleted successfully.";
public static final String CASE_SEED_SEED_EMPTY_LIST_MSG = "No data found";
public static final String CASE_SEED_SEED_JSON_FILE_ID = "caseId";
public static final Integer CASE_SEED_CURRENT_FRESH_STATUS_ID = 1;
public static final String CASE_SEED_SUCCESSFUL_MSG = "Json file uploaded successfully";
public static final String CASE_SEED_UPDATE_MSG = "Case updated successfully.";
public static final String HIBERNATE_EXCEPTION_MSG = "Hibernate exception : ";
public static final String CASE_SEED_NOT_FOUND = "Case not found.";
public static final String USER_NOT_FOUND = "user not found";
public static final String USER_NOT_ADMIN = "The user is not from Admin group and not authorized to perform this operation.";
public static final String TRANSACTION_MONITOR_EMPTY_LIST_MSG = "No data found";
public static final String USER_CREATION_SUCCESSFUL = "User created successfully!";
public static final int ACTIVATED_USER_CODE = 1;
public static final int ENABLED_USER_REGISTRATION = 1;
public static final int ENABLED_EMAIL_VERIFICATION = 1;
public static final String USER_REGISTRATION_DISABLED = "User registration is disabled!";
public static final String USERNAME_ALREADY_EXISTS = "User already exists with username : ";
public static final String EMAILADDRESS_ALREADY_EXISTS = "User with same email already exists :";
public static final String CHECKIN_FAILED = "User check-in for notification failed";
public static final String EXCEPTION_MSG = "Failed to run API due to exception encountered.";
public static final String NOTIFICATION_DETAIL_NOT_FOUND = "Notification details not found.";
public static final String NOTIFICATION_RECIPIENT_NOT_FOUND = "No recipient found for this notification.";
public static final String EVENT_RECIPIENT_NOT_FOUND = "No recipient found for this event.";
public static final String USER_NOT_OWNER = "Operation not permitted.";
public static final String ADD_PARTICIPANTS_SUCESSFUL_MSG = "Participants added successfully.";
public static final String REMOVE_PARTICIPANTS_SUCESSFUL_MSG = "Participants removed successfully.";
public static final String NO_PARTICIPANTS_PROVIDED = "Participants not provided.";
public static final String CALENDAR_EVENT_UPDATE_MSG = "Event updated successfully.";
public static final String EVENT_NOT_FOUND = "Event not found.";
public static final String REMOVE_CONTACT_SUCESSFUL_MSG = "Contact removed successfully.";
public static final String ADD_CONTACT_SUCESSFUL_MSG = "Contact added successfully.";
public static final String CONTACT_ALREADY_EXISTS_MSG = "Contact already exists.";
public static final String CONTACT_NOT_FOUND_MSG = "Contact not found.";
public static final String SEARCH_STRING_LENTH_INVALID = "Length of the search string should be at least 3 character.";
public static final String NO_DATA_FOUND_MSG = "No data found";
public static final String MISSING_REQUIRED_FIELDS_MSG = "One or more required fields are missing.";
public static final String USER_NOT_FOUND_MSG = "User not found.";
public static final String USER_DEACTIVATED_SUCCESSFULLY_MSG = "User deactivated succefully.";
public static final String USER_ACTIVATED_SUCCESSFULLY_MSG = "User activated successfully.";
public static final String GROUP_CREATED_SUCCESSFULLY_MSG = "Group created successfully.";
public static final String GROUP_NOT_FOUND_MSG = "Group not found.";
public static final String GROUP_ACTIVATED_SUCCESSFULLY_MSG = "Group activated successfully.";
public static final String GROUP_DEACTIVATED_SUCCESSFULLY_MSG = "Group deactivated successfully.";
public static final String GROUP_UPDATED_SUCCESSFULLY_MSG = "Group updated successfully.";
public static final String USER_ALREADY_IN_GROUP_MSG = "User already exists in this group.";
public static final String USER_OR_GROUP_IS_INACTIVE_MSG = "Either user or group is inactive.";
public static final String USER_ADDED_IN_GROUP_SUCCESSFULLY_MSG = "User successfully added to the group.";
public static final String USER_REMOVED_FROM_GROUP_SUCCESSFULLY_MSG = "User successfully removed from group.";
public static final String USER_PROFILE_UPDATED_SUCCESSFULLY_MSG = "Profile updated successfully.";
public static final String INVALID_JSON_FORMAT_MSG = "Invalid json format.";
public static final String FAILED_TO_GET_DATA_FROM_SERVER_MSG = "Failed to get data from server.";
public static final String FAILED_TO_DELETE_DATA_ON_SERVER_MSG = "Failed to delete data on server.";
public static final String FAILED_TO_UPDATE_DATA_ON_SERVER_MSG = "Failed to update data on server.";
public static final String SUCCESSFULLY_MARKED_AS_FAVOURITE_MSG = "Search history successfully marked as favorite.";
public static final String COULD_NOT_MARK_AS_FAVOURITE_MSG = "Could not mark search history as favorite.";
public static final String FAILED_TO_UPLOAD_FILE_TO_SERVER_MSG = "Failed to upload file to the server.";
public static final String FAILED_TO_UPLOAD_FILES_TO_SERVER_MSG = "Failed to upload files to the server.";
public static final String FAILED_TO_DOWNLOAD_FILE_FROM_SERVER_MSG = "Failed to download file from server.";
public static final String DOCUMENT_METADATA_UPDATED_SUCCESSFULLY_MSG = "Document metadata updated successfully.";
public static final String DOCUMENT_DELETED_SUCCESSFULLY_MSG = "Document deleted successfully.";
public static final String DOCUMENT_UPLOADED_SUCCESSFULLY_MSG = "Document uploaded successfully.";
public static final String DOCUMENT_UPDATED_SUCCESSFULLY_MSG = "Document updated successfully.";
public static final String DOCUMENT_SHARED_SUCCESSFULLY_MSG = "Document shared successfully.";
public static final String DOCUMENT_UNSHARED_SUCCESSFULLY_MSG = "Document unshared successfully.";
public static final String CASE_DELETED_FROM_IN_FOCUS_MSG = "Case deleted from focus area.";
public static final String COULD_NOT_DELETED_CASE_FROM_IN_FOCUS_MSG = "Could not delete case from focus area.";
public static final String CASE_ADDED_TO_FOCUS_MSG = "Case added to focus area.";
public static final String COULD_NOT_ADD_CASE_TO_FOCUS_MSG = "Could not add case to focus area.";
public static final String COMMENT_UPDATED_MSG =  "Comment updated successfully.";
public static final String DOCUMENT_DISSEMINATED_SUCCESSFULLY_MSG = "Document disseminated successfully.";
public static final String SERACH_HISTORY_UPDATED_SUCCESSFULLY_MSG = "Search history successfully marked as favorite.";
public static final String SEARCH_HISTORY_NOT_FOUND = "Search history not found.";
public static final String INVALID_SEARCH_FLAG = "Invalid search flag value.";
public static final String INVALID_DOC_FLAG_MSG = "Invalid docFlag value please provide value in range 0-255.";
public static final String SEARCH_HISTORY_UPDATE_MSG = "Search history updated successfully.";
public static final String SEARCH_HISTORY_NOT_FOUND_MSG = "Search history not found.";
public static final String PROFILE_NOT_FOUND="No profile is found to update,First insert and later update";


//Exceptions
public static final String PARSING_EXCEPTION_MSG="Parsing exception occured";

public static final String FROM_EMAIL="";

public static final String GROUP_NAME_EXIST = "Group with same name already exists.";

public static final String ADMIN_GROUP_NAME = "Admin";

public static final String ANALYST_GROUP_NAME = "Analyst";

public static final Integer DEFAULT_PAGE_TO = 100;

public static final String DOCUMENT_FORMAT="please check the format,only csv format allowed";

public static final String CSV_DATA_COLUMNS_FORMAT="failed to upload ,please check order of columns";

public static final String DATAENTRY_GROUP_NAME = "DataEntry";

public static final String CASE_ALREADY_ADDED_TO_FOCUS_MSG = "Case already added to focus area.";

public static final String CHANGE_PASSWORD_FAIL_MSG="Old Password Wrong Or New Passwrod and Retype Password Not Matched";





// Prevents instantiation
private CustomMessages() {
}

}
