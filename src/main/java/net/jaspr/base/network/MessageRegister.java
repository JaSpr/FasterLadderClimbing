/**
 * This class was implemented by <JaSpr>. It is distributed as part of the FasterLadderClimbing Mod.
 * https://github.com/JaSpr/FasterLadderClimbing
 *
 * FasterLadderClimbing is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 *
 * This class was derived from works created by <Vazkii> which were distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 *
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 */
package net.jaspr.base.network;

import net.minecraftforge.fml.relauncher.Side;
import net.jaspr.base.network.message.MessageChangeConfig;

public class MessageRegister {

	public static void init() {
		NetworkHandler.register(MessageChangeConfig.class, Side.CLIENT);
	}
	
}
