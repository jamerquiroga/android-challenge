package com.jquiroga.challenge.provider

import com.jquiroga.domain.entity.Song

object SongDataProvider {

    fun songDummy() = Song(
        code = 9868573223.toInt(),
        name = "November Rain",
        albumName = "Greatest Hits",
        bandName = "Guns N Roses",
        imageUrl = "https://is4-ssl.mzstatic.com/image/thumb/Music124/v4/ec/a3/5b/eca35b60-59f1-27c9-d336-3aa1699dd417/source/100x100bb.jpg"
    )
}