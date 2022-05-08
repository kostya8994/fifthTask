import comment.Comment

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    fun add(post: Post): Post {
        val idNewPost: Int = posts.size + 1
        posts += post.copy(id = idNewPost)
        return posts[posts.size - 1]
    }

    fun update(post: Post): Boolean {
        for ((index, postCheck) in posts.withIndex()) {
            if (postCheck.id == post.id) {
                posts[index] = postCheck.copy(
                    id = post.id,
                    toId = post.toId,
                    createdBy = post.createdBy,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                    copyright = post.copyright,
                    likes = post.likes,
                    repostsCount = post.repostsCount,
                    userReposted = post.userReposted,
                    viewsCount = post.viewsCount,
                    postType = post.postType,
                    signerId = post.signerId,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    marked_as_ads = post.marked_as_ads,
                    isFavorite = post.isFavorite,
                    donut = post.donut,
                    postponedId = post.postponedId
                )
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment){
        var commentInArray: Boolean = false
        for ((index, postCheck) in posts.withIndex()){
            if (postCheck.id == comment.postId) {
                comments += comment
                commentInArray = true
            }
        }
        if (!commentInArray) throw PostNotFoundException("no post with id ${comment.postId}")
    }
}