package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class CarJSONModel {

    @SerializedName("brand")
    @Expose
    String brand;
    @SerializedName("model")
    @Expose
    String model;
    @SerializedName("year")
    @Expose
    Integer year;
    @SerializedName("hp")
    @Expose
    Double hp;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Double getHp() {
        return hp;
    }

    public CarJSONModel(){}
    public CarJSONModel(String brand, String model, Integer year, Double hp) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.hp = hp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarJSONModel that = (CarJSONModel) o;
        return Objects.equals(brand, that.brand) &&
                Objects.equals(model, that.model) &&
                Objects.equals(year, that.year) &&
                Objects.equals(hp, that.hp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, hp);
    }
}
