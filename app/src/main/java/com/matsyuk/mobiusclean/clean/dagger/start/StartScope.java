package com.matsyuk.mobiusclean.clean.dagger.start;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Matsyuk on 03.02.2017.
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface StartScope {
}
