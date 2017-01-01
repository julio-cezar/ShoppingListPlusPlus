package com.maracujasoftware.shoppinglistplusplus.ui.sharing;

import android.app.Activity;
import android.view.View;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.maracujasoftware.shoppinglistplusplus.model.FireUser;

/**
 * Populates the list_view_friends_autocomplete inside AddFriendActivity
 */
public class AutocompleteFriendAdapter extends FirebaseListAdapter<FireUser> {

    /**
     * Public constructor that initializes private instance variables when adapter is created
     */
    public AutocompleteFriendAdapter(Activity activity, Class<FireUser> modelClass, int modelLayout,
                                     Query ref) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity = activity;
    }


    /**
     * Protected method that populates the view attached to the adapter (list_view_friends_autocomplete)
     * with items inflated from single_autocomplete_item.xml
     * populateView also handles data changes and updates the listView accordingly
     */
    @Override
    protected void populateView(View view,final FireUser model, int position) {

    }

    /** Checks if the friend you try to add is the current user **/
    private boolean isNotCurrentUser(FireUser user) {
        return true;
    }

    /** Checks if the friend you try to add is already added, given a dataSnapshot of a user **/
    private boolean isNotAlreadyAdded(DataSnapshot dataSnapshot, FireUser user) {
        return true;
    }

}