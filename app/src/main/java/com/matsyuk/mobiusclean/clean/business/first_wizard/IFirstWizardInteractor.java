package com.matsyuk.mobiusclean.clean.business.first_wizard;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public interface IFirstWizardInteractor {
    Single<Boolean> acceptLicense();
}
