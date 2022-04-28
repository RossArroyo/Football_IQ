package com.example.football_iq.data

import androidx.room.ColumnInfo
import androidx.room.Embedded       //maybe get rid of
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.UUID

@Entity
data class TopicsContent(
    @PrimaryKey val id: UUID,
    @ColumnInfo(name = "title") @NotNull val title: String,
    @ColumnInfo(name = "description") val description: String
)