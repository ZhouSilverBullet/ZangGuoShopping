package cn.com.zangguo.shopping.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.zangguo.shopping.R;
import cn.com.zangguo.shopping.widget.EmptyView;
import cn.com.zangguo.shopping.widget.LoadingView;

/**
 * Created by zhousaito on 2018/3/7.
 */

public abstract class BaseLoadingFragment extends BaseFragment {

    FrameLayout mContainer;
    @BindView(R.id.zg_base_fragment_empty_loading_view)
    LoadingView mLoadingView;
    @BindView(R.id.zg_base_fragment_empty_empty_view)
    EmptyView mEmptyView;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ConstraintLayout view = (ConstraintLayout) inflater.inflate(R.layout.zg_base_fragment_empty_view, container, false);
        mContainer = view.findViewById(R.id.zg_base_fragment_container);
        mContainer.addView(LayoutInflater.from(mActivity).inflate(getChildViewId(), mContainer, false), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        unbinder = ButterKnife.bind(this, view);
        initChildView();
        initData();
        return view;
    }

    protected abstract void initChildView();

    protected abstract int getChildViewId();

    protected abstract void initData();

    public void showEmptyView(boolean isShow) {
        if (mEmptyView == null) {
            return;
        }
        mEmptyView.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public void showLoadingView(boolean isShow) {
        if (mLoadingView == null) {
            return;
        }
        mLoadingView.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
