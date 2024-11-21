package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.entity.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

public class ArtistMgmtServiceImpl implements IArtistMgmtService {
@Autowired
private EntityManager manager;
/*
  CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_ARTIST_BY_FEE`(in start float,in end float)
BEGIN
	select * from artist_info where fee>=start and fee<=end;
    
END
 */

	@Override
	public List<Artist> showArtistByFeeRange(double start, double end) throws Exception {
		//create storedProcedureQuery object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_ARTIST_BY_FEE",Artist.class);
		//register the params
		query.registerStoredProcedureParameter(1, Float.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Float.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Object.class,ParameterMode.REF_CURSOR);
		//set the value to IN params
		query.setParameter(1, start);
		query.setParameter(2, end);
		//call the PL/SQL procedure
		List<Artist> list=query.getResultList();
	
		return list;
	}

}
