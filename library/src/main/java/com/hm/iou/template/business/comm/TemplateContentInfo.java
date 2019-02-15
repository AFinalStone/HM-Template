package com.hm.iou.template.business.comm;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hjy on 2018/6/27.
 */

public class TemplateContentInfo implements Parcelable {

    private String title;       //标题
    private int contentResId;   //内容图片资源id
    private String typeLabel;

    public TemplateContentInfo(String title, int contentResId, String typeLabel) {
        this.title = title;
        this.contentResId = contentResId;
        this.typeLabel = typeLabel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getContentResId() {
        return contentResId;
    }

    public void setContentResId(int contentResId) {
        this.contentResId = contentResId;
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeInt(this.contentResId);
        dest.writeString(this.typeLabel);
    }

    protected TemplateContentInfo(Parcel in) {
        this.title = in.readString();
        this.contentResId = in.readInt();
        this.typeLabel = in.readString();
    }

    public static final Creator<TemplateContentInfo> CREATOR = new Creator<TemplateContentInfo>() {
        @Override
        public TemplateContentInfo createFromParcel(Parcel source) {
            return new TemplateContentInfo(source);
        }

        @Override
        public TemplateContentInfo[] newArray(int size) {
            return new TemplateContentInfo[size];
        }
    };
}
