package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.property_end_page.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.R;

import java.util.ArrayList;

/**
 * Created by samveg on 24/9/17.
 */

public class PropertImageAdapter extends PagerAdapter {

    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public PropertImageAdapter(ArrayList<Integer> images, Context context) {
        this.images = images;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imagesPager = inflater.inflate(R.layout.property_image_pager,view,false);
        ImageView propertyImage = view.findViewById(R.id.property_image);
        Glide.with(context).load(images.get(position)).into(propertyImage);
        view.addView(imagesPager,0);
        return imagesPager;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
