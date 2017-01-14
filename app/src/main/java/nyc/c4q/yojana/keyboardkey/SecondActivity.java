package nyc.c4q.yojana.keyboardkey;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by yojanasharma on 1/11/17.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String imageURL = getIntent().getStringExtra("keyUrl");
        ImageView imageView = (ImageView) findViewById(R.id.key_image_view);
        Picasso.with(getApplicationContext()).load(MyFragment.URL + imageURL).into(imageView);
    }
}
