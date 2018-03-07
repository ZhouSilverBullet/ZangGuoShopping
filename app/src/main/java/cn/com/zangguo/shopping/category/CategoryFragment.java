package cn.com.zangguo.shopping.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.zangguo.shopping.R;

/**
 * Created by admin on 2018/3/7.
 */

public class CategoryFragment extends Fragment {
    @BindView(R.id.zg_fragment_category_left_recycler)
    RecyclerView mCategoryRecyclerView;
    @BindView(R.id.zg_fragment_category_right_frame_layout)
    FrameLayout mCategoryFrameLayout;
    Unbinder unbinder;
    private CategoryRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zg_fragment_category, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("tab" + i);
        }
        adapter = new CategoryRecyclerViewAdapter(getActivity(), list);
        mCategoryRecyclerView.setAdapter(adapter);
        adapter.setScrollListener(new CategoryRecyclerViewAdapter.ScrollListener() {
            @Override
            public void scroll(int position) {
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
