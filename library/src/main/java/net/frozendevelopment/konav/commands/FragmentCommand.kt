package net.frozendevelopment.konav.commands

import android.os.Bundle
import android.support.v4.app.Fragment
import java.lang.ref.WeakReference

/**
 * Created by josh on 2/3/18.
 */


open class FragmentCommand(nextFragment: Fragment, args: Map<String, Any?>? = null): Command {

    val frag: WeakReference<Fragment>
    val screenKey = nextFragment::class.java.toString()

    init {
        if (args != null) {
            nextFragment.arguments = this.packBundle(args)
        }
        this.frag = WeakReference(nextFragment)
    }

    open fun packBundle(args: Map<String, Any?>): Bundle {
        val bundle = Bundle()
        args.forEach {
            when (it.value) {
                is Int -> bundle.putInt(it.key, it.value as Int)
                is Double -> bundle.putDouble(it.key, it.value as Double)
                is Float -> bundle.putFloat(it.key, it.value as Float)
                is Byte -> bundle.putByte(it.key, it.value as Byte)
                is Boolean -> bundle.putBoolean(it.key, it.value as Boolean)
                else -> bundle.putString(it.key, it.value?.toString())
            }
        }
        return bundle
    }

}
