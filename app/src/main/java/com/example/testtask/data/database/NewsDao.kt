package com.example.testtask.data.database

import androidx.room.*
import com.example.testtask.data.response.NewsEntity
import com.example.testtask.data.response.NewsResponse
import com.example.testtask.domain.entity.News
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: News): Long

    @Delete
    fun deleteNews(news: News): Int

    @Query("SELECT * from NewsDB")
    fun selectAllNews(): Single<List<News>>
}