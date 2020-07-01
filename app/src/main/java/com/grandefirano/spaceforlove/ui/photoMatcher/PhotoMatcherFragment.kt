package com.grandefirano.spaceforlove.ui.photoMatcher

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import com.grandefirano.spaceforlove.R
import com.grandefirano.spaceforlove.SpacePhotoAdapter
import com.grandefirano.spaceforlove.databinding.FragmentPhotoMatcherBinding
import com.grandefirano.spaceforlove.util.GlideApp
import com.grandefirano.spaceforlove.util.RotateTransformation
import com.yuyakaido.android.cardstackview.*
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_photo_matcher.*
import kotlinx.android.synthetic.main.fragment_photo_matcher.view.*

@AndroidEntryPoint
class PhotoMatcherFragment : Fragment(),CardStackListener {

    private val TAG = "PhotoMatcherFragment"

    // private lateinit var photoMatcherViewModel: PhotoMatcherViewModel
    private val photoMatcherViewModel by navGraphViewModels<PhotoMatcherViewModel>(R.id.mobile_navigation) {
        defaultViewModelProviderFactory
    }

    private val adapter=SpacePhotoAdapter()
    private val layoutManager by lazy {
        CardStackLayoutManager(this.context,this).apply {
            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            setOverlayInterpolator(LinearInterpolator())
            setDirections(Direction.HORIZONTAL)
            setStackFrom(StackFrom.Top)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
////TODO:binding may be deleted here

          val view=inflater.inflate(R.layout.fragment_photo_matcher, container, false)
//        binding.viewmodel=photoMatcherViewModel
//        binding.lifecycleOwner=this

        view.stack_view.layoutManager=layoutManager
        view.stack_view.adapter=adapter
        view.stack_view.itemAnimator.apply {
            if(this is DefaultItemAnimator){
                supportsChangeAnimations=false
            }
        }

        photoMatcherViewModel.nasaPhotos.observe(viewLifecycleOwner, Observer {
            //temporary

            adapter.submitList(listOf(it))
        })



        return view
        ////
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        Log.d(TAG, "onCardDisappeared: ${adapter.itemCount-1}  pos: $position")
        if(position>=adapter.itemCount-1){
            Log.d(TAG, "onCardDisappeared: That's all")
        }
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {
        when(direction){
            Direction.Left->{
                Log.d(TAG, "onCardSwiped:Left ")
            }
            Direction.Right->{
                Log.d(TAG, "onCardSwiped:Right ")
            }
        }
    }

    override fun onCardCanceled() {

    }

    override fun onCardAppeared(view: View?, position: Int) {

    }

    override fun onCardRewound() {

    }
}