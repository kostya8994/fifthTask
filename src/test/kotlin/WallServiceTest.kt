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
}