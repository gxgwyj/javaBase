package com.xyz.java.base.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author gaoxugang
 * @data 2022/11/20 13:40
 * @description 自定义验证器
 */
public class LengthConstraintValidatorImpl implements ConstraintValidator<Length6,String> {
    @Override
    public void initialize(Length6 constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !"".equals(value.trim()) && value.length() <= 6) {
            return true;
        }
        return false;
    }
}
