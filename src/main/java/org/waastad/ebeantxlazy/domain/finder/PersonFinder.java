package org.waastad.ebeantxlazy.domain.finder;

import com.avaje.ebean.Finder;
import org.waastad.ebeantxlazy.domain.Person;
import org.waastad.ebeantxlazy.domain.query.QPerson;

public class PersonFinder extends Finder<Long,Person> {

  /**
   * Construct using the default EbeanServer.
   */
  public PersonFinder() {
    super(Person.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public PersonFinder(String serverName) {
    super(Person.class, serverName);
  }

  /**
   * Start a new typed query.
   */
  public QPerson where() {
     return new QPerson(db());
  }

  /**
   * Start a new document store query.
   */
  public QPerson text() {
     return new QPerson(db()).text();
  }
}
