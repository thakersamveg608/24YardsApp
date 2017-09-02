package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.R;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model.SubCategoryData;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by samveg on 26/8/17.
 */

public class SubCategoriesAdapter extends RecyclerView.Adapter<SubCategoriesAdapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    Context context;
    private List<SubCategoryData> subCategoryData = new ArrayList<>();

    public SubCategoriesAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setSubCategoryList(List<SubCategoryData> subCategorydata){
        this.subCategoryData = subCategorydata;
    }

    @Override
    public SubCategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.sub_category_items,parent,false);
        return new ViewHolder(view );
    }

    @Override
    public void onBindViewHolder(SubCategoriesAdapter.ViewHolder holder, int position) {

        SubCategoryData data = subCategoryData.get(position);
        holder.siteName.setText(data.getTitle());
        holder.siteLocation.setText(data.getLocation());
        holder.sitePrice.setText(data.getPrice());
        Glide.with(context).load(data.getImage()).bitmapTransform(new CropCircleTransformation(context)).into(holder.siteImage);
        Glide.with(context).load(R.drawable.call_button).bitmapTransform(new CropCircleTransformation(context)).into(holder.callDealer);
    }

    @Override
    public int getItemCount() {
        return subCategoryData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView siteName;
        TextView sitePrice;
        TextView siteLocation;
        ImageView siteImage;
        ImageView callDealer;

        public ViewHolder(View itemView) {
            super(itemView);
            siteName = (TextView) itemView.findViewById(R.id.site_name);
            sitePrice = (TextView) itemView.findViewById(R.id.site_price);
            siteLocation = (TextView) itemView.findViewById(R.id.site_locality);
            siteImage = (ImageView) itemView.findViewById(R.id.site_image);
            callDealer = (ImageView) itemView.findViewById(R.id.call_button);
        }

    }
}
