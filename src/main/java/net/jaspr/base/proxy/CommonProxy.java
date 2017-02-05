/**
 * This class was implemented by <JaSpr>. It is distributed as part
 * of the FasterLadderClimbing Mod.
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
package net.jaspr.base.proxy;

import net.jaspr.base.network.GuiHandler;
import net.jaspr.base.network.MessageRegister;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;


import net.jaspr.base.module.ModuleLoader;
import net.jaspr.fasterladderclimbing.FasterLadderClimbing;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ModuleLoader.preInit(event);

		NetworkRegistry.INSTANCE.registerGuiHandler(FasterLadderClimbing.instance, new GuiHandler());
		MessageRegister.init();
	}

	public void init(FMLInitializationEvent event) {
		ModuleLoader.init(event);
	}

	public void postInit(FMLPostInitializationEvent event) {
		ModuleLoader.postInit(event);
	}

	public void serverStarting(FMLServerStartingEvent event) {
		ModuleLoader.serverStarting(event);
	}

	
}
