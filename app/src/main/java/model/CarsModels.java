package model;

import android.widget.ArrayAdapter;

public class CarsModels {

    private ArrayAdapter<String> modelsList;
    
    public ArrayAdapter<String> getModelsList() {
        return modelsList;
    }

    public void setModelsList(ArrayAdapter<String> modelsList) {
        this.modelsList = modelsList;
    }



    public void getMarks(String brand, ArrayAdapter<String> modelsList){

        this.modelsList = modelsList;
        modelsList.clear();
        modelsList.add("Wszystkie modele");
        if(brand.equals("Audi")){
            modelsList.add("A1");
            modelsList.add("A2");
            modelsList.add("A3");
            modelsList.add("A4");
            modelsList.add("A5");
            modelsList.add("A6");
            modelsList.add("A7");
            modelsList.add("A8");
            modelsList.add("Q2");
            modelsList.add("Q3");
            modelsList.add("Q5");
            modelsList.add("Q7");
            modelsList.add("RS3");
            modelsList.add("RS5");
            modelsList.add("RS6");
            modelsList.add("RS7");
            modelsList.add("S1");
            modelsList.add("S2");
            modelsList.add("S3");
            modelsList.add("S4");
            modelsList.add("S5");
            modelsList.add("S6");
            modelsList.add("S7");
            modelsList.add("S8");
            modelsList.add("TT");
            modelsList.add("TT RS");
            modelsList.add("TT S");
        } else if(brand.equals("BMW")){
            modelsList.add("3");
            modelsList.add("525");
            modelsList.add("7");
            modelsList.add("M5");
        } else if (brand.equals("Chevrolet")){
            modelsList.add("1500");
            modelsList.add("3000");
            modelsList.add("Alero");
            modelsList.add("Apache");
            modelsList.add("Długa testowa nazwa dla auta");
        }else{
            modelsList.add("Testowy model");
        }
    }





}
