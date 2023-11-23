# UserApi

All URIs are relative to *http://localhost/mantisbt-2.26.0/api/rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**userAdd**](UserApi.md#userAdd) | **POST** /users | Create an user
[**userDelete**](UserApi.md#userDelete) | **DELETE** /users/{id} | Delete an user


<a name="userAdd"></a>
# **userAdd**
> UserAddResponse userAdd(body)

Create an user

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
User body = new User(); // User | The user to add.
try {
    UserAddResponse result = apiInstance.userAdd(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#userAdd");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**User**](User.md)| The user to add. |

### Return type

[**UserAddResponse**](UserAddResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userDelete"></a>
# **userDelete**
> userDelete(id)

Delete an user

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UserApi apiInstance = new UserApi();
Long id = 789L; // Long | The user id.
try {
    apiInstance.userDelete(id);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#userDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The user id. |

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

