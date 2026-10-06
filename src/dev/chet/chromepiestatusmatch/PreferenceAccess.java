package dev.chet.chromepiestatusmatch;

import android.content.Context;
import android.widget.Toast;

/** Uses framework-managed sharing when available; keeps settings UI usable otherwise. */
public final class PreferenceAccess {
    private static boolean warned;
    private PreferenceAccess() { }

    @SuppressWarnings("deprecation")
    public static int mode(Context context) {
        try {
            context.getSharedPreferences(context.getPackageName() + "_preferences",
                    Context.MODE_WORLD_READABLE);
            return Context.MODE_WORLD_READABLE;
        } catch (SecurityException e) {
            if (!warned) {
                warned = true;
                Toast.makeText(context, "Preference sharing unavailable. Enable this module for "
                        + "ChromePie Status Match itself, reboot, and reopen settings.",
                        Toast.LENGTH_LONG).show();
            }
            return Context.MODE_PRIVATE;
        }
    }
}
