/*
 * MantisBT REST API
 * For the sandbox to work, MantisBT must be hosted at the root folder of the host. For example: http://mantishost/ rather http://host/mantisbt.  If that is not the case, then create a host alias to map it as such or edit swagger.json to change basePath to include the mantisbt folder name.
 *
 * OpenAPI spec version: 1.1.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.model.User;
import io.swagger.client.model.UserAddResponse;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserApi
 */
@Ignore
public class UserApiTest {

    private final UserApi api = new UserApi();

    
    /**
     * Create an user
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void userAddTest() throws Exception {
        User body = null;
        UserAddResponse response = api.userAdd(body);

        // TODO: test validations
    }
    
    /**
     * Delete an user
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void userDeleteTest() throws Exception {
        Long id = null;
        api.userDelete(id);

        // TODO: test validations
    }
    
}
