package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Artist;
import com.nt.repository.IArtistRepository;

@Service("artistService")
public class ArtistMgmtServiceImp implements IArtistMgmtService {

    @Autowired
    private IArtistRepository artistRepo;

    @Override
    public String registerArtist(Artist artist) {
        Artist savedArtist = artistRepo.save(artist);
        return savedArtist.getAid() == null ? "Artist not saved" : "Artist saved";
    }

    @Override
    public boolean checkArtistAvailability(int id) {
        return artistRepo.existsById(id);
    }

    @Override
    public long showArtistsCount() {
        return artistRepo.count();
    }

    @Override
    public String registerArtistBatch(List<Artist> list) {
        Iterable<Artist> savedList = artistRepo.saveAll(list);
        List<Integer> ids = StreamSupport.stream(savedList.spliterator(), false)
                                         .map(Artist::getAid)
                                         .collect(Collectors.toList());
        return ids.size() + " artist(s) registered with IDs: " + ids;
    }

    @Override
    public List<Artist> showAllArtist() {
        Iterable<Artist> list = artistRepo.findAll();
        return (List<Artist>) list;
    }

    @Override
    public Iterable<Artist> showArtistByIds(Iterable<Integer> ids) {
        List<Integer> nonNullIds = new ArrayList<>();
        ids.forEach(id -> {
            if (id != null) nonNullIds.add(id);
        });
        return artistRepo.findAllById(nonNullIds);
    }

    @Override
    public Optional<Artist> showArtistById(int id) {
        return artistRepo.findById(id);
    }

    @Override
    public String getArtistById(int id) {
        return artistRepo.findById(id).map(Object::toString).orElse("Artist not found");
    }

    @Override
    public Artist fetchArtistById(int id) {
        return artistRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
    }

    @Override
    public String registerOrUpdateArtist(Artist artist) {
        artistRepo.save(artist);
        return artistRepo.existsById(artist.getAid()) ? artist.getAname() + " updated" : artist.getAname() + " registered";
    }

    @Override
    public String hikeActorFeeByIdAndPercentage(int id, double percentage) {
        return artistRepo.findById(id).map(artist -> {
            artist.setFee(artist.getFee() + (artist.getFee() * percentage / 100.0));
            artistRepo.save(artist);
            return "Artist updated";
        }).orElse("Artist not found");
    }

    @Override
    public String removeArtistById(int id) {
        return artistRepo.findById(id).map(artist -> {
            artistRepo.deleteById(id);
            return "Artist deleted";
        }).orElse("Artist not found");
    }

    @Override
    public String removeAllArtist() {
        long count = artistRepo.count();
        artistRepo.deleteAll();
        return count + " artist(s) deleted";
    }

    @Override
    public String removeArtistByIds(Iterable<Integer> ids) {
        List<Integer> nonNullIds = new ArrayList<>();
        ids.forEach(id -> {
            if (id != null) nonNullIds.add(id);
        });

        if (nonNullIds.isEmpty()) {
            return "No valid artist IDs provided for deletion.";
        }

        Iterable<Artist> list = artistRepo.findAllById(nonNullIds);
        long count = StreamSupport.stream(list.spliterator(), false).count();
        artistRepo.deleteAllById(nonNullIds);
        return count + " artist(s) deleted.";
    }
}
