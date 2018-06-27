package com.hm.iou.template.business.comm;

import com.hm.iou.template.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjy on 2018/6/27.
 */

public class TemplateUtil {

    public static List<TemplateContentInfo> getPaperBorrowTemplateList() {
        List<TemplateContentInfo> list = new ArrayList<>();

        TemplateContentInfo info = new TemplateContentInfo("纸质“借条”注意事项",
                R.mipmap.template_paper_borrow_1, R.mipmap.template_icon_remind);
        list.add(info);

        info = new TemplateContentInfo("借 条",
                R.mipmap.template_paper_borrow_2, R.mipmap.template_icon_money);
        list.add(info);

        info = new TemplateContentInfo("借 条",
                R.mipmap.template_paper_borrow_3, R.mipmap.template_icon_material);
        list.add(info);

        info = new TemplateContentInfo("中文数字大写",
                R.mipmap.template_paper_borrow_4, 0);
        list.add(info);

        return list;
    }

    public static List<TemplateContentInfo> getPaperReceiveTemplateList() {
        List<TemplateContentInfo> list = new ArrayList<>();

        TemplateContentInfo info = new TemplateContentInfo("纸质“收条”注意事项",
                R.mipmap.template_paper_receive_1, R.mipmap.template_icon_remind);
        list.add(info);

        info = new TemplateContentInfo("收 条",
                R.mipmap.template_paper_receive_2, R.mipmap.template_icon_money);
        list.add(info);

        info = new TemplateContentInfo("收 条",
                R.mipmap.template_paper_receive_3, R.mipmap.template_icon_material);
        list.add(info);

        info = new TemplateContentInfo("代 收 条",
                R.mipmap.template_paper_receive_4, R.mipmap.template_icon_collect);
        list.add(info);

        info = new TemplateContentInfo("中文数字大写",
                R.mipmap.template_paper_borrow_4, 0);
        list.add(info);

        return list;
    }

}
