package nyc.c4q.yojana.keyboardkey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yojanasharma on 1/11/17.
 */

public class Features {
    private boolean success;

    @SerializedName("available keys") private List<Key> availableKeys;


    public List <Key> getKeyboardList(){
        return availableKeys;
    }

}
