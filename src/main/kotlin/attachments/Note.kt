package attachments

import Attachments

data class Note(
    override val type: String = "note",
    override val id: Int = 0,
    override val ownerId: Int = 0,
    override val title: String = "Заметка",
    override val date: Int = 0,
    val note: Note? = null,
    val text: String = "Очень интересный текст заметки",
    val comments: Int = 0,
    val readComments: Int = 0,
    val viewUrl: String = "Адрес" ,
    val privacy: Int = 1,
    val commentPrivacy: Int = 1,
    val privateView: String = "",
    val privateComment: String = "",
    var deleteNote: Boolean = false
) : Attachments {
}