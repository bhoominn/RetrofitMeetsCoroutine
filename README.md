# RetrofitMeetsCoroutine

## Retrofit with Coroutine
```
GlobalScopeExt(this) {
    getUser(onApiSuccess = {
        //Handle Response
        showUser(it)
    })
}
```

## Retrofit without Coroutine
### GET Example
```
getResponse(getApis().getUser(), onApiSuccess = {
     //Handle Response
     txtName.text = it.name
}, onApiError = {
     //Handle Api Error
     toast(it)
}, onNetworkError = {
     //Handle No Internet Connection
})

```

### POST Example
```
val requestModel = RequestModel()
requestModel.name = "Bhoomin"

getResponse(getApis().createUser(requestModel), onApiSuccess = {
    txtName.text = it.name
}, onApiError = {
    //Handle Api Error
    toast(it)
}, onNetworkError = {
    //Handle No Internet Connection
})