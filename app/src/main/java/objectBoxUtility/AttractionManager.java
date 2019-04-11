package objectBoxUtility;


import datadb.Attraction;
import io.objectbox.Box;
import io.objectbox.BoxStore;

public class AttractionManager {

    final private String RELAX = "relax";
    final private String ADVEN = "adventure";
    final private String MUSEU = "museum";
    final private String NIGHT = "night";

    private Box<Attraction> attractionBox;
    private boolean alreadyInit = false;

    public AttractionManager(BoxStore boxStore){
        this.attractionBox = boxStore.boxFor(Attraction.class);
    }

    public void init(){
        if(!alreadyInit){
            Attraction attraction;
            for(int i = 0; i<4; i++){
                attraction = new Attraction();
                if(i == 0)
                    attraction.attraction = RELAX;
                else if(i == 1)
                    attraction.attraction = ADVEN;
                else if(i == 2)
                    attraction.attraction = MUSEU;
                else
                    attraction.attraction = NIGHT;

                attractionBox.put(attraction);

            }
            alreadyInit = true;
        }
    }

    public Attraction getAttraction(int attraction){
        if(attraction < 4)
            return attractionBox.get(attraction + 1);
        return null;
    }

    public Attraction getAttraction(String attraction){
        if(attraction.toLowerCase().equals(RELAX))
            return getAttraction(0);
        if(attraction.toLowerCase().equals(ADVEN))
            return getAttraction(1);
        if(attraction.toLowerCase().equals(MUSEU))
            return getAttraction(2);
        if(attraction.toLowerCase().equals(NIGHT))
            return getAttraction(3);
        return null;

    }
}
