package com.fct.api.http.support.session;


import com.fct.common.exceptions.BaseException;

/**
 * @author ningyang
 */
public final class AccessTokenMissingException extends BaseException {

    public AccessTokenMissingException() {
        super(1000, "缺少access-token");
    }
}
