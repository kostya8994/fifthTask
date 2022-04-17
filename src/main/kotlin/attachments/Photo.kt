package attachments

import Attachments

class Photo(
    override val id: Int = 0,
    override val ownerId: Int = 0,
    override val title: String = "Фотка",
    override val date: Int = 0,
    val albumId: Int = 0,
    val userId: Int = 0,
    val width: Int = 0,
    val height: Int = 0,
) : Attachments {
}