package com.xyz.java.base.validation;

import javax.validation.GroupSequence;

/**
 * @author gaoxugang
 * @data 2022/11/20  13:32
 * @description TODO
 */
@GroupSequence({ValidateAge.class,ValidateName.class})
public interface ValidateGroupSeq {
}
