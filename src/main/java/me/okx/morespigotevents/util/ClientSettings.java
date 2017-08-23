package me.okx.morespigotevents.util;

import com.comphenix.protocol.wrappers.EnumWrappers;
import net.minecraft.server.v1_12_R1.EnumMainHand;

public class ClientSettings {
    private String locale;
    private int viewDistance;
    private EnumWrappers.ChatVisibility mode;
    private boolean enableColours;
    private SkinParts skinParts;
    private EnumMainHand mainHand;

    public ClientSettings(String locale, int viewDistance, EnumWrappers.ChatVisibility mode, boolean enableColours, SkinParts skinParts, EnumMainHand mainHand) {
        this.locale = locale;
        this.viewDistance = viewDistance;
        this.mode = mode;
        this.enableColours = enableColours;
        this.skinParts = skinParts;
        this.mainHand = mainHand;
    }

    public String getLocale() {
        return locale;
    }

    public int getViewDistance() {
        return viewDistance;
    }

    public EnumWrappers.ChatVisibility getMode() {
        return mode;
    }

    public boolean isEnableColours() {
        return enableColours;
    }

    public SkinParts getSkinParts() {
        return skinParts;
    }

    public EnumMainHand getMainHand() {
        return mainHand;
    }

    public static class SkinParts {
        private boolean cape;
        private boolean jacket;
        private boolean leftSleeve;
        private boolean rightSleeve;
        private boolean leftLeg;
        private boolean rightLeg;
        private boolean hat;

        public SkinParts(int c) {
            cape = (c & 1) > 0;
            jacket = (c & 2) > 0;
            leftSleeve = (c & 4) > 0;
            rightSleeve = (c & 8) > 0;
            leftLeg = (c & 16) > 0;
            rightLeg = (c & 32) > 0;
            hat = (c & 64) > 0;
        }

        public boolean isCape() {
            return cape;
        }

        public boolean isJacket() {
            return jacket;
        }

        public boolean isLeftSleeve() {
            return leftSleeve;
        }

        public boolean isRightSleeve() {
            return rightSleeve;
        }

        public boolean isLeftLeg() {
            return leftLeg;
        }

        public boolean isRightLeg() {
            return rightLeg;
        }

        public boolean isHat() {
            return hat;
        }
    }
}
