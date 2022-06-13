package notes

interface NoteCommentService<E> {
    fun add(note: E)
    fun delete (id: Int)
    fun edit (note: E)
    fun restore(id: Int)
}