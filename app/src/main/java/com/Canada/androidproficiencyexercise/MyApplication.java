package com.Canada.androidproficiencyexercise;

import android.app.Activity;
import android.app.Application;

import com.Canada.androidproficiencyexercise.di.component.ApplicationComponent;
import com.Canada.androidproficiencyexercise.di.component.DaggerApplicationComponent;
import com.Canada.androidproficiencyexercise.di.module.ContextModule;


public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);

    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}

