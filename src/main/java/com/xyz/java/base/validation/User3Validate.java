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
public class User3Validate {
    @NotNull(groups = ValidateName.class)
    private String name;

    @Max(value = 30,groups = ValidateAge.class)
    private int age;

    public User3Validate(String name, int age) {
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

        User3Validate user = new User3Validate(null,35);

        /**
         * @GroupSequence({ValidateAge.class,ValidateName.class})顺序的含义是：
         * ValidateAge.class完成validate通过才会检查ValidateName.class并不是一起validate。
         * 可以理解为ValidateAge.class是ValidateName.class的前置校验，如果ValidateAge都通不过检查的化ValidateName也就没有检查的必要了。
         */

        Set<ConstraintViolation<User3Validate>> validate1 = validator.validate(user,ValidateGroupSeq.class);

        for (ConstraintViolation<User3Validate> constraintViolation : validate1) {
            System.out.println(constraintViolation.getMessage());
        }


    }
}
