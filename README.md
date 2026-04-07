# Bunny

<p align="center">
<img src="icon_app.png" alt="white rabbit on green background" width="128">
</p>

Bunny is a high-performance epub reader for Android, specifically engineered for RSVP (Rapid
Serial Visual Presentation). By flashing words at a controlled speed, Bunny allows you to
consume literature faster than traditional reading while maintaining high comprehension.

To ensure that the reading engine remains perfectly fluid, the app uses a distributed architecture:
heavy tasks like book downloading and parsing are offloaded to a dedicated background service.

## Features

* **RSVP Engine**: Custom-built engine for Rapid Serial Visual Presentation.
* **epub Support**: Comprehensive support for standard ePub formats.
* **Integrated Downloader**: Background service for fetching books without interrupting your reading
  flow.
* **Material You**: Clean, modern interface that adapts to your device's theme.
* **Remote Configuration**: Shared settings managed across processes via AIDL.

## Screenshots

| Reading Interface        | Library View             | Settings                 |
|--------------------------|--------------------------|--------------------------|
| [Screenshot Placeholder] | [Screenshot Placeholder] | [Screenshot Placeholder] |

## Download

You can get the latest version of Bunny Reader through the following channels:

### F-Droid

**(Coming Soon)**

Bunny Reader will be available on the official F-Droid repository.
This is the recommended method for receiving automatic, privacy-friendly updates.

### GitHub Releases

check our [releases page](https://github.com/onlyashd/bunny/releases).

## Building from Source

### Prerequisites

* Android Studio Otter 3 (or newer)
* JDK 21
* Android SDK 29+

1. Clone the repository:

```shell
git clone https://github.com/onlyashd/bunny-reader.git 
```

2. Open the project in Android Studio.
3. Synchronize Gradle.
4. Run the `app` configuration on your device or emulator.

## Architecture

This project follows a strict Client-Service model to guarantee UI performance. The communication
between the main app and the background worker is handled via AIDL (Android Interface Definition
Language).

For a deep dive into the technical implementation, Hilt modules, and IPC logic, please refer to
our [Architecture Documentation](Architecture.md).

## License

This project is licensed under the **AGPL-3.0** License. See the [LICENSE file](LICENSE) for
details.