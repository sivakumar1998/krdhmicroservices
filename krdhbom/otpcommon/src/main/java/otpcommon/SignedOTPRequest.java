package otpcommon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import in.cadac.auth.auth.domainobject.signature.Signature;
import jakarta.validation.constraints.NotNull;

public class SignedOTPRequest extends OtpRequest{
    @JacksonXmlElementWrapper(useWrapping = true)
    @NotNull(message = "signature is must for signed xml")
    @JsonProperty("Signature")
    private Signature signature;

    public Signature getSignature() {
        return signature;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    public void setOTPReqData( OtpRequest otpRequest) {
        this.setUid(otpRequest.getUid());
        this.setAc(otpRequest.getAc());
        this.setSa(otpRequest.getSa());
        this.setVer(otpRequest.getVer());
        this.setTxn(otpRequest.getTxn());
        this.setTs(otpRequest.getTs());
        this.setLk(otpRequest.getLk());
        this.setType(otpRequest.getType());

    }

    @Override
    public String toString() {
        return "SignedRequest [signature=" + signature + "]";
    }

}
