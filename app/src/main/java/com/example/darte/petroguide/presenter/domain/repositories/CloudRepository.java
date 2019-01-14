package com.example.darte.petroguide.presenter.domain.repositories;

import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.Single;
import java.util.List;

public interface CloudRepository {

    Single<List<Place>> getPlaces();
}
