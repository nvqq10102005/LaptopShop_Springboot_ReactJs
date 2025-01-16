package vn.com.LaptopShop.service.validator;

import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.com.LaptopShop.domain.dto.RegisterDTO;
import vn.com.LaptopShop.service.UserService;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {


    private final UserService userService;
    public RegisterValidator(UserService userService){
        this.userService = userService;
    }
    @Override
public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {
    boolean valid = true;

    
    if (user.getPassword() == null || user.getPassword().isEmpty()) {
        context.buildConstraintViolationWithTemplate("Password cannot be empty")
                .addPropertyNode("password")
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        valid = false;
    }

    
    if (user.getConfirmPassword() == null || !user.getConfirmPassword().equals(user.getPassword())) {
        context.buildConstraintViolationWithTemplate("Passwords do not match")
                .addPropertyNode("confirmPassword")
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        valid = false;
    }

    
    if (this.userService.checkEmailExist(user.getEmail())) {
        context.buildConstraintViolationWithTemplate("Email already exists")
                .addPropertyNode("email")
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        valid = false;
    }

    return valid;
    }
}
