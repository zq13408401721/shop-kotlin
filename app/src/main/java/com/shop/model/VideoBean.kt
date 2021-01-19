package com.shop.model

data class VideoBean(
    val `data`: Data,
    val status: Status
)

data class Status(
    val message: String,
    val serverTime: String,
    val statusCode: Int
)

data class Data(
    val countNumber: Int,
    val list: List<X>
)

data class X(
    val activityShow: Int,
    val albumID: Int,
    val allPostsNumber: String,
    val clothing: String,
    val commentNumber: Int,
    val content: String,
    val cover: String,
    val createTime: String,
    val expPrefix: Int,
    val expSuffix: Int,
    val headUrl: String,
    val id: Int,
    val ignb: Int,
    val images: List<Any>,
    val installedAccording: String,
    val isCollected: Int,
    val isHomeActivity: Int,
    val isRepeat: Int,
    val isVisible: Int,
    val labels: String,
    val latitude: Int,
    val level: Int,
    val likeDetails: List<Any>,
    val likeNumber: Int,
    val location: String,
    val longitude: Int,
    val nickName: String,
    val outboundPersonnel: String,
    val peopleNearby: Int,
    val photoAlbumCover: String,
    val photoAlbumName: String,
    val playTourNumber: Int,
    val postId: Int,
    val postLike: Int,
    val pullWires: Int,
    val rank: Int,
    val rankName: String,
    val rankType: Int,
    val relation: Int,
    val repeatContent: String,
    val repeatId: Int,
    val repeatNumber: Int,
    val repeatUserId: Int,
    val rewards: List<Any>,
    val scene: String,
    val sex: String,
    val shoot: String,
    val shortUrl: String,
    val suggestion: String,
    val tapeLength: Int,
    val title: String,
    val type: Int,
    val typeName: String,
    val userID: Int,
    val videoHeight: Int,
    val videoPath: String,
    val videoWidth: Int,
    val voteOptions: List<Any>
)
