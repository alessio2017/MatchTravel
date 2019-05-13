package objectBoxUtility;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import datadb.City;
import datadb.User;
import datadb.User_;
import io.objectbox.Box;
import io.objectbox.BoxStore;

public class UserManager {
    private Box<User> userBox;
    private CityManager cityManager;

    public UserManager(BoxStore boxStore){
        this.userBox = boxStore.boxFor(User.class);
        this.cityManager = new CityManager(boxStore);
    }

    @SuppressWarnings("all")
    public void init(){
        final String statusSingle = "Single";
        final String statusRelantionship = "Relationship";
        final String statusMarried =  "Married";

        final String countryUk = "UK";
        final String countryIta = "Italy";
        final String countryEsp = "Spain";
        final String countryFra = "France";
        final String countryGer = "Germany";
        final String countryUsa = "U.S.A.";
        final String countryAus = "Austria";
        final String countryIrl = "Ireland";

        User u;
        Calendar cal = Calendar.getInstance();
        List<City> destinations = new ArrayList<>();

        /*Di seguito vengono creati user fittizzi: 12*/
        u = new User();
        u.name="Mark";
        u.surname="Colbin";
        cal.set(1990,12,25);
        u.age = cal.getTime();
        u.status = statusSingle;
        u.country = countryUk;
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
        u.status = statusSingle;
        u.country = countryIta;
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
        u.status = statusRelantionship;
        u.country = countryUsa;
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
        u.status = statusSingle;
        u.country = countryIrl;
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
        u.status = statusRelantionship;
        u.country = countryFra;
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
        u.status = statusMarried;
        u.country = countryAus;
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
        u.status = statusSingle;
        u.country = countryEsp;
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
        u.status = statusSingle;
        u.country = countryGer;
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
        u.status = statusSingle;
        u.country = countryIta;
        u.description = "I don't know a lot of english, but I always travel with someone who know it, so I don't have any kind of problem. If you know english and want to travel with me, let me check your desired destinations and we will see if we can go ;)";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Marco";
        u.surname="Zucckie";
        cal.set(1979,5,10);
        u.age = cal.getTime();
        u.status = statusSingle;
        u.country = countryUsa;
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
        u.status = statusMarried;
        u.country = countryIrl;
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
        u.status = statusRelantionship;
        u.country = countryIta;
        u.description = "I really like travel and, if it depends on me, I wuold do it every time I can. I'm looking for someone, more than one, why not, to suggest me and give me the opportunity to leave and take a long and refreshing voyage.";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Anna";
        u.surname="Smith";
        cal.set(1984,5,10);
        u.age = cal.getTime();
        u.status = statusSingle;
        u.country = countryUsa;
        u.description = "I live in Los Angeles and rigth now all I want to do is to travel away from this country and see the beauty of Europe! Contact me if you are ahead there too, or live there and you want to travel around.";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Jessica";
        u.surname="Plum";
        cal.set(1987,5,10);
        u.age = cal.getTime();
        u.status = statusSingle;
        u.country = countryUk;
        u.description = "I had travel a lot around England and I think it's time to change plances. I would like to travel where the sun is hot and it's easy to take some time outdoor without carrying of the rain or the wind. I'm more interested in european countries than asian or american.";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Scarlett";
        u.surname="Mustard";
        cal.set(1990,5,10);
        u.age = cal.getTime();
        u.status = statusSingle;
        u.country = countryUk;
        u.description = "I never travel out of my country: England. I would really love to take a trip to the rest of Europe and see our neighboors habits and culture. Also, I would really love to take a trip in the US too! Contact me if you are interested.";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Elizabeth";
        u.surname="Fourier";
        cal.set(1989,5,10);
        u.age = cal.getTime();
        u.status = statusSingle;
        u.country = countryFra;
        u.description = "I live in Paris and I've seen almost everything of these city, so do not ask me to take a trip here, please. I want to go around Asia or America but I would love to see some european cities as well.";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        u = new User();
        u.name="Betty";
        u.surname="Beatle";
        cal.set(1982,5,10);
        u.age = cal.getTime();
        u.status = statusSingle;
        u.country = countryUk;
        u.description = "I live in London and I travel a lot for work, but I never have time to visit the city! Recently, I have finally found time and money to make a good and satisfying trip. I go where yot want, just let me go!";
        destinations = cityManager.getRandomCities();
        for (City c:
                destinations) {
            u.destinations.add(c);
        }
        userBox.put(u);

        //utenti veri
        u = new User();
        u.name="Daniele";
        u.surname="Buonadonna";
        cal.set(1995,10,20);
        u.age = cal.getTime();
        u.status = statusRelantionship;
        u.country = countryIta;
        u.description = "";
        destinations = null;
        userBox.put(u);

        u = new User();
        u.name="Umberto";
        u.surname="di Canito";
        cal.set(1994,5,19);
        u.age = cal.getTime();
        u.status = statusRelantionship;
        u.country = countryIta;
        u.description = "";
        destinations = null;
        userBox.put(u);

        u = new User();
        u.name="Alessio";
        u.surname="Fiorenza";
        cal.set(1995,9,10);
        u.age = cal.getTime();
        u.status = statusRelantionship;
        u.country = countryIta;
        u.description = "";
        destinations = null;
        userBox.put(u);
    }

    public User getRealUser(String user){
        /*Nella pagina di profilo, se si clicca su "Terms"
        * si ha la possibilità di swicthare ad un altro user,
        * in questo caso uno tra "Daniele", "Alessio" o "Umberto"*/
        if(user.equals("Daniele"))
            return userBox.query().equal(User_.name, "Daniele").build().findFirst();
        if(user.equals("Alessio"))
            return userBox.query().equal(User_.name, "Alessio").build().findFirst();
        return userBox.query().equal(User_.name, "Umberto").build().findFirst();
    }

    public List<User> getUsersForCity(City city){
        /*Ritorna tutti gli utenti associati ad una città*/
        List<User> wantedUsers = new ArrayList<>();
        List<User> users = userBox.getAll();
        for(User u : users){
            if(u.destinations.contains(city))
                wantedUsers.add(u);
        }
        return wantedUsers;
    }

    public User getUser(String name, String surname){
        /*Get fake user from database, based on the complete name*/
        return userBox.query().equal(User_.name, name).equal(User_.surname, surname).build().findFirst();
    }

    public User changeDescription(User user, String newDesc){
        /*change the description parameter for the user selected*/
        user = userBox.get(user.id);
        user.setDescription(newDesc);
        userBox.remove(user.id);
        userBox.put(user);
        return user;
    }

    public void addDestination(User user, City city){
        if(!user.destinations.contains(city)){
            user = userBox.get(user.id);
            userBox.remove(user.id);
            user.destinations.add(city);
            userBox.put(user);
        }
    }

    public User addDestination(User user, List<City> cities){
        List<City> toBeActuallyAdded = new ArrayList<>();
        for(City c : cities){
            if(!user.destinations.contains(c))
                toBeActuallyAdded.add(c);
        }
        user = userBox.get(user.id);
        user.destinations.addAll(toBeActuallyAdded);
        userBox.put(user);
        return user;
    }

    public void removeDestination(User user, City city){
        if(!user.destinations.contains(city)){
            userBox.remove(user.id);
            user.destinations.remove(city);
            userBox.put(user);

        }
    }
}
