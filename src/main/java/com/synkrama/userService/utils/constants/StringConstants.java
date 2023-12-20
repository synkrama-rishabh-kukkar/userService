package com.synkrama.userService.utils.constants;

public class StringConstants {

    //Text
    public static final String TEXT_COUNTRY_CODE = "+91";
    public static final String TEXT_REGEX_CONTACT_VALIDATOR = "^[+](91)?\\d{10}";
    public static final String TEXT_REGEX_SYMBOL_REMOVAL = "[^0-9]";
    public static final String TEXT_SPACE = "";
    public static final String TEXT_ADD = "+";
    public static final String TEXT_REGEX_SYMBOL_CONVERT_NUMBER_INTO_SIX_DIGIT = "%06d";
    public static final String TEXT_EMPTY = "";
    public static final String TEXT_COLON = ":";
    public static final String MEETING_TIME_FORMAT = "HH:mm";
    public static final String API_ROOT_ROUTE = "/**";
    public static final String API_AUTH_ROUTE = "/auth/**";
    public static final String API_FILE_PATH = "/file/**";
    public static final String TEXT_EMPTY_SPACE = " ";

    public static final String TEXT_DEMO_USER_MOBILE_NUMBER = "9999999999";
    public static final String TEXT_DEMO_USER_OTP_NUMBER = "123456";

    //Date Time Format
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    //User Controller
    public static final String REQUEST_SUCCESS_MESSAGE_USER_CREATED = "User Created Successfully!!";
    public static final String REQUEST_FAILURE_MESSAGE_USER_NOT_CREATED = "Failed to Create User";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_UPDATED = "User Updated Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_DELETED = "User Deleted Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_FETCHED = "User Fetched Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_SELECTED_USER_FETCHED = "Fetched User by id: ";
    public static final String REQUEST_FAILURE_MESSAGE_NO_USER_FOUND = "No User Found";

    //Swagger Constant
    public static final String TEXT_SWAGGER_TITLE = "All meet mate APIs";
    public static final String TEXT_SWAGGER_DESC = "REST APIs reference for developers";
    public static final String TEXT_SWAGGER_CONTACT_EMAIL = "synkrama@gmail.com";
    public static final String TEXT_SWAGGER_LICENCE = "http://licence-url.com";
    public static final String TEXT_APP_NAME = "User Service";
    public static final String TEXT_SWAGGER_API_VERSION = "1.0";
    public static final String TEXT_SWAGGER_REGEX_PATH = "/*.*";


}
