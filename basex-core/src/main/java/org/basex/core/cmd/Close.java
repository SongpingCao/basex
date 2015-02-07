package org.basex.core.cmd;

import static org.basex.core.Text.*;

import org.basex.core.*;
import org.basex.core.locks.*;
import org.basex.core.users.*;
import org.basex.data.*;

/**
 * Evaluates the 'close' command and closes the current database.
 *
 * @author BaseX Team 2005-15, BSD License
 * @author Christian Gruen
 */
public final class Close extends Command {
  /**
   * Default constructor.
   */
  public Close() {
    super(Perm.NONE);
  }

  @Override
  protected boolean run() {
    final Data data = context.data();
    if(data == null) return true;

    close(data, context);
    context.closeDB();
    return info(DB_CLOSED_X, data.meta.name);
  }

  @Override
  public void databases(final LockResult lr) {
    lr.read.add(DBLocking.CTX);
  }

  /**
   * Closes the specified database.
   * @param data data reference
   * @param ctx database context
   */
  public static void close(final Data data, final Context ctx) {
    synchronized(ctx.datas) { if(ctx.datas.unpin(data)) data.close(); }
  }
}
