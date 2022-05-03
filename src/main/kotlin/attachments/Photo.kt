package attachments

import Attachments

data class Photo(
    override val type: String = "photo",
    override val id: Int = 0,
    override val ownerId: Int = 0,
    override val title: String = "Фотка",
    override val date: Int = 0,
    val photo: Photo = Photo(),
    val albumId: Int = 0,
    val userId: Int = 0,
    val width: Int = 0,
    val height: Int = 0,
) : Attachments {
}