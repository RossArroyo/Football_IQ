package com.example.football_iq.convertor

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.football_iq.data.TopicsContent
import com.example.football_iq.data.TopicsContentDao
import java.util.UUID
import java.util.concurrent.Executors

@Database(entities = [TopicsContent::class], version = 1)
abstract class AppDatabase: RoomDatabase(){

    abstract fun academyContentDao(): TopicsContentDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "Football_IQ")
                .addCallback(seedDatabase(context))
                .allowMainThreadQueries()
                .build()
        }

        private fun seedDatabase(context: Context): Callback {
            return object: Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Executors.newSingleThreadExecutor().execute {
                        val academyDao = getInstance(context).academyContentDao()
                        academyDao.insert(
                            TopicsContent(
                                id = UUID.randomUUID(),
                                title = "Basic Alignment",
                                description = "The offensive line is comprised of 5 people. It has 2 tackles,\n" +
                                        "2 guards, and 1 center. th order in which they are present is\n" +
                                        "left tackle, left guard, center, right guard, right tackle."
                            )
                        )
                        academyDao.insert(
                            TopicsContent(
                                id = UUID.randomUUID(),
                                title = "Blocking Schemes",
                                description = "The blocking scheme that a offensive line must execute is determined\n" +
                                        " by the play call. There are 7 base types of blocking schemes including\n" +
                                        "inside zone, outside zone, power, counter, pass pro, screens, and\n" +
                                        "draws. While these are base types there are variations with subtle differences"
                            )
                        )
                        academyDao.insert(
                            TopicsContent(
                                id = UUID.randomUUID(),
                                title = "Combinations",
                                description = "With offensive line being the one of the most cooperative positions in any sport\n" +
                                        "combinations are a key component of each players skills. Often when performing a\n" +
                                        "combination block, the goal is to drive the initial defensive lineman back to a linebacker.\n" +
                                        "However there are instances where you will do a combination block against only one person and\n" +
                                        "this is called a combination kill block since it is intended to dominate a defensive lineman. There are instances\n" +
                                        "where you will do a combination kill block against highly skilled defensive lineman to even the playing\n" +
                                        "field but these instances are rare."
                            )
                        )
                        academyDao.insert(
                            TopicsContent(
                                id = UUID.randomUUID(),
                                title = "Reading Defenses",
                                description = "What separates good and great offensive lineman is the ability to read a defense. defenses tend\n" +
                                        "to fall into 2 categories, 3 down and 4 down. This talks about the number of defensive lineman on the line\n" +
                                        "of scrimmage. The alignment of the 3/4 defensive lineman also matters as this can give you and idea as to\n" +
                                        "what the rest of the defense is doing; the variety of alignments is numerous so we will only cover a few in a\n" +
                                        "later topic."
                            )
                        )

                    }
                }
            }
        }
    }
}