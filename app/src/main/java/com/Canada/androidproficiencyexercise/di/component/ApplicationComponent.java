package com.Canada.androidproficiencyexercise.di.component;

import android.content.Context;


import com.Canada.androidproficiencyexercise.MyApplication;
import com.Canada.androidproficiencyexercise.di.module.ContextModule;
import com.Canada.androidproficiencyexercise.di.module.RetrofitModule;
import com.Canada.androidproficiencyexercise.di.qualifier.ApplicationContext;
import com.Canada.androidproficiencyexercise.di.scopes.ApplicationScope;
import com.Canada.androidproficiencyexercise.retrofit.APIInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    APIInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}
