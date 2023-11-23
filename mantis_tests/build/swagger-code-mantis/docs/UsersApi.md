# UsersApi

All URIs are relative to *http://localhost/mantisbt-2.26.0/api/rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**userGetMe**](UsersApi.md#userGetMe) | **GET** /users/me | Get information about logged in user


<a name="userGetMe"></a>
# **userGetMe**
> UserResponse userGetMe()

Get information about logged in user

Gets information about logged in user.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

UsersApi apiInstance = new UsersApi();
try {
    UserResponse result = apiInstance.userGetMe();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#userGetMe");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

