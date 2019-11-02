package study.zdf.xingoudemo.presenter.impl;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Date;
import java.util.IllegalFormatCodePointException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import study.zdf.xingoudemo.model.ContentItemBean;
import study.zdf.xingoudemo.presenter.interf.IndexPresenterInterf;
import study.zdf.xingoudemo.ui.fragment.indexFragment;
import study.zdf.xingoudemo.utils.ThreadUtils;
import study.zdf.xingoudemo.view.indexFragmentView;

/**
 * @author ZhengDeFeng
 * @description: viewPager的第一个fragment
 * @date :2019/11/2 12:12
 */
public class IndexPresenterImpl implements IndexPresenterInterf {
    private final String path = "http://39.96.187.58:8080/test.json";
    private indexFragmentView view;

    public IndexPresenterImpl(indexFragmentView view) {
        this.view = view;
    }

    @Override
    public void requestData() {
        // 这里应该封装一个okhttp的,多次用到了请求数据。。等你确定了用啥这里再换吧
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get().url(path).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                ThreadUtils.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        view.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.body()==null){
                    return;
                }
                Gson gson = new Gson();
                final ContentItemBean contentItemBean = gson.fromJson(response.body().string(), ContentItemBean.class);
                Log.i("zdf","数据长度"+contentItemBean.data.size());
                if (contentItemBean.data.size()>0){
                    ThreadUtils.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            view.onSuccessRequest(contentItemBean.data);
                        }
                    });
                }
            }
        });
    }
}
