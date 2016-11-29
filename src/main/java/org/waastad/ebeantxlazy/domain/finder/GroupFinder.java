package org.waastad.ebeantxlazy.domain.finder;

import com.avaje.ebean.Finder;
import org.waastad.ebeantxlazy.domain.Group;
import org.waastad.ebeantxlazy.domain.query.QGroup;

public class GroupFinder extends Finder<Long,Group> {

  /**
   * Construct using the default EbeanServer.
   */
  public GroupFinder() {
    super(Group.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public GroupFinder(String serverName) {
    super(Group.class, serverName);
  }

  /**
   * Start a new typed query.
   */
  public QGroup where() {
     return new QGroup(db());
  }

  /**
   * Start a new document store query.
   */
  public QGroup text() {
     return new QGroup(db()).text();
  }
}
