package com.nt.runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Artist;
import com.nt.service.IArtistMgmtService;

@Component
public class CrurdRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IArtistMgmtService artistService;

	@Override
	public void run(String... args) throws Exception {

		// Test Case 1: Register an Artist
		/* 
		Artist artist = new Artist("raja", "hero", 9900000.0);
		try {
			String msg = artistService.registerArtist(artist);
			System.out.println(msg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 2: Check if Artist ID is available
		/*
		try {
			System.out.println("Is artist with ID 15 available? " + artistService.checkArtistAvailability(15));
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 3: Show Artists Count
		/*
		try {
			System.out.println("Artist Count: " + artistService.showArtistsCount());
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 4: Register a Batch of Artists
		
		Artist artist1 = new Artist("rohith", "Hero", 4020210.0);
		Artist artist2 = new Artist("prathap", "Hero", 4020210.0);
		Artist artist3 = new Artist("rr", "Hero", 4020210.0);
		List<Artist> list = List.of(artist1, artist2, artist3);
		try {
			String msg = artistService.registerArtistBatch(list);
			System.out.println(msg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		

		// Test Case 5: Show All Artists
		/*
		try {
			Iterable<Artist> list = artistService.showAllArtist();
			list.forEach(art -> System.out.println(art));
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 6: Show Artists by IDs (Handles null safely)
		/*
		try {
			List<Integer> ids = new ArrayList<>(Arrays.asList(1, 2, 56, null));
			artistService.showArtistByIds(ids).forEach(System.out::println);
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 7: Show Artist by ID
		/*
		try {
			Optional<Artist> opt = artistService.showArtistById(1);
			if (opt.isPresent()) {
				Artist artist = opt.get();
				System.out.println("Artist Info: " + artist);
			} else {
				System.out.println("Artist not found");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 8: Fetch Artist by ID (Throws Exception if ID is not found)
		/*
		try {
			Artist artist = artistService.fetchArtistById(1);
			System.out.println(artist);
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 9: Register or Update an Artist
		/*
		try {
			Artist artist = new Artist(233, "Rohith", "Villain", 8900.0);
			String msg = artistService.registerOrUpdateArtist(artist);
			System.out.println(msg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 10: Hike Actor Fee by ID and Percentage
		/*
		try {
			String msg = artistService.hikeActorFeeByIdAndPercentage(152, 20.0);
			System.out.println(msg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 11: Remove Artist by ID
		/*
		try {
			System.out.println(artistService.removeArtistById(2));
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 12: Remove All Artists
		/*
		try {
			System.out.println(artistService.removeAllArtist());
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		// Test Case 13: Remove Artists by IDs with null value in list
		/*try {
			System.out.println("Artist count: " + artistService.removeArtistByIds(Arrays.asList(1, 2, null)));
		} catch(Exception e) {
			e.printStackTrace();
		}*/
	}
}
