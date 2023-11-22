# LocalizationApi

All URIs are relative to *http://localhost/api/rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**langGet**](LocalizationApi.md#langGet) | **GET** /lang | Get localized strings


<a name="langGet"></a>
# **langGet**
> LangGetResponse langGet(string)

Get localized strings

Gets a set of localized strings in context of the logged in user&#39;s language.  If a localized string is not defined, then it will be filtered out.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.LocalizationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Authorization
ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
Authorization.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Authorization.setApiKeyPrefix("Token");

LocalizationApi apiInstance = new LocalizationApi();
List<String> string = Arrays.asList("string_example"); // List<String> | An array of localized labels given their name string lang/strings_english.txt folder in MantisBT.  The name doesn't include $s_ prefix.
try {
    LangGetResponse result = apiInstance.langGet(string);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocalizationApi#langGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **string** | [**List&lt;String&gt;**](String.md)| An array of localized labels given their name string lang/strings_english.txt folder in MantisBT.  The name doesn&#39;t include $s_ prefix. |

### Return type

[**LangGetResponse**](LangGetResponse.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

