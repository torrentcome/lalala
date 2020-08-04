# Lalala

![](/app/src/main/res/mipmap-hdpi/ic_launcher.png)

A sample android app that shows how to use ViewModels, LiveData with RxJava3 & Hilt, in Kotlin by "Clean Architecture".


### Implemented by
The structure of this project with 3 layers:
- ui
- domain
- data

### Communication between layers

1. UI calls method from ViewModel.
2. ViewModel executes internal logic.
3. Internal logic combines data from Repo.
4. The Repo is tied with the data (remote here).
5. Information flows back to the UI by LiveData.

### Dependencies

```gradle
    // androidx ui
    // androidx mvvm
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'

    // hilt
    implementation 'com.google.dagger:hilt-android:2.28-alpha'
    kapt 'com.google.dagger:hilt-android-compiler:2.28-alpha'
    implementation 'androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-SNAPSHOT'
    kapt 'androidx.hilt:hilt-compiler:1.0.0-SNAPSHOT'

    //rx
    implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
    implementation 'io.reactivex.rxjava3:rxjava:3.0.0'
    //rx edit text
    implementation 'com.jakewharton.rxrelay3:rxrelay:3.0.0'

    // retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0'

    // glide == my GIF client
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    implementation "com.github.bumptech.glide:okhttp3-integration:4.11.0"

    // calligraphy
    implementation 'io.github.inflationx:calligraphy3:3.1.1'
    implementation 'io.github.inflationx:viewpump:2.0.3'

    // test
    testImplementation 'junit:junit:4.13'
    testImplementation 'com.google.truth:truth:0.36'
    testImplementation "org.mockito:mockito-core:2.21.0"
    testImplementation 'android.arch.core:core-testing:1.1.1'

    // android test
    androidTestImplementation 'androidx.test:runner:1.2.0'
    androidTestImplementation 'androidx.test:rules:1.2.0'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
    androidTestImplementation 'com.android.support.test.espresso:espresso-contrib:2.0'
```
