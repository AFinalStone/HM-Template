package com.hm.iou.template.business;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hm.iou.base.BaseActivity;
import com.hm.iou.base.mvp.MvpActivityPresenter;
import com.hm.iou.template.R;
import com.hm.iou.template.R2;
import com.hm.iou.tools.DensityUtil;
import com.hm.iou.uikit.HMTopBarView;

import butterknife.BindView;

/**
 * Created by hjy on 2018/6/25.
 */

public class TemplateDetailActivity extends BaseActivity {

    @BindView(R2.id.topbar)
    HMTopBarView mTopBarView;
    @BindView(R2.id.iv_template_content)
    ImageView mIvContent;

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
        Intent data = getIntent();
        String title = data.getStringExtra("title");
        int resId = data.getIntExtra("contentResId", 0);
        mTopBarView.setTitle(title);
        mIvContent.setImageResource(resId);

        int width = getResources().getDisplayMetrics().widthPixels - DensityUtil.dip2px(this, 20);
        int height = (int) (width * (726f / 602));
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mIvContent.getLayoutParams();
        params.width = width;
        params.height = height;
        mIvContent.setLayoutParams(params);

        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
