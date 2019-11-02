package study.zdf.xingoudemo.view;

import java.io.IOException;
import java.util.ArrayList;

import study.zdf.xingoudemo.model.ContentItemBean;

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/2 12:26
 */
public interface indexFragmentView {
    void onFailure(IOException e);

    void onSuccessRequest(ArrayList<ContentItemBean.ViewItem> data);
}
