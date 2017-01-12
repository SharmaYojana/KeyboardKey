package nyc.c4q.yojana.keyboardkey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by yojanasharma on 1/11/17.
 */

public class MyFragment extends Fragment {
    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        context = getActivity();
        View view;
        view = inflater.inflate(R.layout.item_view,
                parent, false);
        TextView tv = (TextView) view.findViewById(R.id.name);
        tv.setText("Name");
        return view;


    }

    public void onStart() {
        super.onStart();
        Button button = (Button) context.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}

