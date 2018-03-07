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
    @BindView(R.id.zg_base_fragment_container)
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
        unbinder = ButterKnife.bind(this, view);
        mContainer.addView(getChildView(), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return view;
    }

    protected abstract View getChildView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
