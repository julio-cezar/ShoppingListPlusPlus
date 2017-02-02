package com.maracujasoftware.shoppinglistplusplus;


import com.google.firebase.database.FirebaseDatabase;

/**
 * Includes one-time initialization of Firebase related code
 */
public class ShoppingListApplication extends android.app.Application {

    @Override
    public void onCreate() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}