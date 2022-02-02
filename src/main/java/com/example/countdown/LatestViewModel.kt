package com.example.countdown

class LatestViewModel(
    private val newsRepository: NewsRepository
): Viewmodel(){
    init {
        viewModelScope.launch{
            newsRepository.favoriteLatestNews.collect{favoriteNews->

            }
        }
    }
}