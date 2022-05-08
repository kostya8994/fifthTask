import comment.Comment
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val postOne = service.add(Post(text = "Первый тест"))

        assertTrue(postOne.id >= 0)
    }


    @Test
    fun updateTrue() {
        val service = WallService()
        val postOne = service.add(Post(text = "Первый тест"))
        val postTwo = service.add(Post(text = "Второй тест"))
        val postThree = service.add(Post(text = "Третий тест"))

        val update = Post(id = 2, text = "Измененный текст")
        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val service = WallService()
        val postOne = service.add(Post(text = "Первый тест"))
        val postTwo = service.add(Post(text = "Второй тест"))
        val postThree = service.add(Post(text = "Третий тест"))

        val update = Post(id = 5, text = "Измененный текст")
        val result = service.update(update)

        assertFalse(result)
    }

    @Test
    fun createCommentTrue() {
        val service = WallService()
        val postOne = service.add(Post(id = 0))
        val postTwo = service.add(Post(id = 1))
        val postThree = service.add(Post(id = 2))

        val comment = Comment(postId = 2)
        val result = service.createComment(comment)

    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentFalse() {
        val service = WallService()
        val postOne = service.add(Post(id = 0))
        val postTwo = service.add(Post(id = 1))
        val postThree = service.add(Post(id = 2))

        val comment = Comment(postId = 5)
        val result = service.createComment(comment)

    }
}