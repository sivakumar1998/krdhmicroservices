package in.cadac.auth.auth.domainobject.signature;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "SignatureValue")
public class SignatureValue {
	private char c=13;
	@JacksonXmlText()
	private String signatureValue;

	public String getSignatureValue() {
		return signatureValue;
//				.replaceAll("@", "&#13;");
//				.replace("\r", "&#13;");
	}

	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
//				.replaceAll("&#13;", "@");
//				.replace("&#13;", "\r");
	}

	@Override
	public String toString() {
		return "SignatureValue [signatureValue=" + signatureValue + "]";
	}
	
}
