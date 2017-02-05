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
package net.jaspr.base.network.message;

import net.jaspr.base.module.ModuleLoader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageChangeConfig extends NetworkMessage {
	
	public String moduleName;
	public String category;
	public String key;
	public String value;
	public boolean saveToFile;
	
	public MessageChangeConfig() { }

	public MessageChangeConfig(String moduleName, String category, String key, String value, boolean saveToFile) {
		this.moduleName = moduleName;
		this.category = category;
		this.key = key;
		this.value = value;
	}
	
	@Override
	public IMessage handleMessage(MessageContext context) {
		changeConfig(moduleName, category, key, value, saveToFile);
		return null;
	}
	public static void changeConfig(String moduleName, String category, String key, String value, boolean saveToFile) {

		Configuration config = ModuleLoader.config;
		String fullCategory = moduleName;
		if(!category.equals("-"))
			fullCategory += "." + category;

		char type = key.charAt(0);
		key = key.substring(2);

		if(config.hasKey(fullCategory, key)) {
			boolean changed = false;

			try {
				switch(type) {
					case 'B':
						boolean b = Boolean.parseBoolean(value);
						config.get(fullCategory, key, false).setValue(b);
					case 'I':
						int i = Integer.parseInt(value);
						config.get(fullCategory, key, 0).setValue(i);
					case 'D':
						double d = Double.parseDouble(value);
						config.get(fullCategory, key, 0.0).setValue(d);
					case 'S':
						config.get(fullCategory, key, "").setValue(value);
				}
			} catch(IllegalArgumentException e) {}

			if(config.hasChanged()) {
				ModuleLoader.forEachModule(module -> module.setupConfig());

				if(saveToFile)
					config.save();
			}
		}
	}
	
}
