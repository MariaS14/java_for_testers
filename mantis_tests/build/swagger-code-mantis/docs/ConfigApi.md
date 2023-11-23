# ConfigApi

All URIs are relative to *http://localhost/mantisbt-2.26.0/api/rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**configGet**](ConfigApi.md#configGet) | **GET** /config | Get config options


<a name="configGet"></a>
# **configGet**
> ConfigGetResponse configGet(option, projectId, userId)

Get config options

Get the value for a set of configuration options given a user and project context.  If a configuration option is invalid or is marked as private, then they will be filtered out, but request will still succeed.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ConfigApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ConfigApi apiInstance = new ConfigApi();
List<String> option = Arrays.asList("option_example"); // List<String> | An array of configuration options.
Long projectId = 789L; // Long | The project id (default All Projects).
Long userId = 789L; // Long | The user id (default is logged in user).  This can only be set by users with access level ADMINISTRATOR.
try {
    ConfigGetResponse result = apiInstance.configGet(option, projectId, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigApi#configGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **option** | [**List&lt;String&gt;**](String.md)| An array of configuration options. |
 **projectId** | **Long**| The project id (default All Projects). | [optional]
 **userId** | **Long**| The user id (default is logged in user).  This can only be set by users with access level ADMINISTRATOR. | [optional]

### Return type

[**ConfigGetResponse**](ConfigGetResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

