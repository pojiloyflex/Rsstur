# RSTTUR 
This project is an implementation of the MVI (Model-View-Intent) architecture using Jetpack Compose and ViewModel. The application uses the following dependencies:

- Jetpack Compose: For building the UI
- ViewModel: For managing UI-related data in a lifecycle conscious way
- Coroutines: For asynchronous programming
- ViewModel KTX: For ViewModel support
- Retrofit: For network operations
- Moshi: For JSON parsing
- OkHttp Logging Interceptor: For logging network requests
- Picasso: For image loading
- Hilt: For dependency injection
- Hilt Navigation Compose: For navigation integration with Hilt
- Navigation Compose: For navigation integration with Compose

The application follows the MVI architecture, where the Model is responsible for fetching and providing data from local/remote sources, the View represents the UI layer, and the Intent represents user actions or events. The ViewModel handles user actions and transforms them into Intents, which are then processed by the Model and the new state is delivered to the View

https://github.com/pojiloyflex/Rsttur/assets/113837245/e85167a5-8b59-46b5-a48f-6dbf6b05c23d

