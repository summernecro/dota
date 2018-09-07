package com.summer.dota.main;

//by summer on 2018-09-06.

import android.content.Context;

import com.android.lib.base.ope.BaseValue;
import com.android.lib.util.GsonUtil;
import com.android.lib.util.SPUtil;
import com.google.gson.reflect.TypeToken;
import com.summer.dota.R;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainValue extends BaseValue {

    private ArrayList<Integer> imageRes = new ArrayList<>();

    private int[] imageInts = new int[]{
            R.drawable.abyssal_underlord_vert,//深渊领主
            R.drawable.tidehunter_vert,//潮汐猎人
            R.drawable.axe_vert,//斧王
            R.drawable.necrolyte_vert,//瘟疫法师
            R.drawable.pudge_vert,//屠夫
            R.drawable.bristleback_vert,//钢背兽
            R.drawable.furion_vert,//先知
            R.drawable.chaos_knight_vert,//混沌骑士
            R.drawable.medusa_vert,//美杜莎
            R.drawable.spectre_vert,//幽鬼
            R.drawable.drow_ranger_vert,//小黑
            R.drawable.antimage_vert,//敌法
    };

    public void init(Context context) {
        imageRes.clear();
        SPUtil.getInstance().init(context);
        String str = SPUtil.getInstance().getStr("images");
        if(str!=null&&!"".equals(str)&&!"null".equals(str)){
            imageRes = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr("images"),new TypeToken<ArrayList<Integer>>(){}.getType());
        }else{
            for(int i=0;i<imageInts.length;i++){
                imageRes.add(imageInts[i]);
            }
        }
    }


}
