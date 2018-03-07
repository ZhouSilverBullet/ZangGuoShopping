package cn.com.zangguo.shopping.category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.zangguo.shopping.R;

/**
 * Created by admin on 2018/3/7.
 */

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<String> list;
    private int selectItem;
    private ScrollListener scrollListener;

    public CategoryRecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.zg_category_fragment_recycler_item, parent, false);
        return new CategoryHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final CategoryHolder holder, final int position) {
        holder.text.setText(list.get(position));
        if (selectItem == position) {
            holder.text.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark));
        } else {
            holder.text.setBackgroundColor(context.getResources().getColor(R.color.ch_color_download_normal_title));
        }
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != selectItem) {
                    selectItem = position;
                    if (scrollListener != null) {
                        scrollListener.scroll(position);
                    }
                    notifyDataSetChanged();
                }
            }
        });
    }

    public interface ScrollListener {
        void scroll(int position);
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.scrollListener = scrollListener;
    }

    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class CategoryHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.zg_category_fragment_recycler_item_text)
        TextView text;

        public CategoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
