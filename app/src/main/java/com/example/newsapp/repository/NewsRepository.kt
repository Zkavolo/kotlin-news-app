package com.example.newsapp.repository

import androidx.room.Query
import com.example.newsapp.api.RetroFitInstance
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.models.Article
import java.util.Locale.IsoCountryCode

class NewsRepository (val db: ArticleDatabase){

    suspend fun getHeadLines(countryCode: String, pageNumber: Int) =
        RetroFitInstance.api.getHeadLines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetroFitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getCategories() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle()
}