package com.nexora.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nexora.data.local.entity.UserEntity
import com.nexora.data.local.entity.MatchEntity
import com.nexora.data.local.entity.MeetingEntity
import com.nexora.data.local.entity.InsightEntity
import com.nexora.data.local.entity.MessageEntity
import com.nexora.data.local.dao.UserDao
import com.nexora.data.local.dao.MatchDao
import com.nexora.data.local.dao.MeetingDao
import com.nexora.data.local.dao.InsightDao
import com.nexora.data.local.dao.MessageDao

@Database(
    entities = [UserEntity::class, MatchEntity::class, MeetingEntity::class, InsightEntity::class, MessageEntity::class],
    version = 1,
    exportSchema = false
)
@androidx.room.TypeConverters(com.nexora.data.local.converters.Converters::class)
abstract class NexoraDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
    abstract fun matchDao(): MatchDao
    abstract fun meetingDao(): MeetingDao
    abstract fun insightDao(): InsightDao
    abstract fun messageDao(): MessageDao
}