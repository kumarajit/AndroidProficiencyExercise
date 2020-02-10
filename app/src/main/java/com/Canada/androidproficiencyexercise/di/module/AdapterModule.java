package com.Canada.androidproficiencyexercise.di.module;



import com.Canada.androidproficiencyexercise.MainActivity;
import com.Canada.androidproficiencyexercise.Adapter.RecyclerViewAdapter;
import com.Canada.androidproficiencyexercise.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getCoinList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }
}
