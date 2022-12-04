package com.xyz.java.base.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gaoxugang
 * @data 2022/11/20 0020 13:44
 * @description TODO
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {LengthConstraintValidatorImpl.class})
public @interface Length6 {
    String message() default "长度必须是6个字符长度";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
