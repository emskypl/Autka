package model;


import java.util.ArrayList;

public class Brands {
    private ArrayList<String> brandsList;

    public ArrayList<String> getBrandsList() {
        return brandsList;
    }

    public void setBrandsList(ArrayList<String> brandsList) {
        this.brandsList = brandsList;
    }

    public void brandsToArray(ArrayList<String> brandsList){

        this.brandsList = brandsList;
        brandsList.add("Audi");
        brandsList.add("BMW");
        brandsList.add("Chevrolet");
        brandsList.add("Ferrari");
        brandsList.add("Ford");
        brandsList.add("Honda");
        brandsList.add("Hyundai");
        brandsList.add("Lexus");
        brandsList.add("Mazda");
        brandsList.add("Mercedes-Benz");
        brandsList.add("Nissan");
        brandsList.add("Opel");
        brandsList.add("Porsche");
        brandsList.add("Renault");
        brandsList.add("Seat");
        brandsList.add("Skoda");
        brandsList.add("Toyota");
        brandsList.add("Volkswagen");
        brandsList.add("Inny");
    }


}
