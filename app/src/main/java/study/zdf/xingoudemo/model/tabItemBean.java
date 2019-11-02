package study.zdf.xingoudemo.model;

import java.util.List;

/**
 * @author ZhengDeFeng
 * @description:tab的bean，自己按照json的格式改改
 * @date :2019/11/2 10:42
 */
public class tabItemBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"colid":38,"name":"汉服新闻","nameid":"hanfu","jianjie":"民族文化汉服新闻资讯"},{"colid":37,"name":"房产新闻","nameid":"house","jianjie":"房产写字楼新闻资讯"},{"colid":36,"name":"科学探索","nameid":"sicprobe","jianjie":"探索宇宙和科学的真相"},{"colid":35,"name":"汽车新闻","nameid":"auto","jianjie":"汽车行业新闻资讯接口"},{"colid":34,"name":"互联网资讯","nameid":"internet","jianjie":"互联网资讯新闻接口"},{"colid":33,"name":"动漫资讯","nameid":"dongman","jianjie":"全网热点动漫资讯API"},{"colid":32,"name":"财经新闻","nameid":"caijing","jianjie":"了解身边的经济大事"},{"colid":31,"name":"游戏资讯","nameid":"game","jianjie":"每日游戏精选新闻"},{"colid":30,"name":"CBA新闻","nameid":"cba","jianjie":"CBA新闻咨询API接口"},{"colid":29,"name":"人工智能","nameid":"ai","jianjie":"AI人工智能行业新闻资讯API"},{"colid":28,"name":"区块链新闻","nameid":"blockchain","jianjie":"区块链行业相关新闻资讯API"},{"colid":22,"name":"IT资讯","nameid":"it","jianjie":"IT行业相关新闻资讯API"},{"colid":21,"name":"VR科技","nameid":"vr","jianjie":"VR虚拟现实新闻资讯API"},{"colid":11,"name":"美女图片","nameid":"meinv","jianjie":"美女图片API"},{"colid":14,"name":"奇闻异事","nameid":"qiwen","jianjie":"世界奇闻资讯API"},{"colid":17,"name":"健康知识","nameid":"health","jianjie":"健康知识养生资讯文章资讯"},{"colid":18,"name":"旅游资讯","nameid":"travel","jianjie":"旅游景点新闻资讯API"},{"colid":23,"name":"移动互联","nameid":"mobile","jianjie":"移动互联网行业资讯API"},{"colid":27,"name":"军事新闻","nameid":"military","jianjie":"军事资讯API"},{"colid":19,"name":"苹果新闻","nameid":"apple","jianjie":"Apple产品动态API"},{"colid":24,"name":"创业新闻","nameid":"startup","jianjie":"互联网行业新闻AP"},{"colid":13,"name":"科技新闻","nameid":"keji","jianjie":"信息科技行业新闻"},{"colid":26,"name":"足球新闻","nameid":"football","jianjie":"国足新闻动态实时更新"},{"colid":20,"name":"NBA新闻","nameid":"nba","jianjie":"NBA新闻动态API"},{"colid":12,"name":"体育新闻","nameid":"tiyu","jianjie":"国内外体育API"},{"colid":10,"name":"娱乐新闻","nameid":"huabian","jianjie":"娱乐新闻API服务"},{"colid":8,"name":"国际新闻","nameid":"world","jianjie":"国际新闻API接口服务"},{"colid":7,"name":"国内新闻","nameid":"guonei","jianjie":"国内新闻API接口服务"},{"colid":5,"name":"社会新闻","nameid":"social","jianjie":"了解社会新闻大事"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * colid : 38
         * name : 汉服新闻
         * nameid : hanfu
         * jianjie : 民族文化汉服新闻资讯
         */

        private int colid;
        private String name;
        private String nameid;
        private String jianjie;

        public int getColid() {
            return colid;
        }

        public void setColid(int colid) {
            this.colid = colid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNameid() {
            return nameid;
        }

        public void setNameid(String nameid) {
            this.nameid = nameid;
        }

        public String getJianjie() {
            return jianjie;
        }

        public void setJianjie(String jianjie) {
            this.jianjie = jianjie;
        }
    }
}
