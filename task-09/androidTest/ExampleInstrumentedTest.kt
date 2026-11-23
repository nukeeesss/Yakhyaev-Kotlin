package com.example.kotlinpractice

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.kotlinpractice.ui.theme.KotlinPracticeTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp() {
        composeRule.setContent {
            KotlinPracticeTheme {
                WaterTracker()
            }
        }
    }

    @Test
    fun buttonsAndDayCounterAreVisible() {
        composeRule.onNodeWithText("+250 мл")
            .assertIsDisplayed()

        composeRule.onNodeWithText("Завершить день")
            .assertIsDisplayed()

        composeRule.onNodeWithText("100 мл")
            .assertIsDisplayed()

        composeRule.onNodeWithText("Дней подряд с нормой: 0")
            .assertIsDisplayed()
    }

    @Test
    fun addButtonAdds250EachTime() {
        addWater(times = 1)

        composeRule.onNodeWithText("350 мл")
            .assertIsDisplayed()

        addWater(times = 1)

        composeRule.onNodeWithText("600 мл")
            .assertIsDisplayed()
    }

    @Test
    fun finishDayCountsConsecutiveSuccessfulDays() {
        addWater(times = 6)

        composeRule.onNodeWithText("1600 мл")
            .assertIsDisplayed()

        finishDay()

        composeRule.onNodeWithText("0 мл")
            .assertIsDisplayed()

        composeRule.onNodeWithText("Дней подряд с нормой: 1")
            .assertIsDisplayed()

        addWater(times = 6)

        composeRule.onNodeWithText("1500 мл")
            .assertIsDisplayed()

        finishDay()

        composeRule.onNodeWithText("0 мл")
            .assertIsDisplayed()

        composeRule.onNodeWithText("Дней подряд с нормой: 2")
            .assertIsDisplayed()
    }

    @Test
    fun finishDayBelowGoalResetsStreak() {
        addWater(times = 6)
        finishDay()

        composeRule.onNodeWithText("Дней подряд с нормой: 1")
            .assertIsDisplayed()

        addWater(times = 5)

        composeRule.onNodeWithText("1250 мл")
            .assertIsDisplayed()

        finishDay()

        composeRule.onNodeWithText("0 мл")
            .assertIsDisplayed()

        composeRule.onNodeWithText("Дней подряд с нормой: 0")
            .assertIsDisplayed()
    }

    private fun addWater(times: Int) {
        repeat(times) {
            composeRule.onNodeWithText("+250 мл")
                .performClick()
        }
    }

    private fun finishDay() {
        composeRule.onNodeWithText("Завершить день")
            .performClick()
    }
}
