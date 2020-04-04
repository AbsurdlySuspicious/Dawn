package me.saket.dank;

import android.util.Log;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

public class TimberReleaseTree extends Timber.DebugTree {
  public TimberReleaseTree() {
    super();
  }

  @Override
  protected void log(int priority, String tag, @NotNull String message, Throwable t) {
    if (priority >= Log.ERROR) {
      super.log(priority, tag, message, t);
    }
  }
}
