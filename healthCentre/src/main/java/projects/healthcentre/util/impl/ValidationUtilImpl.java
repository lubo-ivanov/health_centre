package projects.healthcentre.util.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import projects.healthcentre.util.ValidationUtil;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidationUtilImpl implements ValidationUtil {
    private final Validator validator;

    public ValidationUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
