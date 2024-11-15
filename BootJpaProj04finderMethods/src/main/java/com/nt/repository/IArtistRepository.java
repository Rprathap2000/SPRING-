package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.entity.Artist;

public interface IArtistRepository extends JpaRepository<Artist, Integer> 
{
	public List<Artist> findByCategoryEqualsI(String category);
	public List<Artist> findByCategoryEqualsIgnoreCase(String category);
	public List<Artist>readByCategory(String category);
	public List<Artist>getByCategory(String category);
	public List<Artist>findByAnameStartingWith(String initChars);
	public List<Artist>findByAnameEndingWith(String initChars);
	public List<Artist>findByAnameContaning(String chars);
	public List<Artist>findByAnameContaningIgnoreCase(String chars);
	public Iterable<Artist>findByAnameLike(String chars);
	
	public Iterable<Artist>findByFeeBetween(double start,double end);
	public Iterable<Artist>findByCategoryIn(List<String>categoeies);
	public Iterable<Artist>readByCategoryIn(String...categories);
	public Iterable<Artist>readByCategoryAsc(String...categories);
	public Iterable<Artist>readBycategoryInOrderByAnameAsc(String...categories);

}
