package nyc.c4q.yojana.keyboardkey;

import retrofit2.Call;

import retrofit2.http.GET;

/**
 * Created by yojanasharma on 1/11/17.
 */

public interface KeyboardService {
    @GET("classroom/photos/letter_C.jpg/")
   Call<Features> getFeatures();
}
