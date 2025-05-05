package in.cadac.auth.auth.error;

public class LKNotFoundException extends RuntimeException {
    public LKNotFoundException(String clientLicenseKeyNotFound) {
        super(clientLicenseKeyNotFound);
    }
}
