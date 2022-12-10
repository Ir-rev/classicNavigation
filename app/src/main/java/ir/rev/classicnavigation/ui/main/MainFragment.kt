package ir.rev.classicnavigation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ir.rev.classicnavigation.Cat
import ir.rev.classicnavigation.R
import ir.rev.classicnavigation.ui.second.SecondFragment

class MainFragment : Fragment() {

    companion object {
        private const val CAT_FRAGMENT = "CAT_FRAGMENT"
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_navigation).setOnClickListener {
            val parentFragmentManager = parentFragmentManager
            if (parentFragmentManager.findFragmentByTag(CAT_FRAGMENT) == null) {
                val fragment = SecondFragment.newInstance(
                    Cat(
                        name = "Кузя",
                        age = 2
                    )
                )
                parentFragmentManager.beginTransaction().replace(
                    R.id.container, // Вот эта проблема, то что придется знать айди родительского контейнера, что не всегда возможно
                    fragment,
                    CAT_FRAGMENT
                )
                    .addToBackStack(null)
                    .commit()
            }

        }
    }

}