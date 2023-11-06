package com.nivs.all.room_offline_crud_notes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nivs.all.R
import kotlinx.coroutines.launch
import java.util.*

class RoomCRUDActivity : AppCompatActivity() {
    private var addButton: Button? = null
    lateinit var editText: EditText
    private lateinit var adapter: NotesRVAdapter
    private var noteDateAdded : Date? = null
    private var noteText : String = ""
    private val noteDatabase by lazy { NoteDatabase.getDatabase(this).noteDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_room)

        addButton = this.findViewById(R.id.addButton)
        editText = this.findViewById(R.id.editText)

        setRecyclerView()

        observeNotes()

        addData()
    }

    private fun addData() {
        addButton?.setOnClickListener {
            noteText = editText.text.toString()
            if (noteText.isNotEmpty() && noteDateAdded == null) {
                noteDateAdded = Date()
                // Add the new note at the top of the list
                val newNote = Note(noteDateAdded!!, noteText)
                lifecycleScope.launch {
                    noteDatabase.addNote(newNote)
                }
                noteText = ""
                editText.setText("")
                noteDateAdded = null
            } else if (noteText.isNotEmpty() && noteDateAdded != null) {
                val editedNote = Note(noteDateAdded!!, noteText)
                lifecycleScope.launch {
                    noteDatabase.updateNote(editedNote)
                }
                noteText = ""
                editText.setText("")
                noteDateAdded = null
            }
            else {
                    Toast.makeText(this, "Write data", Toast.LENGTH_LONG).show()
                }
        }
    }

    private fun setRecyclerView() {
        val notesRecyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        notesRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = NotesRVAdapter()
        adapter.setItemListener(object : RecyclerClickListener {

            // Tap the 'X' to delete the note.
            override fun onItemRemoveClick(position: Int) {
                val notesList = adapter.currentList.toMutableList()
                val noteText = notesList[position].noteText
                val noteDateAdded = notesList[position].dateAdded
                val removeNote = Note(noteDateAdded, noteText)
                lifecycleScope.launch {
                    noteDatabase.deleteNote(removeNote)
                }
            }

            // Tap the note to edit.
            override fun onItemClick(position: Int) {
                val notesList = adapter.currentList.toMutableList()
                noteDateAdded = notesList[position].dateAdded
                editText.setText(notesList[position].noteText)
                noteText = notesList[position].noteText
            }
        })
        notesRecyclerview.adapter = adapter
    }

    private fun observeNotes() {
            lifecycleScope.launch {
                noteDatabase.getNotes().collect { notesList ->
                    if (notesList.isNotEmpty()) {
                        adapter.submitList(notesList)
                    }
                }
            }
        }
}