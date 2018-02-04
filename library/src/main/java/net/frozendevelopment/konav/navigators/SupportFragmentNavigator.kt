package net.frozendevelopment.konav.navigators

import android.support.v4.app.FragmentManager
import net.frozendevelopment.konav.commands.*

/**
 * Created by josh on 2/3/18.
 */


open class SupportFragmentNavigator(private val manager: FragmentManager, private val containerId: Int): Navigator {

    override fun applyCommand(command: Command) = when(command) {
        is ForwardFragment -> forward(command)
        is ReplaceWithFragment -> replace(command)
        is BackTo -> backTo(command)
        is Back -> back()
        else -> { }
    }

    open protected fun forward(command: ForwardFragment) {
        val transaction = this.manager.beginTransaction()
        transaction
                .replace(this.containerId, command.frag.get())
                .addToBackStack(command.screenKey)
                .commit()
    }

    open protected fun replace(command: ReplaceWithFragment) {
        if (this.manager.backStackEntryCount > 0) {
            this.manager.popBackStack()

            val transaction = this.manager.beginTransaction()
            transaction
                    .replace(this.containerId, command.frag.get())
                    .addToBackStack(command.screenKey)
                    .commit()
        } else {
            val transaction = this.manager.beginTransaction()
            transaction
                    .replace(this.containerId, command.frag.get())
                    .commit()
        }

    }

    open protected fun back() {
        this.manager.popBackStack()
    }

    open protected fun backTo(command: BackTo) {
        this.manager.popBackStack(command.screenKey, 0)
    }

    open fun backToRoot() {
        this.manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

}
