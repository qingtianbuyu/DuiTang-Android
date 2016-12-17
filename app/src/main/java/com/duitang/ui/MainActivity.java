package com.duitang.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.duitang.R;
import com.duitang.base.BaseActivity;
import com.duitang.base.BaseFragment;
import com.duitang.entity.LoginResultEntity;
import com.duitang.entity.TabEntity;
import com.duitang.http.AccountHttp;
import com.duitang.ui.main.DiscoverFragment;
import com.duitang.ui.main.HomeFragment;
import com.duitang.ui.main.MeFragment;
import com.duitang.ui.main.ShopFragment;
import com.duitang.util.RetrofitUtil;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.tl_2)
    CommonTabLayout mTabLayout_3;

    private ArrayList<Fragment> mFragments2 = new ArrayList<>();
    private String[] mTitles = {"首页", "发现", "商店", "我"};
    private int[] mIconUnselectIds = {
            R.mipmap.tabbar_home, R.mipmap.tabbar_discover,
            R.mipmap.tabbar_shop, R.mipmap.tabbar_me};
    private int[] mIconSelectIds = {
            R.mipmap.tabbar_home_h, R.mipmap.tabbar_discover_h,
            R.mipmap.tabbar_shop_h, R.mipmap.tabbar_me_h};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        login();
    }

    public void initView() {
        mFragments2.add(HomeFragment.newInstance());
        mFragments2.add(DiscoverFragment.newInstance());
        mFragments2.add(ShopFragment.newInstance());
        mFragments2.add(MeFragment.newInstance());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mTabLayout_3.setTabData(mTabEntities, this, R.id.fl_container, mFragments2);
        mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }


    private void login() {
        AccountHttp.loginByAuthInfo(new RetrofitUtil.RequestCallBack<LoginResultEntity>() {
            @Override
            public void success(LoginResultEntity data) {

            }

            @Override
            public void failure(String failure) {

            }
        });
    }

}
