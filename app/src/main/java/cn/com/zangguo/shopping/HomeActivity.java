package cn.com.zangguo.shopping;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.zangguo.shopping.helper.BottomNavigationViewHelper;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class HomeActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @BindView(R.id.de_main_bottom_navigation)
    BottomNavigationView mBottomNavigation;
    @BindView(R.id.de_main_frame_layout)
    FrameLayout mFrameLayout;

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
                    case R.id.de_main_bottom_navigation_news:
                        break;
                    case R.id.de_main_bottom_navigation_guangchang:
                        Log.e(TAG, "onNavigationItemSelected" + item.getItemId());
                        break;

                }
                return true;
            }
        });
        mBottomNavigation.setSelectedItemId(R.id.de_main_bottom_navigation_guangchang);
        Badge badge = new QBadgeView(this).bindTarget(findViewById(R.id.de_main_bottom_navigation_guangchang));
        badge.setBadgeTextSize(12, true);
        badge.setGravityOffset(10, 0,true);
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
}
