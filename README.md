# KMM Shared Services Architecture

[![Build](https://github.com/Maruchin1/kmm-shared-services/actions/workflows/main-workflow.yml/badge.svg)](https://github.com/Maruchin1/kmm-shared-services/actions/workflows/main-workflow.yml)

<img align="right" width="400" src="https://user-images.githubusercontent.com/46427781/224071234-a892a3d2-e045-4ae3-85fc-d7376c956875.png">

### androidApp (Native)

- `Views` implemented with either XML or Jetpack Compose.

- Presentation logic holder of your choice. It can be a `ViewModel` or some other solution.

### iosApp (Native)

- `Views` implemented with either UIKit or SwiftUI.

- Presentation logic holder of your choice. It can be a `ViewModel` or some other solution.

### shared (KMM)

- `Services` handle an application logic. They expose public methods which return data or perform some operations.

- `Services` access different `Repositories` to get or save data.

- `Repository` access different `DataSources` in order to fetch or persist data locally or remotely.

# Architecture concept

This architectural approach for implementing a KMM module favours simplicity and flexibility. Using Shared Services we can adjust a level of code sharing which
fits our project the best way. 

1. If you want to share some common algorithms, for example encryption logic, you can implement it in the the KMM module as a standalone `Service` 
which performs this kind of operations.

2. If your app persists some data in the database or uses a remote API and you would like to share this logic across platforms you can introduce a `Repository` 
to your KMM module. Different `Repositories` manage different types of objects and can use different data sources to get and persist them. `Services` are always a 
public API of the KMM module. They expose public methods to the native app and return data from different `Repositories`.

3. If your app has some extra business logic built on top of your data you can extract this logic to the KMM `Services`. In this case the `Service` can
get data from different `Repositories` and use it to perform more complex business operations like executing some wider process or return transformed data 
to the nativie app.

# Technical details

KMM module has a single entry point called `DemoSdk`. This class allows native apps to get instances of `Services` in a simple way. 
Under the hood KMM module uses [Koin](https://insert-koin.io/) DI framework to connect all the code together.

The `DemoSdk` class accepts an instance of `DemoConfig` as a constructor parameter. This `DemoConfig` uses an `expect/actual` mechanism to provide 
platform specifc configuration to the KMM module. For example on the Android side we need to pass down the `Context` to create local storage, 
while on the iOS side `Context` is not present.

Thanks to the single `DemoSdk` entry point the native apps gain great flexibility in terms of choosing the tools and solutions according to the preference.
Demo Android is not forced to use Koin which is present in the KMM module. For the purpose of this example the Android app uses a Hilt DI which is an 
official tool recommended by Google. Using `Hilt` `@Module` we create an instance of the `DemoSdk` and connect all the `Services` to the DI graph.

On the other hand, the iOS app can use simple custom solution based on the Singleton pattern. We create a `DemoSdkProvider` which is a Singleton.
In this class we create an instance of `DemoSdk` and allow other parts of the app to access it in order to get given `Services`.

# Demo application

This repository contains a simple app implemented for Android and iOS usign the Shared Services architecture for the KMM module.

### Login screen

We display welcome text with user's email. Email is hardcoded for the demo purpose. 
User can click `Login` button to verify if user with this email can access the app. After successfull verification user is moved to the `Home` screen.

### Home screen

We display a list of posts. Each post contains a title, author name and body. 
User can scroll through the list and click `Logout` button to move back to the `Login` screen

![Projekt bez tytułu (1)](https://user-images.githubusercontent.com/46427781/224264955-f82c7422-fc6d-4a04-a962-b4c514d89d98.png)
