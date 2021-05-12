package com.example.triviaapp.ui.fragments.summary
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.triviaapp.R
import com.example.triviaapp.databinding.FragmentSummaryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SummaryFragment: Fragment(R.layout.fragment_summary) {
    private val args: SummaryFragmentArgs by navArgs()
    private lateinit var binding: FragmentSummaryBinding
    private val viewModel: SummaryViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSummaryBinding.bind(view)

        binding.apply {
            textHelloName.text = "${getString(R.string.hello)} ${args.triviaInfo.name}"
            textBestCricketerAnswer.text = "${getString(R.string.answer)} ${args.triviaInfo.cricketerName}"
            textFlagAnswer.text = "${getString(R.string.answers)} ${args.triviaInfo.flagColors}"
        }

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.apply {
            buttonFinish.setOnClickListener {
                viewModel.insert(args.triviaInfo)
                val action = SummaryFragmentDirections.actionSummaryFragmentToNameInfoFragment()
                findNavController().navigate(action)
            }
            buttonHistory.setOnClickListener {
                val action = SummaryFragmentDirections.actionSummaryFragmentToHistoryFragment()
                findNavController().navigate(action)
            }
        }
    }
}