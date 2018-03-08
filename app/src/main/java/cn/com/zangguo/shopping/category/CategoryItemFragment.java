package cn.com.zangguo.shopping.category;

import android.support.v7.widget.StaggeredGridLayoutManager;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import butterknife.BindView;
import cn.com.zangguo.shopping.R;
import cn.com.zangguo.shopping.base.BaseLoadingFragment;
import cn.com.zangguo.shopping.base.BaseModel;
import cn.com.zangguo.shopping.base.BaseView;
import cn.com.zangguo.shopping.category.entry.CategoryEntry;
import cn.com.zangguo.shopping.http.DataParseUtil;
import cn.com.zangguo.shopping.utils.CloseUtils;

/**
 * Created by admin on 2018/3/8.
 */

public class CategoryItemFragment extends BaseLoadingFragment {

    @BindView(R.id.zg_fragment_category_item_recycler)
    EasyRecyclerView mRecyclerView;

    @Override
    protected void initChildView() {
        InputStream open = null;
        StringBuilder builder = new StringBuilder();
        try {
            open = mActivity.getAssets().open("category.json");
            byte[] bs = new byte[1024 * 4];
            int len = -1;
            while ((len = open.read(bs)) != -1) {
                builder.append(new String(bs, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeIO(open);
        }

        Logger.json(builder.toString());
        BaseModel baseModel = DataParseUtil.parseObject(builder.toString(), BaseModel.class);
        Object data = baseModel.data;
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setEmptyView(R.layout.zg_base_fragment_empty_view);
        mRecyclerView.setProgressView(R.layout.layout_load_progress);
        mRecyclerView.setAdapter(new CategoryItemRecyclerAdapter(mActivity, new ArrayList<CategoryEntry>()));
    }

    @Override
    protected int getChildViewId() {
        return 0;
    }

    @Override
    protected void initData() {

    }


}
