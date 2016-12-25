package com.duitang.ui.discover;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.duitang.R;
import com.duitang.base.BaseActivity;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/25 下午12:47
 */
public class ClubActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_container, ClubFragment.newInstance(), ClubFragment.class.getSimpleName())
                .commit();
    }
}
