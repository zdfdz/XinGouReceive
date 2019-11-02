package study.zdf.xingoudemo.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.util.List;

import study.zdf.xingoudemo.R;
import study.zdf.xingoudemo.adapter.MainViewPagerAdapter;
import study.zdf.xingoudemo.base.BaseActivity;
import study.zdf.xingoudemo.model.tabItemBean;
import study.zdf.xingoudemo.presenter.impl.MainPresenterImpl;
import study.zdf.xingoudemo.view.mainView;

public class MainActivity extends BaseActivity implements mainView {

    private TabLayout mTabLayout;
    private MainPresenterImpl mPresenter;
    private ViewPager mViewPager;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();

        mPresenter = new MainPresenterImpl(this);
        mPresenter.requestData();
    }

    @Override
    public void initView() {
        super.initView();

        mTabLayout = findViewById(R.id.tablayout);
        mViewPager = findViewById(R.id.vp_mvPager);

    }

    @Override
    public void onFailure(IOException e) {
        myToast("网络问题,咱拿不到数据");
    }

    @Override
    public void onSuccessRequest(List<tabItemBean.NewslistBean> newslist) {
        for (int i=0;i<newslist.size();i++){
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setText(newslist.get(i).getName());
            mTabLayout.addTab(tab);
        }
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(newslist, getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }
}
