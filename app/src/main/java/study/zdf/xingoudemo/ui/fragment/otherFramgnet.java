package study.zdf.xingoudemo.ui.fragment;

import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.view.View;
import android.widget.TextView;

import study.zdf.xingoudemo.R;
import study.zdf.xingoudemo.base.BaseFragment;

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/2 12:46
 */
public class otherFramgnet extends BaseFragment {
    @Override
    public int getLayoutID() {
        return R.layout.fragment_orther;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        TextView mTvTxt = view.findViewById(R.id.tv_other);
        //获取传过来的bundle数据
        Bundle arguments = getArguments();
        mTvTxt.setText(arguments.getString("zdf"));
    }
}
