package com.example.testtask.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NewsDB")
data class News(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val description: String,
    @ColumnInfo val url: String,
    @ColumnInfo val urlToImage: String?,
    @ColumnInfo val publishedAt: String
)