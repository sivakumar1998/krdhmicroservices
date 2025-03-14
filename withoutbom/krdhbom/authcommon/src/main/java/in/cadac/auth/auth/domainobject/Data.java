package in.cadac.auth.auth.domainobject;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@JacksonXmlRootElement(localName = "Data")
public class Data {

	@JacksonXmlProperty(isAttribute = true)
	@Pattern(regexp = "^[XP]$", message = "Value must be either 'X' or 'P'.")
	private String type;
	@JacksonXmlText()
	@NotEmpty(message = "data should not be empty")
	@Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$", message = "Invalid Base64 format")
	private String data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Data [type=" + type + ", data=" + data + "]";
	}

}
