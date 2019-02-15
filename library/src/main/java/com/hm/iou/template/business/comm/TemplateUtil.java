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
                R.mipmap.template_paper_borrow_1, "提醒");
        list.add(info);

        info = new TemplateContentInfo("借 条",
                R.mipmap.template_paper_borrow_2, "资金");
        list.add(info);

        info = new TemplateContentInfo("借 条",
                R.mipmap.template_paper_borrow_3, "物品");
        list.add(info);

        info = new TemplateContentInfo("中文数字大写",
                R.mipmap.template_paper_borrow_4, "");
        list.add(info);

        return list;
    }

    public static List<TemplateContentInfo> getPaperReceiveTemplateList() {
        List<TemplateContentInfo> list = new ArrayList<>();

        TemplateContentInfo info = new TemplateContentInfo("纸质“收条”注意事项",
                R.mipmap.template_paper_receive_1, "提醒");
        list.add(info);

        info = new TemplateContentInfo("收 条",
                R.mipmap.template_paper_receive_2, "资金");
        list.add(info);

        info = new TemplateContentInfo("收 条",
                R.mipmap.template_paper_receive_3, "物品");
        list.add(info);

        info = new TemplateContentInfo("代 收 条",
                R.mipmap.template_paper_receive_4, "代收");
        list.add(info);

        info = new TemplateContentInfo("中文数字大写",
                R.mipmap.template_paper_borrow_4, "");
        list.add(info);

        return list;
    }

}
