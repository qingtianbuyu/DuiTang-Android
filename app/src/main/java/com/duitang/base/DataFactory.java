package com.duitang.base;

import com.duitang.R;
import com.duitang.entity.RecyclerMenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/10 下午4:33
 */
public class DataFactory {

    public static List<RecyclerMenuItem> getMeMenu() {
        List<RecyclerMenuItem> menuItems = new ArrayList<>();
        RecyclerMenuItem menuItem = new RecyclerMenuItem(R.mipmap.ic_launcher, "YKing3000", RecyclerMenuItem.KEY_TYPE_ICON);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_order, "我的订单", RecyclerMenuItem.KEY_TYPE_ORDER);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem();
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_coupon, "我的礼券", RecyclerMenuItem.KEY_TYPE_NORMAL);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_luckybag, "我的福袋", RecyclerMenuItem.KEY_TYPE_NORMAL);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem();
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_album, "我的专辑", RecyclerMenuItem.KEY_TYPE_NORMAL);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_article, "我的文章", RecyclerMenuItem.KEY_TYPE_NORMAL);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_collect, "我的收藏", RecyclerMenuItem.KEY_TYPE_NORMAL);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_subscribe, "我的订阅", RecyclerMenuItem.KEY_TYPE_NORMAL);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem();
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_comments, "评论", RecyclerMenuItem.KEY_TYPE_NORMAL);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_notification, "收藏/赞", RecyclerMenuItem.KEY_TYPE_NORMAL);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_message, "聊天", RecyclerMenuItem.KEY_TYPE_NORMAL);
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem();
        menuItems.add(menuItem);
        menuItem = new RecyclerMenuItem(R.mipmap.me_icon_follow, "添加好友", RecyclerMenuItem.KEY_TYPE_NORMAL);
        menuItems.add(menuItem);
        return menuItems;
    }
}
