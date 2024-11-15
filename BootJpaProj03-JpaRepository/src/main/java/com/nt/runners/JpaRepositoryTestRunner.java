package com.nt.runners;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nt.entity.Artist;
import com.nt.service.IArtistMgmtService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(JpaRepositoryTestRunner.class);

    @Autowired
    private IArtistMgmtService artistService;

    @Override
    public void run(String... args) throws Exception {
        try {
            List<Artist> list = artistService.searchArtistByGivenData("rohith", 900.0);
            list.forEach(System.out::println);
        } catch (Exception e) {
            logger.error("An error occurred while fetching artists", e);
        }
    	try
    	{
    		Optional<Artist> opt = artistService.fetchArtistById(3);
    		artistService.fetchArtistById(1);
    		if(opt.isEmpty())
    		{
    			System.out.println("Artist is not found");
    		}
    		else
    		{
    			System.out.println("Artist  found "+opt.get());
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		
    	}
    	System.out.println("----------------------------");
    	try
    	{
    		Artist proxy=artistService.LoadArtistById(3);
    		System.out.println("Proxy object class name ::"+proxy.getClass()+" super class "+proxy.getClass().getSuperclass());
    		
    		System.out.println(proxy.getAid());
    		System.out.println(proxy.getAname());
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
