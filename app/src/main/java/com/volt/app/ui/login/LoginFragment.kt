package com.volt.app.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.volt.app.R
import com.volt.app.data.wrapper.Resource
import com.volt.app.databinding.LoginFragmentBinding
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.main_activity.*

class LoginFragment : Fragment(){

    private lateinit var vm: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        vm = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.loginEt.requestFocus()
        binding.submitBtn.setOnClickListener {
            binding.isLoading = true
            login(binding.loginEt.text.toString())
            binding.loginEt.onEditorAction(EditorInfo.IME_ACTION_DONE);
        }
    }

    private fun login(code:String) {
        vm.login(code).observe(this, Observer { resource ->
            if (resource?.status == Resource.Status.SUCCESS) {
                binding.isLoading = false
                vm.setData(resource.data)
            } else {
                binding.isLoading = false
                Snackbar.make(binding.root, resource?.message ?: "Error", Snackbar.LENGTH_LONG)
                    .show()
            }
        })
    }

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        (activity as AppCompatActivity).supportActionBar?.show()
        super.onStop()
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}