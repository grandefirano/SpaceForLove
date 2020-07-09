package com.grandefirano.spaceforlove.ui.photoMatcher

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import com.grandefirano.spaceforlove.R
import com.grandefirano.spaceforlove.SpacePhotoAdapter
import com.grandefirano.spaceforlove.data.entity.ReviewOfPhotos
import com.yuyakaido.android.cardstackview.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_photo_matcher.view.*

@AndroidEntryPoint
class PhotoMatcherFragment : Fragment(),CardStackListener {

    private val TAG = "PhotoMatcherFragment"

    // private lateinit var photoMatcherViewModel: PhotoMatcherViewModel
    private val photoMatcherViewModel by navGraphViewModels<PhotoMatcherViewModel>(R.id.mobile_navigation) {
        defaultViewModelProviderFactory
    }

    private var count=0

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

        photoMatcherViewModel.nasaPhotosResponse.observe(viewLifecycleOwner, Observer {
            //temporary

            adapter.submitList(it)
        })

        return view

    }

    

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        Log.d(TAG, "onCardDragging: ")
    }

    override fun onCardSwiped(direction: Direction?) {
        when(direction){
            Direction.Left->{
                Log.d(TAG, "onCardSwiped:Left ")
                photoMatcherViewModel.addDislike()
                photoMatcherViewModel.addPhotoToList(count,false)
                Log.d(TAG, "onCardSwiped: ${photoMatcherViewModel.dislikes}")

            }
            Direction.Right->{
                Log.d(TAG, "onCardSwiped:Right ")
                photoMatcherViewModel.addLike()
                photoMatcherViewModel.addPhotoToList(count,true)
                Log.d(TAG, "onCardSwiped: ${photoMatcherViewModel.likes}")
            }
            else->{
                Log.d(TAG, "onCardSwiped: Incorrect Swipe")
            }
        }
        count+=1
        if(count>=adapter.itemCount){
            Log.d(TAG, "onCardSwiped: That's all")

            navigateToResultFragment()


        }


    }

    private fun navigateToResultFragment() {
        val likesCount=photoMatcherViewModel.likes
        val dislikesCount=photoMatcherViewModel.dislikes
//        val array=photoMatcherViewModel.listOfPhotos.toTypedArray()
        val mapOfReviews=ReviewOfPhotos(photoMatcherViewModel.mapOfReviews, "male","female")
        val action=PhotoMatcherFragmentDirections
            .actionPhotoMatcherToResult(likesCount,dislikesCount,mapOfReviews)
        findNavController().navigate(action)
    }

    override fun onCardCanceled() {
        Log.d(TAG, "onCardCanceled: ")
    }

    override fun onCardAppeared(view: View?, position: Int) {
        Log.d(TAG, "onCardAppeared: ")
    }

    override fun onCardRewound() {
        Log.d(TAG, "onCardRewound: ")
    }
    override fun onCardDisappeared(view: View?, position: Int) {
        Log.d(TAG, "onCardDisappeared: ${adapter.itemCount-1}  pos: $position")
        if(position>=adapter.itemCount-1){
            Log.d(TAG, "onCardDisappeared: That's all")
            
        }
    }
}