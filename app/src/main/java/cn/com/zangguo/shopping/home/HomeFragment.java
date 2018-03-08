package cn.com.zangguo.shopping.home;

import android.widget.TextView;

import butterknife.BindView;
import cn.com.zangguo.shopping.R;
import cn.com.zangguo.shopping.base.BaseLoadingFragment;

/**
 * Created by admin on 2018/3/7.
 */

public class HomeFragment extends BaseLoadingFragment {
    @BindView(R.id.zg_fragment_home_text)
    TextView homeText;

    @Override
    protected void initChildView() {
        homeText.setText("这时bindView的");
    }

    @Override
    protected int getChildViewId() {
        return R.layout.zg_fragment_home;
    }

    @Override
    protected void initData() {

    }
}
