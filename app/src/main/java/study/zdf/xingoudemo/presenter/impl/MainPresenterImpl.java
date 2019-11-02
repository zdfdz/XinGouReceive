package study.zdf.xingoudemo.presenter.impl;


import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import study.zdf.xingoudemo.model.tabItemBean;
import study.zdf.xingoudemo.presenter.interf.MainPresenterInterf;
import study.zdf.xingoudemo.utils.ThreadUtils;
import study.zdf.xingoudemo.view.mainView;

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/2 10:45
 */
public class MainPresenterImpl implements MainPresenterInterf {
    private final String path = "http://39.96.187.58:8080/xingou_tab.json";
    private mainView view;
    public MainPresenterImpl(mainView view) {
        this.view = view;
    }

    @Override
    public void requestData() {
        // OKHTTP请求数据
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get().url(path).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                ThreadUtils.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        //这样就运行在主线程了
                        view.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //这里不一定说明请求到了数据,只是说明有response返回,需要处理一哈。
                if (response.isSuccessful() && response.body()==null){
                    return;
                }
                Gson gson = new Gson();
                final tabItemBean tabItemBean = gson.fromJson(response.body().string(), tabItemBean.class);
                Log.i("zdf","返回数据长度为："+tabItemBean.getNewslist().size());
                if (tabItemBean.getNewslist().size()>0){
                    //合法数据,给UI层处理也行，m层处理也行. 你阔以根据自己的写法来
                    //我就先给UI层了哈,这里一定要通过主线程传数据。
                    ThreadUtils.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            view.onSuccessRequest(tabItemBean.getNewslist());
                        }
                    });

                }
            }
        });
    }
}
