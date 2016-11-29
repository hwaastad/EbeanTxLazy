package org.waastad.ebeantxlazy.domain.finder;

import com.avaje.ebean.Finder;
import org.waastad.ebeantxlazy.domain.PersonGroup;
import org.waastad.ebeantxlazy.domain.query.QPersonGroup;

public class PersonGroupFinder extends Finder<Long, PersonGroup> {

    /**
     * Construct using the default EbeanServer.
     */
    public PersonGroupFinder() {
        super(PersonGroup.class);
    }

    /**
     * Construct with a given EbeanServer.
     */
    public PersonGroupFinder(String serverName) {
        super(PersonGroup.class, serverName);
    }

    /**
     * Start a new typed query.
     */
    public QPersonGroup where() {
        return new QPersonGroup(db());
    }

    /**
     * Start a new document store query.
     */
    public QPersonGroup text() {
        return new QPersonGroup(db()).text();
    }

    public int deleteByName(String name) {
        return where().person.name.eq(name).delete();
    }
}
