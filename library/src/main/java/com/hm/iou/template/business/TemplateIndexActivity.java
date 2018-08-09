package com.hm.iou.template.business;

import android.os.Bundle;
import android.view.View;

import com.hm.iou.base.BaseActivity;
import com.hm.iou.base.mvp.MvpActivityPresenter;
import com.hm.iou.base.utils.TraceUtil;
import com.hm.iou.router.Router;
import com.hm.iou.template.R;
import com.hm.iou.template.R2;
import com.hm.iou.uikit.HMTopBarView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by hjy on 18/5/15.<br>
 * 模板入口首页
 */

public class TemplateIndexActivity extends BaseActivity {

    @BindView(R2.id.topbar)
    HMTopBarView mTopBarView;

    @Override
    protected int getLayoutId() {
        return R.layout.template_activity_template_index;
    }

    @Override
    protected MvpActivityPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initEventAndData(Bundle bundle) {
        mTopBarView.getDividerView().setVisibility(View.GONE);
        mTopBarView.hideBackIcon();
    }

    @OnClick(value = {R2.id.iv_close, R2.id.rl_template_borrow, R2.id.rl_template_receive})
    void onClick(View v) {
        if (v.getId() == R.id.iv_close) {
            TraceUtil.onEvent(this, "template_close_click");
            finish();
        } else if (v.getId() == R.id.rl_template_borrow) {
            TraceUtil.onEvent(this, "templaet_borrow_click");
            Router.getInstance().buildWithUrl("hmiou://m.54jietiao.com/template/paper_borrow")
                    .withString("show_include", "true")
                    .navigation(this);
        } else if (v.getId() == R.id.rl_template_receive) {
            TraceUtil.onEvent(this, "template_receive_click");
            Router.getInstance().buildWithUrl("hmiou://m.54jietiao.com/template/paper_receive")
                    .withString("show_include", "true")
                    .navigation(this);
        }
    }

}
