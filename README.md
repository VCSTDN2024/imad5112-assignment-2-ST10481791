[ReadMe.txt](https://github.com/user-attachments/files/20352183/ReadMe.txt)[Uploading ReadMe.txt…Course: Introduction to Mobile Application Development
Student Number: ST10481791
Name: Blessing Bwanali
Group: 2

---

# Flashcards App

## What the App Is About

Flashcards is a simple true/false quiz app designed to help users test their knowledge through interactive flashcards. It guides the user through three screens: a **Welcome screen**, a **Quiz screen**, and a **Review screen**, storing the user’s answers and offering instant feedback.

This app is perfect for quick learning sessions, allowing users to:

* Start a quiz with a welcome message
* Answer a series of true/false questions
* Review their choices at the end of the quiz
* Reset the quiz and try again

---

## How the App Works

### 1. **Welcome Screen (`MainActivity.kt`)**

* Displays a welcome message.
* Contains a button to start the quiz.
* On button click, it launches the `SecondScreen` activity.

### 2. **Quiz Screen (`second_screen.kt`)**

* Displays flashcard questions one at a time.
* User selects either True or False.
* The answer is stored in an array/list.
* After the last question, navigates to `ThirdScreen` with answers passed via intent.

### 3. **Review Screen (`third_screen.kt`)**

* Shows the questions along with the user's selected answers.
* Provides a reset button to clear results and go back to the welcome screen.

---

## XML Layout Analysis

### `activity_main.xml`

* Contains a `TextView` for the welcome message.
* A `Button` that starts the quiz via `Intent` to the next screen.

### `activity_second_screen.xml`

* Includes a `TextView` to show the current question.
* Two `Buttons` labeled "True" and "False".
* Likely includes logic to hide/show next question after a response.

### `activity_third_screen.xml`

* Displays a summary of answers.
* May include a `ListView` or `TextViews` to show each Q\&A.
* Includes a reset button.

---

## Kotlin Code Analysis

### `MainActivity.kt`

* Simple entry point to the app.
* Handles the intent to transition to the quiz screen.

### `second_screen.kt`

* Handles question logic.
* Likely uses a `List<String>` for questions and stores responses in an `ArrayList<Boolean>` or similar.
* Navigates to the review screen via Intent extras.

### `third_screen.kt`

* Retrieves answers passed through the intent.
* Displays a result summary.
* Handles reset logic and returns to the main screen.



]()
