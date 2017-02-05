/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 *
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 *
 * File Created @ [19/03/2016, 00:59:31 (GMT)]
 */
package net.jaspr.base.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.jaspr.fasterladderclimbing.ref.Ref;
import net.jaspr.base.module.ModuleLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GuiFactory implements IModGuiFactory {

	@Override
	public void initialize(Minecraft minecraftInstance) {
		// NO-OP
	}


	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return GuiQuarkConfig.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
		return null;
	}

	public static class GuiQuarkConfig extends GuiConfig {

		public GuiQuarkConfig(GuiScreen parentScreen) {
			super(parentScreen, getAllElements(), Ref.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ModuleLoader.config.toString()));
		}

		public static List<IConfigElement> getAllElements() {
			List<IConfigElement> list = new ArrayList();

			Set<String> categories = ModuleLoader.config.getCategoryNames();
			for(String s : categories)
				if(!s.contains(".") && !s.startsWith("_"))
					list.add(new DummyConfigElement.DummyCategoryElement(s, s, new ConfigElement(ModuleLoader.config.getCategory(s)).getChildElements()));

			return list;
		}

	}

}
