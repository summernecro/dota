package com.summer.dota.main;

//by summer on 2018-09-06.

import com.android.lib.base.activity.BaseUIActivity;

public class MainAct extends BaseUIActivity<MainUIOpe,MainDAOpe,MainValue> {

    @Override
    protected void initNow() {
        super.initNow();
        getP().getU().initImages(getP().getV().getImageRes());
    }
}
