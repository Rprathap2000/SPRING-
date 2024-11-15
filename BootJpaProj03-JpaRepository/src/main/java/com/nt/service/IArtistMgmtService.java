package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Artist;

public interface IArtistMgmtService {
    public String removeArtistByIdInBatch(List<Integer> id);
    public List<Artist> searchArtistByGivenData(String name, double income);
    public Optional<Artist> fetchArtistById(int id);
    public Artist LoadArtistById(int id);
}
