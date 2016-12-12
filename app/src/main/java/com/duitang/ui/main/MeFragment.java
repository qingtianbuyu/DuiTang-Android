package com.duitang.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.BaseFragment;
import com.duitang.base.DataFactory;
import com.duitang.entity.RecyclerMenuItem;
import com.duitang.view.menu.MenuStyleAdapter;
import com.duitang.view.refresh.ListViewDecoration;
import com.duitang.view.refresh.OnRecyclerItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 上午10:04
 */
public class MeFragment extends BaseFragment {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgbtn_left)
    ImageButton imgbtnLeft;
    @BindView(R.id.imgbtn_right)
    ImageButton imgbtnRight;
    @BindView(R.id.recycler)
    RecyclerView recycler;

    public static MeFragment newInstance() {
        Bundle args = new Bundle();
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_me, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initView();
        setupRecyclerView();
    }

    public void initView() {
        imgbtnLeft.setVisibility(View.GONE);
        imgbtnRight.setImageResource(R.mipmap.nav_icon_set);
        tvTitle.setText("我");
    }

    public void setupRecyclerView() {
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.addItemDecoration(new ListViewDecoration(getContext()));
        final List<RecyclerMenuItem> meMenu = DataFactory.getMeMenu();
        MenuStyleAdapter adapter = new MenuStyleAdapter(meMenu);
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new MenuStyleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                RecyclerMenuItem menuItem = meMenu.get(position);
                if (menuItem.type == RecyclerMenuItem.KEY_TYPE_NORMAL && menuItem.action != null) {
                    startActivity(new Intent(getContext(), menuItem.action));
                }
            }
        });
    }
}
