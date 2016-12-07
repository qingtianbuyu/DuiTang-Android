package com.duitang.entity;

import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/5 下午10:31
 */
public class AlbumData {

    /**
     * album : {"id":64760088,"name":"卧蚕儿","count":23,"category":0,"covers":["http://img3.duitang.com/uploads/item/201412/15/20141215200427_SCRKx.jpeg"],"status":0,"like_count":319,"actived_at":0,"favorite_count":369,"favorite_id":0}
     * photo : {"width":500,"height":500,"path":"https://b-ssl.duitang.com/uploads/item/201412/15/20141215200427_SCRKx.jpeg_webp"}
     * msg : weibo：http://weibo.com/balalapure
     * id : 263243066
     * sender : {"id":4340303,"username":"BalalaPure","avatar":"https://a-ssl.duitang.com/uploads/people/201409/09/20140909232152_aBZzA.jpeg","identity":["personal_certify"],"is_certify_user":true}
     * buyable : 0
     * reply_count : 1
     * source_link :
     * add_datetime : 2014年12月15日 20:04
     * add_datetime_pretty : 1年前
     * add_datetime_ts : 1418645081
     * icon_url :
     * sender_id : 4340303
     * like_count : 3
     * favorite_count : 10
     * extra_type : PICTURE
     * is_certify_user : false
     */

    private Album album;
    private Photo photo;
    private String msg;
    private int id;
    private User sender;
    private int buyable;
    private int reply_count;
    private String source_link;
    private String add_datetime;
    private String add_datetime_pretty;
    private int add_datetime_ts;
    private String icon_url;
    private int sender_id;
    private int like_count;
    private int favorite_count;
    private String extra_type;
    private boolean is_certify_user;
    private String url;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public int getBuyable() {
        return buyable;
    }

    public void setBuyable(int buyable) {
        this.buyable = buyable;
    }

    public int getReply_count() {
        return reply_count;
    }

    public void setReply_count(int reply_count) {
        this.reply_count = reply_count;
    }

    public String getSource_link() {
        return source_link;
    }

    public void setSource_link(String source_link) {
        this.source_link = source_link;
    }

    public String getAdd_datetime() {
        return add_datetime;
    }

    public void setAdd_datetime(String add_datetime) {
        this.add_datetime = add_datetime;
    }

    public String getAdd_datetime_pretty() {
        return add_datetime_pretty;
    }

    public void setAdd_datetime_pretty(String add_datetime_pretty) {
        this.add_datetime_pretty = add_datetime_pretty;
    }

    public int getAdd_datetime_ts() {
        return add_datetime_ts;
    }

    public void setAdd_datetime_ts(int add_datetime_ts) {
        this.add_datetime_ts = add_datetime_ts;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public String getExtra_type() {
        return extra_type;
    }

    public void setExtra_type(String extra_type) {
        this.extra_type = extra_type;
    }

    public boolean isIs_certify_user() {
        return is_certify_user;
    }

    public void setIs_certify_user(boolean is_certify_user) {
        this.is_certify_user = is_certify_user;
    }

    public boolean is_certify_user() {
        return is_certify_user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
