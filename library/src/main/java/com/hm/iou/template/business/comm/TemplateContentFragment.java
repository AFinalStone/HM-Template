package com.hm.iou.template.business.comm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
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

    public static TemplateContentFragment newInstance(TemplateContentInfo info) {
        TemplateContentFragment fragment = new TemplateContentFragment();
        Bundle args = new Bundle();
        args.putParcelable("data", info);
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R2.id.tv_template_title)
    TextView mTvTitle;
    @BindView(R2.id.iv_template_content)
    ImageView mIvContent;
    @BindView(R2.id.iv_template_type)
    ImageView mIvType;
    @BindView(R2.id.iv_template_zoom)
    ImageView mIvZoom;

    private TemplateContentInfo mContentInfo;

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
            if (mContentInfo == null) {
                return;
            }
            mTvTitle.setText(mContentInfo.getTitle());
            mIvContent.setImageResource(mContentInfo.getContentResId());
            mIvType.setImageResource(mContentInfo.getTopLabelResId());

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
