package com.example.countdown

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import kotlin.String


class MainActivity : AppCompatActivity() {
    private lateinit var flowOne: Flow<String>
    private lateinit var flowTwo: Flow<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFlows()
        zipFlows()
    }

    private fun setupFlows() {
        flowOne = flowOf("Юрий", "Александр", "Иван").flowOn(Dispatchers.Default)
        flowTwo = flowOf("Гагарин", "Пушкин", "Грозный").flowOn(Dispatchers.Default)
    }

    private fun zipFlows() {
        findViewById<Button>(R.id.button).setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                flowOne.zip(flowTwo)
                { firstString, secondString ->
                    "$firstString $secondString"
                }.collect {
                    Log.d(TAG, it)
                }
            }
        }
    }

    companion object {
        private const val TAG = "###"
    }
}

lateinit var flowOne: Flow<String1>
lateinit var flowTwo: Flow<String1>

private fun setupFlows() {
    flowOne = flowOf("Никита", "Инга", "Иван").flowOn(Dispatchers.Default)
    flowTwo = flowOf("Мусса", "Прокофьева", "Грозный").flowOn(Dispatchers.Default)
}

private fun zipFlows() {
    findViewById<Button>(R.id.button).setOnClickListener {
        CoroutineScope(Dispatchers.Main).launch {
            flowOne.zip(flowTwo)
            { firstString, secondString ->
                "$firstString $secondString"
            }.collect {
                Log.d(TAG, it)
            }
        }
    }
}
