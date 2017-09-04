package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.R;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.model.CategoryData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private List<CategoryData> categoryData = new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;

    public CategoryAdapter(Context context){

        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    public void setCategoryData(List<CategoryData> categoryData){
        this.categoryData = categoryData;
    }

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.home_recycler_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CategoryData categoryData1 = categoryData.get(position);
        holder.categoryName.setText(categoryData1.getProperty_type());
        Glide.with(context).load(categoryData1.getImage_url()).into(holder.categoryImage);

    }

    @Override
    public int getItemCount() {
        return categoryData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView categoryImage;
        public TextView categoryName;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.category_image);
            categoryName = itemView.findViewById(R.id.category_type);
        }
    }
}
