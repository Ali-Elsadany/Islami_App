package com.pi.isalmi_c40.ui.screens.home.tabs.radio

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pi.isalmi_c40.R
import com.pi.isalmi_c40.databinding.FragmentQuranBinding
import com.pi.isalmi_c40.databinding.FragmentRadioBinding


class RadioFragment : Fragment() {

    private lateinit var binding: FragmentRadioBinding
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false // Change from val to var

    // Radio URL
    private val radioUrl = "https://Qurango.net/radio/alzain_mohammad_ahmad"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadioBinding.inflate(inflater, container, false)

        // Setup media controls (play, pause, etc.)
        setupMediaControls()

        return binding.root
    }

    private fun setupMediaControls() {
        // Play/Pause Button logic
        binding.playButton.setOnClickListener {
            if (isPlaying) {
                pauseRadio()
            } else {
                playRadio()
            }
        }

        // Handle previous/next buttons if necessary
        binding.prevButton.setOnClickListener {
            Toast.makeText(requireContext(), "Previous station (not implemented)", Toast.LENGTH_SHORT).show()
        }

        binding.nextButton.setOnClickListener {
            Toast.makeText(requireContext(), "Next station (not implemented)", Toast.LENGTH_SHORT).show()
        }
    }

    private fun playRadio() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer().apply {
                setDataSource(radioUrl) // Set the streaming URL
                prepareAsync() // Prepare the MediaPlayer asynchronously
                setOnPreparedListener {
                    it.start() // Start playback when prepared
                    this@RadioFragment.isPlaying = true // Change the play state
                    updatePlayButtonUI() // Update the UI to reflect the playing state
                }
                setOnErrorListener { mp, what, extra ->
                    Toast.makeText(requireContext(), "Error playing radio", Toast.LENGTH_SHORT).show()
                    false
                }
            }
        } else {
            mediaPlayer?.start()
            isPlaying = true // Change the play state
            updatePlayButtonUI()
        }
    }

    private fun pauseRadio() {
        mediaPlayer?.pause()
        isPlaying = false // Change the play state
        updatePlayButtonUI()
    }

    // Update the play button icon depending on the play/pause state
    private fun updatePlayButtonUI() {
        if (isPlaying) {
            binding.playButton.setImageResource(R.drawable.ic_play) // Use pause icon when playing
        } else {
            binding.playButton.setImageResource(R.drawable.ic_play) // Use play icon when paused
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseMediaPlayer() // Release resources when fragment is destroyed
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
        isPlaying = false // Reset play state when releasing the media player
    }
}