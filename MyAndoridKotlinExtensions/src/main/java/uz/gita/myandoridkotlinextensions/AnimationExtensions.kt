package uz.gita.myandoridkotlinextensions

import android.animation.Animator
import android.view.ViewPropertyAnimator

fun ViewPropertyAnimator.addEndListener(endBlock: (Boolean) -> Unit): ViewPropertyAnimator {
    var isCancel = false
    this.setListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator?) {

        }

        override fun onAnimationEnd(animation: Animator?) {
            endBlock(isCancel)
        }

        override fun onAnimationCancel(animation: Animator?) {
            isCancel = true
        }

        override fun onAnimationRepeat(animation: Animator?) {

        }
    })
    return this
}