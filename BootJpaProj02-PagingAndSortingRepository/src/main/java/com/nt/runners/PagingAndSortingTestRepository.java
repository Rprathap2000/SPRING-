package com.nt.runners;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Artist;
import com.nt.service.IArtistMgmtService;

@Component
public class PagingAndSortingTestRepository implements CommandLineRunner {
	@Autowired
	private IArtistMgmtService  artistService;

	@Override
	public void run(String... args) throws Exception {
		/*try {
//			artistService.showArtistSorting(true, "aname","aid").forEach(System.out::println);
			artistService.showArtistSorting(true, "fee","aid").forEach(System.out::println);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		/*try
		{
			Page<Artist>page=artistService.showArtistByPageNo(0,3);
			//get connect of the page
			List<Artist>list=page.getContent();
			list.forEach(System.out::println);
			System.out.println("------------------");
			System.out.println("current page no:"+page.getNumber());
			System.out.println("page size:"+page.getSize());
			System.out.println("total no.of pages::"+page.getTotalPages());
			System.out.println("total number of  records on the current pages::"+page.getNumberOfElements());
			System.out.println("is the current pagen is first page:"+page.isFirst());
			System.out.println("is the current pagen is last page:"+page.isLast());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		 try {
	            int pageSize = 3; // Make sure this is a valid positive number
	            artistService.showArtistPageByPage(pageSize, true, "aname");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
