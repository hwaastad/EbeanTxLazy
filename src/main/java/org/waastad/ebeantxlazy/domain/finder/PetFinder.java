package org.waastad.ebeantxlazy.domain.finder;

import com.avaje.ebean.Finder;
import org.waastad.ebeantxlazy.domain.Pet;
import org.waastad.ebeantxlazy.domain.query.QPet;

public class PetFinder extends Finder<Long,Pet> {

  /**
   * Construct using the default EbeanServer.
   */
  public PetFinder() {
    super(Pet.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public PetFinder(String serverName) {
    super(Pet.class, serverName);
  }

  /**
   * Start a new typed query.
   */
  public QPet where() {
     return new QPet(db());
  }

  /**
   * Start a new document store query.
   */
  public QPet text() {
     return new QPet(db()).text();
  }
}
