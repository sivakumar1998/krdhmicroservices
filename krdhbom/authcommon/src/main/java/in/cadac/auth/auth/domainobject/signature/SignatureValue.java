package in.cadac.auth.auth.domainobject.signature;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "SignatureValue")
public class SignatureValue {

	@JacksonXmlText()
	private String signatureValue;

	public String getSignatureValue() {
		return signatureValue.replace("\r", "&#13;");
	}

	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue.replace("&#13;", "\r");
	}

	@Override
	public String toString() {
		return "SignatureValue [signatureValue=" + signatureValue + "]";
	}
	
}
