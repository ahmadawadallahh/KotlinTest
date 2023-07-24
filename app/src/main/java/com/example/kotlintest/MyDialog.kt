package com.example.kotlintest

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.kotlintest.databinding.AddPersonBinding

class MyDialog : DialogFragment() {
    private lateinit var binding: AddPersonBinding
    private var firstName: String?=null
    private var lastName: String?=null
    private lateinit var  listener:OnSendClickListener

    companion object{
        fun getInstance(/*firstName: String, lastName:String,*/listener: OnSendClickListener):MyDialog
        {
            val dialog=MyDialog()
//            dialog.firstName=firstName
//            dialog.lastName=lastName
            dialog.listener=listener
            return dialog
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=AddPersonBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (showsDialog){
            dialog?.setCancelable(false)
        }
        binding.addBtn.setOnClickListener {
            if (!TextUtils.isEmpty(binding.firstNameEdt.text) || !TextUtils.isEmpty(binding.lastNameEdt.text))
            {
            listener.click(binding.firstNameEdt.text.toString(),binding.lastNameEdt.text.toString())
            dialog?.dismiss()}
            else
            {
                Toast.makeText(context,"Enter first or last name",Toast.LENGTH_LONG).show()
            }
        }

    }
}