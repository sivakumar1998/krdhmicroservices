package in.cadac.auth.auth.domainobject.signature;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "SignatureValue")
public class SignatureValue {

	@JacksonXmlText()
	private String signatureValue;

	public String getSignatureValue() {
		return signatureValue;
	}

	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
	}

	@Override
	public String toString() {
		return "SignatureValue [signatureValue=" + signatureValue + "]";
	}
	
}
