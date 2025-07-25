package com.arhakim.bp2crud.Model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arhakim.bp2crud.Adapter.ListPersonAdapter
import com.arhakim.bp2crud.DBHelper.DBHelper
import com.arhakim.bp2crud.Model.Person
import com.arhakim.bp2crud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: DBHelper
    private var lstPersons: List<Person> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DBHelper(this)

        refreshData()

        binding.btnAdd.setOnClickListener {
            val person = Person(
                binding.edtId.text.toString().toInt(),
                binding.edtName.text.toString(),
                binding.edtEmail.text.toString()
            )
            db.addPerson(person)
            refreshData()
        }

        binding.btnUpdate.setOnClickListener {
            val person = Person(
                binding.edtId.text.toString().toInt(),
                binding.edtName.text.toString(),
                binding.edtEmail.text.toString()
            )
            db.updatePerson(person)
            refreshData()
        }

        binding.btnDelete.setOnClickListener {
            val person = Person(
                binding.edtId.text.toString().toInt(),
                binding.edtName.text.toString(),
                binding.edtEmail.text.toString()
            )
            db.deletePerson(person)
            refreshData()
        }
    }

    private fun refreshData() {
        lstPersons = db.allPerson
        val adapter = ListPersonAdapter(
            this@MainActivity,
            lstPersons,
            binding.edtId,
            binding.edtName,
            binding.edtEmail
        )
        binding.listPersons.adapter = adapter
    }
}
