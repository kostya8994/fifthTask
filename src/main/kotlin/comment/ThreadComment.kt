package comment

data class ThreadComment(
    val count: Int = 0,
    val canPosts: Boolean = true,
    val showReplyButton: Boolean = false,
    val groupsCanPost: Boolean = true
) {
}