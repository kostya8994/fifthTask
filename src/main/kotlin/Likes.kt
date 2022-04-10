data class Likes(
    val count: UInt = 0u,
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
) {
}