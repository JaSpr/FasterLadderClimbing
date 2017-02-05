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

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.jaspr.base.module.ModuleLoader;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		ModuleLoader.preInitClient(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		ModuleLoader.initClient(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		ModuleLoader.postInitClient(event);
	}
		
}
