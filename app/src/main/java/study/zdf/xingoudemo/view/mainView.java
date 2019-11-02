package study.zdf.xingoudemo.view;

import java.io.IOException;
import java.util.List;

import study.zdf.xingoudemo.model.tabItemBean;

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/2 11:04
 */
public interface mainView {
    void onFailure(IOException e);

    void onSuccessRequest(List<tabItemBean.NewslistBean> newslist);
}
