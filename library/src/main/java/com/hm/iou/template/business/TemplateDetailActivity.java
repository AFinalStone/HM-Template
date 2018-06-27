package com.hm.iou.template.business;

import android.os.Bundle;

import com.hm.iou.base.BaseActivity;
import com.hm.iou.base.mvp.MvpActivityPresenter;
import com.hm.iou.template.R;

/**
 * Created by hjy on 2018/6/25.
 */

public class TemplateDetailActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.template_activity_template_detail;
    }

    @Override
    protected MvpActivityPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initEventAndData(Bundle bundle) {

    }
}
