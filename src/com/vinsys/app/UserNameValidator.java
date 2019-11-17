package com.vinsys.app;

import org.apache.wicket.validation.CompoundValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidationError;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.apache.wicket.validation.validator.PatternValidator;

public class UserNameValidator extends CompoundValidator<String> {

	/*@Override
	public void validate(IValidatable<String> valitable) {
		
		System.out.println("Entered text field "+valitable.getValue());
		ValidationError error = new ValidationError();	
		
		error.setMessage("bakwass");
		valitable.error(error);
	}*/

public UserNameValidator(){
	add(PatternValidator.exactLength(8));
}

	
}
