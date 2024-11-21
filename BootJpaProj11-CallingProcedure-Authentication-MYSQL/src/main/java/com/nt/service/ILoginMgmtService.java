package com.nt.service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public interface ILoginMgmtService {
	public String doLogin(String user,String pwd);

}
