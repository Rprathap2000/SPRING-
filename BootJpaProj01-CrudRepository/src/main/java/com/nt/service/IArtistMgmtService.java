package com.nt.service;

import java.util.List;
import java.util.Optional;
import com.nt.entity.Artist;

public interface IArtistMgmtService {
    String registerArtist(Artist artist);
    boolean checkArtistAvailability(int id);
    long showArtistsCount();
    String registerArtistBatch(List<Artist> list);
    Iterable<Artist> showAllArtist();
    Iterable<Artist> showArtistByIds(Iterable<Integer> ids);
    Optional<Artist> showArtistById(int id);
    String getArtistById(int id);
    Artist fetchArtistById(int id);
    String registerOrUpdateArtist(Artist artist);
    String hikeActorFeeByIdAndPercentage(int id, double percentage);
    String removeArtistById(int id);
    String removeAllArtist();
    String removeArtistByIds(Iterable<Integer> ids);
}
