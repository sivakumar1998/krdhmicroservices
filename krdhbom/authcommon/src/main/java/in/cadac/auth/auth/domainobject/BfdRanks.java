package in.cadac.auth.auth.domainobject;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JacksonXmlRootElement(localName = "BfdRanks")
public class BfdRanks implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private List<BfdRank> bfdRank;

public List<BfdRank> getBfdRank() {
	return bfdRank;
}

public void setBfdRank(List<BfdRank> bfdRank) {
	this.bfdRank = bfdRank;
}

}
