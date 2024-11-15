package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.entity.Artist;
import com.nt.repository.IArtistRepository;

@Service("artistService")
public class ArtistMgmtServiceImp implements IArtistMgmtService {

    @Autowired
    private IArtistRepository artistRepo;

    @Override
    public String removeArtistByIdInBatch(List<Integer> ids) {
        // Load objects by IDs
        List<Artist> list = artistRepo.findAllById(ids);
        // Delete objects by IDs in batch processing
        artistRepo.deleteAllByIdInBatch(ids);

        return list.size() + " records are deleted";
    }

    @Override
    public List<Artist> searchArtistByGivenData(String name, double income) {
        // Prepare Example object to use for querying
        Artist artist = new Artist();
        artist.setAname(name);
        artist.setFee(income);

        Example<Artist> example = Example.of(artist);
        // Return the list of artists matching the example
        return artistRepo.findAll(example);
    }

	@Override
	public Optional<Artist> fetchArtistById(int id) {
		
		return artistRepo.findById(id);
	}

	@Override
	public Artist LoadArtistById(int id) {
		
		return artistRepo.getReferenceById(id);
	}

}
