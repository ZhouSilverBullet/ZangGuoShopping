package cn.com.zangguo.shopping.category;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import cn.com.zangguo.shopping.category.entry.CategoryEntry;

/**
 * Created by admin on 2018/3/8.
 */

public class CategoryItemRecyclerAdapter extends RecyclerArrayAdapter<CategoryEntry> {

    public CategoryItemRecyclerAdapter(Context context, List<CategoryEntry> objects) {
        super(context, objects);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(new TextView(parent.getContext()));
    }

    class CategoryItemViewHolder extends BaseViewHolder<CategoryEntry> {

        public CategoryItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
