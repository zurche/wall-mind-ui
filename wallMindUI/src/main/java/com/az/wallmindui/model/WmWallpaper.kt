package com.az.wallmindui.model

data class WmWallpaper(
    var key: String = "",
    var category: String = "",
    var fileUrl: String = "",
    var tags: String = "",
    var thumbnailUrl: String = "",
    var isFavorite: Boolean = false,
    var fileLocalPath: String = "",
    var thumbnailLocalPath: String = ""
)
