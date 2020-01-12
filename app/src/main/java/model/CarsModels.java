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



    public void getMarks(String brand, ArrayAdapter<String> modelsList) {

        this.modelsList = modelsList;
        modelsList.clear();
        modelsList.add("Wszystkie modele");
        if (brand.equals("Abarth")) {

            modelsList.add("124");
            modelsList.add("500");
            modelsList.add("595");
            modelsList.add("GrandePunto");
            modelsList.add("Inny");

        } else if (brand.equals("Acura")) {

            modelsList.add("Legend");
            modelsList.add("MDX");
            modelsList.add("NSX");
            modelsList.add("Inny");
            modelsList.add("RDX");
            modelsList.add("RL");
            modelsList.add("RSX");
            modelsList.add("TL");
            modelsList.add("TSX");
            modelsList.add("ZDX");


        } else if (brand.equals("Aixam")) {

            modelsList.add("A721");
            modelsList.add("A741");
            modelsList.add("A751");
            modelsList.add("City");
            modelsList.add("Coupe");
            modelsList.add("Crossline");
            modelsList.add("Crossover");
            modelsList.add("Inny");
            modelsList.add("Roadline");
            modelsList.add("ScoutyR");


        } else if (brand.equals("Alfa-romeo")) {

            modelsList.add("145");
            modelsList.add("146");
            modelsList.add("147");
            modelsList.add("155");
            modelsList.add("156");
            modelsList.add("159");
            modelsList.add("164");
            modelsList.add("166");
            modelsList.add("Brera");
            modelsList.add("Crosswagon");
            modelsList.add("Giulia");
            modelsList.add("Giuletta");
            modelsList.add("GT");
            modelsList.add("GTV");
            modelsList.add("Mito");
            modelsList.add("Inny");
            modelsList.add("Spider");
            modelsList.add("Stelvio");


        } else if (brand.equals("Alpine")) {

            modelsList.add("A110");


        } else if (brand.equals("Aro")) {

            modelsList.add("10-4");


        } else if (brand.equals("Asia")) {

            modelsList.add("Rocksta");


        } else if (brand.equals("Aston-martin")) {

            modelsList.add("Bulldog");
            modelsList.add("DB11");
            modelsList.add("DB7");
            modelsList.add("DB9");
            modelsList.add("DBS");
            modelsList.add("Rapide");
            modelsList.add("V12Vantage");
            modelsList.add("V8Vantage");
            modelsList.add("Vanquish");
            modelsList.add("Vantage");
            modelsList.add("Virage");


        } else if (brand.equals("Audi")) {

            modelsList.add("100");
            modelsList.add("200");
            modelsList.add("80");
            modelsList.add("90");
            modelsList.add("A1");
            modelsList.add("A2");
            modelsList.add("A3");
            modelsList.add("A4");
            modelsList.add("A4Allroad");
            modelsList.add("A5");
            modelsList.add("A6");
            modelsList.add("A6Allroad");
            modelsList.add("A7");
            modelsList.add("A8");
            modelsList.add("Cabriolet");
            modelsList.add("Coupe");
            modelsList.add("e-tron");
            modelsList.add("Inny");
            modelsList.add("Q2");
            modelsList.add("Q3");
            modelsList.add("Q5");
            modelsList.add("Q7");
            modelsList.add("Q8");
            modelsList.add("Quattro");
            modelsList.add("R8");
            modelsList.add("RSQ3");
            modelsList.add("RS3");
            modelsList.add("RS4");
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
            modelsList.add("SQ5");
            modelsList.add("SQ7");
            modelsList.add("SQ8");
            modelsList.add("TT");
            modelsList.add("TTRS");
            modelsList.add("TTS");
            modelsList.add("V8");


        } else if (brand.equals("Austin")) {


            modelsList.add("Ambassador");
            modelsList.add("Healey");
            modelsList.add("Inny");

        } else if (brand.equals("Autobianchi")) {

            modelsList.add("Bianchina");


        } else if (brand.equals("Baic")) {

            modelsList.add("SenovaX25");


        } else if (brand.equals("Bentley")) {

            modelsList.add("Bentayga");
            modelsList.add("ContinentalFlyingSpur");
            modelsList.add("ContinentalGT");
            modelsList.add("Mulsanne");
            modelsList.add("Inny");
            modelsList.add("TurboR");


        } else if (brand.equals("Bmw")) {

            modelsList.add("1M");
            modelsList.add("3GT");
            modelsList.add("5GT");
            modelsList.add("6GT");
            modelsList.add("i3");
            modelsList.add("i8");
            modelsList.add("M2");
            modelsList.add("M3");
            modelsList.add("M4");
            modelsList.add("M5");
            modelsList.add("M6");
            modelsList.add("M8");
            modelsList.add("Inny");
            modelsList.add("Seria1");
            modelsList.add("Seria2");
            modelsList.add("Seria3");
            modelsList.add("Seria4");
            modelsList.add("Seria5");
            modelsList.add("Seria6");
            modelsList.add("Seria7");
            modelsList.add("Seria8");
            modelsList.add("X1");
            modelsList.add("X2");
            modelsList.add("X3");
            modelsList.add("X4");
            modelsList.add("X5");
            modelsList.add("X5M");
            modelsList.add("X6");
            modelsList.add("X6M");
            modelsList.add("X7");
            modelsList.add("Z3");
            modelsList.add("Z4");
            modelsList.add("Z4M");


        } else if (brand.equals("Brilliance")) {


            modelsList.add("BS4");

        } else if (brand.equals("Bugatti")) {

            modelsList.add("Inny");


        } else if (brand.equals("Buick")) {

            modelsList.add("Enclave");
            modelsList.add("Lacrosse");
            modelsList.add("Inny");
            modelsList.add("ParkAvenue");
            modelsList.add("Regal");
            modelsList.add("Randezvous");
            modelsList.add("Riviera");
            modelsList.add("Roadmaster");


        } else if (brand.equals("Cadillac")) {

            modelsList.add("ATS");
            modelsList.add("BLS");
            modelsList.add("Brougham");
            modelsList.add("CT6");
            modelsList.add("CTS");
            modelsList.add("Deville");
            modelsList.add("DTS");
            modelsList.add("Eldorado");
            modelsList.add("Escalade");
            modelsList.add("Fleewood");
            modelsList.add("Inny");
            modelsList.add("Seville");
            modelsList.add("SRX");
            modelsList.add("STS");
            modelsList.add("XT5");
            modelsList.add("XTS");


        } else if (brand.equals("Casalini")) {


            modelsList.add("Sulky");

        } else if (brand.equals("Caterham")) {


            modelsList.add("SuperSeven");


        } else if (brand.equals("Chatenet")) {

            modelsList.add("CH32");
            modelsList.add("Inny");

        } else if (brand.equals("Chevrolet")) {

            modelsList.add("1500");
            modelsList.add("3500");
            modelsList.add("Apache");
            modelsList.add("Astro");
            modelsList.add("Avalanche");
            modelsList.add("Aveo");
            modelsList.add("Beretta");
            modelsList.add("Blazer");
            modelsList.add("Bolt");
            modelsList.add("C-10");
            modelsList.add("Camaro");
            modelsList.add("Caprice");
            modelsList.add("Captiva");
            modelsList.add("Chevelle");
            modelsList.add("Colorado");
            modelsList.add("Corvette");
            modelsList.add("Cruze");
            modelsList.add("ElCamino");
            modelsList.add("Epica");
            modelsList.add("Equinox");
            modelsList.add("Evanda");
            modelsList.add("Express");
            modelsList.add("G");
            modelsList.add("HHR");
            modelsList.add("Impala");
            modelsList.add("Kalos");
            modelsList.add("Lacetti");
            modelsList.add("Malibu");
            modelsList.add("Malibu");
            modelsList.add("Matiz");
            modelsList.add("MonteCarlo");
            modelsList.add("Nubira");
            modelsList.add("Orlando");
            modelsList.add("Inny");
            modelsList.add("Rezzo");
            modelsList.add("S-10");
            modelsList.add("Silverado");
            modelsList.add("Spark");
            modelsList.add("Suburban");
            modelsList.add("Tacuma");
            modelsList.add("Tahoe");
            modelsList.add("Trailblazer");
            modelsList.add("TransSport");
            modelsList.add("Traverse");
            modelsList.add("Trax");
            modelsList.add("Volt");


        } else if (brand.equals("Chrysler")) {

            modelsList.add("200");
            modelsList.add("300C");
            modelsList.add("300M");
            modelsList.add("Aspen");
            modelsList.add("Crossfire");
            modelsList.add("Daytona");
            modelsList.add("GrandVoyager");
            modelsList.add("LeBaron");
            modelsList.add("Neon");
            modelsList.add("NewYorker");
            modelsList.add("Inny");
            modelsList.add("Pacifica");
            modelsList.add("PTCruiser");
            modelsList.add("Sebring");
            modelsList.add("Stratus");
            modelsList.add("Town&Country");
            modelsList.add("Vision");
            modelsList.add("Voyager");


        } else if (brand.equals("Citroen")) {


            modelsList.add("Berlingo");
            modelsList.add("BX");
            modelsList.add("C-Crosser");
            modelsList.add("C-Elysee");
            modelsList.add("C1");
            modelsList.add("C2");
            modelsList.add("C3");
            modelsList.add("C3Aircross");
            modelsList.add("C3Picasso");
            modelsList.add("C3Pluriel");
            modelsList.add("C4");
            modelsList.add("C4Aircross");
            modelsList.add("C4Cactuss");
            modelsList.add("C4GrandPicasso");
            modelsList.add("C4Picasso");
            modelsList.add("C5");
            modelsList.add("C5Aircross");
            modelsList.add("C6");
            modelsList.add("C8");
            modelsList.add("CX");
            modelsList.add("DS");
            modelsList.add("DS3");
            modelsList.add("DS4");
            modelsList.add("DS5");
            modelsList.add("Evasion");
            modelsList.add("GSA");
            modelsList.add("Jumper");
            modelsList.add("JumpyCombi");
            modelsList.add("Nemo");
            modelsList.add("Inny");
            modelsList.add("Saxo");
            modelsList.add("SpaceTourer");
            modelsList.add("Xantia");
            modelsList.add("XM");
            modelsList.add("Xsara");


        } else if (brand.equals("Cupra")) {

            modelsList.add("Ateca");

        } else if (brand.equals("Dacia")) {


            modelsList.add("1300");
            modelsList.add("Dokker");
            modelsList.add("DokkerVan");
            modelsList.add("Duster");
            modelsList.add("Lodgy");
            modelsList.add("Logan");
            modelsList.add("LoganVan");
            modelsList.add("PickUp");
            modelsList.add("Sandero");
            modelsList.add("SanderoStepway");

        } else if (brand.equals("Daewoo")) {


            modelsList.add("Espero");
            modelsList.add("Evanda");
            modelsList.add("Kalos");
            modelsList.add("Lacetti");
            modelsList.add("Lanos");
            modelsList.add("Leganza");
            modelsList.add("Matiz");
            modelsList.add("Nexia");
            modelsList.add("Nubira");
            modelsList.add("Inny");
            modelsList.add("Rezzo");
            modelsList.add("Tacuma");
            modelsList.add("Tico");

        } else if (brand.equals("Daihatsu")) {

            modelsList.add("Charade");
            modelsList.add("Copen");
            modelsList.add("Cuore");
            modelsList.add("Feroza");
            modelsList.add("GranMove");
            modelsList.add("Materia");
            modelsList.add("Sirion");
            modelsList.add("Terios");
            modelsList.add("Trevis");
            modelsList.add("YRV");

        } else if (brand.equals("De-lorean")) {


            modelsList.add("DMC12");

        } else if (brand.equals("DFSK")) {


            modelsList.add("PickUp");

        } else if (brand.equals("DKW")) {

            modelsList.add("Inny");


        } else if (brand.equals("Dodge")) {


            modelsList.add("Avenger");
            modelsList.add("Caliber");
            modelsList.add("Challenger");
            modelsList.add("Charger");
            modelsList.add("Dakota");
            modelsList.add("Dart");
            modelsList.add("Durango");
            modelsList.add("GrandCaravan");
            modelsList.add("Journey");
            modelsList.add("Magnum");
            modelsList.add("Nitro");
            modelsList.add("Inny");
            modelsList.add("RAM");
            modelsList.add("Stratus");
            modelsList.add("Viper");

        } else if (brand.equals("DSAutomobiles")) {

            modelsList.add("DS3");
            modelsList.add("DS3Crossback");
            modelsList.add("DS4");
            modelsList.add("DS4Crossback");
            modelsList.add("DS5");
            modelsList.add("DS7Crossback");


        } else if (brand.equals("Ferrari")) {

            modelsList.add("208");
            modelsList.add("308");
            modelsList.add("456");
            modelsList.add("458Italia");
            modelsList.add("488");
            modelsList.add("599GTB");
            modelsList.add("612");
            modelsList.add("812Superfast");
            modelsList.add("California");
            modelsList.add("F12berlinetta");
            modelsList.add("F355");
            modelsList.add("F430");
            modelsList.add("FF");
            modelsList.add("GTC4Lusso");
            modelsList.add("LaFerrari");
            modelsList.add("Mondial");
            modelsList.add("Portofino");


        } else if (brand.equals("Fiat")) {

            modelsList.add("124Spider");
            modelsList.add("125p");
            modelsList.add("126");
            modelsList.add("128");
            modelsList.add("130");
            modelsList.add("131");
            modelsList.add("132");
            modelsList.add("500");
            modelsList.add("50L");
            modelsList.add("500X");
            modelsList.add("600");
            modelsList.add("Albea");
            modelsList.add("Barchetta");
            modelsList.add("Brava");
            modelsList.add("Bravo");
            modelsList.add("Cinquecento");
            modelsList.add("Coupe");
            modelsList.add("Croma");
            modelsList.add("Doblo");
            modelsList.add("Ducato");
            modelsList.add("Fiorino");
            modelsList.add("Freemont");
            modelsList.add("Fullback");
            modelsList.add("GrandePunto");
            modelsList.add("Idea");
            modelsList.add("Linea");
            modelsList.add("Marea");
            modelsList.add("Multipla");
            modelsList.add("Inny");
            modelsList.add("Palio");
            modelsList.add("Panda");
            modelsList.add("Punto");
            modelsList.add("Punto2012");
            modelsList.add("PuntoEvo");
            modelsList.add("Qubo");
            modelsList.add("Scudo");
            modelsList.add("Sedici");
            modelsList.add("Seicento");
            modelsList.add("Siena");
            modelsList.add("Stilo");
            modelsList.add("Strada");
            modelsList.add("Talento");
            modelsList.add("Tempra");
            modelsList.add("Tipo");
            modelsList.add("Ulysse");
            modelsList.add("Uno");
            modelsList.add("X1");


        } else if (brand.equals("Ford")) {


            modelsList.add("B-MAX");
            modelsList.add("Bronco");
            modelsList.add("C-MAX");
            modelsList.add("Capri");
            modelsList.add("Cougar");
            modelsList.add("Courier");
            modelsList.add("Crown");
            modelsList.add("EcoSport");
            modelsList.add("EDGE");
            modelsList.add("Escape");
            modelsList.add("Escort");
            modelsList.add("Excursion");
            modelsList.add("Expedition");
            modelsList.add("Explorer");
            modelsList.add("F150");
            modelsList.add("F250");
            modelsList.add("F350");
            modelsList.add("Festiva");
            modelsList.add("Fiesta");
            modelsList.add("Focus");
            modelsList.add("FocusC-Max");
            modelsList.add("Freestyle");
            modelsList.add("Fusion");
            modelsList.add("Galaxy");
            modelsList.add("Granada");
            modelsList.add("GrandC-MAX");
            modelsList.add("KA");
            modelsList.add("Ka+");
            modelsList.add("Kuga");
            modelsList.add("Maverick");
            modelsList.add("Mercury");
            modelsList.add("Mondeo");
            modelsList.add("Mustang");
            modelsList.add("Inny");
            modelsList.add("Probe");
            modelsList.add("Puma");
            modelsList.add("Ranger");
            modelsList.add("S-Max");
            modelsList.add("Scorpio");
            modelsList.add("Sierra");
            modelsList.add("Streetka");
            modelsList.add("Taunus");
            modelsList.add("Taurus");
            modelsList.add("Thunderbird");
            modelsList.add("TourneoConnect");
            modelsList.add("TourneoCourier");
            modelsList.add("TourneoCustom");
            modelsList.add("Transit");
            modelsList.add("TransitConnect");
            modelsList.add("TransitCourier");
            modelsList.add("TransitCustom");


        } else if (brand.equals("Galloper")) {


            modelsList.add("SuperExceed");


        } else if (brand.equals("Gaz")) {


            modelsList.add("69");
            modelsList.add("Inny");

        } else if (brand.equals("GMC")) {


            modelsList.add("Acadia");
            modelsList.add("Envoy");
            modelsList.add("Inny");
            modelsList.add("Safari");
            modelsList.add("Savana");
            modelsList.add("Sierra");
            modelsList.add("Sonoma");
            modelsList.add("Terrain");

        } else if (brand.equals("Gonow")) {


            modelsList.add("altul");

        } else if (brand.equals("Grecav")) {


            modelsList.add("Sonique");

        } else if (brand.equals("GWM")) {


            modelsList.add("Hover");


        } else if (brand.equals("Honda")) {


            modelsList.add("Accord");
            modelsList.add("City");
            modelsList.add("Civic");
            modelsList.add("Concerto");
            modelsList.add("CR-R");
            modelsList.add("CR-Z");
            modelsList.add("CRX");
            modelsList.add("FR-V");
            modelsList.add("HR-V");
            modelsList.add("Insight");
            modelsList.add("Integra");
            modelsList.add("Jazz");
            modelsList.add("Legend");
            modelsList.add("Logo");
            modelsList.add("Odysey");
            modelsList.add("Inny");
            modelsList.add("Pilot");
            modelsList.add("Prelude");
            modelsList.add("Ridgeline");
            modelsList.add("S2000");
            modelsList.add("Stream");

        } else if (brand.equals("Hummer")) {


            modelsList.add("H1");
            modelsList.add("H2");
            modelsList.add("H3");

        } else if (brand.equals("Hyundai")) {


            modelsList.add("Accent");
            modelsList.add("Atos");
            modelsList.add("Coupe");
            modelsList.add("Elantra");
            modelsList.add("equus");
            modelsList.add("Galloper");
            modelsList.add("Genesis");
            modelsList.add("GenesisCoupe");
            modelsList.add("Getz");
            modelsList.add("GrandsantaFe");
            modelsList.add("H-1");
            modelsList.add("H-1Starex");
            modelsList.add("H200");
            modelsList.add("i10");
            modelsList.add("i20");
            modelsList.add("i30");
            modelsList.add("i30N");
            modelsList.add("i40");
            modelsList.add("IONIQ");
            modelsList.add("ix20");
            modelsList.add("ix35");
            modelsList.add("ix55");
            modelsList.add("Kona");
            modelsList.add("Lantra");
            modelsList.add("Matrix");
            modelsList.add("S-Coupe");
            modelsList.add("SantaFe");
            modelsList.add("Sonata");
            modelsList.add("Terracan");
            modelsList.add("Trajet");
            modelsList.add("Tucson");
            modelsList.add("Veloster");
            modelsList.add("XG30");
            modelsList.add("XG350");


        } else if (brand.equals("Infiniti")) {


            modelsList.add("EX");
            modelsList.add("FX");
            modelsList.add("G");
            modelsList.add("I35");
            modelsList.add("M");
            modelsList.add("Inny");
            modelsList.add("Q30");
            modelsList.add("Q50");
            modelsList.add("Q60");
            modelsList.add("Q70");
            modelsList.add("QX");
            modelsList.add("QX30");
            modelsList.add("SQ50");
            modelsList.add("SQ60");
            modelsList.add("XQ70");

        } else if (brand.equals("Isuzu")) {


            modelsList.add("D-Max");
            modelsList.add("Inny");
            modelsList.add("Trooper");

        } else if (brand.equals("Iveco")) {


            modelsList.add("Massif");

        } else if (brand.equals("Jaguar")) {


            modelsList.add("Daimler");
            modelsList.add("E-Pace");
            modelsList.add("E-Type");
            modelsList.add("F-Pace");
            modelsList.add("F-Type");
            modelsList.add("I-Pace");
            modelsList.add("Inny");
            modelsList.add("S-Type");
            modelsList.add("X-Type");
            modelsList.add("XE");
            modelsList.add("XF");
            modelsList.add("XJ");
            modelsList.add("XJS");
            modelsList.add("XK");


        } else if (brand.equals("Jeep")) {


            modelsList.add("Cherokee");
            modelsList.add("CJ");
            modelsList.add("Commander");
            modelsList.add("Compass");
            modelsList.add("GrandCherokee");
            modelsList.add("Liberty");
            modelsList.add("Inne");
            modelsList.add("Patriot");
            modelsList.add("Renegade");
            modelsList.add("Wagoneer");
            modelsList.add("Willys");
            modelsList.add("Wrangler");


        } else if (brand.equals("Kia")) {


            modelsList.add("AsiaRocsta");
            modelsList.add("Carens");
            modelsList.add("carnival");
            modelsList.add("Cee'd");
            modelsList.add("Cerato");
            modelsList.add("Clarus");
            modelsList.add("Joice");
            modelsList.add("Magnetis");
            modelsList.add("Niro");
            modelsList.add("Opirus");
            modelsList.add("Optima");
            modelsList.add("Picanto");
            modelsList.add("Pregio");
            modelsList.add("Pro_cee'd");
            modelsList.add("Retona");
            modelsList.add("Rio");
            modelsList.add("Rocsta");
            modelsList.add("Sephia");
            modelsList.add("Shuma");
            modelsList.add("Sorento");
            modelsList.add("Soul");
            modelsList.add("Spectra");
            modelsList.add("Sportage");
            modelsList.add("Stinger");
            modelsList.add("Stonic");
            modelsList.add("Venga");
            modelsList.add("XCeed");

        } else if (brand.equals("Lada")) {


            modelsList.add("1200");
            modelsList.add("2103");
            modelsList.add("2105");
            modelsList.add("2107");
            modelsList.add("2109");
            modelsList.add("Kalina");
            modelsList.add("Niva");
            modelsList.add("Inny");
            modelsList.add("Samara");

        } else if (brand.equals("Lamborghini")) {


            modelsList.add("Aventador");
            modelsList.add("Diablo");
            modelsList.add("Gallardo");
            modelsList.add("Huracan");
            modelsList.add("Urus");

        } else if (brand.equals("Lancia")) {


            modelsList.add("Delta");
            modelsList.add("Fulvia");
            modelsList.add("Kappa");
            modelsList.add("Lybra");
            modelsList.add("Musa");
            modelsList.add("Inny");
            modelsList.add("Phedra");
            modelsList.add("Thema");
            modelsList.add("Thesis");
            modelsList.add("Voyager");
            modelsList.add("Ypsilon");

        } else if (brand.equals("LandRover")) {


            modelsList.add("Defender");
            modelsList.add("Discovery");
            modelsList.add("DiscoverySport");
            modelsList.add("Freelander");
            modelsList.add("Inny");
            modelsList.add("RangeRover");
            modelsList.add("RangeRoverEvoque");
            modelsList.add("RangeRoverSport");
            modelsList.add("RangeRoverVelar");

        } else if (brand.equals("Lexus")) {

            modelsList.add("CT");
            modelsList.add("ES");
            modelsList.add("GS");
            modelsList.add("GX");
            modelsList.add("IS");
            modelsList.add("LC");
            modelsList.add("LFA");
            modelsList.add("LS");
            modelsList.add("LX");
            modelsList.add("NX");
            modelsList.add("Inny");
            modelsList.add("RC");
            modelsList.add("RX");
            modelsList.add("SC");
            modelsList.add("UX");

        } else if (brand.equals("Ligier")) {


            modelsList.add("Ambra");
            modelsList.add("Be-Two");
            modelsList.add("IXO");
            modelsList.add("JS50");
            modelsList.add("JS50L");
            modelsList.add("Nova");
            modelsList.add("Inny");
            modelsList.add("X-Too");

        } else if (brand.equals("Lincoln")) {


            modelsList.add("Aviator");
            modelsList.add("Continental");
            modelsList.add("LS");
            modelsList.add("Mark");
            modelsList.add("MKX");
            modelsList.add("MKZ");
            modelsList.add("Navigator");
            modelsList.add("Inny");
            modelsList.add("TownCar");

        } else if (brand.equals("Lotus")) {


            modelsList.add("Elan");
            modelsList.add("Elise");
            modelsList.add("Esprit");
            modelsList.add("SuperSeven");

        } else if (brand.equals("LTI")) {


            modelsList.add("Fairway");
            modelsList.add("TX2");


        } else if (brand.equals("Mahindra")) {


            modelsList.add("Inny");

        } else if (brand.equals("Maserati")) {


            modelsList.add("3200");
            modelsList.add("Biturbo");
            modelsList.add("Ghibli");
            modelsList.add("GranCabrio");
            modelsList.add("Gransport");
            modelsList.add("GranTurismo");
            modelsList.add("Levante");
            modelsList.add("Quattroporte");
            modelsList.add("Spyder");

        } else if (brand.equals("Maybach")) {


            modelsList.add("62");
            modelsList.add("Inny");

        } else if (brand.equals("Mazda")) {


            modelsList.add("2");
            modelsList.add("3");
            modelsList.add("323");
            modelsList.add("323F");
            modelsList.add("5");
            modelsList.add("6");
            modelsList.add("626");
            modelsList.add("929");
            modelsList.add("BT-50");
            modelsList.add("CX-3");
            modelsList.add("CX-30");
            modelsList.add("CX-5");
            modelsList.add("CX-7");
            modelsList.add("CX-9");
            modelsList.add("Demio");
            modelsList.add("MPV");
            modelsList.add("MX-5");
            modelsList.add("MX-6");
            modelsList.add("Inny");
            modelsList.add("Premacy");
            modelsList.add("Protege");
            modelsList.add("RX-6");
            modelsList.add("RX-7");
            modelsList.add("RX-8");
            modelsList.add("SeriaB");
            modelsList.add("Tribute");
            modelsList.add("Xedos");

        } else if (brand.equals("McLaren")) {


            modelsList.add("570GT");
            modelsList.add("570SCoupe");
            modelsList.add("570SSpider");
            modelsList.add("600LTCoupe");
            modelsList.add("600LTSpider");
            modelsList.add("720SCoupe");
            modelsList.add("720SSpider");
            modelsList.add("altul");

        } else if (brand.equals("Mercedes-Benz")) {


            modelsList.add("280");
            modelsList.add("AMGGT");
            modelsList.add("Citan");
            modelsList.add("CL");
            modelsList.add("CAL");
            modelsList.add("CLC");
            modelsList.add("CLK");
            modelsList.add("CLS");
            modelsList.add("GL");
            modelsList.add("GLA");
            modelsList.add("GLC");
            modelsList.add("GLE");
            modelsList.add("GLK");
            modelsList.add("GLS");
            modelsList.add("KlasaA");
            modelsList.add("KlasaB");
            modelsList.add("KlasaC");
            modelsList.add("KlasaE");
            modelsList.add("KlasaG");
            modelsList.add("KlasaR");
            modelsList.add("KlasaV");
            modelsList.add("MB100");
            modelsList.add("ML");
            modelsList.add("Inny");
            modelsList.add("SL");
            modelsList.add("SLC");
            modelsList.add("SLK");
            modelsList.add("SLR");
            modelsList.add("SLS");
            modelsList.add("Sprinter");
            modelsList.add("Vaneo");
            modelsList.add("Vario");
            modelsList.add("Viano");
            modelsList.add("Vito");

        } else if (brand.equals("Mercury")) {

            modelsList.add("Cougar");
            modelsList.add("Marquis");
            modelsList.add("Inny");
            modelsList.add("Villager");


        } else if (brand.equals("MG")) {


            modelsList.add("MGA");
            modelsList.add("MGB");
            modelsList.add("MGF");
            modelsList.add("Midget");
            modelsList.add("TD");
            modelsList.add("TF");
            modelsList.add("ZR");
            modelsList.add("ZRS");
            modelsList.add("ZT");

        } else if (brand.equals("Microcar")) {

            modelsList.add("DUE");
            modelsList.add("HighlandX");
            modelsList.add("Ligier");
            modelsList.add("M.GO");
            modelsList.add("MC");
            modelsList.add("Inny");
            modelsList.add("Virgo");


        } else if (brand.equals("Mini")) {

            modelsList.add("1000");
            modelsList.add("1300");
            modelsList.add("Clubman");
            modelsList.add("Cooper");
            modelsList.add("CooperS");
            modelsList.add("Countryman");
            modelsList.add("ONE");
            modelsList.add("Inny");
            modelsList.add("Paceman");


        } else if (brand.equals("Mitsubishi")) {

            modelsList.add("3000GT");
            modelsList.add("ASX");
            modelsList.add("Canter");
            modelsList.add("Carisma");
            modelsList.add("Colt");
            modelsList.add("Eclipse");
            modelsList.add("EclipseCross");
            modelsList.add("Endeavor");
            modelsList.add("FTO");
            modelsList.add("Galant");
            modelsList.add("Grandis");
            modelsList.add("i-MiEV");
            modelsList.add("L200");
            modelsList.add("L300");
            modelsList.add("Lancer");
            modelsList.add("LancerEvolution");
            modelsList.add("Montero");
            modelsList.add("Inny");
            modelsList.add("Outlander");
            modelsList.add("Pajero");
            modelsList.add("PajeroPinin");
            modelsList.add("SpaceGear");
            modelsList.add("SpaceRunner");
            modelsList.add("SpaceStar");
            modelsList.add("SpaceWagon");
            modelsList.add("Starion");


        } else if (brand.equals("Morgan")) {

            modelsList.add("Aero8");
            modelsList.add("Inny");
            modelsList.add("Roadster");


        } else if (brand.equals("Moskwicz")) {


            modelsList.add("403");


        } else if (brand.equals("Nissan")) {
            modelsList.add("100NX");
            modelsList.add("200SX");
            modelsList.add("280ZX");
            modelsList.add("300ZX");
            modelsList.add("350Z");
            modelsList.add("370Z");
            modelsList.add("Almera");
            modelsList.add("AlmeraTino");
            modelsList.add("Altima");
            modelsList.add("Armada");
            modelsList.add("Bluebird");
            modelsList.add("Cube");
            modelsList.add("Frontier");
            modelsList.add("GT_R");
            modelsList.add("Interstar");
            modelsList.add("Juke");
            modelsList.add("KingCab");
            modelsList.add("Kubistar");
            modelsList.add("Leaf");
            modelsList.add("Maxima");
            modelsList.add("Micra");
            modelsList.add("Murao");
            modelsList.add("Navara");
            modelsList.add("Note");
            modelsList.add("NP300Pickup");
            modelsList.add("NV200");
            modelsList.add("NV300");
            modelsList.add("NV400");
            modelsList.add("Inny");
            modelsList.add("Pathfinder");
            modelsList.add("Patrol");
            modelsList.add("Pickup");
            modelsList.add("Pixo");
            modelsList.add("Primastar");
            modelsList.add("Primera");
            modelsList.add("Pulsar");
            modelsList.add("Qashqai");
            modelsList.add("Qashqai+2");
            modelsList.add("Quest");
            modelsList.add("Rogue");
            modelsList.add("Sentra");
            modelsList.add("Silivia");
            modelsList.add("Skyline");
            modelsList.add("Sunny");
            modelsList.add("Terrano");
            modelsList.add("Tiida");
            modelsList.add("Titan");
            modelsList.add("X-Trail");
            modelsList.add("Xterra");


        } else if (brand.equals("NSU")) {

            modelsList.add("Inny");
            modelsList.add("RO80");


        } else if (brand.equals("Nysa")) {


            modelsList.add("Inny");
            modelsList.add("Seria500");

        } else if (brand.equals("Oldsmobile")) {

            modelsList.add("Aurora");
            modelsList.add("Cutlass");
            modelsList.add("Delta88");
            modelsList.add("Inny");


        } else if (brand.equals("Opel")) {

            modelsList.add("Adam");
            modelsList.add("Agila");
            modelsList.add("Ampera");
            modelsList.add("Antara");
            modelsList.add("Ascona");
            modelsList.add("Astra");
            modelsList.add("Calibra");
            modelsList.add("Cascada");
            modelsList.add("Combo");
            modelsList.add("Commodore");
            modelsList.add("Corsa");
            modelsList.add("CrosslandX");
            modelsList.add("Frontera");
            modelsList.add("GrandlandX");
            modelsList.add("GT");
            modelsList.add("Insignia");
            modelsList.add("Kadett");
            modelsList.add("Karl");
            modelsList.add("Manta");
            modelsList.add("Meriva");
            modelsList.add("Mokka");
            modelsList.add("Monterey");
            modelsList.add("Monza");
            modelsList.add("Movano");
            modelsList.add("Omega");
            modelsList.add("Inny");
            modelsList.add("Rekord");
            modelsList.add("Senator");
            modelsList.add("Signum");
            modelsList.add("Tigra");
            modelsList.add("Vectra");
            modelsList.add("Vivaro");
            modelsList.add("Zafira");


        } else if (brand.equals("Peugeot")) {


            modelsList.add("1007");
            modelsList.add("106");
            modelsList.add("107");
            modelsList.add("108");
            modelsList.add("2008");
            modelsList.add("205");
            modelsList.add("206");
            modelsList.add("206CC");
            modelsList.add("206plus");
            modelsList.add("207");
            modelsList.add("207CC");
            modelsList.add("208");
            modelsList.add("3008");
            modelsList.add("301");
            modelsList.add("304");
            modelsList.add("306");
            modelsList.add("307");
            modelsList.add("307CC");
            modelsList.add("308");
            modelsList.add("308CC");
            modelsList.add("309");
            modelsList.add("4007");
            modelsList.add("4008");
            modelsList.add("404");
            modelsList.add("405");
            modelsList.add("406");
            modelsList.add("407");
            modelsList.add("5008");
            modelsList.add("508");
            modelsList.add("605");
            modelsList.add("607");
            modelsList.add("806");
            modelsList.add("807");
            modelsList.add("Bipper");
            modelsList.add("Boxer");
            modelsList.add("Expert");
            modelsList.add("Inny");
            modelsList.add("Partner");
            modelsList.add("RCZ");
            modelsList.add("Rifter");
            modelsList.add("Traveller");


        } else if (brand.equals("Piaggio")) {

            modelsList.add("Inny");


        } else if (brand.equals("Plymouth")) {


            modelsList.add("Inny");
            modelsList.add("Prowler");
            modelsList.add("Valiant");
            modelsList.add("Voyager");


        } else if (brand.equals("Polonez")) {
            modelsList.add("1.5");
            modelsList.add("1.6");
            modelsList.add("Atu");
            modelsList.add("Caro");
            modelsList.add("Inny");


        } else if (brand.equals("Pontiac")) {
            modelsList.add("Bonneville");
            modelsList.add("Chieftain");
            modelsList.add("Firebird");
            modelsList.add("G6");
            modelsList.add("Grand-Prix");
            modelsList.add("Montana");
            modelsList.add("Inny");
            modelsList.add("Solstice");
            modelsList.add("TransAm");
            modelsList.add("TransSport");


        } else if (brand.equals("Porsche")) {
            modelsList.add("356");
            modelsList.add("718Coxter");
            modelsList.add("718Cayman");
            modelsList.add("911");
            modelsList.add("914");
            modelsList.add("924");
            modelsList.add("944");
            modelsList.add("968");
            modelsList.add("Boxter");
            modelsList.add("Cayenne");
            modelsList.add("Cayman");
            modelsList.add("Macan");
            modelsList.add("Inny");
            modelsList.add("Panamera");


        } else if (brand.equals("RAM")) {
            modelsList.add("1500");


        } else if (brand.equals("Renault")) {
            modelsList.add("11");
            modelsList.add("19");
            modelsList.add("4");
            modelsList.add("5");
            modelsList.add("Alaskan");
            modelsList.add("Avantime");
            modelsList.add("Captur");
            modelsList.add("Clio");
            modelsList.add("Coupe");
            modelsList.add("Espace");
            modelsList.add("Express");
            modelsList.add("Fluence");
            modelsList.add("GrandEspace");
            modelsList.add("GrandScenic");
            modelsList.add("Kadjar");
            modelsList.add("Kangoo");
            modelsList.add("Koleos");
            modelsList.add("Laguna");
            modelsList.add("Latitude");
            modelsList.add("Master");
            modelsList.add("Megane");
            modelsList.add("Modus");
            modelsList.add("Inny");
            modelsList.add("Safrane");
            modelsList.add("Scenic");
            modelsList.add("ScenicConquest");
            modelsList.add("ScenicRX4");
            modelsList.add("Talisman");
            modelsList.add("Thalia");
            modelsList.add("Trafic");
            modelsList.add("Twingo");
            modelsList.add("Twizy");
            modelsList.add("VelSatis");
            modelsList.add("Wind");
            modelsList.add("Zoe");


        } else if (brand.equals("Rolls-royce")) {


            modelsList.add("Corniche");
            modelsList.add("Cullinan");
            modelsList.add("Ghost");
            modelsList.add("Inny");
            modelsList.add("SilverCloud");
            modelsList.add("SilverShadow");
            modelsList.add("Wraith");


        } else if (brand.equals("Rover")) {

            modelsList.add("216");
            modelsList.add("25");
            modelsList.add("400");
            modelsList.add("416");
            modelsList.add("420");
            modelsList.add("45");
            modelsList.add("600");
            modelsList.add("618");
            modelsList.add("620");
            modelsList.add("75");
            modelsList.add("825");
            modelsList.add("MG");
            modelsList.add("Inny");
            modelsList.add("Streetwise");


        } else if (brand.equals("Saab")) {


            modelsList.add("9-3");
            modelsList.add("9-5");
            modelsList.add("90");
            modelsList.add("900");
            modelsList.add("9000");
            modelsList.add("99");
            modelsList.add("Inny");


        } else if (brand.equals("Seat")) {

            modelsList.add("Alhambra");
            modelsList.add("Altea");
            modelsList.add("AlteaXL");
            modelsList.add("Arona");
            modelsList.add("Arosa");
            modelsList.add("Ateca");
            modelsList.add("Cordoba");
            modelsList.add("Exeo");
            modelsList.add("Ibiza");
            modelsList.add("Inca");
            modelsList.add("Leon");
            modelsList.add("Marbella");
            modelsList.add("Mii");
            modelsList.add("Inny");
            modelsList.add("Ronda");
            modelsList.add("Tarraco");
            modelsList.add("Toledo");


        } else if (brand.equals("Skoda")) {
            modelsList.add("100");
            modelsList.add("120");
            modelsList.add("Citigo");
            modelsList.add("Fabia");
            modelsList.add("Favorit");
            modelsList.add("Felicia");
            modelsList.add("Kamiq");
            modelsList.add("Karoq");
            modelsList.add("Kodiaq");
            modelsList.add("Octavia");
            modelsList.add("Inny");
            modelsList.add("Praktik");
            modelsList.add("RAPID");
            modelsList.add("Roomster");
            modelsList.add("Scala");
            modelsList.add("Superb");
            modelsList.add("Yeti");


        } else if (brand.equals("Smart")) {

            modelsList.add("Forfour");
            modelsList.add("Fortwo");
            modelsList.add("Inny");
            modelsList.add("Roadster");


        } else if (brand.equals("SsangYong")) {

            modelsList.add("Actyon");
            modelsList.add("Family");
            modelsList.add("Korando");
            modelsList.add("Kyron");
            modelsList.add("MUSSO");
            modelsList.add("REXTON");
            modelsList.add("Rodius");
            modelsList.add("Tivoli");
            modelsList.add("XLV");


        } else if (brand.equals("Subaru")) {

            modelsList.add("B9Tribeca");
            modelsList.add("BRZ");
            modelsList.add("Forester");
            modelsList.add("G3Xjusty");
            modelsList.add("Impreza");
            modelsList.add("Justy");
            modelsList.add("Legacy");
            modelsList.add("Leone");
            modelsList.add("Levorg");
            modelsList.add("Inny");
            modelsList.add("OUTBACK");
            modelsList.add("SVX");
            modelsList.add("Trezia");
            modelsList.add("Tribeca");
            modelsList.add("WRX");
            modelsList.add("XT");
            modelsList.add("XV");


        } else if (brand.equals("Suzuki")) {

            modelsList.add("Alto");
            modelsList.add("Baleno");
            modelsList.add("Celerio");
            modelsList.add("GrandVitara");
            modelsList.add("Ignis");
            modelsList.add("Jimny");
            modelsList.add("Kizashi");
            modelsList.add("Liana");
            modelsList.add("LJ");
            modelsList.add("Samurai");
            modelsList.add("SJ");
            modelsList.add("Splash");
            modelsList.add("Swift");
            modelsList.add("SX4");
            modelsList.add("SX4S-Cross");
            modelsList.add("Vitara");
            modelsList.add("WagonR+");
            modelsList.add("X-90");
            modelsList.add("XL7");


        } else if (brand.equals("Syrena")) {


            modelsList.add("104");
            modelsList.add("105");
            modelsList.add("Bosto");


        } else if (brand.equals("Tata")) {


            modelsList.add("Indica");
            modelsList.add("Safari");
            modelsList.add("Xenon");


        } else if (brand.equals("Tesla")) {


            modelsList.add("Model3");
            modelsList.add("ModelS");
            modelsList.add("ModelX");


        } else if (brand.equals("Toyota")) {

            modelsList.add("4-Runner");
            modelsList.add("Auris");
            modelsList.add("Avalon");
            modelsList.add("AvesnisVerso");
            modelsList.add("Aygo");
            modelsList.add("C-HR");
            modelsList.add("Camry");
            modelsList.add("CamrySolara");
            modelsList.add("Carina");
            modelsList.add("Celica");
            modelsList.add("Corolla");
            modelsList.add("CorollaVerso");
            modelsList.add("FJ");
            modelsList.add("GT86");
            modelsList.add("Hiace");
            modelsList.add("Highlander");
            modelsList.add("Hilux");
            modelsList.add("iQ");
            modelsList.add("LandCruiser");
            modelsList.add("Matrix");
            modelsList.add("MR2");
            modelsList.add("Inny");
            modelsList.add("Paseo");
            modelsList.add("Previa");
            modelsList.add("Prius");
            modelsList.add("Prius+");
            modelsList.add("ProAce");
            modelsList.add("ProaceVerso");
            modelsList.add("RAV4");
            modelsList.add("Sequoia");
            modelsList.add("Sienna");
            modelsList.add("Starlet");
            modelsList.add("Supra");
            modelsList.add("Tacoma");


        } else if (brand.equals("Trabant")) {


            modelsList.add("601");
            modelsList.add("Inny");


        } else if (brand.equals("Triumph")) {


            modelsList.add("Inny");
            modelsList.add("TR4");


        } else if (brand.equals("TVR")) {


            modelsList.add("Inny");

        } else if (brand.equals("Uaz")) {


            modelsList.add("452");
            modelsList.add("469B");
            modelsList.add("Inny");


        } else if (brand.equals("Vauxhall")) {

            modelsList.add("Astra");


        } else if (brand.equals("Volkswagen")) {

            modelsList.add("Amarok");
            modelsList.add("Arteon");
            modelsList.add("Beetle");
            modelsList.add("Bora");
            modelsList.add("Buggy");
            modelsList.add("Caddy");
            modelsList.add("California");
            modelsList.add("Caravelle");
            modelsList.add("CC");
            modelsList.add("Corrado");
            modelsList.add("Crafter");
            modelsList.add("Eos");
            modelsList.add("Fox");
            modelsList.add("Garbus");
            modelsList.add("Golf");
            modelsList.add("GolfPlus");
            modelsList.add("GolfSportsvan");
            modelsList.add("Iltis");
            modelsList.add("Jetta");
            modelsList.add("KarmannGhia");
            modelsList.add("Lupo");
            modelsList.add("Multivan");
            modelsList.add("NewBeetle");
            modelsList.add("Inny");
            modelsList.add("Passat");
            modelsList.add("PasatCC");
            modelsList.add("Phaeton");
            modelsList.add("Polo");
            modelsList.add("Routan");
            modelsList.add("Santana");
            modelsList.add("Scirocco");
            modelsList.add("Sharan");
            modelsList.add("T-Cross");
            modelsList.add("T-Roc");
            modelsList.add("Tiguan");
            modelsList.add("TiguanAllspace");
            modelsList.add("Touareg");
            modelsList.add("Touran");
            modelsList.add("Transporter");
            modelsList.add("up!");
            modelsList.add("Vento");


        } else if (brand.equals("Volvo")) {

            modelsList.add("245");
            modelsList.add("340");
            modelsList.add("745");
            modelsList.add("850");
            modelsList.add("C30");
            modelsList.add("C70");
            modelsList.add("Inny");
            modelsList.add("S40");
            modelsList.add("S60");
            modelsList.add("S70");
            modelsList.add("S80");
            modelsList.add("S90");
            modelsList.add("Seria200");
            modelsList.add("Seria400");
            modelsList.add("Seria700");
            modelsList.add("Seria900");
            modelsList.add("V40");
            modelsList.add("V50");
            modelsList.add("V60");
            modelsList.add("V70");
            modelsList.add("V90");
            modelsList.add("XC40");
            modelsList.add("XC60");
            modelsList.add("XC70");
            modelsList.add("XC90");


        } else if (brand.equals("Warszawa")) {

            modelsList.add("203");
            modelsList.add("204");
            modelsList.add("223");
            modelsList.add("M-20");


        } else if (brand.equals("Wartburg")) {

            modelsList.add("1.3");
            modelsList.add("311");
            modelsList.add("312");
            modelsList.add("353");


        } else if (brand.equals("Wołga")) {

            modelsList.add("GAZ-21");
            modelsList.add("Gaz-24");


        } else if (brand.equals("Yugo")) {

            modelsList.add("Koral");


        } else if (brand.equals("Zastawa")) {

            modelsList.add("1100");
            modelsList.add("750");


        } else if (brand.equals("Żuk")) {


            modelsList.add("Inny");

        }
    }
}
