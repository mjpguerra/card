package layout.superdigital.com.superdigitallayout.animator

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Build
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.annotation.RequiresApi
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.LinearInterpolator


/**
 * @author Mario Guerra on 10/07/2019
 */
class CentralAnimator{

    companion object {
        @SuppressLint("ObjectAnimatorBinding")
        @JvmStatic fun mAnimatePath(view: View){
            val objectAnimator = ObjectAnimator.ofFloat(view, "percentage", 0.0f, 1.0f)
            objectAnimator.duration = 3000
            objectAnimator.interpolator = LinearInterpolator()
            objectAnimator.repeatCount = ObjectAnimator.INFINITE
            objectAnimator.start()
        }

        /**
         * Physics Animation
         */
        @JvmStatic fun startAnimatorError(view: View) {
            val springAnimation = SpringAnimation(view, DynamicAnimation.TRANSLATION_X)
            val force = SpringForce()
            force.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
            force.stiffness = SpringForce.STIFFNESS_LOW
            force.finalPosition = 0f
            springAnimation.spring = force
            springAnimation.setStartVelocity(5000f)
            springAnimation.start()
            view.tag = springAnimation
        }


        @JvmStatic fun startAnimatorVertical(view: View) {
            val springAnimation = SpringAnimation(view, DynamicAnimation.TRANSLATION_Y)
            val force = SpringForce()
            force.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
            force.stiffness = SpringForce.STIFFNESS_LOW
            force.finalPosition = 0f
            springAnimation.spring = force
            springAnimation.setStartVelocity(5000f)
            springAnimation.start()
        }

        @JvmStatic fun startPhysicsAnimitionScale(view: View){
            val springAnimationX = SpringAnimation(view, SpringAnimation.SCALE_X)
            val forceX = SpringForce()
            forceX.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
            forceX.stiffness = SpringForce.STIFFNESS_HIGH
            forceX.finalPosition = 1f
            springAnimationX.spring = forceX
            springAnimationX.setStartVelocity(1000f)

            val springAnimationY = SpringAnimation(view, SpringAnimation.SCALE_Y)
            val forceY = SpringForce()
            forceY.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
            forceY.stiffness = SpringForce.STIFFNESS_HIGH
            forceY.finalPosition = 1f
            springAnimationY.spring = forceY
            springAnimationY.setStartVelocity(1000f)

            springAnimationX.start()
            springAnimationY.start()
        }


        /**
         * Reveal Effect
         */
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        @JvmStatic fun showRevealView(view: View, duration: Long){
            //center point
            val cx = (view.left + view.right) / 2
            val cy = (view.bottom) / 2
            //radius
            val radius = Math.max(view.width, view.height)
            val animation = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0f, radius.toFloat())
            view.visibility = View.VISIBLE
            animation.duration = duration
            animation.start()
        }

    }


}