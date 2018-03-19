# MainThreadScheduler

[![](https://jitpack.io/v/Mohamed-Fadel/MainThreadScheduler.svg)](https://jitpack.io/#Mohamed-Fadel/MainThreadScheduler)

Android Library to `schedule` tasks to run as soon as `MainThread` become `Idle` written in Kotlin & java using `Espresso` analogy

# Use Example

- You want to determine View (e.g EditText) width, So you can use this library in case you want to determine the right moment that `activity` is in foreground and all views had already been
  `drawen` as even `onResume()` doesn't guarantee that all view had already been drawen. Instead of waiting a random time for drawing it fires the tasks
  on the right time.
  
  
 # Usage
 
 - Kotlin:
 
 ```
 MainThreadScheduler.scheduleWhenIdle { 
            // add here any thing you want to run on MainThread (to run as soon as MainThread become idle)
        }
 
 ```
 - Java:
 
 ```
  MainThreadScheduler.scheduleWhenIdle(new Runnable() {
            @Override
            public void run() {
                // add here any thing you want to run on MainThread (to run as soon as MainThread become idle)
            }
        });
 
 ```
 
 # Gradle Dependency
 
 1. Add the JitPack repository to your build file Add it in your root build.gradle at the end of repositories:
 
 ```
 allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
 
 ```
 
 2. Add the dependency
  
  - kotlin
    
    ```
    implementation  'com.github.Mohamed-Fadel:MainThreadScheduler:v1.0.0-kotlin'
    
    ```
  - java
    
    ```
    implementation  'com.github.Mohamed-Fadel:MainThreadScheduler:v1.0.0'
    
    ```
  
 
