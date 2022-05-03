package attachments

import Attachments

data class Note(
    override val type: String = "note",
    override val id: Int = 0,
    override val ownerId: Int = 0,
    override val title: String = "Заметка",
    override val date: Int = 0,
    val note: Note = Note(),
    val text: String = "Очень интересный текст заметки",
    val comments: Int = 0,
    val readComments: Int = 0,
    val viewUrl: String = "Адрес"
) : Attachments {
}