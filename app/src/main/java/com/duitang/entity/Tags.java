package com.duitang.entity;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/5 下午8:31
 */
public class Tags {
    /**
     * id : 6005980
     * name : 人物
     * target :
     * type : 1
     * tag_id : 12779
     */

    private int id;
    private String name;
    private String target;
    private int type;
    private int tag_id;

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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }
}
