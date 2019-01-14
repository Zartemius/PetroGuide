package com.example.darte.petroguide.presenter.data.clouddatabase;

import com.example.darte.petroguide.presenter.domain.model.Place;
import com.example.darte.petroguide.presenter.domain.repositories.CloudRepository;
import com.google.firebase.firestore.*;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class PlacesCloudDb implements CloudRepository {

    private String collectionPath = "places";
    private CollectionReference mPlacesCollection = FireStoreDb.getInstance().collection(collectionPath);

    @Override
    public Single<List<Place>> getPlaces() {
        return Single.create(new SingleOnSubscribe<List<Place>>() {
            @Override
            public void subscribe(final SingleEmitter<List<Place>> emitter) throws Exception {
                mPlacesCollection.addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        List<Place> places = new ArrayList<>();
                        if(queryDocumentSnapshots != null) {
                            for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                                places.add(doc.toObject(Place.class));
                            }
                            emitter.onSuccess(places);
                        }
                    }
                });
            }
        }).subscribeOn(Schedulers.io());
    }
}
