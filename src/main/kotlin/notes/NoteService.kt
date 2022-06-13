package notes

import attachments.Note
import comment.Comment

class NoteService<E>() : NoteCommentService<E> {

    var notes = mutableListOf<Note>()

    override fun add(note: E) {
        if (note is Note) {
            notes += note
        }
    }

    override fun delete(id: Int) {
        for ((index, noteCheck) in notes.withIndex()) {
            if (noteCheck.id == id) {
                notes[index] = noteCheck.copy(
                    deleteNote = true
                )
            }
        }
    }

    override fun edit(note: E) {
        if (note is Note) {
            for ((index, noteCheck) in notes.withIndex()) {
                if (noteCheck.id == note.id) {
                    if (!notes[index].deleteNote)
                        notes[index] = note

                }
            }
        }
    }

    override fun restore(id: Int) {
        for ((index, noteCheck) in notes.withIndex()) {
            if (noteCheck.id == id) {
                notes[index] = noteCheck.copy(
                    deleteNote = false
                )
            }
        }
    }
}
