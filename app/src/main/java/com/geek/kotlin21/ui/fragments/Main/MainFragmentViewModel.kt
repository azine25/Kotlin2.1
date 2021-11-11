package com.geek.kotlin21.ui.fragments.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geek.kotlin21.core.App
import com.geek.kotlin21.model.TriviaCategories
import retrofit2.Call
import retrofit2.Callback

class MainFragmentViewModel : ViewModel() {

    private val api = App.client
    private var questionsAmount = 0
    private val questionsLiveData = MutableLiveData<Int>()

    fun getCategories(): MutableLiveData<TriviaCategories> {
        val liveData = MutableLiveData<TriviaCategories>()
        api.getCategories().enqueue(object : Callback<TriviaCategories> {

            override fun onFailure(call: Call<TriviaCategories>, t: Throwable) {
                print(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<TriviaCategories>,
                response: retrofit2.Response<TriviaCategories>
            ) {
                liveData.value = response.body()
            }
        })
        return liveData
    }

    fun setQuestionsAmount(questions: Int) {
        questionsAmount = questions
    }

    fun getQuestionsAmount(): LiveData<Int> {
        questionsLiveData.postValue(questionsAmount)
        return questionsLiveData
    }

}
