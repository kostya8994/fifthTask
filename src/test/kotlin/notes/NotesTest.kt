package notes

import org.junit.Test

import org.junit.Assert.*

class NotesTest {

    @Test
    fun add() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")

        assertTrue(notes.notes[0].id == 1)
    }

    @Test
    fun createComment() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")
        notes.createComment(1,0,0,"Коммент", 0)

        assertTrue(notes.notesComments[0].id == 1)
    }

    @Test
    fun delete() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")

        assertTrue(notes.delete(1) == 1)
    }

    @Test
    fun deleteComment() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")
        notes.createComment(1,0,0,"Коммент", 0)

        assertTrue(notes.deleteComment(1, 1) == 1)
    }

    @Test
    fun edit() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")

        assertTrue(notes.edit(1,"новая заметка", "измененный текст заметки", 1, 1, "", "") == 1)
    }

    @Test
    fun editErrorDelete() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")
        notes.delete(1)

        assertTrue(notes.edit(1,"новая заметка", "измененный текст заметки", 1, 1, "", "") == 0)
    }

    @Test
    fun editComment() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")
        notes.createComment(1,0,0,"Коммент", 0)

        assertTrue(notes.editComment(1,"Измененный коммент") == 1)
    }

    @Test
    fun editCommentErrorDelete() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")
        notes.createComment(1,0,0,"Коммент", 0)
        notes.deleteComment(1, 1)

        assertTrue(notes.editComment(1,"Измененный коммент") == 0)
    }


    @Test
    fun getComments() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")
        notes.createComment(1,0,0,"первый", 0)
        notes.createComment(1,0,0,"второй", 0)

        assertTrue(notes.getComments(1) == "Найденые комментарии: /nпервый;/nвторой;/n")
    }

    @Test
    fun restoreNote() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")
        notes.delete(1)
        notes.restoreNote(1)

        assertFalse(notes.notes[0].deleteNote)
    }

    @Test
    fun restoreComment() {
        val notes = Notes()
        notes.add("новая заметка", "текст заметки", 1, 1, "", "")
        notes.createComment(1,0,0,"Коммент", 0)
        notes.restoreComment(1,0)

        assertFalse(notes.notesComments[0].deleteComment)
    }
}