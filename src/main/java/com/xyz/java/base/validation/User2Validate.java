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
 * @description java 规则验证(指定分组)
 */
public class User2Validate {
    @NotNull(groups = ValidateName.class)
    private String name;

    @Max(value = 30,groups = ValidateAge.class)
    private int age;

    public User2Validate(String name, int age) {
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

        User2Validate user = new User2Validate(null,35);

        Set<ConstraintViolation<User2Validate>> validate1 = validator.validate(user,ValidateName.class);

        for (ConstraintViolation<User2Validate> constraintViolation : validate1) {
            System.out.println(constraintViolation.getMessage());
        }
        System.out.println("ValidateName" + "分组校验结束");


        Set<ConstraintViolation<User2Validate>> validate2 = validator.validate(user,ValidateAge.class);

        for (ConstraintViolation<User2Validate> constraintViolation : validate2) {
            System.out.println(constraintViolation.getMessage());
        }
        System.out.println("ValidateAge" + "分组校验结束");


    }
}
