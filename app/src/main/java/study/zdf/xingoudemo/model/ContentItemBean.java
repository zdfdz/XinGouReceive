package study.zdf.xingoudemo.model;

import java.util.ArrayList;

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/12 11:49
 */
public class ContentItemBean {
    public ArrayList<ViewItem> data;//返回的首页数据
    public ArrayList<Integer> extend;

    public class ViewItem {
        public String ctrip;//携程评分

        public String getCtrip() {
            return ctrip;
        }

        public void setCtrip(String ctrip) {
            this.ctrip = ctrip;
        }

        public String getMafengwo() {
            return mafengwo;
        }

        public void setMafengwo(String mafengwo) {
            this.mafengwo = mafengwo;
        }

        public String getPiclink() {
            return piclink;
        }

        public void setPiclink(String piclink) {
            this.piclink = piclink;
        }

        public String getQunar() {
            return qunar;
        }

        public void setQunar(String qunar) {
            this.qunar = qunar;
        }

        public String getRecommend_score() {
            return recommend_score;
        }

        public void setRecommend_score(String recommend_score) {
            this.recommend_score = recommend_score;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String mafengwo;//马蜂窝评分
        public String piclink;//图片链接

        @Override
        public String toString() {
            return "ViewItem{" + "ctrip='" + ctrip + '\'' + ", mafengwo='" + mafengwo + '\'' + ", piclink='" + piclink + '\'' + ", qunar='" + qunar + '\'' + ", recommend_score='" + recommend_score + '\'' + ", title='" + title + '\'' + '}';
        }

        public String qunar;//去哪评分
        public String recommend_score;//平均值
        public String title;//景点名称
        public String url;//评论url
    }
}