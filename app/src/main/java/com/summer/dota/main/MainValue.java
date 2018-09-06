package com.summer.dota.main;

//by summer on 2018-09-06.

import com.android.lib.base.ope.BaseValue;
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
            R.drawable.medusa_vert//美杜莎
    };

    public MainValue() {
        for(int i=0;i<imageInts.length;i++){
            imageRes.add(imageInts[i]);
        }
    }
}
