package nyc.c4q.yojana.keyboardkey;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    final static String URL = "http://jsjrobotics.nyc/classroom/photos/letter_C.jpg/";
    List<Features> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new MyFragment());
        fragmentTransaction.commit();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        KeyboardService service = retrofit.create(KeyboardService.class);
        Call<Features> call = service.getFeatures();
    }

    public void setCall(Call<Features> call) {
        call.enqueue(new Callback<Features>() {
            @Override
            public void onResponse(Call<Features> call, Response<Features> response) {
                list = (List<Features>) response.body();
                Log.d("Retrofit Sucess", String.valueOf(list.get(0).getKeyboardList()));
            }

            @Override
            public void onFailure(Call<Features> call, Throwable t) {
                Log.d("Retrofit Failute", t.toString());

            }
        });
    }
}

