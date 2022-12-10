package ir.rev.classicnavigation.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ir.rev.classicnavigation.Cat
import ir.rev.classicnavigation.R

class SecondFragment : Fragment() {

    companion object {

        private const val CAT_ARGS = "CAT_ARGS"

        fun newInstance(cat: Cat) = SecondFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CAT_ARGS, cat)
            }
        }
    }

    private lateinit var viewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.cat_description).apply {
            val cat: Cat = requireArguments().getParcelable(CAT_ARGS) ?: return@apply
            text = "я кот ${cat.name}\nмне ${cat.age} лет"
        }
    }

}