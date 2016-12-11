package com.duitang.base;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午7:27
 */
public class AppConst {
    public interface TopicConst {
        int FirstType = 0;
        String Large = "large";
        int LargeType = 1;
        String Small = "small";
        int SmallType = 2;
    }

    public interface AlbumConst {
        String includeFieleds = "id,text,desc,user,like_count,like_id,count,covers,managers,members,member_count,category,share_links_3";
    }

    public interface AlbumDetailAdapterConst {
        int ItemTypeHeader = 0;
        int ItemTypeContent = 1;
    }
}
