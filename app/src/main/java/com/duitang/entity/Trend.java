package com.duitang.entity;

import com.blankj.utilcode.utils.TimeUtils;

import java.util.List;

public class Trend {

    /**
     * id : 68265345
     * type : ALBUM
     * title : 小食记
     * user : {"id":12295222,"username":"YKing3000","avatar":"http://cdn.duitang.com/uploads/people/201606/27/20160627082612_ci3jS.jpeg","identity":["normal"],"is_certify_user":false}
     * blogs : [{"id":681702854,"photo":{"width":1999,"height":1359,"path":"https://a-ssl.duitang.com/uploads/item/201612/16/20161216193014_XGMR2.jpeg_webp"}},{"id":681702853,"photo":{"width":2000,"height":3004,"path":"https://a-ssl.duitang.com/uploads/item/201612/16/20161216193022_HNtFK.jpeg_webp"}},{"id":681702851,"photo":{"width":2000,"height":3141,"path":"https://a-ssl.duitang.com/uploads/item/201612/16/20161216193029_CiBPW.jpeg_webp"}}]
     * add_datetime_ts : 1481887854
     * publisher : {"id":233432,"username":"复古米米","avatar":"http://img3.duitang.com/uploads/people/201510/19/20151019000606_t2HNk.jpeg","identity":["personal_certify"],"is_certify_user":true}
     * update_blog_count : 3
     * update_blog_count_pretty : +6
     * photos : [{"width":984,"height":625,"path":"http://img3.duitang.com/uploads/item/201611/08/20161108203234_XzrP3.jpeg_webp"}]
     */

    private int id;
    private String type;
    private String title;
    private User user;
    private int add_datetime_ts;
    private User publisher;
    private int update_blog_count;
    private String update_blog_count_pretty;
    private List<Blog> blogs;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAdd_datetime_ts() {
        return add_datetime_ts;
    }

    public void setAdd_datetime_ts(int add_datetime_ts) {
        this.add_datetime_ts = add_datetime_ts;
    }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public int getUpdate_blog_count() {
        return update_blog_count;
    }

    public void setUpdate_blog_count(int update_blog_count) {
        this.update_blog_count = update_blog_count;
    }

    public String getUpdate_blog_count_pretty() {
        return update_blog_count_pretty;
    }

    public void setUpdate_blog_count_pretty(String update_blog_count_pretty) {
        this.update_blog_count_pretty = update_blog_count_pretty;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }


    public String getAdd_datetime_tsStr() {
        return TimeUtils.milliseconds2String(add_datetime_ts);
    }
}
