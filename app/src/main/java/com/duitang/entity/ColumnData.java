package com.duitang.entity;

import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/25 下午1:17
 */
public class ColumnData {

    /**
     * id : 395225
     * type : article
     * title : 试用第5期 | 我和糖果有个约会  糖果组合
     * sender : {"id":13529930,"username":"堆糖试用申请","avatar":"http://cdn.duitang.com/uploads/item/201612/19/20161219140044_J4QLh.jpeg","identity":["personal_certify"],"is_certify_user":true}
     * photos : [{"width":200,"height":200,"path":"http://img3.duitang.com/uploads/item/201612/20/20161220160948_WEAxU.jpeg"}]
     * column : {"id":"582ee155e4b09b4a77c2fa65","name":"堆糖实验室","target":"http://www.duitang.com/guide2/column/582ee155e4b09b4a77c2fa65/?__urlopentype=pageweb","image":"http://img4q.duitang.com/uploads/item/201611/18/20161118190859_SL2Vr.jpeg","color":"#70CF95","sub_count":2}
     * desc :
     * url : http://www.duitang.com/life_artist/article/?id=395225&__containertype=1
     * favorite_count : 151
     * add_datetime_ts : 0
     * recommend_word : CMS文章-申请试用
     * dynamic_info : 22167人参与
     * short_desc : 堆糖试用申请
     * article_category : article_item_apply
     * article_status : 0
     * pin_tag_name : 试用
     */

    private int id;
    private String type;
    private String title;
    private User sender;
    private Column column;
    private String desc;
    private String url;
    private int favorite_count;
    private int add_datetime_ts;
    private String recommend_word;
    private String dynamic_info;
    private String short_desc;
    private String article_category;
    private int article_status;
    private String pin_tag_name;
    private List<Photo> photos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public int getAdd_datetime_ts() {
        return add_datetime_ts;
    }

    public void setAdd_datetime_ts(int add_datetime_ts) {
        this.add_datetime_ts = add_datetime_ts;
    }

    public String getRecommend_word() {
        return recommend_word;
    }

    public void setRecommend_word(String recommend_word) {
        this.recommend_word = recommend_word;
    }

    public String getDynamic_info() {
        return dynamic_info;
    }

    public void setDynamic_info(String dynamic_info) {
        this.dynamic_info = dynamic_info;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getArticle_category() {
        return article_category;
    }

    public void setArticle_category(String article_category) {
        this.article_category = article_category;
    }

    public int getArticle_status() {
        return article_status;
    }

    public void setArticle_status(int article_status) {
        this.article_status = article_status;
    }

    public String getPin_tag_name() {
        return pin_tag_name;
    }

    public void setPin_tag_name(String pin_tag_name) {
        this.pin_tag_name = pin_tag_name;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }


}
