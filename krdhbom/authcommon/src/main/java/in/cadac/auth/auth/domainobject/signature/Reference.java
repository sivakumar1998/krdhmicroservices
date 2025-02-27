package in.cadac.auth.auth.domainobject.signature;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Reference")
public class Reference {

	@JacksonXmlProperty(isAttribute = true, localName = "URI")
	private String uri;

	@JsonProperty(value = "Transforms")
	private Transforms transforms;
	@JsonProperty(value = "DigestMethod")
	private DigestMethod digestMethod;
	@JsonProperty(value = "DigestValue")
	private DigestValue digestValue;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Transforms getTransforms() {
		return transforms;
	}

	public void setTransforms(Transforms transforms) {
		this.transforms = transforms;
	}

	public DigestMethod getDigestMethod() {
		return digestMethod;
	}

	public void setDigestMethod(DigestMethod digestMethod) {
		this.digestMethod = digestMethod;
	}

	public DigestValue getDigestValue() {
		return digestValue;
	}

	public void setDigestValue(DigestValue digestValue) {
		this.digestValue = digestValue;
	}

	@Override
	public String toString() {
		return "Reference [uri=" + uri + ", transforms=" + transforms + ", digestMethod=" + digestMethod
				+ ", digestValue=" + digestValue + "]";
	}

}
