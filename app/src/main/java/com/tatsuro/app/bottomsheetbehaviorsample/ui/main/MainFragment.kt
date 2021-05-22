package com.tatsuro.app.bottomsheetbehaviorsample.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.tatsuro.app.bottomsheetbehaviorsample.IncomeOrExpenseType
import com.tatsuro.app.bottomsheetbehaviorsample.R
import com.tatsuro.app.bottomsheetbehaviorsample.databinding.MainFragmentBinding

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = MainFragmentBinding.bind(view)

        val bottomSheet = binding.bottomSheet
        val behavior = BottomSheetBehavior.from(bottomSheet)
        behavior.apply {
            state = BottomSheetBehavior.STATE_HIDDEN
            isDraggable = false

            addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    Log.d("MainFragment", "newState: $newState")
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    Log.d("MainFragment", "slideOffset: $slideOffset")
                }
            })
        }

        binding.apply {
            hideButton.setOnClickListener {
                Log.d("MainFragment", "HideButton has been clicked.")
                behavior.state = BottomSheetBehavior.STATE_HIDDEN
            }

            expandButton.setOnClickListener {
                Log.d("MainFragment", "ExpandButton has been clicked.")
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }

            collapseButton.setOnClickListener {
                Log.d("MainFragment", "CollapseButton has been clicked.")
                behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }

            bottomSheetToolbar.setNavigationOnClickListener {
                behavior.state = BottomSheetBehavior.STATE_HIDDEN
            }

            typeRecyclerView.apply {
                layoutManager = GridLayoutManager(
                    requireContext(), 3, RecyclerView.VERTICAL, false)
                adapter = TypeAdapter(IncomeOrExpenseType.incomeTypes()) {
                    Log.d("MainFragment", "Item has been clicked.")
                    Log.d("MainFragment", "item: $it")
                    behavior.state = BottomSheetBehavior.STATE_HIDDEN
                    Toast.makeText(
                        requireContext(), "${it}がクリックされました", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}