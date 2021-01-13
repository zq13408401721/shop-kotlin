package com.shop.model

data class HotBean(
    val `data`: Data,
    val status: Status
)
{
    data class Status(
            val message: String,
            val serverTime: String,
            val statusCode: Int
    )

    data class Data(
            val comTotal: Int,
            val list: List<X>,
            val total: Int
    )

    data class X(
            var corner:Int = 20,
            val author: String,
            val cagetory: String,
            val commID: Int,
            val content: String,
            val cover: String,
            val createTime: String,
            val detailUrl: String,
            val filePathList: List<FilePath>,
            val id: Int,
            val keyword: String,
            val listImages: String,
            val qiYuId: String,
            val reptileArticleID: Int,
            val sourceStr: String,
            val status: Int,
            val title: String,
            val type: Int
    )

    data class FilePath(
            val filePath: String
    )
}

