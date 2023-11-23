# ProjectApi

All URIs are relative to *http://localhost/mantisbt-2.26.0/api/rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**projectGet**](ProjectApi.md#projectGet) | **GET** /projects | Get a project


<a name="projectGet"></a>
# **projectGet**
> GetProjectResponse projectGet(projectId)

Get a project

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProjectApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

ProjectApi apiInstance = new ProjectApi();
Long projectId = 789L; // Long | The project id.
try {
    GetProjectResponse result = apiInstance.projectGet(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectApi#projectGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Long**| The project id. |

### Return type

[**GetProjectResponse**](GetProjectResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

