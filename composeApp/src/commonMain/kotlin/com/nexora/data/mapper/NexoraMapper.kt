package com.nexora.data.mapper

import com.nexora.data.local.entity.InsightEntity
import com.nexora.data.local.entity.MatchEntity
import com.nexora.data.local.entity.MeetingEntity
import com.nexora.data.local.entity.MessageEntity
import com.nexora.data.local.entity.UserEntity
import com.nexora.domain.model.Insight
import com.nexora.domain.model.Match
import com.nexora.domain.model.MatchStatusEnum
import com.nexora.domain.model.Meeting
import com.nexora.domain.model.MeetingStatusEnum
import com.nexora.domain.model.Message
import com.nexora.domain.model.User
import com.nexora.domain.model.StatusEnum

fun UserEntity.toDomain(): User {
    return User(
        id = id, 
        name = name,
        email = email,
        username = username,
        photoUrl = photoUrl, 
        bio = bio, 
        skills = skills, 
        goals = goals, 
        stage = stage, 
        status = StatusEnum.valueOf(status)
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        username = username,
        email = email,
        name = name, 
        photoUrl = photoUrl, 
        bio = bio, 
        skills = skills, 
        goals = goals, 
        stage = stage, 
        status = status.name
    )
}

fun MatchEntity.toDomain(): Match {
    return Match(
        id = id, 
        user1Id = user1Id, 
        user2Id = user2Id, 
        status = MatchStatusEnum.valueOf(status)
    )
}

fun Match.toEntity(): MatchEntity {
    return MatchEntity(
        id = id, 
        user1Id = user1Id, 
        user2Id = user2Id, 
        status = status.name
    )
}

fun MeetingEntity.toDomain(): Meeting {
    return Meeting(
        id = id,
        match = matchId,
        title = title,
        description = description,
        date = date,
        status = MeetingStatusEnum.valueOf(status),
        participants = participants
    )
}

fun Meeting.toEntity(): MeetingEntity {
    return MeetingEntity(
        id = id, 
        matchId = match,
        title = title, 
        description = description, 
        date = date, 
        status = status.name,
        participants = participants
    )
}

fun InsightEntity.toDomain(): Insight {
    return Insight(
        id = id, 
        title = title, 
        content = content, 
        tags = tags, 
        status = status
    )
}

fun Insight.toEntity(): InsightEntity {
    return InsightEntity(
        id = id, 
        title = title, 
        content = content, 
        tags = tags, 
        status = status
    )
}

fun MessageEntity.toDomain(): Message {
    return Message(
        messageId = id, 
        matchId = matchId, 
        senderId = senderId, 
        receiverId = receiverId, 
        text = text,
        timestamp = timestamp
    )
}

fun Message.toEntity(): MessageEntity {
    return MessageEntity(
        id = messageId, 
        matchId = matchId, 
        senderId = senderId, 
        receiverId = receiverId, 
        text = text,
        timestamp = timestamp
    )
}
