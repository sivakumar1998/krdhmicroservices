package in.cadac.auth.auth.domainobject;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@JacksonXmlRootElement(localName = "Skey")
public class Skey {
	@JacksonXmlProperty(isAttribute = true)
	@Pattern(regexp = "^(?:19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])$", message = "Date must be in the format YYYYMMDD and valid.")
	@NotEmpty(message = "ci should not be empty")
	private String ci;
	@JacksonXmlText
	@Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$", message = "Invalid Base64 format")
	private String skey;

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	@Override
	public String toString() {
		return "Skey [ci=" + ci + ", skey=" + skey + "]";
	}

}
