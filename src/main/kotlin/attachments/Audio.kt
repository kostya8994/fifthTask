package attachments

import Attachments

class Audio(
    override val type: String = "audio",
    override val id: Int = 0,
    override val title: String = "Песня",
    override val date: Int = 0,
    override val ownerId: Int = 0,
    val audio: Audio = Audio(),
    val artist: String = "Какой-то исполнитель",
    val duration: Int = 0,
    val url: String = "Адрес",
    val genreId: Int = 0,
    var lyricsId: Int = 0,
    var albumId: Int = 0,
    var noSearch: Boolean = false,
    var isHq: Boolean = false
) : Attachments {
    fun play(): String {
        return "Играет песня $title исполнителя $artist"
    }
}