package com.summer.dota.main;

//by summer on 2018-09-06.

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.android.lib.BR;
import com.android.lib.GlideApp;
import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.bean.AppViewHolder;
import com.summer.dota.R;
import com.summer.dota.databinding.ActMainBinding;
import com.summer.dota.databinding.ItemImageBinding;

import java.util.ArrayList;

public class MainUIOpe extends BaseUIOpe<ActMainBinding>{

    public void initImages(final ArrayList<Integer> images){
        if(getBind().recycle.getAdapter()==null){
            getBind().recycle.setLayoutManager(new GridLayoutManager(getActivity(),3));
            getBind().recycle.setAdapter(new AppsDataBindingAdapter(getActivity(), R.layout.item_image, BR.item_image,images){
                @Override
                public void onBindViewHolder(AppViewHolder holder, int position) {
                    super.onBindViewHolder(holder, position);
                    ItemImageBinding binding = (ItemImageBinding) holder.viewDataBinding;
                    GlideApp.with(getActivity()).asBitmap().load(images.get(position)).into(binding.image);
                }
            });
        }else{
            getBind().recycle.getAdapter().notifyDataSetChanged();
        }
    }
}
