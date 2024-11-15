package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Artist;
import com.nt.repository.IArtistRepository;

@Service("artistService")
public class ArtistMgmtServiceImp implements IArtistMgmtService {

    @Autowired
    private IArtistRepository artistRepo;

    @Override
    public Iterable<Artist> showArtistSorting(boolean ascOrder, String... props) {
        // Prepare the sort object
        Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, props);
        
        // Invoke the method with sorting
        return artistRepo.findAll(sort);
    }

    @Override
    public Page<Artist> showArtistByPageNo(int pageNo, int pageSize) {
        // Validate pageSize to avoid division by zero
        if (pageSize <= 0) {
            throw new IllegalArgumentException("Page size must be greater than zero.");
        }

        // Prepare Pageable object with inputs
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        // Call the method
        return artistRepo.findAll(pageable);
    }

    @Override
    public void showArtistPageByPage(int pageSize, boolean ascOrder, String... props) {
        // Validate pageSize to avoid division by zero
        if (pageSize <= 0) {
            throw new IllegalArgumentException("Page size must be greater than zero.");
        }

        // Get record count
        long count = artistRepo.count();
        
        // Calculate number of pages
        long pagesCount = count / pageSize;
        if (count % pageSize != 0) {
            pagesCount++;
        }

        // Prepare sort object
        Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, props);

        // Loop through all pages
        for (int i = 0; i < pagesCount; i++) {
            // Prepare Pageable object for each page
            Pageable pageable = PageRequest.of(i, pageSize, sort);
            // Get each page's records
            Page<Artist> page = artistRepo.findAll(pageable);
            
            // Display each page's records
            page.forEach(System.out::println);
            
            // Correctly print page number and total pages
            System.out.println("--------- Page " + (page.getNumber() + 1) + " of " + page.getTotalPages() + " -----------");
        }
    }
}
