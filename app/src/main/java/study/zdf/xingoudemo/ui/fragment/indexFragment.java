package study.zdf.xingoudemo.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import study.zdf.xingoudemo.R;
import study.zdf.xingoudemo.adapter.IndexRcAdapter;
import study.zdf.xingoudemo.base.BaseFragment;
import study.zdf.xingoudemo.model.ContentItemBean;
import study.zdf.xingoudemo.model.GoodsInfoBean;
import study.zdf.xingoudemo.presenter.impl.IndexPresenterImpl;
import study.zdf.xingoudemo.ui.activity.GoodsInfoActivity;
import study.zdf.xingoudemo.view.indexFragmentView;

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/2 12:05
 */
public class indexFragment extends BaseFragment implements indexFragmentView {
    private IndexPresenterImpl mPresenter;
    private RecyclerView mIndexRecyclerView;
    private IndexRcAdapter adapter;
    private ArrayList<ContentItemBean.ViewItem> data;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_index;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mIndexRecyclerView = view.findViewById(R.id.rv_indexFragment);
    }

    @Override
    public void initData() {
        super.initData();
        //这个adapter最好提前初始化,这样有数据后可以直接加载.
        adapter = new IndexRcAdapter(getContext());
        mPresenter = new IndexPresenterImpl(this);
        mPresenter.requestData();
    }

    @Override
    public void initListener() {
        super.initListener();
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        mIndexRecyclerView.setLayoutManager(layoutManager);
        mIndexRecyclerView.setAdapter(adapter);

        //一个自定义的点击回调接口
        adapter.myClickEvent(new IndexRcAdapter.myClickListener() {

            @Override
            public void ClickCallBack(int i) {
                Toast.makeText(getContext(), "点击了第 " + i + " Item", Toast.LENGTH_LONG).show();
                ArrayList<GoodsInfoBean> mList = new ArrayList<>();
                GoodsInfoBean infoBean = new GoodsInfoBean();
                infoBean.setName(data.get(i).title);
                infoBean.setInfo(data.get(i).recommend_score);
                infoBean.setUrl(data.get(i).piclink);
                mList.add(infoBean);
                Intent intent = new Intent(getContext(), GoodsInfoActivity.class);
                intent.putParcelableArrayListExtra("goods_info", mList);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFailure(IOException e) {
        //数据拉取错误。。给个提示啥的
    }

    @Override
    public void onSuccessRequest(ArrayList<ContentItemBean.ViewItem> data) {
        this.data = data;
        adapter.setData(data);
    }
}
