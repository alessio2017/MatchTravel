package objectBoxUtility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import datadb.City;

public class SurveyManager {

    private CityManager cityManager;
    //the answer to the survey
    private int kind;
    private int local;
    private int budget;
    private int activities;
    private int tourist;
    private int temperature;


    public SurveyManager(){
        this.cityManager = new CityManager(ObjectBox.get());
    }

    public List<City> getCitiesFromSurvey(){
        List<City> cities = new ArrayList<>();
        /*local, activities and temperature can lead to case "i don't care"
        * these cases are handled by the cityManager*/
        cities.addAll(cityManager.getCity(kind, local, budget, activities, tourist, temperature));

        /*all of the following local attributes are useful for the following algorithm*/
        boolean notAlreadyWeakened = true;
        boolean canContinue = true;
        boolean doBudget = true;
        boolean maxBudgetReached = false;
        boolean maxTouristReached = false;

        if(budget == 3){
            maxBudgetReached = true;
            doBudget = false;
        }
        if(tourist == 0)
            maxTouristReached = true;

        int b = budget;
        int t = tourist;

        /*SPIEGAZIONE ALGORITMO
        * Il punto è: meno di 6 città non è un risultato accettabile, ergo dobbiamo ripetere la
        * query di prima ma indebolita (weakened), in modo da riavere più risultati.
        * Il primo tentativo è fatto togliendo il constraint sulle activities (4° domanda). Questo
        * tentativo viene fatto una sola volta, da qui necessario 'notAlreadyWeakened'.
        * Il secondo tentativo viene fatto intervallando la crescita del budget e la decrescita del
        * fattore 'turisti'. 'doBudget' tiene conto di chi è il turno (se del 'budget' o del
        * 'tourist'), se si è arrivati all'altezza massima consentita non si può incrementare ancora,
        * da qui la necessità di 'maxBudgetReached' e 'maxTouristReached'.
        * Se non è possibile proseguire è necessario fermare il ciclo 'while', quindi si setta
        * 'canContinue' a false.
        * Fine.
        * */
        while (cities.size() < 6 && canContinue){
            List<City> otherCities = new ArrayList<>();
            if(activities != 4 && notAlreadyWeakened){
                otherCities = cityManager.getCity(kind, local, budget, 4, tourist, temperature);
                notAlreadyWeakened = false;
            }else if(doBudget && !maxBudgetReached){
                b++;
                if(b<4)
                    otherCities = cityManager.getCity(kind, local, b, activities, tourist, temperature);
                else
                    maxBudgetReached = true;
                if(!maxTouristReached)
                    doBudget=false;
            }else if(!doBudget && !maxTouristReached){
                t--;
                if(t>=0)
                    otherCities = cityManager.getCity(kind, local, budget, activities, t, temperature);
                else
                    maxTouristReached = true;
                if(!maxBudgetReached)
                    doBudget = true;
            }else{
                canContinue = false;
            }

            if(otherCities!=null && canContinue){
                List<City> toDelete = new ArrayList<>();
                if(otherCities.size() < cities.size()){
                    for (City c: otherCities){
                        if(cities.contains(c)) {
                            toDelete.add(c);
                        }
                    }
                }else{
                    for (City c: cities){
                        if(otherCities.contains(c)){
                            toDelete.add(c);
                        }
                    }
                }
                otherCities.removeAll(toDelete);
                cities.addAll(otherCities);
            }
        }

        while(cities.size()<6){
            List<City> temp = cityManager.getRandomCities();
            Iterator<City> iterator = temp.iterator();
            while(cities.size()<6 && iterator.hasNext()){
                City c = iterator.next();
                if(!cities.contains(c)){
                    cities.add(c);
                }
            }
        }

        return cities;
    }

    public void setAnswers(int a1, int a2, int a3, int a4, int a5, int a6){
        this.kind = a1;
        this.local = a2;
        this.budget = a3;
        this.activities = a4;
        this.tourist = a5;
        this.temperature = a6;
    }

    //getter and setter
    public void setAnswer1(int a1){
        this.kind = a1;
    }

    public int getAnswer1() {
        return kind;
    }

    public int getAnswer2() {
        return local;
    }

    public void setAnswer2(int answer2) {
        this.local = answer2;
    }

    public int getAnswer3() {
        return budget;
    }

    public void setAnswer3(int answer3) {
        this.budget = answer3;
    }

    public int getAnswer4() {
        return activities;
    }

    public void setAnswer4(int answer4) {
        this.activities = answer4;
    }

    public int getAnswer5() {
        return tourist;
    }

    public void setAnswer5(int answer5) {
        this.tourist= answer5;
    }

    public int getAnswer6() {
        return temperature;
    }

    public void setAnswer6(int answer6) {
        this.temperature = answer6;
    }
}
