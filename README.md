# LoadOut

**LoadOut** is lorem ipsum dolor sit amet, consectetur adipiscing elit.

## Current Dependencies

| Dependency | Version | Description |
|------------|---------|-------------|
| **firebase-bom** | 32.3.1 | Bill of Materials for managing Firebase dependencies consistently |
| **firebase-database** | bom | Firebase Realtime Database for syncing IoT sensor data |
| **firebase-auth** | bom | Firebase Authentication for secure login (email, Google, etc.) |
| **firebase-messaging** | bom | Firebase Cloud Messaging for push notifications (e.g., trash full alerts) |
| **retrofit** | 2.11.0 | Type-safe HTTP client for API calls to external IoT services |
| **converter-moshi** | 2.11.0 | JSON serialization/deserialization with Moshi |
| **room-runtime** | 2.6.1 | Local database for offline data persistence |
| **datastore-preferences** | 1.2.0-alpha02 | Jetpack DataStore for storing user/app preferences |
| **work-runtime-ktx** | 2.8.1 | WorkManager for scheduling background tasks (e.g., syncing data) |
| **dagger-compiler** | 2.51.1 | Dependency Injection compiler for Dagger (manages app components) |

## Plugins

| Plugin | Version | Description |
|--------|---------|-------------|
| **google-services** | latest | Integrates Firebase services with the Android app |
| **devtools-ksp** | 1.9.0-1.0.13 | Kotlin Symbol Processing (KSP) used for Room & Dagger annotation processing |

## Setup & Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/loadout.git
   cd loadout

---

## Configs: 

- **Java:** 17
- **API level:** 34
- **Android Gradle Plugin (AGP):** 8.3.2

