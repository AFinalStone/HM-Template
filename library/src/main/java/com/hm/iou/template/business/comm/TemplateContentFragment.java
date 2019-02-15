package com.hm.iou.template.business.comm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hm.iou.base.BaseFragment;
import com.hm.iou.base.mvp.MvpFragmentPresenter;
import com.hm.iou.template.R;
import com.hm.iou.template.R2;
import com.hm.iou.template.business.TemplateDetailActivity;

import butterknife.BindView;

/**
 * Created by hjy on 2018/6/25.
 */

public class TemplateContentFragment extends BaseFragment {

    public static TemplateContentFragment newInstance(TemplateContentInfo info, int labelTextColor, int labelBgColor) {
        TemplateContentFragment fragment = new TemplateContentFragment();
        Bundle args = new Bundle();
        args.putParcelable("data", info);
        args.putInt("labelTextColor", labelTextColor);
        args.putInt("labelBgColor", labelBgColor);
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R2.id.tv_template_title)
    TextView mTvTitle;
    @BindView(R2.id.iv_template_content)
    ImageView mIvContent;
    @BindView(R2.id.tv_template_type)
    TextView mTvType;
    @BindView(R2.id.iv_template_zoom)
    ImageView mIvZoom;

    private TemplateContentInfo mContentInfo;
    private int mLabelTextColor;
    private int mLabelBgColor;

    @Override
    protected int getLayoutId() {
        return R.layout.template_item_pager_template;
    }

    @Override
    protected MvpFragmentPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initEventAndData(Bundle bundle) {
        Bundle args = getArguments();
        if (args != null) {
            TemplateContentInfo info = args.getParcelable("data");
            mContentInfo = info;
            mLabelTextColor = args.getInt("labelTextColor");
            mLabelBgColor = args.getInt("labelBgColor");
            if (mContentInfo == null) {
                return;
            }
            mTvTitle.setText(mContentInfo.getTitle());
            mIvContent.setImageResource(mContentInfo.getContentResId());

            if (TextUtils.isEmpty(mContentInfo.getTypeLabel())) {
                mTvType.setVisibility(View.INVISIBLE);
            } else {
                mTvType.setText(mContentInfo.getTypeLabel());
                mTvType.setBackgroundColor(mLabelBgColor);
                mTvType.setTextColor(mLabelTextColor);
            }

            mIvContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toDetailView();
                }
            });

            mIvZoom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toDetailView();
                }
            });
        }
    }

    private void toDetailView() {
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                mIvContent, "过渡动画");
        Intent intent = new Intent(getActivity(), TemplateDetailActivity.class);
        intent.putExtra("title", mContentInfo.getTitle());
        intent.putExtra("contentResId", mContentInfo.getContentResId());
        startActivity(intent, transitionActivityOptions.toBundle());


/*        Intent intent = new Intent(getActivity(), TemplateDetailActivity.class);
        intent.putExtra("title", mContentInfo.getTitle());
        intent.putExtra("contentResId", mContentInfo.getContentResId());
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.template_zoom_enter, R.anim.template_zoom_exit);*/
    }

}
