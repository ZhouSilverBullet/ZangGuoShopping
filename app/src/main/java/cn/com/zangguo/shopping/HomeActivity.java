package cn.com.zangguo.shopping;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.zangguo.shopping.base.BaseActivity;
import cn.com.zangguo.shopping.category.CategoryFragment;
import cn.com.zangguo.shopping.helper.BottomNavigationViewHelper;
import cn.com.zangguo.shopping.home.HomeFragment;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class HomeActivity extends BaseActivity {

    public static final String TAG = "HomeActivity";

    @BindView(R.id.zg_home_bottom_navigation)
    BottomNavigationView mBottomNavigation;
    @BindView(R.id.zg_home_frame_layout)
    FrameLayout mFrameLayout;

    private Fragment mTempFragment;
    private CategoryFragment categoryFragment;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigation);
        mBottomNavigation.setItemIconTintList(null);
        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.de_main_bottom_navigation_home:
                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                        }
                        replace(homeFragment);
                        break;
                    case R.id.de_main_bottom_navigation_category:
                        Log.e(TAG, "onNavigationItemSelected" + item.getItemId());
                        if (categoryFragment == null) {
                            categoryFragment = new CategoryFragment();
                        }
                        replace(categoryFragment);
                        break;

                }
                return true;
            }
        });
        mBottomNavigation.setSelectedItemId(R.id.de_main_bottom_navigation_home);
        Badge badge = new QBadgeView(this).bindTarget(findViewById(R.id.de_main_bottom_navigation_category));
        badge.setBadgeTextSize(12, true);
        badge.setGravityOffset(10, 0, true);
        badge.setBadgeNumber(999);
        badge.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                if (dragState == STATE_SUCCEED) {
                    Toast.makeText(HomeActivity.this, "删除成功！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void replace(Fragment fragment) {
        if (fragment == null) {
            Log.e(TAG, "fragment 为空！");
            return;
        }

        String name = fragment.getClass().getName();
        if (mTempFragment != null && mTempFragment.getClass().getName().equals(name)) {
            Log.e(TAG, "value 和 mTempValue的值相同！");
            return;
        }
        Log.e(TAG, "fragment:" + fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment.isAdded()) {
            transaction.show(fragment).hide(mTempFragment).commitAllowingStateLoss();
        } else {
            if (mTempFragment == null) { //temp为空就是第一次
                transaction.add(R.id.zg_home_frame_layout, fragment, name).commitAllowingStateLoss();
            } else {
                transaction.add(R.id.zg_home_frame_layout, fragment, name).hide(mTempFragment).commitAllowingStateLoss();
            }
        }
        mTempFragment = fragment;
    }
}
