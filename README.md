# TheGeniusList

The Genius List is designed to demonstrate API handling in an Android application.  
List will auto-populate from the API and will process the adding a user POST request on clicking the Floating Action Button.  

## Architecture
* [Kotlin](https://kotlinlang.org/) for the ease of use and ease of code readability
* [OkHttp](https://square.github.io/okhttp/) to perform HTTP requests to an API
* [Retrofit](https://square.github.io/retrofit/) turns an HTTP Client into an interface
* [Gson](https://github.com/google/gson) to convert JSON data from JSON objects for processing
* [GsonConverter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) a Retrofit Gson converter
* [Picasso](https://square.github.io/picasso/) for hassle-free image loading
* [CircleImageView](https://github.com/hdodenhof/CircleImageView) to make ImageViews a bit neater and circular

#### Future updates
* Add a local persistent database to store all the values taken from the API server. Will use a [Android Room Persistence Library](https://developer.android.com/topic/libraries/architecture/room) implementation
* Integrate [RxJava](https://github.com/ReactiveX/RxJava) with [RxKotlin](https://github.com/ReactiveX/RxKotlin) to add RxJava reactive extensions and use RxJava with Kotlin
