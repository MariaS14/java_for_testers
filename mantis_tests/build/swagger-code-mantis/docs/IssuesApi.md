# IssuesApi

All URIs are relative to *http://localhost/mantisbt-2.26.0/api/rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**issueAdd**](IssuesApi.md#issueAdd) | **POST** /issues | Create an issue
[**issueDelete**](IssuesApi.md#issueDelete) | **DELETE** /issues | Delete an issue
[**issueGet**](IssuesApi.md#issueGet) | **GET** /issues | Get issue details


<a name="issueAdd"></a>
# **issueAdd**
> issueAdd(body)

Create an issue

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IssuesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IssuesApi apiInstance = new IssuesApi();
Issue body = new Issue(); // Issue | The issue to add.
try {
    apiInstance.issueAdd(body);
} catch (ApiException e) {
    System.err.println("Exception when calling IssuesApi#issueAdd");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Issue**](Issue.md)| The issue to add. |

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="issueDelete"></a>
# **issueDelete**
> issueDelete(id)

Delete an issue

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IssuesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IssuesApi apiInstance = new IssuesApi();
Long id = 789L; // Long | The issue id.
try {
    apiInstance.issueDelete(id);
} catch (ApiException e) {
    System.err.println("Exception when calling IssuesApi#issueDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The issue id. |

### Return type

null (empty response body)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="issueGet"></a>
# **issueGet**
> CreateIssueResponse issueGet(id)

Get issue details

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.IssuesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

IssuesApi apiInstance = new IssuesApi();
Long id = 789L; // Long | The issue id.
try {
    CreateIssueResponse result = apiInstance.issueGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IssuesApi#issueGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| The issue id. |

### Return type

[**CreateIssueResponse**](CreateIssueResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

