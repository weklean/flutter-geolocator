package com.baseflow.geolocator.location;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;

@SuppressWarnings({"ConstantConditions", "unchecked"})
public class ForegroundNotificationOptions {

    @NonNull
    private final String notificationTitle;
    @NonNull
    private final String notificationText;
    @NonNull
    private final AndroidIconResource notificationIcon;
    private final boolean enableWifiLock;
    private final boolean enableWakeLock;
    private final String iconColor;

    public static ForegroundNotificationOptions parseArguments(@Nullable  Map<String, Object> arguments) {
    if (arguments == null) {
      return null;
    }

   final AndroidIconResource notificationIcon = AndroidIconResource.parseArguments((Map<String, Object>)arguments.get("notificationIcon"));
    final String notificationTitle = (String) arguments.get("notificationTitle");
    final String notificationText = (String) arguments.get("notificationText");
    final Boolean enableWifiLock = (Boolean) arguments.get("enableWifiLock");
    final Boolean enableWakeLock = (Boolean) arguments.get("enableWakeLock");
    final @Nullable String iconColor = (String) arguments.get("iconColor");
    return new ForegroundNotificationOptions(
            notificationTitle,
            notificationText,
            notificationIcon,
            enableWifiLock,
            enableWakeLock,
            iconColor
    );
  }

    private ForegroundNotificationOptions(
        @NonNull  String notificationTitle,
        @NonNull String notificationText,
        @NonNull AndroidIconResource notificationIcon,
        boolean enableWifiLock,
        boolean enableWakeLock,
        @Nullable String iconColor
    ) {
        this.notificationTitle = notificationTitle;
        this.notificationText = notificationText;
        this.notificationIcon = notificationIcon;
        this.enableWifiLock = enableWifiLock;
        this.enableWakeLock = enableWakeLock;
        this.iconColor = iconColor;
    }

    @NonNull
    public  String getNotificationTitle() {
        return notificationTitle;
    }

    @NonNull
    public  String getNotificationText() {
        return notificationText;
    }

    @NonNull
    public AndroidIconResource getNotificationIcon() {
        return notificationIcon;
    }

    public boolean isEnableWifiLock() {
        return enableWifiLock;
    }

    public boolean isEnableWakeLock() {
        return enableWakeLock;
    }

    @Nullable
    public Integer getIconColor() {
        if (iconColor == null) {
            return null;
        }
        return Color.parseColor(iconColor);
    }
}
