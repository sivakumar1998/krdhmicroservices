package in.cadac.auth.auth.domainobject.signature;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Transform")
public class Transform {
	@JacksonXmlProperty(isAttribute = true, localName = "Algorithm")
	private String algorithm;

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public String toString() {
		return "Transform [algorithm=" + algorithm + "]";
	}

}
