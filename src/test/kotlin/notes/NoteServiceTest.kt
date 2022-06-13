package notes

import attachments.Note
import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun add() {
        val notes = NoteService<Note>()
        val note = Note(id = 1)
        notes.add(note)

        assertTrue(notes.notes[0].id == 1)
    }

    @Test
    fun delete() {
        val notes = NoteService<Note>()
        val note = Note(id = 1)
        notes.add(note)
        notes.delete(1)

        assertTrue(notes.notes[0].deleteNote)
    }


    @Test
    fun edit() {
        val notes = NoteService<Note>()
        val note = Note(id = 1)
        val noteNew = Note(id = 1, text = "Новая заметка")
        notes.add(note)
        notes.edit(noteNew)

        assertTrue(notes.notes[0].text == "Новая заметка")
    }

    @Test
    fun restore() {
        val notes = NoteService<Note>()
        val note = Note(id = 1)
        notes.add(note)
        notes.delete(1)
        notes.restore(1)

        assertFalse(notes.notes[0].deleteNote)
    }
}