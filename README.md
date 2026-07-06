# Android Development Practice
 
A collection of Android projects built while learning Kotlin and Android development concepts. Each folder represents a specific topic or mini-project demonstrating hands-on implementation of core Android features.
 
---
 
## 📱 Projects Overview
 

### **FirstDemoProject**
An early practice project combining basic Android concepts learned in the initial stages.

### **InteractiveApp**
A small interactive application experimenting with user interaction and event handling.
 
### **TextandScrollView**
Working with TextView and ScrollView — handling text display and scrollable content for longer text that exceeds screen height.

### **ExplicitIntent**
First exploration of explicit intents — navigating between activities and passing data directly between screens.
 
### **ImplicitIntent**
Learning implicit intents — letting the Android system decide which app handles an action (like opening URLs, sharing content, etc.).
 
### **WebView**
Building a WebView component to display web content directly inside an Android app.
 
### **SplashScreen**
A welcome/intro screen with navigation capabilities — similar to the SigninAnddatabase but without database integration. Features custom background and branding, serving as an entry point before the main app.
 
### **StackUp** ⭐
My first fully functional, polished Android app. A CS topic explorer with:
- Multi-screen navigation using explicit intents
- Dynamic UI generation in Kotlin (programmatic view creation)
- Topic selection cards (orange and green themed)
- Circular UI components with custom borders using GradientDrawable
- Responsive layouts with FlexboxLayout (auto-wrapping content)
- YouTube playlist integration via implicit intents
- Custom gradient backgrounds across screens
- Custom app icon and branding
**Key Concepts Demonstrated:**
- Explicit & Implicit Intents
- WebView, TextView, ScrollView
- Dynamic view generation
- FlexboxLayout for responsive design
- GradientDrawable for custom shapes
- Intent data passing with arrays
- Uri.parse() for opening external apps
 
### **MultiScreenApp**
Exploring multi-screen navigation and data passing — takes 4 orders as input and displays them on the next screen, demonstrating how to pass data between activities using intent extras.
 
### **SigninAnddatabase** 🔐
A Firebase-integrated authentication project featuring:
- Sign-in menu with user input fields
- Firebase Realtime Database integration
- User credentials and details stored in the database
- Understanding data persistence and cloud storage
**Key Concepts Demonstrated:**
- Firebase setup and configuration
- Realtime Database operations
- User authentication flows
- Data storage and retrieval
- Intent navigation post-authentication

### **ViewBinding Project**
- A practice project exploring Android's ViewBinding feature as an alternative to findViewById().
 
**What is ViewBinding?**
 
- ViewBinding automatically generates a binding class for each XML layout file, providing type-safe and null-safe access to views without using findViewById().
 
**Key Concepts Covered**
 
- Enabling ViewBinding in build.gradle
- Binding class generation from XML layouts
- Accessing views through binding object instead of findViewById()
- Benefits: Type safety, null safety, and cleaner code
 **Why Use ViewBinding?**
 
- Type-safe: Compiler catches errors at build time, not runtime
- Null-safe: No null pointer exceptions from missing views
- Cleaner code: No need for casting or null checks
- Performance: More efficient than findViewById()

### **AlertDialogue**
Practice project exploring Android's AlertDialog — displaying popup dialogs to show messages, confirmations, single choice input, multiple choice inputs or get user input. Demonstrates creating simple dialogs with buttons, handling user interactions, and dismissing dialogs.

**Key Concepts:** AlertDialog.Builder, positive/negative buttons, dialog listeners, and user response handling.

### **CustomisedAlertBox Project**

A practice project creating customized AlertDialogs with custom layouts, styling, and themes. Explores how to go beyond basic dialogs by adding custom views, colors, fonts, and designs to match app branding.

**Key Concepts:** Custom AlertDialog layouts, XML styling, view inflation, and advanced dialog customization.

### **DemoExam — Android MCQ/MSQ Quiz App**
 
A simple Android quiz application that presents MCQ (Multiple Choice) and MSQ (Multiple Select) questions through native AlertDialogs, with a clean results summary at the end.
 
 **Features**
 
