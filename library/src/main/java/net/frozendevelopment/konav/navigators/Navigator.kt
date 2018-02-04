package net.frozendevelopment.konav.navigators

import net.frozendevelopment.konav.commands.Command

/**
 * Created by josh on 2/3/18.
 */


interface Navigator {

    fun applyCommand(command: Command)

}
