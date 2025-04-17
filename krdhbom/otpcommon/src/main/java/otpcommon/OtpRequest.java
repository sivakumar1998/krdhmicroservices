package otpcommon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@JacksonXmlRootElement(localName = "Otp")
public class OtpRequest {

    @JacksonXmlProperty(isAttribute = true, localName = "uid")
    @Pattern(
            regexp = "^(\\d{12}|\\d{16}|[0-9a-zA-Z/=+\\\\]{72}|\\d{10})$",
            message = "Value must be a 12-digit Aadhaar number, 16-digit Virtual ID, 72-character UID Token, or a 10-digit mobile number"
    )
    @NotEmpty(message = "uid is mandatory")
    private String uid;

    @JacksonXmlProperty(isAttribute = true, localName = "ac")
    @Pattern(
            regexp = "^[a-zA-Z0-9]{1,10}$",
            message = "Value must be an alphanumeric string with a maximum length of 10"
    )
    @NotEmpty(message = "ac is mandatory")
    private String ac;

    @JacksonXmlProperty(isAttribute = true, localName = "sa")
    @Pattern(
            regexp = "^[a-zA-Z0-9]{1,10}$",
            message = "Value must be an alphanumeric string with a maximum length of 10"
    )
    @NotEmpty(message = "sa is mandatory")
    private String sa;

    @JacksonXmlProperty(isAttribute = true, localName = "ver")
    @Pattern(
            regexp = "^2\\.5$",
            message = "Value must be exactly '2.5'"
    )
    @NotEmpty(message = "ver is mandatory")
    private String ver;

    @JacksonXmlProperty(isAttribute = true, localName = "txn")
    @Pattern(
            regexp = "^[a-zA-Z0-9.,\\\\/\\-():]{1,50}$",
            message = "Value must be an alphanumeric string of maximum length 50, and can include .,\\/-():"
    )
    @NotEmpty(message = "txn is mandatory")
    private String txn;

    @JacksonXmlProperty(isAttribute = true, localName = "ts")
    @Pattern(
            regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$",
            message = "Value must be in the format 'YYYY-MM-DDThh:mm:ss'"
    )
    @NotEmpty(message = "ts is mandatory")
    private String ts;

    @JacksonXmlProperty(isAttribute = true, localName = "lk")
    @NotEmpty(message = "lk is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9\\-_]{1,64}$", message = "Value must be an alpha-numeric string of 1 to 64 characters.")
    private String lk;

    @JacksonXmlProperty(isAttribute = true, localName = "type")
    @Pattern(
            regexp = "^([AEVTM])?$",
            message = "Value must be one of 'A', 'E', 'V', 'T', 'M', or empty"
    )
    private String type;
    @JsonProperty(value = "Opts")

    private Opts opts;

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getAc() {
        return ac;
    }

    public void setSa(String sa) {
        this.sa = sa;
    }

    public String getSa() {
        return sa;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getVer() {
        return ver;
    }

    public void setTxn(String txn) {
        this.txn = txn;
    }

    public String getTxn() {
        return txn;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getTs() {
        return ts;
    }

    public void setLk(String lk) {
        this.lk = lk;
    }

    public String getLk() {
        return lk;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setOpts(Opts opts) {
        this.opts = opts;
    }

    public Opts getOpts() {
        return opts;
    }
}
