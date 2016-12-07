package com.duitang.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.BaseActivity;
import com.duitang.entity.AlbumData;
import com.duitang.entity.Topic;
import com.duitang.http.HomeHttp;
import com.duitang.util.RetrofitUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/7 下午9:06
 */
public class ArticleDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgbtn_right)
    ImageButton imgbtnRight;
    @BindView(R.id.wb_article)
    WebView wbArticle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    public void initView() {
        tvTitle.setText("文章详情");
        imgbtnRight.setImageResource(R.mipmap.nav_more);
        WebSettings settings = wbArticle.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setSupportZoom(true);
        settings.setBlockNetworkImage(false);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
    }

    public void initData() {
        Topic topic = (Topic) getIntent().getSerializableExtra("topic");
        String target = topic.getTarget();
        int beginIndex = target.lastIndexOf("=");
        String topicId = target.substring(beginIndex + 1, target.length());
        HomeHttp.loadArticle(topicId, new RetrofitUtil.RequestCallBack<AlbumData>() {
            @Override
            public void success(AlbumData data) {
                wbArticle.loadUrl(data.getUrl());
            }

            @Override
            public void failure(String failure) {

            }
        });
    }
}
