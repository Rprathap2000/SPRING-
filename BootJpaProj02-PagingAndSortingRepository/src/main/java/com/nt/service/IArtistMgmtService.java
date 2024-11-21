package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Artist;

public interface IArtistMgmtService {
    public Iterable<Artist> showArtistSorting(boolean ascOrder, String... props);
    public Page<Artist> showArtistByPageNo(int pageNo,int pageSize);
    public void showArtistPageByPage(int pageSize,boolean ascOrder,String...props);
}
