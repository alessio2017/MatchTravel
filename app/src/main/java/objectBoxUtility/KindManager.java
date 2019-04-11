package objectBoxUtility;

import datadb.Kind;
import io.objectbox.Box;
import io.objectbox.BoxStore;

public class KindManager {

    final private String SEA = "sea";
    final private String MOU = "mountain";
    final private String ART = "art";
    final private String FOO = "food";
    final private String ROM = "romantic";

    private Box<Kind> kindBox;
    private boolean alreadyInit = false;

    public KindManager(BoxStore boxStore){
        this.kindBox = boxStore.boxFor(Kind.class);
    }

    public void init(){
        if(!alreadyInit){
            Kind kind;
            for(int i = 0; i < 5; i++){
                kind = new Kind();
                if(i == 0)
                    kind.kind = SEA;
                else if(i == 1)
                    kind.kind = MOU;
                else if(i == 2)
                    kind.kind = ART;
                else if(i == 3)
                    kind.kind = FOO;
                else
                    kind.kind = ROM;
                kindBox.put(kind);
            }
            alreadyInit = true;
        }
    }

    public Kind getKind(int kind){
        if(kind<5)
            return kindBox.get(kind + 1);
        else
            return null;
    }

    public Kind getKind(String kind){
        if(kind.toLowerCase().equals(SEA))
            return getKind(0);
        if(kind.toLowerCase().equals(MOU))
            return getKind(1);
        if(kind.toLowerCase().equals(ART))
            return getKind(2);
        if(kind.toLowerCase().equals(FOO))
            return getKind(3);
        if(kind.toLowerCase().equals(ROM))
            return getKind(4);
        return null;
    }
}
