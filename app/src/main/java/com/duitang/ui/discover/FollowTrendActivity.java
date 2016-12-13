package com.duitang.ui.discover;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.ImageButton;
import android.widget.TextView;

import com.blankj.utilcode.utils.IntentUtils;
import com.duitang.R;
import com.duitang.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:关注动态
 * description:
 * author: yking
 * created on: 2016/12/13 下午9:41
 */
public class FollowTrendActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.imgbtn_left)
    ImageButton imgBtnLeft;

    @BindView(R.id.imgbtn_right)
    ImageButton imgBtnRight;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_trends);
        ButterKnife.bind(this);
        initView();
    }


    public void initView() {
        tvTitle.setText("关注动态");
    }

    public void rightClick() {
        startActivity(new Intent(this, RecommandDaringActivity.class));
    }


}
