package fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Nullable;

import datadb.User;
import matchtravel.com.matchtravel.R;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.UserManager;

public class ProfileOwnFragment extends Fragment {
    private ImageView facebook;
    private ImageView mail;
    private ImageView instagram;

    private TextView edit_btn;
    private TextView terms;
    private TextView privacy_own;

    private TextView ageOwn;
    private TextView stateOwn;
    private TextView nationOwn;
    private TextView nameOwn;
    private EditText descriptionOwn;

    private User currentUser;
    private UserManager userManager;
    private Context context;
    private View layout;

    OnChangeCurrentUserListener callback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.layout = inflater.inflate(R.layout.fragment_profile_own, container, false);
        View view = layout;
        this.userManager = new UserManager(ObjectBox.get());
        this.context = getContext();

        facebook = (ImageView) view.findViewById(R.id.facebook);
        mail = (ImageView) view.findViewById(R.id.mail);
        instagram = (ImageView) view.findViewById(R.id.instagram);

        edit_btn = (TextView) view.findViewById(R.id.edit);
        terms = (TextView) view.findViewById(R.id.terms);
        privacy_own = (TextView) view.findViewById(R.id.privacy_own);

        ageOwn = (TextView) view.findViewById(R.id.ageown);
        stateOwn = (TextView) view.findViewById(R.id.stateown);
        nationOwn = (TextView) view.findViewById(R.id.nationown);
        nameOwn = (TextView) view.findViewById(R.id.txt_name);
        descriptionOwn = view.findViewById(R.id.edit_own);
        descriptionOwn.setClickable(false);

        updateView();

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
        edit_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //descriptionOwn.setClickable(true);
                //TODO: Come fare per cambiare descrizione?
                /*
                String newDescription = ?
                userManager.changeDescription(currentUser, newDescription);
                 */
            }
        });

        privacy_own.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //creating and inflating popup menu to change current user
                PopupMenu popup = new PopupMenu(getContext(), privacy_own);
                popup.getMenuInflater().inflate(R.menu.popup_current_user, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        //retrieve desidered user
                        User user = userManager.getRealUser("" + item.getTitle());
                        //retrieve shared preference
                        SharedPreferences sharedPreferences = context.
                                getSharedPreferences(getString(R.string.sharedPref_file),
                                        Context.MODE_PRIVATE);
                        //retrieve current user
                        int currentUserId = sharedPreferences.getInt(
                                getString(R.string.sharedPref_current_user),
                                0);
                        //update current user
                        int newId;
                        if(user.getName().equals("Daniele"))
                            newId = 0;
                        else if(user.getName().equals("Alessio"))
                            newId = 1;
                        else
                            newId = 2;

                        if(newId != currentUserId){
                            //the activity now have the new current user
                            callback.onUserSelected(user);
                            setCurrentUser(user);
                            //the sharedPreferences are updated
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putInt(context.getString(R.string.sharedPref_current_user), newId);
                            editor.commit();

                            Log.i("CAMBIO PROFILO", "RIUSCITO");
                        }
                        else
                            Log.i("CAMBIO PROFILO", "NESSUN CAMBIO. PROFILO GIA' MEMORIZZATO");

                        return true;
                    }
                });

                popup.show();
            }
        });

        return view;
    }

    public void setCurrentUser(User user){
        if(user!=null)
            this.currentUser = user;
        updateView();
    }

    /*interfaccia necessaria per comunicare all'activity del cambio di utente*/
    public interface OnChangeCurrentUserListener{
        void onUserSelected(User user);
    }
    /*metodo di utility dell'interfaccia*/
    public void setOnChangeCurrentUserListener(OnChangeCurrentUserListener listener){
        this.callback = listener;
    }

    private void updateView(){
        try{
            if(currentUser!=null){
                String name = currentUser.getName() + "\n" + currentUser.getSurname();
                String age = Integer.toString(calculateAge(currentUser.getAge())) + " yo";
                String status = currentUser.getStatus();
                String country = currentUser.getCountry();
                String description = currentUser.getDescription();
                String defaultDesc = "Press 'Edit' and type something about yourself.";

                nameOwn.setText(name);
                ageOwn.setText(age);
                stateOwn.setText(status);
                nationOwn.setText(country);
                if(description!=null)
                    descriptionOwn.setText(description);
                else
                    descriptionOwn.setText(defaultDesc);

                //TODO: settare immagine
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private int calculateAge(Date age) {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        cal.setTime(age);
        int userYear = cal.get(Calendar.YEAR);
        return currentYear - userYear;
    }
}
