package com.example.lostinsiberia.ui.inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lostinsiberia.R
import com.example.lostinsiberia.databinding.FragmentInventoryBinding
import com.example.lostinsiberia.ui.actions.ActionsFragment
import com.example.lostinsiberia.utils.Actions
import com.example.lostinsiberia.utils.Inventory

class InventoryFragment : Fragment() {

    private lateinit var inventoryViewModel: InventoryViewModel
    private var _binding: FragmentInventoryBinding? = null

    private lateinit var test_text : TextView
    private lateinit var inventory : Inventory

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        inventoryViewModel =
                ViewModelProvider(this).get(InventoryViewModel::class.java)

        _binding = FragmentInventoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        test_text = root.findViewById(R.id.testText)


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}