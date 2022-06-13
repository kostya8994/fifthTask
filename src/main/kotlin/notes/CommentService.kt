package notes

import comment.Comment

class CommentService<E>() : NoteCommentService<E> {
    var notesComments = mutableListOf<Comment>()

    override fun add(note: E) {
        if (note is Comment) {
            val idNewComment: Int = if (notesComments.isEmpty()) {
                1
            } else {
                notesComments[notesComments.size - 1].id + 1
            }
            notesComments += note
        }
    }

    override fun delete(id: Int) {
        for ((index, commentCheck) in notesComments.withIndex()) {
            if (commentCheck.id == id) {
                notesComments[index].deleteComment = true
            }
            if (commentCheck.postId == id) {
                notesComments[index].deleteComment = true
            }
        }
    }

    override fun edit(note: E) {
        if (note is Comment) {
            for ((index, commentCheck) in notesComments.withIndex()) {
                if (commentCheck.id == note.id) {
                    if (!notesComments[index].deleteComment)
                        notesComments[index] = note
                }
            }
        }
    }

    override fun restore(id: Int) {
        for ((index, commentCheck) in notesComments.withIndex()) {
            if (commentCheck.id == id) {
                notesComments[index].deleteComment = false
            }
        }
    }
}