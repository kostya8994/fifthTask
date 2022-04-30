class WallService {
    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        val idNewPost : Int = if (posts.isEmpty()) {
            1
        }
        else {
            posts[posts.size - 1].id + 1
        }
        posts += post.copy(id = idNewPost)
        return posts.last()
    }

    fun update(post: Post): Boolean {
//        val postCheck : Post
        for ((index, postCheck) in posts.withIndex()) {
            if (postCheck.id == post.id) {
                posts[index] = post.copy(
                    date = postCheck.date,
                    toId = postCheck.toId
                )
                return true
            }
        }
        return false
    }
}