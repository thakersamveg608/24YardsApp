package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.R;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.SharedPrefs;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.model.CategoryData;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.view.SubCategoryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private List<CategoryData> categoryData = new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;
    SharedPrefs sharedPrefs;

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
        sharedPrefs = new SharedPrefs(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final CategoryData categoryData1 = categoryData.get(position);
        holder.categoryName.setText(categoryData1.getProperty_type());
        Glide.with(context).load(categoryData1.getImage_url()).into(holder.categoryImage);
        holder.subCategoryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefs.setProperty(categoryData1.getProperty_type().toString());

                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_body, new SubCategoryFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView categoryImage;
        public TextView categoryName;
        RelativeLayout subCategoryCard;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.category_image);
            categoryName = itemView.findViewById(R.id.category_type);
            subCategoryCard = (RelativeLayout) itemView.findViewById(R.id.sub_category_card);
        }
    }
}
