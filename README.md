# MyStarterApps
### Starter templates and tutorials for compose built using clean princples

Landing page feature package is "main" for running default dagger hilt appplications with room databases.  
Standard Navhost navigation to different apps.
- Dictionary
- Cryptocurrency

For others mostly tutorials or testing compose features (Nav Destinations, basic room, dagger hilt vm models etc)  
Change the name and the main activity to run different feature packages  
not included in the landing page set up (mostly tutorials that don't implement dagger hilt  
or use a different style.  
e.g:  
android:name=".feature_room.data.EntryApplication"  
android:name=".feature_dagger_hilt_vm.MyApp"  

MainActivity also needs changing for running these each feature package has its own.  
Feature_room will need the dagger hilt application commenting out to use its own Application  

## Features: 
- Jetpack Compose  
- Kotlin  
- MVVM  
- Dagger Hilt  
- Retrofit  
- Room  
- Offline Capability  
