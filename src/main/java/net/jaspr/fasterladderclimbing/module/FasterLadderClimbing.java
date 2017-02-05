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
package net.jaspr.fasterladderclimbing.module;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.jaspr.base.module.Feature;

public class FasterLadderClimbing extends Feature {

    private boolean allowQuickAscension;
    private boolean allowQuickDescension;
    private int speedModifier;

    @Override
    public void setupConfig() {
        allowQuickAscension = loadPropBool("Allow going UP faster", "If [false], then player can only climb up the ladder at normal speed.", true);
        allowQuickDescension = loadPropBool("Allow going DOWN faster", "If [false], then player can only go down the ladder at normal speed.", true);
        speedModifier = loadPropInt("Speed modifier", "1 is Vanilla speed, 11 is lightning speed", 4);
    }

    @SubscribeEvent
    public void onPlayerTick(LivingUpdateEvent event) {
        if (false == (event.entityLiving instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer)event.entityLiving;

        if (player.isOnLadder() && !player.isSneaking()) {
            EntityClimber climber = new EntityClimber(player);

            if (allowQuickDescension && climber.isFacingDownward() && !climber.isMovingForward() && !climber.isMovingBackward()) {
                climber.moveDownFarther();
            } else if (allowQuickAscension && climber.isFacingUpward() && climber.isMovingForward()) {
                climber.moveUpFarther();
            }
        }
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }


    @Override
    public String[] getIncompatibleMods() {
        return new String[] { "quark" };
    }

    private class EntityClimber {
        private EntityPlayer player;

        public EntityClimber(EntityPlayer player) {
            this.player = player;
        }

        private boolean isFacingDownward() {
            return player.rotationPitch > 0;
        }

        private boolean isFacingUpward() {
            return player.rotationPitch < 0;
        }

        private boolean isMovingForward() {
            return player.moveForward > 0;
        }

        private boolean isMovingBackward() {
            return player.moveForward < 0;
        }

        private float getElevationChangeUpdate() {
            System.out.println("CURRENT MODIFER = " + speedModifier);
            return (float)Math.abs(player.rotationPitch / 90.0) * (((float)speedModifier - 1 ) / 9);
        }

        public void moveUpFarther() {
            int px = 0;
            float dx = getElevationChangeUpdate();
            player.moveEntity(px, dx, px);
        }

        public void moveDownFarther() {
            int px = 0;
            float dx = getElevationChangeUpdate();
            player.moveEntity(px, (dx * -1), px);
        }
    }

}
