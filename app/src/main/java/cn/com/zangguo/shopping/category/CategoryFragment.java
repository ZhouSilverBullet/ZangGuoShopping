package cn.com.zangguo.shopping.category;

import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import cn.com.zangguo.shopping.R;
import cn.com.zangguo.shopping.base.BaseLoadingFragment;

/**
 * Created by admin on 2018/3/7.
 */

public class CategoryFragment extends BaseLoadingFragment {
    @BindView(R.id.zg_fragment_category_left_recycler)
    RecyclerView mCategoryRecyclerView;
    @BindView(R.id.zg_fragment_category_right_frame_layout)
    FrameLayout mCategoryFrameLayout;
    Unbinder unbinder;
    private CategoryRecyclerViewAdapter2 adapter;

    @Override
    protected void initChildView() {

    }

    @Override
    protected int getChildViewId() {
        return R.layout.zg_fragment_category;
    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("tab" + i);
        }
        adapter = new CategoryRecyclerViewAdapter2(getActivity(), list);
        mCategoryRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.zg_fragment_category_right_frame_layout, new CategoryItemFragment())
                        .commitAllowingStateLoss();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
