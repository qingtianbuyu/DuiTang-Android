package com.duitang.entity;

import com.blankj.utilcode.utils.TimeUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午1:48
 */
public class Topic implements Serializable {

    /**
     * target : https://www.duitang.com/guide2/mkt/hws30/?__urlopentype=pageweb&app_version=6.5.0&app_code=gandalf
     * tag : NEW
     * stitle :
     * style :
     * nickname :
     * content_type :
     * image_url : http://img4q.duitang.com/uploads/item/201612/02/20161202173740_FNaS5.jpeg
     * enabled_at : 1480683600
     * enabled_at_str : 2016-12-02 21:00:00
     * disabled_at : 1480899600
     * disabled_at_str : 2016-12-05 09:00:00
     * description : 幸福周末VOL.30
     * tag_title :
     * dynamic_info :
     * dynamic_info2 : 0
     * icon_url :
     * ext_info :
     * content_category :
     */

    private String target;
    private String tag;
    private String stitle;
    private String style;
    private String nickname;
    private String content_type;
    private String image_url;
    private long enabled_at;
    private String enabled_at_str;
    private int disabled_at;
    private String disabled_at_str;
    private String description;
    private String tag_title;
    private String dynamic_info;
    private String dynamic_info2;
    private String icon_url;
    private String ext_info;
    private String content_category;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getEnabled_at_str() {
        Date date = TimeUtils.string2Date(enabled_at_str);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 EEEE");
        return TimeUtils.date2String(date, sdf);
    }

    public void setEnabled_at_str(String enabled_at_str) {
        this.enabled_at_str = enabled_at_str;
    }

    public int getDisabled_at() {
        return disabled_at;
    }

    public void setDisabled_at(int disabled_at) {
        this.disabled_at = disabled_at;
    }

    public String getDisabled_at_str() {
        return disabled_at_str;
    }

    public void setDisabled_at_str(String disabled_at_str) {
        this.disabled_at_str = disabled_at_str;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag_title() {
        return tag_title;
    }

    public void setTag_title(String tag_title) {
        this.tag_title = tag_title;
    }

    public String getDynamic_info() {
        return dynamic_info;
    }

    public void setDynamic_info(String dynamic_info) {
        this.dynamic_info = dynamic_info;
    }

    public String getDynamic_info2() {
        return dynamic_info2;
    }

    public void setDynamic_info2(String dynamic_info2) {
        this.dynamic_info2 = dynamic_info2;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getExt_info() {
        return ext_info;
    }

    public void setExt_info(String ext_info) {
        this.ext_info = ext_info;
    }

    public String getContent_category() {
        return content_category;
    }

    public void setContent_category(String content_category) {
        this.content_category = content_category;
    }

    public String getTargetId() {
        try {
            return target.substring(target.lastIndexOf("=") + 1, target.length());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }



}
