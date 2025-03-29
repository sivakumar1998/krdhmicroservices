package in.cadac.auth.auth.domainobject.signature;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "DigestValue")
public class DigestValue implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JacksonXmlText()
	private String digest;

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	@Override
	public String toString() {
		return "DigestValue [digest=" + digest + "]";
	}
	

}
