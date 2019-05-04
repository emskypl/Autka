package model;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@IgnoreExtraProperties
public class HitsList {

    @SerializedName("hits")
    @Expose
    private List<CarSource> carIndex;

    public List<CarSource> getCarIndex() {
        return carIndex;
    }

    public void setCarIndex(List<CarSource> carIndex) {
        this.carIndex = carIndex;
    }
}
