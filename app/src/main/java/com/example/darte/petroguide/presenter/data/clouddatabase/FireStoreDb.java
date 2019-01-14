package com.example.darte.petroguide.presenter.data.clouddatabase;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class FireStoreDb {

    public static FirebaseFirestore getInstance(){
        FirebaseFirestore dbInstance = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings =
                new FirebaseFirestoreSettings.Builder().setTimestampsInSnapshotsEnabled(true)
                        .build();

        dbInstance.setFirestoreSettings(settings);
        return dbInstance;
    }
}
