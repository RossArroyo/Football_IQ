package com.example.football_iq.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TopicsContentDao {
        @Query("SELECT * FROM TopicsContent")
        fun getAllContent(): List<TopicsContent>

        @Insert
        fun insert(content: TopicsContent)
}