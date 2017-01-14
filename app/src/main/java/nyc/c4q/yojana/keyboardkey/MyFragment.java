package nyc.c4q.yojana.keyboardkey;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yojanasharma on 1/11/17.
 */

public class MyFragment extends Fragment {
    private RecyclerView recyclerView;
    public final static String URL = "http://jsjrobotics.nyc";
    private List<Key> list = new ArrayList<>();
    private KBAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, parent, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new KBAdapter(list);
        recyclerView.setAdapter(adapter);
        setCall(getFeaturesCall());

    }


    private Call<Features> getFeaturesCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        KeyboardService service = retrofit.create(KeyboardService.class);
        return service.getFeatures();
    }

    public void setCall(Call<Features> call) {
        call.enqueue(new Callback<Features>() {
            @Override
            public void onResponse(Call<Features> call, Response<Features> response) {
                list =  response.body().getKeyboardList();
                Log.d("Retrofit Sucess", String.valueOf(list.get(0).getName()));
                Log.d("myTag", "JsonResponse: " + response.body().getKeyboardList().size());
                adapter = new KBAdapter(list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Features> call, Throwable t) {
                Log.d("Retrofit Failure", t.toString());

            }
        });
    }

}

