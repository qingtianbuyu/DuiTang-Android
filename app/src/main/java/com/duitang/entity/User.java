package com.duitang.entity;

import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/5 下午8:33
 */
public class User {

    /**
     * id : 3326121
     * username : sherry4-7
     * avatar : https://a-ssl.duitang.com/uploads/people/201610/25/20161025194353_iB4FJ.jpeg
     * identity : ["personal_certify"]
     * score : 37163
     * gender : 0
     * birthday : 0
     * city : 浙江 杭州
     * status : 0
     * staff : false
     * actived : true
     * relationship : 0
     * target : duitang://www.duitang.com/people/3326121/
     * is_certify_user : false
     * album_count : 7
     * article_count : 0
     * album_like_count : 9
     * be_follow_count : 49243
     * follow_count : 13
     * forward_count : 46
     * mblog_count : 1037
     * blog_count : 991
     * new_inbox_msg_count : 0
     * new_system_msg_count : 0
     * short_description : 完美主义的小神经！！！WECHAT:SHERRY0947
     * identity_info : 堆糖认证美食达人
     * city_code : 330100
     * email_checked : false
     * date_joined : 1406216531
     * last_active_date : 1420349917
     * good_at : ["美食"]
     */

    private int id;
    private String username;
    private String avatar;
    private int score;
    private int gender;
    private int birthday;
    private String city;
    private int status;
    private boolean staff;
    private boolean actived;
    private int relationship;
    private String target;
    private boolean is_certify_user;
    private int album_count;
    private int article_count;
    private int album_like_count;
    private int be_follow_count;
    private int follow_count;
    private int forward_count;
    private int mblog_count;
    private int blog_count;
    private int new_inbox_msg_count;
    private int new_system_msg_count;
    private String short_description;
    private String identity_info;
    private String city_code;
    private boolean email_checked;
    private int date_joined;
    private int last_active_date;
    private List<String> identity;
    private List<String> good_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public int getRelationship() {
        return relationship;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean isIs_certify_user() {
        return is_certify_user;
    }

    public void setIs_certify_user(boolean is_certify_user) {
        this.is_certify_user = is_certify_user;
    }

    public int getAlbum_count() {
        return album_count;
    }

    public void setAlbum_count(int album_count) {
        this.album_count = album_count;
    }

    public int getArticle_count() {
        return article_count;
    }

    public void setArticle_count(int article_count) {
        this.article_count = article_count;
    }

    public int getAlbum_like_count() {
        return album_like_count;
    }

    public void setAlbum_like_count(int album_like_count) {
        this.album_like_count = album_like_count;
    }

    public int getBe_follow_count() {
        return be_follow_count;
    }

    public void setBe_follow_count(int be_follow_count) {
        this.be_follow_count = be_follow_count;
    }

    public int getFollow_count() {
        return follow_count;
    }

    public void setFollow_count(int follow_count) {
        this.follow_count = follow_count;
    }

    public int getForward_count() {
        return forward_count;
    }

    public void setForward_count(int forward_count) {
        this.forward_count = forward_count;
    }

    public int getMblog_count() {
        return mblog_count;
    }

    public void setMblog_count(int mblog_count) {
        this.mblog_count = mblog_count;
    }

    public int getBlog_count() {
        return blog_count;
    }

    public void setBlog_count(int blog_count) {
        this.blog_count = blog_count;
    }

    public int getNew_inbox_msg_count() {
        return new_inbox_msg_count;
    }

    public void setNew_inbox_msg_count(int new_inbox_msg_count) {
        this.new_inbox_msg_count = new_inbox_msg_count;
    }

    public int getNew_system_msg_count() {
        return new_system_msg_count;
    }

    public void setNew_system_msg_count(int new_system_msg_count) {
        this.new_system_msg_count = new_system_msg_count;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getIdentity_info() {
        return identity_info;
    }

    public void setIdentity_info(String identity_info) {
        this.identity_info = identity_info;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public boolean isEmail_checked() {
        return email_checked;
    }

    public void setEmail_checked(boolean email_checked) {
        this.email_checked = email_checked;
    }

    public int getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(int date_joined) {
        this.date_joined = date_joined;
    }

    public int getLast_active_date() {
        return last_active_date;
    }

    public void setLast_active_date(int last_active_date) {
        this.last_active_date = last_active_date;
    }

    public List<String> getIdentity() {
        return identity;
    }

    public void setIdentity(List<String> identity) {
        this.identity = identity;
    }

    public List<String> getGood_at() {
        return good_at;
    }

    public void setGood_at(List<String> good_at) {
        this.good_at = good_at;
    }
}
