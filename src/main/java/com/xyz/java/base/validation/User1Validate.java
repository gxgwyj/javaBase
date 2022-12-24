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
 * @description java 规则验证,参考博文  https://blog.csdn.net/heroyuchao/article/details/100696227
 */
public class User1Validate {
    // 参数校验注解
    @NotNull
    private String name;
    @Max(30)
    private int age;

    public User1Validate(String name, int age) {
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

        // 创建参数
        User1Validate user1Validate = new User1Validate(null,35);

        // 验证参数
        Set<ConstraintViolation<User1Validate>> validate = validator.validate(user1Validate);

        for (ConstraintViolation<User1Validate> constraintViolation : validate) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}
