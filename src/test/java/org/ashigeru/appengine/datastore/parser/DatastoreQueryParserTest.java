/*
 * Copyright 2010 @ashigeru.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.ashigeru.appengine.datastore.parser;

import static org.junit.Assert.*;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

/**
 * Test for {@link DatastoreQueryParser}.
 * @author ashigeru
 */
public class DatastoreQueryParserTest {

    /**
     * Test method for {@link DatastoreQueryParser#parseQuery(Reader)}.
     */
    @Test
    public void testParseQuery_Select() {
        Reader source = r(new String[] {
                "SELECT h FROM Hoge h",
        });
        DatastoreQueryParser parser = new DatastoreQueryParser();
        parser.parseQuery(source);
    }

    /**
     * Test method for {@link DatastoreQueryParser#parseQuery(Reader)}.
     */
    @Test
    public void testParseQuery_Apply() {
        Reader source = r(new String[] {
                "APPLY function(h) FROM Hoge h",
        });
        DatastoreQueryParser parser = new DatastoreQueryParser();
        parser.parseQuery(source);
    }

    /**
     * Test method for {@link DatastoreQueryParser#parseQuery(Reader)}.
     */
    @Test
    public void testParseQuery_Filter() {
        Reader source = r(new String[] {
                "SELECT h FROM Hoge h",
                "WHERE h.field == 1",
        });
        DatastoreQueryParser parser = new DatastoreQueryParser();
        parser.parseQuery(source);
    }

    /**
     * Test method for {@link DatastoreQueryParser#parseQuery(Reader)}.
     */
    @Test
    public void testParseQuery_Order() {
        Reader source = r(new String[] {
                "SELECT h FROM Hoge h",
                "ORDER BY h.field DESC",
        });
        DatastoreQueryParser parser = new DatastoreQueryParser();
        parser.parseQuery(source);
    }

    /**
     * Test method for {@link DatastoreQueryParser#parseConstraint(Reader)}.
     */
    @Test
    public void testParseConstraint_Simple() {
        Reader source = r(new String[] {
                "a == 0",
        });
        DatastoreQueryParser parser = new DatastoreQueryParser();
        parser.parseConstraint(source);
    }

    private static Reader r(String...lines) {
        if (lines.length == 0) {
            return new StringReader("");
        }
        StringBuilder buf = new StringBuilder();
        buf.append(lines[0]);
        for (int i = 1; i < lines.length; i++) {
            buf.append('\n');
            buf.append(lines[i]);
        }
        return new StringReader(buf.toString());
    }
}
