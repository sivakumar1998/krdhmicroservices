package in.cadac.auth.auth.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UKCFilterImpl implements ConstraintValidator<UKCFilter, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		int colonIndex =-1;
		
		if(value!=null) {
			colonIndex= value.indexOf(":");
		}
		
		if (colonIndex >0) {
			String textBeforeColon = value.substring(0, colonIndex);
			if (textBeforeColon.startsWith("U") && textBeforeColon.charAt(0) == 'U') {
				return false;
			} else {
				return true;

			}
		}
		return true;
	}

}
