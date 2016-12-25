package com.duitang.entity;

import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/25 下午12:24
 */
public class TopicData {

    /**
     * id : 15732
     * content : 让你落泪哭到不能自已的一瞬间？
     * category : default
     * sender : {"id":1743086,"username":"没事就多笑","avatar":"http://cdn.duitang.com/uploads/people/201612/23/20161223192847_HEFZT.jpeg","identity":["normal"],"is_certify_user":false}
     * photos : [{"width":640,"height":480,"path":"http://img3.duitang.com/uploads/item/201507/21/20150721214659_zri8F.jpeg"}]
     * tags : [{"name":"精选","id":89567,"relation_type":2}]
     * status : 0
     * comment_count : 2983
     * visit_count : 0
     * active_time : 1482634223
     * add_datetime_ts : 1437486419
     * club : {"id":"54b790c817c2cc03d7c43ba6","name":"看电影"}
     * favorite_id : 0
     * like_id : 0
     * status_str : normal
     * dynamic_info2 : 0
     */

    private int id;
    private String content;
    private String category;
    private User sender;
    private int status;
    private int comment_count;
    private int visit_count;
    private int active_time;
    private int add_datetime_ts;
    private Club club;
    private int favorite_id;
    private int like_id;
    private String status_str;
    private String dynamic_info2;
    private List<Photo> photos;
    private List<Tags> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getVisit_count() {
        return visit_count;
    }

    public void setVisit_count(int visit_count) {
        this.visit_count = visit_count;
    }

    public int getActive_time() {
        return active_time;
    }

    public void setActive_time(int active_time) {
        this.active_time = active_time;
    }

    public int getAdd_datetime_ts() {
        return add_datetime_ts;
    }

    public void setAdd_datetime_ts(int add_datetime_ts) {
        this.add_datetime_ts = add_datetime_ts;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public int getLike_id() {
        return like_id;
    }

    public void setLike_id(int like_id) {
        this.like_id = like_id;
    }

    public String getStatus_str() {
        return status_str;
    }

    public void setStatus_str(String status_str) {
        this.status_str = status_str;
    }

    public String getDynamic_info2() {
        return dynamic_info2;
    }

    public void setDynamic_info2(String dynamic_info2) {
        this.dynamic_info2 = dynamic_info2;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

}
