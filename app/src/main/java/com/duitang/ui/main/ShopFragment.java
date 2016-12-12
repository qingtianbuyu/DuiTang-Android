package com.duitang.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.BaseFragment;
import com.duitang.entity.AlbumData;
import com.duitang.entity.Topic;
import com.duitang.http.HomeHttp;
import com.duitang.util.RetrofitUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description: 数据接口SSL加密无法获取
 * author: yking
 * created on: 2016/12/4 上午10:04
 */
public class ShopFragment extends BaseFragment {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgbtn_left)
    ImageButton imgbtnLeft;
    @BindView(R.id.imgbtn_right)
    ImageButton imgbtnRight;
    @BindView(R.id.wb)
    WebView wb;

    public static ShopFragment newInstance() {
        Bundle args = new Bundle();
        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_shop, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
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
        wb.loadUrl("http://m.duitang.com/");
    }


}
