package attachments

import Attachments

class Document(
    override val type: String = "document",
    override val id: Int = 0,
    override val ownerId: Int = 0,
    override val title: String = "Очень важный документ",
    override val date: Int = 0,
    val document: Document = Document(),
    val size: Int = 0,
    val ext: String = "txt",
    val url: String = "Адрес",
    val typeDocument: Int = 1,
    var preview: String? = null,
) : Attachments {
    fun viewing(): String {
        if (preview == null) {
            return "Документ $title имеет расширение $ext"
        } else {
            return "Документ $title имеет расширение $ext. Описание документа $preview"
        }
    }
}