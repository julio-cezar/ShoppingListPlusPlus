package com.maracujasoftware.shoppinglistplusplus.ui.activeLists;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.maracujasoftware.shoppinglistplusplus.R;
import com.maracujasoftware.shoppinglistplusplus.model.ShoppingList;
import com.maracujasoftware.shoppinglistplusplus.ui.activeListDetails.ActiveListDetailsActivity;
import com.maracujasoftware.shoppinglistplusplus.utils.Constants;
import com.maracujasoftware.shoppinglistplusplus.utils.Utils;

import java.util.Date;


public class ShoppingListsFragment extends Fragment {
    private String mEncodedEmail;
    //private ActiveListAdapter mActiveListAdapter;
    private ActiveListAdapter mActiveListAdapter;
    private ListView mListView;

    public ShoppingListsFragment() {
        // Required empty public constructor
    }


    /**
     * Create fragment and pass bundle with data as it's arguments
     * Right now there are not arguments...but eventually there will be.
     */
    public static ShoppingListsFragment newInstance() {
        ShoppingListsFragment fragment = new ShoppingListsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * Initialize UI elements
         */
        View rootView = inflater.inflate(R.layout.fragment_shopping_lists, container, false);
        initializeScreen(rootView);

        DatabaseReference activeListsRef  = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_LOCATION_ACTIVE_LISTS);
        mActiveListAdapter = new ActiveListAdapter(getActivity(),ShoppingList.class,R.layout.single_active_list, activeListsRef);
        mListView.setAdapter(mActiveListAdapter);


        /**
         * Set interactive bits, such as click events and adapters
         */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               ShoppingList selectedList = mActiveListAdapter.getItem(position);
               if (selectedList != null) {
                    Intent intent = new Intent(getActivity(), ActiveListDetailsActivity.class);

                    String listId = mActiveListAdapter.getRef(position).getKey();
                    intent.putExtra(Constants.KEY_LIST_ID, listId);
                    startActivity(intent);
                }
            }
        });



        return rootView;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mActiveListAdapter.cleanup();
    }

    /**
     * Link list view from XML
     */
    private void initializeScreen(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.list_view_active_lists);

    }
}