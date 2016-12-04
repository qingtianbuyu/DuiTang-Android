package com.duitang.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 上午1:17
 */
public class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(getClass().getName());
        String tag = getClass().getName() + "--->" + new Exception().getStackTrace()[0].getMethodName();
        Log.d("TAG", tag);
        return textView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        String tag = getClass().getName() + "--->" + new Exception().getStackTrace()[0].getMethodName();
        Log.d("TAG", tag);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String tag = getClass().getName() + "--->" + new Exception().getStackTrace()[0].getMethodName();
        Log.d("TAG", tag);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        String tag = getClass().getName() + "--->" + new Exception().getStackTrace()[0].getMethodName();
        Log.d("TAG", tag);
    }

    @Override
    public void onResume() {
        super.onResume();
        String tag = getClass().getName() + "--->" + new Exception().getStackTrace()[0].getMethodName();
        Log.d("TAG", tag);
    }

    @Override
    public void onPause() {
        super.onPause();
        String tag = getClass().getName() + "--->" + new Exception().getStackTrace()[0].getMethodName();
        Log.d("TAG", tag);
    }

    @Override
    public void onStop() {
        super.onStop();
        String tag = getClass().getName() + "--->" + new Exception().getStackTrace()[0].getMethodName();
        Log.d("TAG", tag);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        String tag = getClass().getName() + "--->" + new Exception().getStackTrace()[0].getMethodName();
        Log.d("TAG", tag);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
