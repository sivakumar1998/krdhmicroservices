package in.cadac.auth.auth.error;

public class ErrorDto {
private String message;
private String Errorcode;

public ErrorDto(String message, String errorcode) {
	super();
	this.message = message;
	Errorcode = errorcode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getErrorcode() {
	return Errorcode;
}
public void setErrorcode(String errorcode) {
	Errorcode = errorcode;
}

}
