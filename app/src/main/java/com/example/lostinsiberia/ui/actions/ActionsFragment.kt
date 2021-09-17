package com.example.lostinsiberia.ui.actions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lostinsiberia.R
import com.example.lostinsiberia.databinding.FragmentActionsBinding
import com.example.lostinsiberia.ui.inventory.InventoryFragment
import com.example.lostinsiberia.utils.*
import com.google.gson.Gson

class ActionsFragment : Fragment() {

    private lateinit var actionsViewModel: ActionsViewModel

    private lateinit var action_spinner: Spinner
    private lateinit var log_view: TextView
    private lateinit var button: Button

    private lateinit var tmp_action : Action
    private lateinit var tmp_am : ActionMaterial
    private lateinit var tmp_ac : ActionCraft
    private lateinit var p : Player




    private var _binding: FragmentActionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?


    ): View {
        actionsViewModel =
                ViewModelProvider(this).get(ActionsViewModel::class.java)

        _binding = FragmentActionsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        action_spinner = root.findViewById(R.id.action_spinner)
        //val actions = resources.getStringArray(R.array.actions_spinner)

        val wood = Material(1, "Wood")
        val stone = Material(2, "Stone")

        val action1 = ActionMaterial("Forage wood", wood, 2)
        val action2 = ActionMaterial("Forage stone", stone, 1)

        val actions = Actions().actionManager
        actions.add(action1)
        actions.add(action2)


        
        action_spinner.adapter = activity?.let { ArrayAdapter<Action>(it, android.R.layout.simple_list_item_1, actions) }

        log_view = root.findViewById(R.id.log_view)
        button = root.findViewById(R.id.action_button)

        p = Player("Sqaarf")
        p.setInventory(this.arguments?.get("inventory") as Inventory?)

        action_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                button.setOnClickListener {

                    if (actions[p2] is ActionMaterial) { //If the action affect a material
                        tmp_am = actions[p2] as ActionMaterial //Creating a ActionMaterial variable
                        p.inventory.add(tmp_am.material, tmp_am.quantity)

                        log_view.text = p.inventory.getIM()[tmp_am.material].toString()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                log_view.text = "Please select an action"
            }
        }



        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}