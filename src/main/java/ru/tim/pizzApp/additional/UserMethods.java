package ru.tim.pizzApp.additional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.tim.pizzApp.entity.Additive;
import ru.tim.pizzApp.entity.Bucket;
import ru.tim.pizzApp.service.AdditiveService;

import java.util.List;

public class UserMethods {


    public static String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }


}
