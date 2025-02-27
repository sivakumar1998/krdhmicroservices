package in.cadac.auth.auth.domainobject.signature;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "Signature")
public class Signature {
	@JsonProperty(value ="SignedInfo" )
	private SignedInfo signedinfo;
	
	@JsonProperty(value="SignatureValue")
	private SignatureValue signatureValue;
	
	@JsonProperty(value="KeyInfo")
	private KeyInfo keyInfo;

	
	@JacksonXmlText
	private String signature;

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public SignedInfo getSignedinfo() {
		return signedinfo;
	}

	public void setSignedinfo(SignedInfo signedinfo) {
		this.signedinfo = signedinfo;
	}

	public SignatureValue getSignatureValue() {
		return signatureValue;
	}

	public void setSignatureValue(SignatureValue signatureValue) {
		this.signatureValue = signatureValue;
	}

	public KeyInfo getKeyInfo() {
		return keyInfo;
	}

	public void setKeyInfo(KeyInfo keyInfo) {
		this.keyInfo = keyInfo;
	}

	@Override
	public String toString() {
		return "Signature [signedinfo=" + signedinfo + ", signatureValue=" + signatureValue + ", keyInfo=" + keyInfo
				+ ", signature=" + signature + "]";
	}


}
