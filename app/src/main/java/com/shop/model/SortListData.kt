package com.shop.model

data class SortListData(
    val currentCategory: CurrentCategory
)

data class CurrentCategory(
    val banner_url: String,
    val front_desc: String,
    val front_name: String,
    val icon_url: String,
    val id: Int,
    val img_url: String,
    val is_show: Int,
    val keywords: String,
    val level: String,
    val name: String,
    val parent_id: Int,
    val show_index: Int,
    val sort_order: Int,
    val subCategoryList: List<SubCategory>,
    val type: Int,
    val wap_banner_url: String
)

data class SubCategory(
    val banner_url: String,
    val front_desc: String,
    val front_name: String,
    val icon_url: String,
    val id: Int,
    val img_url: String,
    val is_show: Int,
    val keywords: String,
    val level: String,
    val name: String,
    val parent_id: Int,
    val show_index: Int,
    val sort_order: Int,
    val type: Int,
    val wap_banner_url: String
)