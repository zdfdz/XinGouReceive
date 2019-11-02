package study.zdf.xingoudemo.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import study.zdf.xingoudemo.model.tabItemBean;
import study.zdf.xingoudemo.ui.fragment.indexFragment;
import study.zdf.xingoudemo.ui.fragment.otherFramgnet;

/**
 * @author ZhengDeFeng
 * @description:ViewPager的适配器
 * @date :2019/11/2 11:38
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private List<tabItemBean.NewslistBean> newslist;

    public MainViewPagerAdapter(List<tabItemBean.NewslistBean> newslist, FragmentManager fm) {
        super(fm);
        this.newslist = newslist;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new indexFragment();
        } else {
            //如果布局相同,用一个基Framgnet就可以,通过设置adapter改变内容
            otherFramgnet otherFramgnet = new otherFramgnet();
            //fragment传值一定用Bundle哈,要不activity重建会引起fragment的数据丢失
            Bundle bundle = new Bundle();
            bundle.putString("zdf", "我 是 第 "+i+" 个 fragment");
            otherFramgnet.setArguments(bundle);
            return otherFramgnet;
        }
    }

    @Override
    public int getCount() {
        return newslist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return newslist.get(position).getName();
    }
}
