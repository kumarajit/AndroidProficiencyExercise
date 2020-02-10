package com.Canada.androidproficiencyexercise.mvp;


import com.Canada.androidproficiencyexercise.Model.Canada;

public interface MainActivityContract {
    interface View {
        void showData(Canada data);

        void showError(String message);

        void showComplete();

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void loadData();
    }
}
