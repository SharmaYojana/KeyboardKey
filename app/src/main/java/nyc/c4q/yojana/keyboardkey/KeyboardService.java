package nyc.c4q.yojana.keyboardkey;

import retrofit2.Call;

import retrofit2.http.GET;

/**
 * Created by yojanasharma on 1/11/17.
 */

public interface KeyboardService {
    @GET("/cgi-bin/1_11_2017_exam.pl")
   Call<Features> getFeatures();
}
