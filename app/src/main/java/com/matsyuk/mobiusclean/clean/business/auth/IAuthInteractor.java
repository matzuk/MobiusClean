package com.matsyuk.mobiusclean.clean.business.auth;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public interface IAuthInteractor {

    Single<Boolean> login(String login, String password);
    Single<Boolean> registration(String login, String password);

}
