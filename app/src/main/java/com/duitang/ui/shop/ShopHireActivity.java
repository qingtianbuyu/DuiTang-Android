package com.duitang.ui.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yking on 2017/7/23.
 */

public class ShopHireActivity extends BaseActivity{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgbtn_left)
    ImageButton imgbtnLeft;
    @BindView(R.id.imgbtn_right)
    ImageButton imgbtnRight;
    @BindView(R.id.wb)
    WebView wb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_hire);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        tvTitle.setText("堆糖商店");
        imgbtnRight.setImageResource(R.mipmap.nav_cart);
        imgbtnLeft.setImageResource(R.mipmap.nav_diamond);
        WebSettings settings = wb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setSupportZoom(true);
        settings.setBlockNetworkImage(false);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        wb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }
        });
        wb.loadUrl("https://m.duitang.com/");
    }


}
