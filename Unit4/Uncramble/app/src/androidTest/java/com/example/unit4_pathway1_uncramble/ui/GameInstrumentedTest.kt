package com.example.unit4_pathway1_uncramble.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.unit4_pathway1_uncramble.MainActivity
import com.example.unit4_pathway1_uncramble.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GameInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun gameScreen_initialState_displayed() {
        // Launch the app
        composeTestRule.setContent {
            MainActivity().apply {
                // Simulate onCreate
            }
        }

        // Check initial elements are displayed
        composeTestRule.onNodeWithText("Unscramble").assertExists()
        composeTestRule.onNodeWithText("Score: 0").assertExists()
        composeTestRule.onNodeWithText("Word 1 of 10").assertExists()
        // Scrambled word should be present
        // Buttons: Submit, Skip
    }

    @Test
    fun gameScreen_enterGuess_checkError() {
        composeTestRule.setContent {
            GameScreen()
        }

        // Enter wrong guess
        composeTestRule.onNodeWithText("Enter your word").performTextInput("wrong")
        composeTestRule.onNodeWithText("Submit").performClick()

        // Check error message appears
        composeTestRule.onNodeWithText("Wrong guess!").assertExists()
    }

    @Test
    fun gameScreen_skipWord_nextWord() {
        composeTestRule.setContent {
            GameScreen()
        }

        val initialWordCount = "Word 1 of 10"

        composeTestRule.onNodeWithText("Skip").performClick()

        // Check word count increased
        composeTestRule.onNodeWithText("Word 2 of 10").assertExists()
        // Score should still be 0
        composeTestRule.onNodeWithText("Score: 0").assertExists()
    }

    // Note: Testing correct guess is hard without knowing the word.
    // In a real scenario, we might need to mock or expose the current word.

    @Test
    fun gameScreen_gameOver_displayed() {
        composeTestRule.setContent {
            GameScreen()
        }

        // Skip 9 times to reach word 10
        repeat(9) {
            composeTestRule.onNodeWithText("Skip").performClick()
        }

        // Skip the 10th word
        composeTestRule.onNodeWithText("Skip").performClick()

        // Check game over screen
        composeTestRule.onNodeWithText("Congratulations!").assertExists()
        composeTestRule.onNodeWithText("Play Again").assertExists()
    }
}