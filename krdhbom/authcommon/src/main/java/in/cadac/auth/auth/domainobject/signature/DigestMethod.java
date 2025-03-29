package in.cadac.auth.auth.domainobject.signature;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "DigestMethod")
public class DigestMethod implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JacksonXmlProperty(isAttribute = true,localName = "Algorithm")
	private String algorithm;

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public String toString() {
		return "DigestMethod [algorithm=" + algorithm + "]";
	}

}
