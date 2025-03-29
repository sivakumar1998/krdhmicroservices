package in.cadac.auth.auth.domainobject.signature;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "X509SubjectName")
public class X509SubjectName implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JacksonXmlText()
	private String x509SubjectName;

	public String getX509SubjectName() {
		return x509SubjectName;
	}

	public void setX509SubjectName(String x509SubjectName) {
		this.x509SubjectName = x509SubjectName;
	}

	@Override
	public String toString() {
		return "X509SubjectName [x509SubjectName=" + x509SubjectName + "]";
	}
	

}
