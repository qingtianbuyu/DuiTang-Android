package com.duitang.entity;

import java.util.List;

/**
 * Title:专辑
 * description:
 * author: yking
 * created on: 2016/12/5 下午8:29
 */
public class Album {

    /**
     * id : 64760088
     * name : 卧蚕儿
     * desc :
     * count : 23
     * category : 0
     * covers : ["http://img3.duitang.com/uploads/item/201412/15/20141215200427_SCRKx.jpeg"]
     * user : {"id":4340303,"username":"BalalaPure","avatar":"https://a-ssl.duitang.com/uploads/people/201409/09/20140909232152_aBZzA.jpeg","identity":["personal_certify"],"is_certify_user":true}
     * tags : [{"id":6005980,"name":"人物","target":"","type":1,"tag_id":12779},{"id":6005981,"name":"100%PURE","target":"","type":1,"tag_id":447689},{"id":6005982,"name":"摄影","target":"","type":1,"tag_id":2240},{"id":6895590,"name":"精选专辑","target":"","type":2,"tag_id":500635},{"id":6895591,"name":"美图摄影","target":"","type":2,"tag_id":492853}]
     * status : 0
     * like_id : 0
     * like_count : 351
     * created_at : 2014-12-15 20:01:25
     * share_links_3 : {"qq":"duitang://www.duitang.com/share/?site=qq&title=%E5%8D%A7%E8%9A%95%E5%84%BF&desc=%E6%9D%A5%E8%87%AA%E5%A0%86%E7%B3%96%E4%B8%93%E8%BE%91&url=http%3A%2F%2Fwww.duitang.com%2Falbum%2F%3Fid%3D64760088%26src%3Dsinadt&imgurl=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201412%2F15%2F20141215200427_SCRKx.jpeg","weixin":"duitang://www.duitang.com/share/?site=weixin&title=%E5%A0%86%E7%B3%96%EF%BC%8D%E4%B8%93%E8%BE%91&desc=%E5%8D%A7%E8%9A%95%E5%84%BF&url=http%3A%2F%2Fwww.duitang.com%2Falbum%2F%3Fid%3D64760088%26src%3Dsinadt&imgurl=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201412%2F15%2F20141215200427_SCRKx.jpeg&scene=session&contenttype=link","system":"duitang://www.duitang.com/share/?site=system&title=%E5%8D%A7%E8%9A%95%E5%84%BF&desc=%E5%8D%A7%E8%9A%95%E5%84%BF%3E%3E%3Ehttp%3A%2F%2Fwww.duitang.com%2Falbum%2F%3Fid%3D64760088%26src%3Dsinadt%E6%9D%A5%E8%87%AA%E5%A0%86%E7%B3%96%E4%B8%93%E8%BE%91%EF%BC%8C%E6%83%B3%E7%9C%8B%E6%9B%B4%E5%A4%9A%E4%B8%93%E8%BE%91%E4%B8%8B%E8%BD%BD%E2%86%92http%3A%2F%2Fweibo.com%2Fp%2F100404149543&url=http%3A%2F%2Fwww.duitang.com%2Falbum%2F%3Fid%3D64760088%26src%3Dsinadt&imgurl=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201412%2F15%2F20141215200427_SCRKx.jpeg","weixinpengyouquan":"duitang://www.duitang.com/share/?site=weixin&title=%E5%8D%A7%E8%9A%95%E5%84%BF%EF%BC%8D%E5%A0%86%E7%B3%96%E4%B8%93%E8%BE%91&desc=&url=http%3A%2F%2Fwww.duitang.com%2Falbum%2F%3Fid%3D64760088%26src%3Dsinadt&imgurl=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201412%2F15%2F20141215200427_SCRKx.jpeg&scene=timeline&contenttype=link","weibo":"duitang://www.duitang.com/share/?site=weibo&title=%E5%8D%A7%E8%9A%95%E5%84%BF&desc=%E5%8D%A7%E8%9A%95%E5%84%BF%3E%3E%3Ehttp%3A%2F%2Fwww.duitang.com%2Falbum%2F%3Fid%3D64760088%26src%3Dsinadt%E6%9D%A5%E8%87%AA%E5%A0%86%E7%B3%96%E4%B8%93%E8%BE%91%EF%BC%8C%E6%83%B3%E7%9C%8B%E6%9B%B4%E5%A4%9A%E4%B8%93%E8%BE%91%E4%B8%8B%E8%BD%BD%E2%86%92http%3A%2F%2Fweibo.com%2Fp%2F100404149543&url=http%3A%2F%2Fwww.duitang.com%2Falbum%2F%3Fid%3D64760088%26src%3Dsinadt&imgurl=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201412%2F15%2F20141215200427_SCRKx.jpeg","qzone":"duitang://www.duitang.com/share/?site=qzone&title=%E5%A0%86%E7%B3%96%EF%BC%8D%E4%B8%93%E8%BE%91&desc=%E5%8D%A7%E8%9A%95%E5%84%BF&url=http%3A%2F%2Fwww.duitang.com%2Falbum%2F%3Fid%3D64760088%26src%3Dsinadt&imgurl=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201412%2F15%2F20141215200427_SCRKx.jpeg"}
     * actived_at : 0
     * favorite_count : 415
     * favorite_id : 0
     */

    private int id;
    private String name;
    private String desc;
    private int count;
    private int category;
    private User user;
    private int status;
    private int like_id;
    private int like_count;
    private String created_at;
    private ShareLinks share_links_3;
    private int actived_at;
    private int favorite_count;
    private int favorite_id;
    private List<String> covers;
    private List<Tags> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLike_id() {
        return like_id;
    }

    public void setLike_id(int like_id) {
        this.like_id = like_id;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public ShareLinks getShare_links_3() {
        return share_links_3;
    }

    public void setShare_links_3(ShareLinks share_links_3) {
        this.share_links_3 = share_links_3;
    }

    public int getActived_at() {
        return actived_at;
    }

    public void setActived_at(int actived_at) {
        this.actived_at = actived_at;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public List<String> getCovers() {
        return covers;
    }

    public void setCovers(List<String> covers) {
        this.covers = covers;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

}
