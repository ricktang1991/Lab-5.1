package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    class ScoreViewModel(finalScore: Int) : ViewModel() {
        // The final score
        var score = finalScore
        init {
            Log.i("ScoreViewModel", "Final score is $finalScore")
        }
    }

    // The current word
    var word = ""
    // The current score
    var score = 0
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    init {
        resetList()
        nextWord()
        Log.i("GameViewModel", "GameViewModel created!")
    }
    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
        }

    }
    /** Methods for buttons presses **/
    fun onSkip() {
        if (!wordList.isEmpty()) {
            score--
        }
        nextWord()
    }

    fun onCorrect() {
        if (!wordList.isEmpty()) {
            score++
        }
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}