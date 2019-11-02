package study.zdf.xingoudemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author ZhengDeFeng
 * @description:商品详细信息bean
 * @date :2019/11/2 15:40
 */
public class GoodsInfoBean implements Parcelable {
    private String name;

    //这里要有一个空参构造
    public GoodsInfoBean() {

    }

    public GoodsInfoBean(Parcel in) {
        name = in.readString();
        url = in.readString();
        info = in.readString();
    }

    public static final Creator<GoodsInfoBean> CREATOR = new Creator<GoodsInfoBean>() {
        @Override
        public GoodsInfoBean createFromParcel(Parcel in) {
            return new GoodsInfoBean(in);
        }

        @Override
        public GoodsInfoBean[] newArray(int size) {
            return new GoodsInfoBean[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String url;
    private String info;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(info);
    }
}
