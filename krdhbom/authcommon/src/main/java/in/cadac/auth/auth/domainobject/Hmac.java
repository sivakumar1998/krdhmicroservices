package in.cadac.auth.auth.domainobject;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import jakarta.validation.constraints.Pattern;

@JacksonXmlRootElement(localName = "Hmac")
public class Hmac {
	@JacksonXmlText()
	@Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$", message = "Invalid Base64 format")
private String Hmac;

	@Override
	public String toString() {
		return "Hmac [Hmac=" + Hmac + "]";
	}
	
}
