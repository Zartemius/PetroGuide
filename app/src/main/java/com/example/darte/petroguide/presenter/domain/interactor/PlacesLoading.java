package com.example.darte.petroguide.presenter.domain.interactor;

import com.example.darte.petroguide.presenter.domain.model.Place;
import com.example.darte.petroguide.presenter.domain.repositories.AppRepository;
import io.reactivex.Single;
import javax.inject.Inject;
import java.util.List;

public class PlacesLoading {

    private AppRepository mAppRepository;

    @Inject
    public PlacesLoading(AppRepository appRepository){
        mAppRepository = appRepository;
    }

    public Single<List<Place>> getPlaces(){
        return mAppRepository.getPlaces();
    }

    public Single<Place> getCertainPlace(String id){
        return mAppRepository.getPlace(id);
    }
}
