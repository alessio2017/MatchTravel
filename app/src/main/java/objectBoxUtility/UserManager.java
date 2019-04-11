package objectBoxUtility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import datadb.City;
import datadb.User;
import io.objectbox.Box;
import io.objectbox.BoxStore;

public class UserManager {

    final private String STATUS_SINGLE = "Single";
    final private String STATUS_RELANTIONSHIP = "Relationship";
    final private String STATUS_MARRIED =  "Married";

    final private String COUNTRY_UK = "UK";
    final private String COUNTRY_ITA = "Italy";
    final private String COUNTRY_ESP = "Spain";
    final private String COUNTRY_FRA = "France";
    final private String COUNTRY_GER = "Germany";
    final private String COUNTRY_USA = "U.S.A.";
    final private String COUNTRY_AUS = "Austria";
    final private String COUNTRY_IRL = "Ireland";

    private Box<User> userBox;
    private CityManager cityManager;

    public UserManager(BoxStore boxStore){
        this.userBox = boxStore.boxFor(User.class);
        this.cityManager = new CityManager(boxStore);
    }

    @SuppressWarnings("all")
    public void init(){
        User u;
        Calendar cal = Calendar.getInstance();
        List<City> destinations = new ArrayList<>();

        /*Di seguito vengono creati user fittizzi*/
        u = new User();
        u.name="Mark";
        u.surname="Colbin";
        cal.set(1990,12,25);
        u.age = cal.getTime();
        u.status = STATUS_SINGLE;
        u.country = COUNTRY_UK;
        u.description = "Hi, my name is Mark! I really like travelling and I do it as often as I can. I'm from Manchester and I already visit great part of England. I wuold like to start exploring the rest of Europe as soon as I can! I always travel with my car, but of course I would change for an hotel if I have to flight to the old continent. I would love to try a voyage with only a backpack, a tend and just the minimum needed to live and travel around Europe, maybe Spain or Italy, maybe (even!) France! Contact me if you are interested, I would really love some company during my trip ;)";
        destinations = cityManager.getRandomCities();
        for (City c:
             destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Giorgio";
        u.surname="Vitale";
        cal.set(1985,5,10);
        u.age = cal.getTime();
        u.status = STATUS_SINGLE;
        u.country = COUNTRY_ITA;
        u.description = "Hello there, my name is Giorgio. I'm from Bolzano, Italy, and finally I have the opportunity to travel outside of my country. I currently speak german, italian and a bit of english, so no problem for that. I always lived near the mountains and I never see the sea. I would love to go on a island or something like that, where there is ocean for miles and miles! Such a dream...";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Lizzie";
        u.surname="Mc Gevor";
        cal.set(1983,12,2);
        u.age = cal.getTime();
        u.status = STATUS_RELANTIONSHIP;
        u.country = COUNTRY_USA;
        u.description = "I really like travelling and meet new people. One of my best friends are from Japan, where I went 5 years ago and I met some of the beautiful people of the world! I would love to repeat that trip but this time I would also like to go with someone else and share the emotions of the trip with him and all the other people we will meet. I can't wait to go, let me now!";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Anna";
        u.surname="Gruman";
        cal.set(1974,25,7);
        u.age = cal.getTime();
        u.status = STATUS_SINGLE;
        u.country = COUNTRY_IRL;
        u.description = "Last time I travel, I was alone and I had a terrible trip! This time I want to share my trip with someone else and see if things go better. The more we are, the best it is, for what concerns me and myself. Usually, I do not go out of Europe, but I'm open to every request, so send them!";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Frederick";
        u.surname="Lepard";
        cal.set(1991,5,10);
        u.age = cal.getTime();
        u.status = STATUS_RELANTIONSHIP;
        u.country = COUNTRY_FRA;
        u.description = "I don't like to tell much about my self.";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Mark";
        u.surname="Huffman";
        cal.set(1970,5,10);
        u.age = cal.getTime();
        u.status = STATUS_MARRIED;
        u.country = COUNTRY_AUS;
        u.description = "URGENT! I have few time to organize a good trip (work is coming!) but I really want to do it. I'm quite in hurry! See my preference and contact me as soon as you can!";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Jorge";
        u.surname="Garzia Cruce";
        cal.set(1985,5,10);
        u.age = cal.getTime();
        u.status = STATUS_SINGLE;
        u.country = COUNTRY_ESP;
        u.description = "Me and my brother always travel togheter but this time he can't since he is busy with his marriage (lucky him). I'm looking for someone who want to share an adventure in the far asia or maybe america. Quite urgent, though, i'm invited to the marriage and it really close!";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Otto";
        u.surname="Frienzan";
        cal.set(1985,5,10);
        u.age = cal.getTime();
        u.status = STATUS_SINGLE;
        u.country = COUNTRY_GER;
        u.description = "I would love to visit other country in Europe and know more about their hystory. I really like to spending time into museum of excellence and then dinner to some good restaurant. If you want to share with me a trip devoted to the knowledge, come on board my friend!";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Lucia";
        u.surname="Becchetti";
        cal.set(1989,5,10);
        u.age = cal.getTime();
        u.status = STATUS_SINGLE;
        u.country = COUNTRY_ITA;
        u.description = "I don't know a lot of english, but I always travel with someone who know it, so I don't have any kind of problem. If you know english and want to travel with me, let me check your desired destinations and we will see if we can go ;)";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Mark";
        u.surname="Zucckie";
        cal.set(1979,5,10);
        u.age = cal.getTime();
        u.status = STATUS_SINGLE;
        u.country = COUNTRY_USA;
        u.description = "I don't know what to write.";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Freya";
        u.surname="Tullia";
        cal.set(1988,5,10);
        u.age = cal.getTime();
        u.status = STATUS_MARRIED;
        u.country = COUNTRY_IRL;
        u.description = "Me and my husband usually like to travel with other couple in order to meet new people and share with them a beautiful voyage around the world. We really like travelling, and more far it is, the better it is!";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Simone";
        u.surname="Pascale";
        cal.set(1994,5,10);
        u.age = cal.getTime();
        u.status = STATUS_RELANTIONSHIP;
        u.country = COUNTRY_ITA;
        u.description = "I really like travel and, if it depends on me, I wuold do it every time I can. I'm looking for someone, more than one, why not, to suggest me and give me the opportunity to leave and take a long and refreshing voyage.";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);
    }
}
