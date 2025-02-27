package in.cadac.auth.auth.domainobject.signature;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "SignedInfo")
public class SignedInfo {
	@JsonProperty(value = "CanonicalizationMethod")
	private CanonicalizationMethod canonicalizationMethod;

	@JsonProperty(value = "SignatureMethod")
	private SignatureMethod signatureMethod;

	@JsonProperty(value = "Reference")
	private Reference reference;

	public CanonicalizationMethod getCanonicalizationMethod() {
		return canonicalizationMethod;
	}

	public void setCanonicalizationMethod(CanonicalizationMethod canonicalizationMethod) {
		this.canonicalizationMethod = canonicalizationMethod;
	}

	public SignatureMethod getSignatureMethod() {
		return signatureMethod;
	}

	public void setSignatureMethod(SignatureMethod signatureMethod) {
		this.signatureMethod = signatureMethod;
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "SignedInfo [canonicalizationMethod=" + canonicalizationMethod + ", signatureMethod=" + signatureMethod
				+ ", reference=" + reference + "]";
	}

}
