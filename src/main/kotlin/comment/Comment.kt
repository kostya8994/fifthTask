package comment

import Attachments

class Comment(
    val id: Int = 0,
    val postId: Int = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "Комментарий",
    val donut: Donut? = null,
    val replyToUser: Int = 0,
    val attachments: Attachments? = null,
    val parentsStack: Array<Int>? = null,
    val threadComment: ThreadComment? = null
) {

}