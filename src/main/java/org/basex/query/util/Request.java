package org.basex.query.util;

import java.util.ArrayList;
import java.util.List;

import org.basex.query.QueryContext;
import org.basex.query.iter.ItemCache;
import org.basex.util.InputInfo;
import org.basex.util.TokenMap;

/**
 * Container for parsed data from <http:request/>.
 * @author BaseX Team 2005-11, BSD License
 * @author Rositsa Shadura
 */
public final class Request {
  /** Request attributes. */
  public final TokenMap attrs = new TokenMap();
  /** Request headers. */
  public final TokenMap headers = new TokenMap();
  /** Body or multipart attributes. */
  public final TokenMap payloadAttrs = new TokenMap();
  /** Body content. */
  public final ItemCache bodyContent = new ItemCache();
  /** Parts in case of multipart request. */
  public final List<Part> parts = new ArrayList<Part>();
  /** Indicator for multipart request. */
  public boolean isMultipart;
  /** Input info. */
  public InputInfo info;
  /** Query context. */
  public QueryContext ctx;

}

/**
 * Container for parsed data from <part/> element.
 * @author BaseX Team 2005-11, BSD License
 * @author Rositsa Shadura
 */
class Part {
  /** Part headers. */
  public final TokenMap headers = new TokenMap();
  /** Attributes of part body. */
  public final TokenMap bodyAttrs = new TokenMap();
  /** Content of part body. */
  public final ItemCache bodyContent = new ItemCache();
}
