package com.summer.dota.main;

//by summer on 2018-09-06.

import android.view.View;

import com.android.lib.base.activity.BaseUIActivity;
import com.android.lib.base.listener.ViewListener;
import com.android.lib.util.GsonUtil;
import com.android.lib.util.SPUtil;
import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;

public class MainAct extends BaseUIActivity<MainUIOpe,MainDAOpe,MainValue> implements ViewListener {

    @Override
    protected void initNow() {
        super.initNow();
        getP().getV().init(this);
        getP().getU().initImages(getP().getV().getImageRes(),this);
    }

    @Override
    public void onInterupt(int i, final View view) {
        switch (i){
            case ViewListener.TYPE_ONCLICK:
                ViewAnimator.animate(view).rotationY(0,360).duration(2000).start().onStop(new AnimationListener.Stop() {
                    @Override
                    public void onStop() {
                        ViewAnimator.animate(view).scale(1,1.1f,1,1.1f,1).duration(2000).start();
                    }
                });
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SPUtil.getInstance().saveStr("images", GsonUtil.getInstance().toJson(getP().getV().getImageRes()));
    }
}
