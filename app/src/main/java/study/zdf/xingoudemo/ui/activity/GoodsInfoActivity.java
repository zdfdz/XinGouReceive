package study.zdf.xingoudemo.ui.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import study.zdf.xingoudemo.R;
import study.zdf.xingoudemo.base.BaseActivity;
import study.zdf.xingoudemo.model.GoodsInfoBean;

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/2 15:16
 */
public class GoodsInfoActivity extends BaseActivity {

    private ArrayList<GoodsInfoBean> goodsInfo;

    @Override
    public int getLayoutID() {
        return R.layout.activity_goods_info;
    }

    @Override
    public void initData() {
        super.initData();
        Intent intent = getIntent();
        goodsInfo = intent.getParcelableArrayListExtra("goods_info");
        Log.i("zdf","goods ---" + goodsInfo.size());
    }

    @Override
    public void initView() {
        super.initView();
        ImageView mIvGoodsInfo = findViewById(R.id.iv_goods_info);
        Picasso.with(this).load(goodsInfo.get(0).getUrl()).into(mIvGoodsInfo);

        TextView mTvGoodsName = findViewById(R.id.tv_goods_name);
        mTvGoodsName.setText(goodsInfo.get(0).getName());

        TextView mTvGoodsTest = findViewById(R.id.tv_goods_test);
        mTvGoodsTest.setText(goodsInfo.get(0).getInfo());

    }
}
