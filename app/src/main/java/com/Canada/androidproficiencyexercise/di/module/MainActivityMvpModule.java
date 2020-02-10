package com.Canada.androidproficiencyexercise.di.module;



import com.Canada.androidproficiencyexercise.di.scopes.ActivityScope;
import com.Canada.androidproficiencyexercise.mvp.MainActivityContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityMvpModule {
    private final MainActivityContract.View mView;


    public MainActivityMvpModule(MainActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    MainActivityContract.View provideView() {
        return mView;
    }


}
