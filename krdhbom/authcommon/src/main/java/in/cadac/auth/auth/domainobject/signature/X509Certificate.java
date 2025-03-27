package in.cadac.auth.auth.domainobject.signature;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement
public class X509Certificate {
	@JacksonXmlText
	private String x509Certificate;

	public String getX509Certificate() {
		return x509Certificate.replace("\r", "&#13;");
	}

	public void setX509Certificate(String x509Certificate) {
		this.x509Certificate = x509Certificate.replace("&#13;", "\r");
	}

	@Override
	public String toString() {
		return "X509Certificate [x509Certificate=" + x509Certificate + "]";
	}

}
