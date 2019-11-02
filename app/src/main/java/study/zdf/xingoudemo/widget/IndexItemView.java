package study.zdf.xingoudemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import study.zdf.xingoudemo.R;
import study.zdf.xingoudemo.model.ContentItemBean;

/**
 * @author ZhengDeFeng
 * @description: index Item 具体实现
 * @date :2019/11/2 14:20
 */
public class IndexItemView extends RelativeLayout {

    private View view;

    public IndexItemView(Context context) {
        super(context);
        view = View.inflate(context, R.layout.item_recyclerview_index, this);
    }

    public IndexItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = View.inflate(context, R.layout.item_recyclerview_index, this);
    }

    public IndexItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = View.inflate(context, R.layout.item_recyclerview_index, this);
    }

    public void setBindData(ContentItemBean.ViewItem item) {
        TextView mTvPrice = view.findViewById(R.id.tv_item_index_price);
        mTvPrice.setText(item.recommend_score);

        ImageView mIvPic = view.findViewById(R.id.iv_pic);
        Picasso.with(view.getContext()).load(item.piclink).into(mIvPic);
    }
}
