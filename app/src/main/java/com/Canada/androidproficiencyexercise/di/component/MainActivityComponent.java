package com.Canada.androidproficiencyexercise.di.component;

import android.content.Context;


import com.Canada.androidproficiencyexercise.MainActivity;
import com.Canada.androidproficiencyexercise.di.module.AdapterModule;
import com.Canada.androidproficiencyexercise.di.module.MainActivityMvpModule;
import com.Canada.androidproficiencyexercise.di.qualifier.ActivityContext;
import com.Canada.androidproficiencyexercise.di.scopes.ActivityScope;

import dagger.Component;


@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();
    void injectMainActivity(MainActivity mainActivity);
}
