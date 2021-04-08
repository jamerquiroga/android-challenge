package com.jquiroga.challenge.features.songdetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.jquiroga.challenge.core.extensions.loadImage
import com.jquiroga.challenge.core.platform.BaseFragment
import com.jquiroga.challenge.databinding.FragmentSongDetailBinding

class SongDetailFragment : BaseFragment() {

    private var _viewBinding: FragmentSongDetailBinding? = null

    private val viewBinding get() = _viewBinding!!

    private val safeArgs: SongDetailFragmentArgs by navArgs()
    private val songModel by lazy { safeArgs.song }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentSongDetailBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun initUI() {
        viewBinding.run {
            imageSong.loadImage(songModel.imageUrl)
            textSongName.text = songModel.name
            textAlbumName.text = songModel.albumName
            textBandName.text = songModel.bandName
        }
    }

}