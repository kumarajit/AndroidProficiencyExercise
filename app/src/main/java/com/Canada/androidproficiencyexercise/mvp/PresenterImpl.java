package com.Canada.androidproficiencyexercise.mvp;



import com.Canada.androidproficiencyexercise.Model.Canada;
import com.Canada.androidproficiencyexercise.retrofit.APIInterface;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PresenterImpl implements MainActivityContract.Presenter {

    APIInterface apiInterface;
    MainActivityContract.View mView;

    @Inject
    public PresenterImpl(APIInterface apiInterface, MainActivityContract.View mView) {
        this.apiInterface = apiInterface;
        this.mView = mView;
    }

    @Override
    public void loadData() {

        mView.showProgress();

        apiInterface.getData("10").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Canada>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                        mView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("Error occurred");
                        mView.hideProgress();
                    }

                    @Override
                    public void onNext(Canada data) {
                        mView.showData(data);
                    }
                });
    }
}
