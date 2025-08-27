# LoadOut

**LoadOut** is lorem ipsum dolor sit amet, consectetur adipiscing elit.

## Pre-requisites

Android Studio: Iguana 2023.2.1 Patch 2

**Enable Firebase Authentication**
1. Go to the [LoadOut Console](https://console.firebase.google.com/u/0/project/loadout-project-id/overview).
2. Navigate to **Project Settings** (gear icon next to Project Overview).
3. Scroll down to **Your apps** section.
4. Click **Download** `google-services.json`
5. Save the file to `app/` directory of the project.
    ```
    LoadOut/
        ├─ .gradle/
        ├─ .idea/
        └─ app/
            ├─ build/
            ├─ src/
            ├─ .gitignore
            ├─ build.gradle.kts
            ├─ google-services.json  <--- Place the file here
            └─ proguard-rules.pro
    ```
6. Sync, build, and run the project.

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
 │   │   │       │   ├─ auth/
 │   │   │       │   │   ├─ LoginActivity.kt
 │   │   │       │   │   └─ RegisterActivity.kt
 │   │   │       │   └─ dashboard/
 │   │   │       │       └─ DashboardActivity.kt
 │   │   │       │
 │   │   │       ├─ presenter/           # Presenters
 │   │   │       │   ├─ auth/           
 │   │   │       │   │   ├─ LoginPresenter.kt
 │   │   │       │   │   └─ RegisterPresenter.kt
 │   │   │       │   └─ dashboard/
 │   │   │       │       └─ DashboardPresenter.kt
 │   │   │       │
 │   │   │       └─ contract/            # View <-> Presenter
 │   │   │           ├─ auth/           
 │   │   │           │   ├─ LoginContract.kt
 │   │   │           │   └─ RegisterContract.kt
 │   │   │           └─ dashboard/
 │   │   │               └─ DashboardContract.kt
 │   │   │
 │   │   └─ res/
 │   │       ├─ layout/
 │   │       │   └─ activity_dashboard.xml
 │   │       └─ values/
 │   │
 │   └─ AndroidManifest.xml
```

### Current Dependencies

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

### Plugins

| Plugin | Version | Description |
|--------|---------|-------------|
| **google-services** | latest | Integrates Firebase services with the Android app |
| **devtools-ksp** | 1.9.0-1.0.13 | Kotlin Symbol Processing (KSP) used for Room & Dagger annotation processing |
