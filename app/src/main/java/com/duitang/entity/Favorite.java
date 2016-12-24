package com.duitang.entity;

import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/24 下午5:55
 */
public class Favorite {

    /**
     * id : 26730020
     * type : album
     * title : 同性电影
     * sender : {"id":2282846,"username":"漱芳斋小凳子","avatar":"https://a-ssl.duitang.com/uploads/people/201501/23/20150123232403_wwYJZ.jpeg","is_certify_user":false}
     * photos : [{"width":0,"height":0,"path":"http://img3.duitang.com/uploads/item/201506/27/20150627160706_rX2Jv.jpeg"},{"width":0,"height":0,"path":"http://img3.duitang.com/uploads/item/201506/27/20150627160605_nxAJB.jpeg"},{"width":0,"height":0,"path":"http://img3.duitang.com/uploads/item/201506/27/20150627160432_8KJPw.jpeg"},{"width":0,"height":0,"path":"http://img3.duitang.com/uploads/item/201506/27/20150627160347_RwscB.jpeg"}]
     * target : duitang://www.duitang.com/album/detail/?id=66213926
     * status_str : normal
     * add_datetime_ts : 1465284249
     * add_datetime : 6月7日 15:24
     * icon_url : http://img4q.duitang.com/uploads/people/201603/01/20160301132551_eVmPy.png
     * blog_count : 46
     */

    private int id;
    private String type;
    private String title;
    private User sender;
    private String target;
    private String status_str;
    private int add_datetime_ts;
    private String add_datetime;
    private String icon_url;
    private int blog_count;
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getStatus_str() {
        return status_str;
    }

    public void setStatus_str(String status_str) {
        this.status_str = status_str;
    }

    public int getAdd_datetime_ts() {
        return add_datetime_ts;
    }

    public void setAdd_datetime_ts(int add_datetime_ts) {
        this.add_datetime_ts = add_datetime_ts;
    }

    public String getAdd_datetime() {
        return add_datetime;
    }

    public void setAdd_datetime(String add_datetime) {
        this.add_datetime = add_datetime;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public int getBlog_count() {
        return blog_count;
    }

    public void setBlog_count(int blog_count) {
        this.blog_count = blog_count;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

}