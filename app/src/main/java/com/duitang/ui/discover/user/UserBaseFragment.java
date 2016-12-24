package com.duitang.ui.discover.user;

import com.duitang.base.BaseListFragment;
import com.duitang.entity.Trend;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/24 下午4:07
 */
public class UserBaseFragment extends BaseListFragment {
    protected Trend trend;

    public void setTrend(Trend trend) {
        this.trend = trend;
    }

}
