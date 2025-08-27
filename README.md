# LoadOut

**LoadOut** is lorem ipsum dolor sit amet, consectetur adipiscing elit.

## Project Structure

```
app/
 ├─ build/
 ├─ src/
 │   ├─ androidTest/                 
 │   ├─ test/                        
 │   ├─ main/
 │   │   ├─ java/
 │   │   │   └─ com.eldroid.loadout/
 │   │   │       ├─ model/               # Data & business logic
 │   │   │       │   ├─ entities/           # Data classes (User, TrashBin, Notification)
 │   │   │       │   ├─ repository/         # Data access (Firebase, Retrofit, Room, etc.)
 │   │   │       │   └─ datasource/         # APIs, DAOs, Firebase adapters
 │   │   │       │
 │   │   │       ├─ view/                # UI (Activities, Fragments, Adapters, XML links)
 │   │   │       │   ├─ login/
 │   │   │       │   │   └─ LoginActivity.kt
 │   │   │       │   └─ dashboard/
 │   │   │       │       └─ DashboardActivity.kt
 │   │   │       │
 │   │   │       ├─ presenter/           # Presenters
 │   │   │       │   ├─ login/           
 │   │   │       │   │   └─ LoginPresenter.kt
 │   │   │       │   └─ dashboard/
 │   │   │       │       └─ DashboardPresenter.kt
 │   │   │       │
 │   │   │       └─ contract/            # View <-> Presenter
 │   │   │           ├─ LoginContract.kt
 │   │   │           └─ DashboardContract.kt
 │   │   │
 │   │   └─ res/
 │   │       ├─ layout/
 │   │       │   ├─ activity_login.xml
 │   │       │   └─ activity_dashboard.xml
 │   │       └─ values/
 │   │           ├─ strings.xml
 │   │           ├─ colors.xml
 │   │           └─ styles.xml
 │   │
 │   └─ AndroidManifest.xml
```

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

