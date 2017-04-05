package com.fct.api.annotations;

import java.lang.annotation.*;

/**
 * all right reserved by nick and YIMIAO corp
 *
 * this is a guest access limitation annotation, it's
 * for fixing a bug which once call /api/guest/token interfaces
 * we need to validate the signature again in the interceptors
 *
 * Created by nick on 2016/5/24.
 * @author nick
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GuestToken {
}
