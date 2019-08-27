package kafka.benchmark.user.address.util;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.util.Set;

@Component
public class Validator {

    private final static javax.validation.Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public void validate(Object o) {
        Set<ConstraintViolation<Object>> violations = VALIDATOR.validate(o);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException("Object is not valid ", violations);
        }
    }
}
