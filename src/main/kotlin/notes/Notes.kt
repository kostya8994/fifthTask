package notes

import attachments.Note
import comment.Comment

class Notes {
    var notes = mutableListOf<Note>()
    var notesComments = mutableListOf<Comment>()

    fun add(
        title: String = "новая заметка", text: String = "текст заметки", privacy: Int = 1,
        commentPrivacy: Int = 1, privateView: String = "", privateComment: String = ""
    ): Int {
        val idNewNote: Int = if (notes.isEmpty()) {
            1
        } else {
            notes[notes.size - 1].id + 1
        }

        notes += Note(
            id = idNewNote,
            title = title,
            text = text,
            privacy = privacy,
            commentPrivacy = commentPrivacy,
            privateView = privateView,
            privateComment = privateComment
        )
        return idNewNote
    }

    fun createComment(
        noteId: Int = 0,
        ownerId: Int = 0,
        replyTo: Int = 0,
        message: String = "Коммент",
        guid: Int = 0
    ): Int {
        val idNewComment: Int = if (notesComments.isEmpty()) {
            1
        } else {
            notesComments[notesComments.size - 1].id + 1
        }
        notesComments += Comment(id = idNewComment, postId = noteId, fromId = ownerId, text = message)
        return idNewComment
    }

    fun delete(noteId: Int): Int {
        for ((index, noteCheck) in notes.withIndex()) {
            if (noteCheck.id == noteId) {
                notes[index] = noteCheck.copy(
                    deleteNote = true
                )
                deleteComment(ownerId = notes[index].ownerId)
                return 1
            }
        }
        return 0
    }

    fun deleteComment(commentId: Int = 0, ownerId: Int): Int {
        for ((index, commentCheck) in notesComments.withIndex()) {
            if (commentCheck.id == commentId) {
                notesComments[index].deleteComment = true
            }
            if (commentCheck.postId == ownerId) {
                notesComments[index].deleteComment = true
            }
        }
        return 1
    }

    fun edit(
        noteId: Int,
        title: String,
        text: String,
        privacy: Int = 1,
        commentPrivacy: Int,
        privateView: String,
        privateComment: String
    ): Int {
        for ((index, noteCheck) in notes.withIndex()) {
            if (noteCheck.id == noteId) {
                if (notes[index].deleteNote) return 0
                notes[index] = noteCheck.copy(
                    title = title,
                    text = text,
                    privacy = privacy,
                    commentPrivacy = commentPrivacy,
                    privateView = privateView,
                    privateComment = privateComment
                )
            }
        }
        return 1
    }

    fun editComment(commentId: Int, message: String): Int {
        for ((index, comentCheck) in notesComments.withIndex()) {
            if (comentCheck.id == commentId) {
                if (notesComments[index].deleteComment) return 0
                notesComments[index].text = message
            }
        }
        return 1
    }

    fun getById(noteId: Int): Note? {
        for ((index, noteCheck) in notes.withIndex()) {
            if (noteCheck.id == noteId) {
                if (notes[index].deleteNote) return null
                return notes[index]
            }
        }
        return null
    }

    fun getComments(noteId: Int): String {
        var stringComments: String = "Найденые комментарии: /n"
        for ((index, comentCheck) in notesComments.withIndex()) {
            if (comentCheck.postId == noteId) {
                if (notesComments[index].deleteComment) {
                    continue
                } else {
                    stringComments += notesComments[index].text + ";/n"
                }
            }
        }
        return stringComments
    }

    fun restoreNote(noteId: Int): Int {
        for ((index, noteCheck) in notes.withIndex()) {
            if (noteCheck.id == noteId) {
                notes[index] = noteCheck.copy(
                    deleteNote = false
                )

            }
        }
        return 1
    }

    fun restoreComment(commentId: Int, ownerId: Int): Int {
        for ((index, commentCheck) in notesComments.withIndex()) {
            if (commentCheck.id == commentId) {
                notesComments[index].deleteComment = false
            }
        }
        return 1
    }
}