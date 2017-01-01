package com.maracujasoftware.shoppinglistplusplus.ui.sharing;

import android.app.Activity;
import android.view.View;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.maracujasoftware.shoppinglistplusplus.model.FireUser;
import com.maracujasoftware.shoppinglistplusplus.model.ShoppingList;

import java.util.HashMap;

/**
 * Populates the list_view_friends_share inside ShareListActivity
 */
public class FriendAdapter extends FirebaseListAdapter<FireUser> {
    private static final String LOG_TAG = FriendAdapter.class.getSimpleName();
    private HashMap <DatabaseReference, ValueEventListener> mLocationListenerMap;


    /**
     * Public constructor that initializes private instance variables when adapter is created
     */
    public FriendAdapter(Activity activity, Class<FireUser> modelClass, int modelLayout,
                         Query ref) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity = activity;
    }

    /**
     * Protected method that populates the view attached to the adapter (list_view_friends_autocomplete)
     * with items inflated from single_user_item.xml
     * populateView also handles data changes and updates the listView accordingly
     */
    @Override
    protected void populateView(View view, final FireUser friend, int position) {

    }

    /**
     * Public method that is used to pass ShoppingList object when it is loaded in ValueEventListener
     */
    public void setShoppingList(ShoppingList shoppingList) {

    }

    /**
     * Public method that is used to pass SharedUsers when they are loaded in ValueEventListener
     */
    public void setSharedWithUsers(HashMap<String, FireUser> sharedUsersList) {

    }


    /**
     * This method does the tricky job of adding or removing a friend from the sharedWith list.
     * @param addFriend This is true if the friend is being added, false is the friend is being removed.
     * @param friendToAddOrRemove This is the friend to either add or remove
     * @return
     */
    private HashMap<String, Object> updateFriendInSharedWith(Boolean addFriend, FireUser friendToAddOrRemove) {
        return null;
    }

    @Override
    public void cleanup() {
        super.cleanup();
    }
}