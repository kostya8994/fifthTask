data class Post(
    val id : Int,
    val toId : Int,
    val fromId : Int,
    val createdBy : Int,
    val date : Int,
    val text : String,
    val replyOwnerId : Int,
    val replyPostId : Int,
    val friendsOnly : Boolean,
    val comments : Comments,
    val copyright: Copyright,
    val likes: Likes,
    val repostsCount : Int,
    val userReposted : Boolean,
    val viewsCount : Int,
    val postType : String,
    val signerId : Int,
    val canPin : Boolean,
    val canDelete : Boolean,
    val canEdit : Boolean,
    val isPinned : Boolean,
    val marked_as_ads : Boolean,
    val isFavorite : Boolean,
    val donut: Donut,
    val postponedId : Int,
) {
}