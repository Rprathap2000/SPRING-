package com.nt.service;

import java.util.List;

import com.nt.entity.Artist;

public interface IArtistMgmtService {
	public List<Artist> showArtistByFeeRange(double start,double end)throws Exception;

}
