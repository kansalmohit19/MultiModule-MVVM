# MultiModule-MVVM 🚀
A scalable Android architecture template built using the MVVM pattern and 
modularization. It separates concerns across different modules (e.g., core, data, domain, and 
features) to improve code maintainability, testability, and build performance in large applications.

## 📦 Tech Stack
- Kotlin
- MVVM Architecture + Clean
- Jetpack: ViewModel, LiveData, Navigation
- Retrofit + Moshi
- Hilt (DI)
- Coroutines + Flows
- Ktlint + Detekt
- JUnit**
- Mockito

## 🛠️ Automation
🔧 Pre-build:
ktlintCheck and detekt are automatically run as part of the preBuild task across all modules.

🔐 Pre-push Git Hook:
A Git hook runs ktlintCheck and detekt before every push to ensure code quality and block bad commits.