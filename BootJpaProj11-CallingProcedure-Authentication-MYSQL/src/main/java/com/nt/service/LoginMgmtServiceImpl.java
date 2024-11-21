package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("loginService")
public class LoginMgmtServiceImpl implements ILoginMgmtService {

    @Autowired
    private EntityManager manager;
    /*
     * CREATE TABLE login_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20),
    password VARCHAR(20)
);

-- Insert some test data
INSERT INTO login_info (username, password) VALUES ('raja', 'rani');

     */

    @Override
    public String doLogin(String user, String pwd) {
        // Create StoredProcedureQuery object to call the stored procedure
        StoredProcedureQuery query = manager.createStoredProcedureQuery("p_authentication");

        // Register input and output parameters for the stored procedure
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);  // username
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);  // password
        query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT); // result

        // Set input parameters
        query.setParameter(1, user);
        query.setParameter(2, pwd);

        // Call the stored procedure and get the output parameter value
        String result = (String) query.getOutputParameterValue(3);

        return result;
    }
}
