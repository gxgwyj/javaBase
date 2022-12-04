package com.xyz.java.base.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author gaoxugang
 * @data 2022/11/20  12:13
 * @description java 规则验证（自定义）
 */
public class User4Validate {
    @NotNull
    @Length6
    private String name;

    @Max(value = 30)
    private int age;

    public User4Validate(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        Validator validator = validatorFactory.getValidator();

        User4Validate user = new User4Validate("gaoxugang666",35);

        Set<ConstraintViolation<User4Validate>> validate1 = validator.validate(user);

        for (ConstraintViolation<User4Validate> constraintViolation : validate1) {
            System.out.println(constraintViolation.getMessage());
        }


    }
}
