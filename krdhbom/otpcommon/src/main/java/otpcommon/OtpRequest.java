package otpcommon;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Otp")
public class OtpRequest {
private String uid;
private String ac;
private String sa;
private String ver;
private String txn;
private String ts;
private String lk;
private String type;

}
