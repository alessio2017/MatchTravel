package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Nullable;

import datadb.User;
import matchtravel.com.matchtravel.HelpActivity;
import matchtravel.com.matchtravel.ProfileNotOwn;
import matchtravel.com.matchtravel.R;
import objectBoxUtility.ObjectBox;
import objectBoxUtility.UserManager;

public class ProfileOwnFragment extends Fragment {

    private TextView privacy_own;

    private TextView ageOwn;
    private TextView stateOwn;
    private TextView nationOwn;
    private TextView nameOwn;
    private TextView descriptionOwn;

    private User currentUser;
    private UserManager userManager;
    private Context context;
    private View layout;

    OnChangeCurrentUserListener callback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_own, container, false);
        this.layout = view;
        this.userManager = new UserManager(ObjectBox.get());
        this.context = getContext();

        TextView edit_btn = view.findViewById(R.id.edit);
        privacy_own = view.findViewById(R.id.privacy_own);

        ageOwn = view.findViewById(R.id.ageown);
        stateOwn = view.findViewById(R.id.stateown);
        nationOwn = view.findViewById(R.id.nationown);
        nameOwn = view.findViewById(R.id.txt_name);
        descriptionOwn = view.findViewById(R.id.edit_own);

        Button editDone = view.findViewById(R.id.edit_btn_done);
        Button editCancel = view.findViewById(R.id.edit_btn_cancel);


        Button terms = view.findViewById(R.id.terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), ProfileNotOwn.class);
                myIntent.putExtra("name", "Mark");
                myIntent.putExtra("surname", "Huffman");
                startActivity(myIntent);
            }
        });

        editDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editBox = layout.findViewById(R.id.actual_edit_description_box);
                String newDescription = editBox.getText().toString();
                currentUser = userManager.changeDescription(currentUser, newDescription);
                callback.onUserSelected(currentUser);
                updateView();
                layout.findViewById(R.id.edit_container).setVisibility(View.GONE);
            }
        });

        editCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.findViewById(R.id.edit_container).setVisibility(View.GONE);
            }
        });

        updateView();

        edit_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                View editContainer = layout.findViewById(R.id.edit_container);
                if(editContainer.getVisibility() == View.GONE) {
                    editContainer.setVisibility(View.VISIBLE);
                    ((EditText)editContainer.findViewById(R.id.actual_edit_description_box)).setText(currentUser.description);
                }
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
                        //retrieve desired user
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
                        switch (user.getName()) {
                            case "Daniele":
                                newId = 0;
                                break;
                            case "Alessio":
                                newId = 1;
                                break;
                            default:
                                newId = 2;
                                break;
                        }

                        if(newId != currentUserId){
                            //the activity now have the new current user
                            callback.onUserSelected(user);
                            setCurrentUser(user);
                            //the sharedPreferences are updated
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putInt(context.getString(R.string.sharedPref_current_user), newId);
                            editor.apply();

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

        Button help = view.findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HelpActivity.class);
                startActivity(intent);
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
                if(description!=null && !description.equals(""))
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
