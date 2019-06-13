package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarSource {

    @SerializedName("_source")
    @Expose
    private Car car;
    public CarSource(Car car) {
        this.car = car;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
}
