package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.nt.repository.IArtistRepository;

@Component
public class FindermethodTestRunners implements CommandLineRunner {
   @Autowired
    private IArtistRepository artistRepo;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(artistRepo.getClass() + "...." + artistRepo.getClass().getSuperclass() + "...." + Arrays.toString(artistRepo.getClass().getDeclaredMethods()));

        artistRepo.findByCategoryEqualsI("Hero").forEach(System.out::println);
        System.out.println("----------------");
        artistRepo.findByCategoryEqualsIgnoreCase("Hero").forEach(System.out::println);
        System.out.println("----------------");
        artistRepo.readByCategory("Hero").forEach(System.out::println);
        System.out.println("-----------------");
        artistRepo.getByCategory("Hero").forEach(System.out::println);

        artistRepo.findByAnameStartingWith("r").forEach(System.out::println);
        System.out.println("----------------");
        artistRepo.findByAnameEndingWith("sh").forEach(System.out::println);
        System.out.println("----------------");
        artistRepo.findByAnameContaning("m").forEach(System.out::println);
        System.out.println("-----------------");
        artistRepo.findByAnameContaningIgnoreCase("m").forEach(System.out::println);
        System.out.println("-----------------");
        artistRepo.findByAnameLike("r%").forEach(System.out::println); // Starting with
        artistRepo.findByAnameLike("%r").forEach(System.out::println); // Ending with
        artistRepo.findByAnameLike("%r%").forEach(System.out::println); // Containing
        artistRepo.findByAnameLike("r%").forEach(System.out::println);

        artistRepo.findByFeeBetween(10000.0, 200000.0).forEach(System.out::println);
        System.out.println("-----------------");
        artistRepo.findByCategoryIn(List.of("Hero", "Villian", "comedian")).forEach(System.out::println);
        System.out.println("-----------------");
        artistRepo.readByCategoryIn("Hero", "Villian", "comedian").forEach(System.out::println);
        System.out.println("-----------------");
        artistRepo.readByCategoryAsc("Hero", "Villian", "comedian").forEach(System.out::println);
        System.out.println("-----------------");
        artistRepo.readBycategoryInOrderByAnameAsc("hero", "Commedian").forEach(System.out::println);
    } // run
} // class
