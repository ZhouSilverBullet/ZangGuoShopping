package cn.com.zangguo.shopping.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.zangguo.shopping.R;

/**
 * Created by admin on 2018/3/7.
 */

public class CategoryRecyclerViewAdapter2 extends RecyclerArrayAdapter<String> {

    private LayoutInflater inflater;
    private int selectItem;

    public CategoryRecyclerViewAdapter2(Context context, List<String> objects) {
        super(context, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, final int position) {
        super.OnBindViewHolder(holder, position);
        ((CategoryHolder) holder).text
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (position != selectItem) {
                            selectItem = position;

                            notifyDataSetChanged();
                        }
                    }
                });
        if (selectItem == position) {
            ((CategoryHolder) holder).text.setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimaryDark));
        } else {
            ((CategoryHolder) holder).text.setBackgroundColor(getContext().getResources().getColor(R.color.ch_color_download_normal_title));
        }
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.zg_category_fragment_recycler_item, parent, false);
        return new CategoryHolder(inflate);
    }

    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    class CategoryHolder extends BaseViewHolder<String> {
        @BindView(R.id.zg_category_fragment_recycler_item_text)
        TextView text;

        public CategoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(String data) {
            text.setText(data);
        }
    }
}
