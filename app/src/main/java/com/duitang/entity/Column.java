package com.duitang.entity;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/25 下午1:22
 */
public class Column {
    /**
     * id : 582ee155e4b09b4a77c2fa65
     * name : 堆糖实验室
     * target : http://www.duitang.com/guide2/column/582ee155e4b09b4a77c2fa65/?__urlopentype=pageweb
     * image : http://img4q.duitang.com/uploads/item/201611/18/20161118190859_SL2Vr.jpeg
     * color : #70CF95
     * sub_count : 2
     */

    private String id;
    private String name;
    private String target;
    private String image;
    private String color;
    private int sub_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSub_count() {
        return sub_count;
    }

    public void setSub_count(int sub_count) {
        this.sub_count = sub_count;
    }
}
