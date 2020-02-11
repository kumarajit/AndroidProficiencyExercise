package com.Canada.androidproficiencyexercise.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.Canada.androidproficiencyexercise.R;
import com.Canada.androidproficiencyexercise.Model.Canada;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Canada.RowsEntity> data;
    private RecyclerViewAdapter.ClickListener clickListener;
    private Context context;
    @Inject
    public RecyclerViewAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
        data = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       // Canada.RowsEntity rowsEntity= (Canada.RowsEntity) data.get(position).getRows();
        holder.textViewUsername.setText(data.get(position).getTitle());
        holder.textViewAddress.setText(data.get(position).getDescription());
      //  holder.imgView.setText(data.get(position).getTitle());
        RequestOptions myOptions = new RequestOptions()
                .fitCenter() // or centerCrop
                .override(400, holder.textViewAddress.getHeight());
        if (TextUtils.isEmpty(data.get(position).getImagehref()) || data.get(position).getImagehref()==null ||
                data.get(position).getImagehref().equalsIgnoreCase("null")){
            holder.imgView.setVisibility(View.GONE);
        }
        else {
            holder.imgView.setVisibility(View.VISIBLE);
            String imgurl=data.get(position).getImagehref().replaceAll("http","https");
            holder.imgView.setVisibility(View.VISIBLE);
           /* Glide.with(context)
                    .load(imgurl)
                    .apply(myOptions)
                    .into(holder.imgView);*/
            Picasso
                    .with(context)
                    .load(imgurl)
                    .into(holder.imgView);
        }



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewUsername;
        private TextView textViewAddress;
        private ImageView imgView;


        ViewHolder(View itemView) {
            super(itemView);

            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewAddress = itemView.findViewById(R.id.textViewAddress);
            imgView = itemView.findViewById(R.id.imgView);

           /* constraintLayoutContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // clickListener.launchIntent(data.get(getAdapterPosition()).name);
                }
            });*/
        }
    }

    public interface ClickListener {
        void launchIntent(String name);
    }

    public void setData(List<Canada.RowsEntity> data, Context context) {
        this.data.clear();
        this.data.addAll(data);
        this.context=context;
        notifyDataSetChanged();
    }
}

