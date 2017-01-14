package nyc.c4q.yojana.keyboardkey;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yojanasharma on 1/12/17.
 */
public class KeyViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTextview;

    public KeyViewHolder(ViewGroup parent) {
        super(inflate(parent));
        nameTextview = (TextView) itemView.findViewById(R.id.name);
    }

    private static View inflate(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
    }

    public void bind(final Key key) {
        nameTextview.setText(key.getName());
        nameTextview.setTextColor(Color.parseColor(key.getTextColor()));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("keyUrl", key.getUrl());
                itemView.getContext().startActivity(intent);
            }
        });

    }
}
//how to pass the information for intent