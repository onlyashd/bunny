# Architecture Overview

This project uses a Client-Service architecture to separate the high-performance UI (RSVP Reader)
from heavy background operations (Book Downloading & Configuration).

## High-Level Design

The system is split into two primary components:

- **The Client (App)**: A Jetpack Compose interface optimized for RSVP reading. It uses Hilt for
  dependency injection and Kotlin Flows to observe service states.
- **The Service (BunnyService)**: A standalone background process that handles long-running tasks
  like
  downloading ePub files and managing global configurations via AIDL (Android Interface Definition
  Language).

### The Client (App Side)

The client uses a reactive "Provider" pattern to communicate with the service. This abstracts away
the complexity of Android's ServiceConnection.
Key Components

- **ServiceProvider<T>**: A generic wrapper that turns asynchronous AIDL connections into a
  StateFlow<
  T?>. This ensures the UI only attempts to call the service when the connection is active.
- **ServiceModule**: A Hilt module that provides singleton instances of our service bridges using
  `@Qualifier` annotations (e.g., `@Configuration`).

#### Example: Accessing Configuration

```kt
// Inject the provider into the ViewModel
@Inject @Configuration
lateinit var configProvider: ServiceProvider<IConfiguration>

// Use it reactively
configProvider.state.collect { service ->
    val bundle = service?.getConfig(Bundle())
// Update UI with config data
}
```

### The Service (BunnyService Side)

The service acts as the _**"Source of Truth"**_ for data and heavy processing. It is designed to be
pluggable and scalable.

#### Key Components

- **MainService**: The entry point. It uses a Binder Coordinator to route incoming requests to the
  correct implementation based on the Intent action.
- **Binder**: The traffic controller. It maps actions to their respective logic classes.
- **<Feature>Impl**: Implements the aidl interface and handles its requests.

##### Example: Scaling with a new Download AIDL

To add the downloading feature, simply:

1. Create IDownload.aidl.
2. Implement DownloadImpl : IDownload.Stub().
3. Add the route to the Binder class:

```kt
when (intent.action) {
    Actions.DOWNLOAD -> downloadImpl
    Actions.CONFIGURATION -> configurationImpl
}
```

## Communication Flow (IPC)

1. **Request**: The App sends an Intent with a specific Action.
2. **Routing**: MainService receives the intent and asks Binder for the correct implementation.
3. **Execution**: The Service performs the task (e.g., fetching a download URL).
4. **Response**: The Service returns a Bundle or primitive result across the process boundary back
   to the App's ServiceProvider.

## Tech Stack

* **Language**: Kotlin
* **Dependency Injection**: Hilt
* **Concurrency**: Kotlin Coroutines & StateFlow
* **Communication**: AIDL (IPC)
* **UI**: Jetpack Compose (Client)

## Why this architecture?

* **RSVP Performance**: By moving downloads to BunnyService, the RSVP engine never stutters due to
  background network or disk I/O.
* **Stability**: If the download service crashes, the main Reader app stays alive.
* **Scalability**: Adding new features (like a Sync service or a Dictionary service) only requires a
  new AIDL file and a new implementation class.