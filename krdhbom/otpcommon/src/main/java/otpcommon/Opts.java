package otpcommon;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.validation.constraints.Pattern;

public class Opts {
    @JacksonXmlProperty(isAttribute = true, localName = "ch")
    @Pattern(
            regexp = "^(00|01|02)?$",
            message = "Value must be one of '00', '01', '02', or empty"
    )
    private String ch;

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }
}
