package com.summer.dota.main;

//by summer on 2018-09-06.

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.android.lib.BR;
import com.android.lib.GlideApp;
import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.bean.AppViewHolder;
import com.summer.dota.R;
import com.summer.dota.databinding.ActMainBinding;
import com.summer.dota.databinding.ItemImageBinding;

import java.util.ArrayList;
import java.util.Collections;

public class MainUIOpe extends BaseUIOpe<ActMainBinding>{

    public void initImages(final ArrayList<Integer> images, ViewListener listener){
        if(getBind().recycle.getAdapter()==null){
            getBind().recycle.setLayoutManager(new GridLayoutManager(getActivity(),3));
            getBind().recycle.setAdapter(new AppsDataBindingAdapter(getActivity(), R.layout.item_image, BR.item_image,images,listener){
                @Override
                public void onBindViewHolder(AppViewHolder holder, int position) {
                    super.onBindViewHolder(holder, position);
                    ItemImageBinding binding = (ItemImageBinding) holder.viewDataBinding;
                    GlideApp.with(getActivity()).asBitmap().load(images.get(position)).into(binding.image);
                }
            });
            ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
                @Override
                public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    //首先回调的方法 返回int表示是否监听该方向
                    int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN|ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;//线性排列时监听到的为上下动作则为：拖拽排序
                    return makeMovementFlags(dragFlags, 0);
                }

                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                    //滑动事件
                    //交换位置
                    Collections.swap(images, viewHolder.getAdapterPosition(), target.getAdapterPosition());
                    //刷新adapter
                    getBind().recycle.getAdapter().notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                    return false;
                }

                @Override
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                }

                @Override
                public boolean isLongPressDragEnabled() {
                    //是否可拖拽
                    return true;
                }
            });
            helper.attachToRecyclerView(getBind().recycle);
        }else{
            getBind().recycle.getAdapter().notifyDataSetChanged();
        }
    }
}
