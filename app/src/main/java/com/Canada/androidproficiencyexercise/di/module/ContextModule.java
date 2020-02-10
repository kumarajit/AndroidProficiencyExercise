package com.Canada.androidproficiencyexercise.di.module;

import android.content.Context;


import com.Canada.androidproficiencyexercise.di.qualifier.ApplicationContext;
import com.Canada.androidproficiencyexercise.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
