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
import org.json.JSONException
import org.json.JSONObject


class InventoryFragment : Fragment() {

    private lateinit var inventoryViewModel: InventoryViewModel
    private var _binding: FragmentInventoryBinding? = null

    private lateinit var test_text : TextView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        inventoryViewModel =
                ViewModelProvider(this).get(InventoryViewModel::class.java)

        _binding = FragmentInventoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        test_text = root.findViewById(R.id.testText)
        test_text.text = ""

        try {
            // As we have JSON object, so we are getting the object
            //Here we are calling a Method which is returning the JSON object
            val fileInString: String = context?.assets?.open("inventory.json")?.bufferedReader().use { it!!.readText() }
            val obj = JSONObject(fileInString)
            // fetch JSONArray named users by using getJSONArray
            val materialsArray = obj.getJSONArray("materials")
            // Get the users data using for loop i.e. id, name, email and so on

            for (i in 0 until materialsArray.length()) {
                // Create a JSONObject for fetching single Material Data
                val material = materialsArray.getJSONObject(i)
                // Fetch id store it in variable
                val id = material.getInt("id")
                val name = material.getString("name")
                test_text.text = "${test_text.text}\n $id : $name"

            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}