package com.arhakim.bp2crud.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.arhakim.bp2crud.Model.Person
import com.arhakim.bp2crud.databinding.RowLayoutBinding // ← ini view binding-nya

class ListPersonAdapter(
    internal var activity: Activity,
    internal var lstPerson: List<Person>,
    internal var edt_id: EditText,
    internal var edt_name: EditText,
    internal var edt_email: EditText
) : BaseAdapter() {

    internal var inflater: LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int = lstPerson.size

    override fun getItem(position: Int): Any = lstPerson[position]

    override fun getItemId(position: Int): Long = lstPerson[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Inflate layout pakai ViewBinding
        val binding = RowLayoutBinding.inflate(inflater, parent, false)

        // Set data
        val person = lstPerson[position]
        binding.txtRowId.text = person.id.toString()
        binding.txtName.text = person.name
        binding.txtEmail.text = person.email

        // OnClick - isi editText
        binding.root.setOnClickListener {
            edt_id.setText(binding.txtRowId.text.toString())
            edt_name.setText(binding.txtName.text.toString())
            edt_email.setText(binding.txtEmail.text.toString())
        }

        return binding.root
    }
}
