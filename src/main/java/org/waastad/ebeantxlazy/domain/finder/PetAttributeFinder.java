package org.waastad.ebeantxlazy.domain.finder;

import com.avaje.ebean.Finder;
import org.waastad.ebeantxlazy.domain.PetAttribute;
import org.waastad.ebeantxlazy.domain.query.QPetAttribute;

public class PetAttributeFinder extends Finder<Long,PetAttribute> {

  /**
   * Construct using the default EbeanServer.
   */
  public PetAttributeFinder() {
    super(PetAttribute.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public PetAttributeFinder(String serverName) {
    super(PetAttribute.class, serverName);
  }

  /**
   * Start a new typed query.
   */
  public QPetAttribute where() {
     return new QPetAttribute(db());
  }

  /**
   * Start a new document store query.
   */
  public QPetAttribute text() {
     return new QPetAttribute(db()).text();
  }
}
