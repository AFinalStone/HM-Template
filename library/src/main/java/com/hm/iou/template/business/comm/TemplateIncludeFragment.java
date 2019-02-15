package com.hm.iou.template.business.comm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hm.iou.base.BaseFragment;
import com.hm.iou.base.mvp.MvpFragmentPresenter;
import com.hm.iou.router.Router;
import com.hm.iou.template.R;
import com.hm.iou.template.R2;

import butterknife.BindView;

/**
 * Created by hjy on 2018/6/27.
 */

public class TemplateIncludeFragment extends BaseFragment {

    public static final int TYPE_PAPER_BORROW = 0;
    public static final int TYPE_PAPER_RECEIVE = 1;

    public static TemplateIncludeFragment newInstance(int type) {
        TemplateIncludeFragment fragment = new TemplateIncludeFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R2.id.tv_template_include_desc)
    TextView mTvDesc;
    @BindView(R2.id.btn_template_include)
    Button mBtnInclude;
    @BindView(R2.id.iv_template_content)
    ImageView mIvTemplateType;

    private int mType;

    @Override
    protected int getLayoutId() {
        return R.layout.template_item_pager_include;
    }

    @Override
    protected MvpFragmentPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initEventAndData(Bundle bundle) {
        Bundle args = getArguments();
        if (args != null) {
            mType = args.getInt("type");
            if (mType == TYPE_PAPER_BORROW) {
                mTvDesc.setText(R.string.template_paper_borrow_include_desc);
                mBtnInclude.setText(R.string.template_paper_borrow_include_btn);
                mIvTemplateType.setImageResource(R.mipmap.template_img_borrow_template);
            } else {
                mTvDesc.setText(R.string.template_paper_receive_include_desc);
                mBtnInclude.setText(R.string.template_paper_receive_include_btn);
                mIvTemplateType.setImageResource(R.mipmap.template_img_receipt_template);
            }
        }

        mBtnInclude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mType == TYPE_PAPER_BORROW) {
                    Router.getInstance().buildWithUrl("hmiou://m.54jietiao.com/iou_create/paper_borrow_prepare")
                            .navigation(getActivity());
                } else {
                    Router.getInstance().buildWithUrl("hmiou://m.54jietiao.com/iou_create/paper_receive_prepare")
                            .navigation(getActivity());
                }
            }
        });
    }
}
