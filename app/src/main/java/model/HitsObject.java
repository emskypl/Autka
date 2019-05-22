package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HitsObject {

    @SerializedName("hits")
    @Expose

    private HitsList hitsList;

    public HitsList getHitsList() {
        return hitsList;
    }

    public void setHitsList(HitsList hitsList) {
        this.hitsList = hitsList;
    }
}
