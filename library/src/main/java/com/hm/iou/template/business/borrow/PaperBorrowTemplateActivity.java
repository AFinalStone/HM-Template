package com.hm.iou.template.business.borrow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.hm.iou.base.BaseActivity;
import com.hm.iou.base.mvp.MvpActivityPresenter;
import com.hm.iou.router.Router;
import com.hm.iou.template.R;
import com.hm.iou.template.R2;
import com.hm.iou.template.business.comm.TemplateContentFragment;
import com.hm.iou.template.business.comm.TemplateContentInfo;
import com.hm.iou.template.business.comm.TemplateIncludeFragment;
import com.hm.iou.template.business.comm.TemplateUtil;
import com.hm.iou.uikit.CircleIndicator;
import com.hm.iou.uikit.HMTopBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by hjy on 2018/6/25.
 */

public class PaperBorrowTemplateActivity extends BaseActivity {

    /**
     * 是否显示收录页，如果传递字符串为"true"，则显示收录页，其他情况都不显示
     */
    public static final String EXTRA_KEY_SHOW_INCLUDE_PAGE = "show_include";

    @BindView(R2.id.topbar)
    HMTopBarView mTopbarView;
    @BindView(R2.id.indicator_template_iou)
    CircleIndicator mCircleIndicator;
    @BindView(R2.id.vp_template_iou)
    ViewPager mViewPager;

    private String mShowInclude;

    @Override
    protected int getLayoutId() {
        return R.layout.template_activity_paper_borrow_template;
    }

    @Override
    protected MvpActivityPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initEventAndData(Bundle bundle) {
        mShowInclude = getIntent().getStringExtra(EXTRA_KEY_SHOW_INCLUDE_PAGE);
        if (bundle != null) {
            mShowInclude = bundle.getString(EXTRA_KEY_SHOW_INCLUDE_PAGE);
        }

        mTopbarView.setRightIcon(R.mipmap.template_icon_calc);
        mTopbarView.setOnMenuClickListener(new HMTopBarView.OnTopBarMenuClickListener() {
            @Override
            public void onClickTextMenu() {

            }

            @Override
            public void onClickImageMenu() {
                Router.getInstance().buildWithUrl("hmiou://m.54jietiao.com/calculator/index")
                        .navigation(PaperBorrowTemplateActivity.this);
            }
        });

        PaperBorrowPagerAdapter adapter = new PaperBorrowPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mCircleIndicator.setViewPager(mViewPager);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_KEY_SHOW_INCLUDE_PAGE, mShowInclude);
    }

    public class PaperBorrowPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> list = new ArrayList<>();

        public PaperBorrowPagerAdapter(FragmentManager fm) {
            super(fm);
            List<TemplateContentInfo> contentList = TemplateUtil.getPaperBorrowTemplateList();
            for (TemplateContentInfo info : contentList) {
                list.add(TemplateContentFragment.newInstance(info));
            }
            if ("true".equals(mShowInclude)) {
                list.add(TemplateIncludeFragment.newInstance(TemplateIncludeFragment.TYPE_PAPER_BORROW));
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "";
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
    }
}
