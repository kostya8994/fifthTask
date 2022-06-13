package notes

import attachments.Note
import comment.Comment
import org.junit.Test

import org.junit.Assert.*

class CommentServiceTest {

    @Test
    fun add() {
        val comments = CommentService<Comment>()
        val comment = Comment(id = 1)
        comments.add(comment)

        assertTrue(comments.notesComments[0].id == 1)
    }

    @Test
    fun delete() {
        val comments = CommentService<Comment>()
        val comment = Comment(id = 1)
        comments.add(comment)
        comments.delete(1)

        assertTrue(comments.notesComments[0].deleteComment)
    }

    @Test
    fun edit() {
        val comments = CommentService<Comment>()
        val comment = Comment(id = 1)
        val commentNew = Comment(id = 1, text = "Новый коммент")
        comments.add(comment)
        comments.edit(commentNew)

        assertTrue(comments.notesComments[0].text == "Новый коммент")
    }

    @Test
    fun restore() {
        val comments = CommentService<Comment>()
        val comment = Comment(id = 1)
        comments.add(comment)
        comments.delete(1)
        comments.restore(1)

        assertFalse(comments.notesComments[0].deleteComment)
    }
}