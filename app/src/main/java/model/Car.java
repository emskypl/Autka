package model;

public class Car {


    private String brand;
    private String model;
    private String engine;
    private String year;
    private Integer hp;
    private Integer mileage;
    private String color;
    private Boolean damaged;
    private Boolean automated;
    private Boolean fuel;
    private String countryFrom;
    private String price;
    private String url;
    private String images;
    private String region;
    private String city;
    private String description;
    private String created_at;

    public Car() {
    }

    public Car(String brand){
        this.brand = brand;
    }
    public Car(String images,String brand, String model, String price, String engine, String year, Integer hp, Integer mileage, String color,
               Boolean damaged, Boolean automated, Boolean fuel, String countryFrom, String url,
               String region, String city, String description, String created_at) {
        this.images = images;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.engine = engine;
        this.year = year;
        this.hp = hp;
        this.mileage = mileage;
        this.color = color;
        this.damaged = damaged;
        this.automated = automated;
        this.fuel = fuel;
        this.countryFrom = countryFrom;
        this.url = url;
        this.region = region;
        this.city = city;
        this.description = description;
        this.created_at = created_at;
    }


    public String getImage_url() { return images; }

    public void setImage_url(String images) { this.images = images; }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getDamaged() {
        return damaged;
    }

    public void setDamaged(Boolean damaged) {
        this.damaged = damaged;
    }

    public Boolean getAutomated() {
        return automated;
    }

    public void setAutomated(Boolean automated) {
        this.automated = automated;
    }

    public Boolean getFuel() {
        return fuel;
    }

    public void setFuel(Boolean fuel) {
        this.fuel = fuel;
    }

    public String getCountry_from() {
        return countryFrom;
    }

    public void setCountry_from(String country_from) {
        this.countryFrom = country_from;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public Integer getMileage() { return mileage; }

    public void setMileage(Integer mileage) { this.mileage = mileage; }

    @Override
    public String toString() {
        return "Car{" +
                "image_url=" + images +'\'' +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price + '\'' +
                ", engine='" + engine + '\'' +
                ", year=" + year +
                ", hp=" + hp +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", damaged=" + damaged +
                ", automated=" + automated +
                ", fuel=" + fuel +
                ", country_from='" + countryFrom + '\'' +
                ", url='" + url + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
