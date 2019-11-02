package study.zdf.xingoudemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import study.zdf.xingoudemo.R;

/**
 * @author ZhengDeFeng
 * @description: activity基类
 * @date :2019/11/2 10:24
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initData();
        initView();
        initListener();
    }

    /**
     * 初始化监听
     */
    public void initListener() {
    }

    /**
     * 数据初始化
     */
    public void initData() {
    }

    /**
     * 做view的初始化操作
     */
    public void initView(){

    }

    /**
     * 获取布局id
     *
     * @return layout ID
     */
    public abstract int getLayoutID();

    /**
     * toast
     */
    public void myToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
