package com.maracujasoftware.shoppinglistplusplus.ui.activeLists;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.maracujasoftware.shoppinglistplusplus.R;
import com.maracujasoftware.shoppinglistplusplus.model.ShoppingList;
import com.maracujasoftware.shoppinglistplusplus.utils.Constants;

import java.util.HashMap;

/**
 * Adds a new shopping list
 */
public class AddListDialogFragment extends DialogFragment {
    String mEncodedEmail;
    EditText mEditTextListName;

   // private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener authStateListener;


    /**
     * Public static constructor that creates fragment and
     * passes a bundle with data into it when adapter is created
     */
    public static AddListDialogFragment newInstance(String encodedEmail) {
        AddListDialogFragment addListDialogFragment = new AddListDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ENCODED_EMAIL, encodedEmail);
        addListDialogFragment.setArguments(bundle);
        return addListDialogFragment;
    }


    /**
     * Initialize instance variables with data from bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEncodedEmail = getArguments().getString(Constants.KEY_ENCODED_EMAIL);

       /* mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(authStateListener);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() == null) {
                   Intent intent = new Intent(AddListDialogFragment.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getActivity(), "Sig in first",Toast.LENGTH_SHORT).show();
                }
            }
        };*/
    }

    /**
     * Open the keyboard automatically when the dialog fragment is opened
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomTheme_Dialog);
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.dialog_add_list, null);
        mEditTextListName = (EditText) rootView.findViewById(R.id.edit_text_list_name);

        /**
         * Call addShoppingList() when user taps "Done" keyboard action
         */
        mEditTextListName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE || keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    addShoppingList();
                }
                return true;
            }
        });

        /* Inflate and set the layout for the dialog */
        /* Pass null as the parent view because its going in the dialog layout*/
        builder.setView(rootView)
                /* Add action buttons */
                .setPositiveButton(R.string.positive_button_create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addShoppingList();
                    }
                });

        return builder.create();
    }

    /**
     * Add new active list
     */
    public void addShoppingList() {

        //mRef.child("users").child(mAuth.getCurrentUser().getUid()).child("pontos").setValue(userEnteredName);
        //DatabaseReference mRef;
        //mRef = FirebaseDatabase.getInstance().getReference();
        String userEnteredName = mEditTextListName.getText().toString();

        //ShoppingList currentList = new ShoppingList(userEnteredName, owner);
        //mRef.child(Constants.FIREBASE_LOCATION_ACTIVE_LIST).setValue(currentList);

        if (!userEnteredName.equals("")) {

            /**
             * Create Firebase references
             */
            DatabaseReference listsRef = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_LOCATION_ACTIVE_LISTS);
            DatabaseReference newListRef = listsRef.push();

            /* Save listsRef.push() to maintain same random Id */
            final String listId = newListRef.getKey();

            /**
             * Set raw version of date to the ServerValue.TIMESTAMP value and save into
             * timestampCreatedMap
             */
            HashMap<String, Object> timestampCreated = new HashMap<>();
            timestampCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);

            /* Build the shopping list */
            ShoppingList newShoppingList = new ShoppingList(userEnteredName, mEncodedEmail,
                    timestampCreated);

            /* Add the shopping list */
            newListRef.setValue(newShoppingList);

            /* Close the dialog fragment */
            AddListDialogFragment.this.getDialog().cancel();
        }


        /**
         * If EditText input is not empty
         */
       /* if (!userEnteredName.equals("")) {

            /**
             * Create Firebase references
             */
           /*
           Firebase userListsRef = new Firebase(Constants.FIREBASE_URL_USER_LISTS).

                    child(mEncodedEmail);
            final Firebase firebaseRef = new Firebase(Constants.FIREBASE_URL);

            Firebase newListRef = userListsRef.push();
            */

            /* Save listsRef.push() to maintain same random Id */
            //final String listId = newListRef.getKey();

            /* HashMap for data to update */
           // HashMap<String, Object> updateShoppingListData = new HashMap<>();

            /**
             * Set raw version of date to the ServerValue.TIMESTAMP value and save into
             * timestampCreatedMap
             */
          //  HashMap<String, Object> timestampCreated = new HashMap<>();
            //timestampCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);

            /* Build the shopping list */
            //ShoppingList newShoppingList = new ShoppingList(userEnteredName, mEncodedEmail,
                 //   timestampCreated);

           // HashMap<String, Object> shoppingListMap = (HashMap<String, Object>)
             //       new ObjectMapper().convertValue(newShoppingList, Map.class);

           // Utils.updateMapForAllWithValue(null, listId, mEncodedEmail,
              //      updateShoppingListData, "", shoppingListMap);

           // updateShoppingListData.put("/" + Constants.FIREBASE_LOCATION_OWNER_MAPPINGS + "/" + listId,
             //       mEncodedEmail);

            /* Do the update */
           // firebaseRef.updateChildren(updateShoppingListData, new Firebase.CompletionListener() {
             //   @Override
               // public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                    /* Now that we have the timestamp, update the reversed timestamp */
                 //   Utils.updateTimestampReversed(firebaseError, "AddList", listId,
                   //         null, mEncodedEmail);
                //}
            //});

            /* Close the dialog fragment */
       // }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //adapter.cleanup();

       /* if (authStateListener != null) {
            mAuth.removeAuthStateListener(authStateListener);
        }*/
    }
}

