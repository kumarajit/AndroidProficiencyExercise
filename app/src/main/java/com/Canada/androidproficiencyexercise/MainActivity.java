package com.Canada.androidproficiencyexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.Canada.androidproficiencyexercise.Adapter.RecyclerViewAdapter;
import com.Canada.androidproficiencyexercise.di.component.ApplicationComponent;
import com.Canada.androidproficiencyexercise.di.component.DaggerMainActivityComponent;
import com.Canada.androidproficiencyexercise.di.component.MainActivityComponent;
import com.Canada.androidproficiencyexercise.di.module.MainActivityContextModule;
import com.Canada.androidproficiencyexercise.di.module.MainActivityMvpModule;
import com.Canada.androidproficiencyexercise.di.qualifier.ActivityContext;
import com.Canada.androidproficiencyexercise.di.qualifier.ApplicationContext;
import com.Canada.androidproficiencyexercise.mvp.MainActivityContract;
import com.Canada.androidproficiencyexercise.mvp.PresenterImpl;
import com.Canada.androidproficiencyexercise.Model.Canada;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View, RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;


    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Inject
    PresenterImpl presenter;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .mainActivityMvpModule(new MainActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        recyclerView.setAdapter(recyclerViewAdapter);

        progressBar = findViewById(R.id.progressBar);
        presenter.loadData();

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadData();
            }
        });

    }

    @Override
    public void launchIntent(String name) {
        Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
        // startActivity(new Intent(activityContext, DetailActivity.class).putExtra("name", name));
    }

    @Override
    public void showData(Canada data) {
        
        List<Canada.RowsEntity> canadas=data.getRows();

        recyclerViewAdapter.setData(canadas, this);
        swipeContainer.setRefreshing(false);

        if(getSupportActionBar() !=null) {
            getSupportActionBar().setTitle(data.getTitle().toString());
        }

    }

    @Override
    public void showError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
