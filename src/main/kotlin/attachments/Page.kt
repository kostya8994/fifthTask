package attachments

import Attachments

class Page(
    override val id: Int = 0,
    override val ownerId: Int = 0,
    override val title: String = "Страница вики",
    override val date: Int = 0,
    val groupId: Int = 0,
    val creatorId: Int = 0,
    val currentUserCanEdit: Boolean = false,
    val currentUserCanEditAccess: Boolean = false,
    val whoCanView : Int = 0,
    val whoCanEdit : Int = 0,
    val edited : Int = 0,
    val created: Int = 0,
    val editorId: Int = 0,
    val views: Int = 0,
    val parent: String? = null,
    val parentTwo: String? = null,
    val source: String? = null,
    val html: String? = null,
    val viewUrl: String = "Адрес",
) : Attachments {
}