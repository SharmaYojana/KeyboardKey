package nyc.c4q.yojana.keyboardkey;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yojanasharma on 1/12/17.
 */
public class KBAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Key> list;

    public KBAdapter(List<Key> list) {
        this.list = list;
    }

    @Override
    public KeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new KeyViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((KeyViewHolder) holder).bind(list.get(position));
    }




    @Override
    public int getItemCount() {
        return list.size();
    }
}
