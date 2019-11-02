package study.zdf.xingoudemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import study.zdf.xingoudemo.model.ContentItemBean;
import study.zdf.xingoudemo.widget.IndexItemView;

/**
 * @author ZhengDeFeng
 * @description: index页recyclerView Adapter
 * @date :2019/11/2 14:10
 */
public class IndexRcAdapter extends RecyclerView.Adapter<IndexRcAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ContentItemBean.ViewItem> data;

    public IndexRcAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = View.inflate(context, R.layout.item_recyclerview_index, null);
        return new ViewHolder(new IndexItemView(context));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        ContentItemBean.ViewItem item = data.get(i);
        IndexItemView itemView = (IndexItemView) viewHolder.itemView;
        itemView.setBindData(item);
        //item点击事件,可以改为布局里view的点击事件
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回调到v层处理事件
                if (listener != null) {
                    listener.ClickCallBack(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * 设置数据信息
     *
     * @param data json返回的data信息,已保证数据安全性,不用再判空了。
     */
    public void setData(ArrayList<ContentItemBean.ViewItem> data) {
        this.data.clear();
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }

    private myClickListener listener;

    public interface myClickListener {
        void ClickCallBack(int i);
    }

    public void myClickEvent(myClickListener listener) {
        this.listener = listener;
    }
}
