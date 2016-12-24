package com.duitang.ui.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.utils.BarUtils;
import com.blankj.utilcode.utils.ScreenUtils;
import com.duitang.R;
import com.duitang.base.AppConst;
import com.duitang.base.BaseActivity;
import com.duitang.entity.Trend;
import com.duitang.entity.User;
import com.duitang.http.AccountHttp;
import com.duitang.ui.discover.user.UserAlbumFragment;
import com.duitang.ui.discover.user.UserArticleFragment;
import com.duitang.ui.discover.user.UserBaseFragment;
import com.duitang.ui.discover.user.UserFavoriteFragment;
import com.duitang.ui.discover.user.UserTrendFragment;
import com.duitang.util.ImageLoaderHelper;
import com.duitang.util.RetrofitUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.htab_header)
    ImageView htabHeader;
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_identity_info)
    TextView tvIdentityInfo;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.tv_short_description)
    TextView tvShortDescription;

    Trend trend;
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BarUtils.setTranslucentForCoordinatorLayout(this, 1);
        setContentView(R.layout.activity_userinfo);
        ButterKnife.bind(this);
        initData();
    }

    public void initData() {
        trend = (Trend) getIntent().getSerializableExtra(AppConst.BlogDetailActivityConst.KEY_TREND);
        //加载个人信息
        loadPeopleProfile();

        final Toolbar toolbar = (Toolbar) findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(trend.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.htab_viewpager);
        setupViewPager(viewPager);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.htab_tabs);
        tabLayout.setupWithViewPager(viewPager);

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.htab_collapse_toolbar);
        collapsingToolbarLayout.setTitleEnabled(false);

//        ImageView header = (ImageView) findViewById(R.id.header);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
//                R.drawable.header);
//
//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//            @SuppressWarnings("ResourceType")
//            @Override
//            public void onGenerated(Palette palette) {
//
//                int vibrantColor = palette.getVibrantColor(R.color.primary_500);
//                int vibrantDarkColor = palette.getDarkVibrantColor(R.color.primary_700);
//                collapsingToolbarLayout.setContentScrimColor(vibrantColor);
//                collapsingToolbarLayout.setStatusBarScrimColor(vibrantDarkColor);
//            }
//        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void loadPeopleProfile() {
        AccountHttp.loadPeopleProfile(trend.getPublisher().getId(), new RetrofitUtil.RequestCallBack<User>() {
            @Override
            public void success(User data) {
                user = data;
                setupUserInfo();
            }

            @Override
            public void failure(String failure) {

            }
        });
    }

    public void setupUserInfo() {
        if (user == null) return;
        ImageLoaderHelper.loadImageViewWithCircle(user.getAvatar(), ivAvatar);
        ImageLoaderHelper.loadImageView(user.getBackground_img_url(), htabHeader);
        tvIdentityInfo.setText(user.getIdentity_info());
        tvScore.setText(user.getScore() + "");
        tvShortDescription.setText(user.getShort_description());
        tvUsername.setText(user.getUsername());
    }

    private void setupViewPager(ViewPager viewPager) {
        viewPager.setOffscreenPageLimit(3);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        setupViewPagerAdapter(adapter, UserTrendFragment.newInstance(), "动态", trend);
        setupViewPagerAdapter(adapter, UserAlbumFragment.newInstance(), "专辑", trend);
        setupViewPagerAdapter(adapter, UserArticleFragment.newInstance(), "文章", trend);
        setupViewPagerAdapter(adapter, UserFavoriteFragment.newInstance(), "收藏", trend);
        viewPager.setAdapter(adapter);
    }

    public void setupViewPagerAdapter(ViewPagerAdapter adapter, UserBaseFragment userBaseFragment, String title, Trend trend) {
        userBaseFragment.setTrend(trend);
        adapter.addFrag(userBaseFragment, title);
    }


}
