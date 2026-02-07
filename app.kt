To create a complete Android Kotlin project named "Make an other one," I'll provide the essential files for a basic app. This will include:

1.  **`MainActivity.kt`**: The main activity class.
2.  **`activity_main.xml`**: The layout file for the main activity.
3.  **`AndroidManifest.xml`**: The application manifest file.
4.  **`build.gradle.kts` (app level)**: The module-level Gradle build script.
5.  **`build.gradle.kts` (project level)**: The project-level Gradle build script.
6.  **`settings.gradle.kts`**: The settings file for the Gradle project.
7.  **`strings.xml`**: Resource file for strings.
8.  **`colors.xml`**: Resource file for colors.
9.  **`themes.xml`**: Resource file for themes (day and night).

---

**1. `MainActivity.kt` (app/src/main/java/com/example/makeanotherone/MainActivity.kt)**

```kotlin
package com.example.makeanotherone

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var clickCountTextView: TextView
    private lateinit var clickMeButton: Button
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickCountTextView = findViewById(R.id.clickCountTextView)
        clickMeButton = findViewById(R.id.clickMeButton)

        updateCountText() // Initial display

        clickMeButton.setOnClickListener {
            count++
            updateCountText()
        }
    }

    private fun updateCountText() {
        clickCountTextView.text = getString(R.string.click_count_message, count)
    }
}
```

---

**2. `activity_main.xml` (app/src/main/res/layout/activity_main.xml)**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/welcomeTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="64dp"
        android:text="@string/welcome_message"
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/clickCountTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:textSize="20sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/welcomeTextView"
        tools:text="You clicked 0 times!" />

    <Button
        android:id="@+id/clickMeButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="48dp"
        android:text="@string/click_me_button"
        android:paddingStart="32dp"
        android:paddingEnd="32dp"
        android:paddingTop="16dp"
        android:paddingBottom="16dp"
        android:textSize="18sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/clickCountTextView" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

---

**3. `AndroidManifest.xml` (app/src/main/AndroidManifest.xml)**

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.MakeAnotherOne"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

---

**4. `build.gradle.kts` (app level - app/build.gradle.kts)**

```kotlin
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.makeanotherone"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.makeanotherone"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
```

---

**5. `build.gradle.kts` (project level - build.gradle.kts)**

```kotlin
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}
```

---

**6. `settings.gradle.kts` (settings.gradle.kts)**

```kotlin
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MakeAnotherOne"
include(":app")
```

---

**7. `strings.xml` (app/src/main/res/values/strings.xml)**

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">Make an other one</string>
    <string name="welcome_message">Welcome to Make an other one!</string>
    <string name="click_count_message">You clicked %d times!</string>
    <string name="click_me_button">Click Me!</string>
</resources>
```

---

**8. `colors.xml` (app/src/main/res/values/colors.xml)**

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="purple_200">#FFBB86FC</color>
    <color name="purple_500">#FF6200EE</color>
    <color name="purple_700">#FF3700B3</color>
    <color name="teal_200">#FF03DAC5</color>
    <color name="teal_700">#FF018786</color>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
</resources>
```

---

**9. `themes.xml` (app/src/main/res/values/themes.xml and app/src/main/res/values-night/themes.xml)**

**`app/src/main/res/values/themes.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.MakeAnotherOne" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/purple_500</item>
        <item name="colorPrimaryVariant">@color/purple_700</item>
        <item name="colorOnPrimary">@color/white</item>
        <!-- Secondary brand color. -->
        <item name="colorSecondary">@color/teal_200</item>
        <item name="colorSecondaryVariant">@color/teal_700</item>
        <item name="colorOnSecondary">@color/black</item>
        <!-- Status bar color. -->
        <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
        <!-- Customize your theme here. -->
    </style>
</resources>
```

**`app/src/main/res/values-night/themes.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.MakeAnotherOne" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/purple_200</item>
        <item name="colorPrimaryVariant">@color/purple_700</item>
        <item name="colorOnPrimary">@color/black</item>
        <!-- Secondary brand color. -->
        <item name="colorSecondary">@color/teal_200</item>
        <item name="colorSecondaryVariant">@color/teal_200</item>
        <item name="colorOnSecondary">@color/black</item>
        <!-- Status bar color. -->
        <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
        <!-- Customize your theme here. -->
    </style>
</resources>
```

---

**To use this project:**

1.  **Open Android Studio.**
2.  Select **"New Project"** -> **"Empty Activity"**.
3.  Configure your project:
    *   **Name:** `Make an other one`
    *   **Package name:** `com.example.makeanotherone` (or your preferred package)
    *   **Save location:** Choose a directory.
    *   **Language:** `Kotlin`
    *   **Minimum SDK:** `API 24: Android 7.0 (Nougat)`
    *   Click **"Finish"**.
4.  Once the project is created, replace the content of the corresponding files in your new project with the code provided above.
5.  **Sync Gradle** (File -> Sync Project with Gradle Files, or click the elephant icon in the toolbar).
6.  Run the app on an emulator or a physical device.

You will see a simple app with a welcome message, a click counter (starting at 0), and a "Click Me!" button. Each time you press the button, the counter will increment.