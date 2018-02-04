package net.frozendevelopment.konav.commands

import android.support.v4.app.Fragment

/**
 * Created by josh on 2/3/18.
 */


open class ForwardFragment(nextFragment: Fragment, args: Map<String, Any?>? = null): FragmentCommand(nextFragment, args)
