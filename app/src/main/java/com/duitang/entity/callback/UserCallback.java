package com.duitang.entity.callback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.duitang.entity.User;

import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/15 下午10:21
 */
public class UserCallback extends DiffUtil.Callback {
    private static final String KEY_RELATIONSHIP = "RELATIONSHIP";

    private List<User> oldList;
    private List<User> newList;

    public UserCallback(List<User> oldList, List<User> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return (oldList == null) ? 0 : oldList.size();
    }

    @Override
    public int getNewListSize() {
        return (newList == null) ? 0 : newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        User oldData = oldList.get(oldItemPosition);
        User newUserData = newList.get(newItemPosition);
        return oldData.getRelationship() == newUserData.getRelationship();
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        User oldData = oldList.get(oldItemPosition);
        User newUserData = newList.get(newItemPosition);
        Bundle diffBundle = new Bundle();
        if (oldData.getRelationship() != newUserData.getRelationship()) {
            diffBundle.putInt(KEY_RELATIONSHIP, newUserData.getRelationship());
        }
        if (diffBundle.size() == 0) {
            return null;
        }
        return diffBundle;
    }
}
