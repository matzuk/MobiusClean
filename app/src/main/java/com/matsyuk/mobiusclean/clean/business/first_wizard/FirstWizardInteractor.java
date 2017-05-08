package com.matsyuk.mobiusclean.clean.business.first_wizard;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public class FirstWizardInteractor implements IFirstWizardInteractor {

    @Override
    public Single<Boolean> acceptLicense() {
        return Single.timer(5, TimeUnit.SECONDS)
                .map(aLong -> true);
    }

}
