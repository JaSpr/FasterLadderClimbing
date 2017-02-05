/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * 
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * 
 * File Created @ [28/08/2016, 00:37:40 (GMT)]
 */
package net.jaspr.base.network;

import net.minecraftforge.fml.relauncher.Side;
import net.jaspr.base.network.message.MessageChangeConfig;

public class MessageRegister {

	public static void init() {
		NetworkHandler.register(MessageChangeConfig.class, Side.CLIENT);
	}
	
}
