package ru.tim.pizzApp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.tim.pizzApp.entity.User;
import ru.tim.pizzApp.service.UserService;

@Service
public class UserValidator implements Validator {

    @Autowired
    UserService userService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        if (user.getLogin().length()<4 || user.getLogin().length()>12) {
            errors.rejectValue("login","", "Логин должен быть более 4-х и менее 12-ти символов");
        }
        if (user.getPassword().length()<4 || user.getPassword().length()>16) {
            errors.rejectValue("password","", "Пароль должен быть более 4-х и менее 16-ти символов");
        }
        if(!user.getLogin().equals("")){
            if (userService.getByLogin(user.getLogin())!=null) {
                errors.rejectValue("login","", "Такой логин уже используется");
            }
        }

    }
}