- Supports both MCQ (single answer, radio buttons) and MSQ (multiple answers, checkboxes)
- Questions presented one at a time via AlertDialog
- Clear button to reset selections without closing the dialog
- Exit button with confirmation to prevent accidental loss of progress
- Results shown after all questions are completed


**How it works**❓
 
1. Question appears in screen without any options 
2. Tap **Answer** on the main screen to begin the quiz
3. Each question appears as an AlertDialog with the appropriate input type
4. Use **Clear** to reset your selection on the current question
5. Tap **Previous** to go to previous question
6. Tap **Next** to move forward, or **Submit** on the last question
7. A summary screen shows your score and feedback for each question
8. Tap **Exit** at any point to quit — a confirmation dialog will appear first

 **Tech Stack**
 
- Language: Kotlin
- UI: Native Android AlertDialog
- Min SDK: 21 (Android 5.0)
- No third-party libraries


### **PhotoFrame — Android Image Viewer App**
 
A simple Android photo frame application that lets you browse through a curated collection of 10 photos with next and previous navigation, along with a dynamic name label that updates with each photo.
 
**Features**
 
- Browse through a collection of 10 photos
- Navigate forward and backward using **Next** and **Previous** image buttons
- Photo name updates dynamically below the image as you navigate

**How it works**❓
 
1. Open the app — the first photo and its name are displayed
2. Tap **Next** to move to the following photo
3. Tap **Previous** to go back to the earlier photo
4. The name label below the photo updates automatically with each navigation


### **ToDoList — ListviewAdapters**
 
A simple Android practice project built to understand how ListView and Adapters work. Displays a static to-do list where tasks are predefined in the code.
 
> **Note:** This is a learning project, not a production app. The goal was to get hands-on with ListView, custom Adapters, and how they work together in Android.
 
 **What I learned**
 
- How a ListView works and how it renders a list of items
- How an Adapter acts as a bridge between data and the ListView
- How to define static data and pass it through an Adapter to the UI
- How data persists across app restarts when hardcoded in the source
 **Features**
 
- Displays a static list of to-do tasks using a ListView
- Tasks are predefined — no user input
- Data persists across app restarts since it lives in the code 

**How it works**❓
 
- The tasks are defined as a static list in the code. An Adapter picks up that list and maps each task to a list item view. The ListView then renders those views on screen, one row per task.


---
 
## 🛠️ Technologies & Tools
 
- **Language:** Kotlin
- **IDE:** Android Studio
- **Target SDK:** Android 12+
- **Backend:** Firebase Realtime Database
- **Concepts Covered:** Intents, WebView, Layouts, Dynamic Views, Gradients, Responsive Design, Firebase Integration
---
 
## 📚 Learning Path
 
This repo documents my learning progression:
1. Basic intents (explicit and implicit)
2. Individual UI components (WebView, ScrollView, TextView)
3. Splash screens and app startup flows
4. Multi-screen navigation and data passing
5. Firebase integration and database operations
6. Dynamic view generation and responsive layouts
7. Full app implementation (StackUp)
---
 
## 🚀 Running the Projects
 
1. Clone the repo
2. Open any project folder in Android Studio
3. Sync Gradle files
4. For Firebase projects (SigninAnddatabase), add your `google-services.json` file
5. Run on an emulator or physical device
---
 
## 💡 What I Learned
 
- The difference between explicit intents (direct navigation) and implicit intents (letting the system decide)
- How to pass data between screens using intent extras (single values and arrays)
- Firebase setup, authentication, and Realtime Database operations
- How to dynamically create views in Kotlin instead of hardcoding XML layouts
- Debugging real layout issues (overflow, spacing, color contrast)
- Responsive design using FlexboxLayout
- Why click listeners belong on Views, not Strings
- Data persistence and cloud storage concepts
---
 
## 📝 Notes
 
Each folder is a standalone Android project. Some are minimal concept demonstrations, others (like StackUp and SigninAnddatabase) are more complete applications with real-world features. This repo shows the journey from "hello world" to building functional apps with backend integration.
 
---
 
**Status:** Actively learning and adding new projects  
**Next Topics:** RecyclerView, Fragments, Room Database, Advanced Firebase Features
