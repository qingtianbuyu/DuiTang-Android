package com.duitang.entity;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/10 上午10:02
 */
public class ContentGroupItem {
    /**
     * icon_url : http://img4q.duitang.com/uploads/people/201610/12/20161012174211_u8HBs.jpeg
     * name : 今日TOP榜
     * target : duitang://www.duitang.com/theme/detail/?theme_id=554c8abaa310def67913c5c0&theme_alias=%E4%BB%8A%E6%97%A5TOP%E6%A6%9C&app_layout=BLOG_THEME
     */

    private String icon_url;
    private String name;
    private String target;

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
