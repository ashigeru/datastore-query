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

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.ashigeru.appengine.datastore.common.LiteralKind;
import org.ashigeru.appengine.datastore.common.OrderDirection;
import org.ashigeru.appengine.datastore.common.RelationalOperator;
import org.junit.Test;

/**
 * Test for {@link DatastoreQueryParser}.
 * @author ashigeru
 */
public class DatastoreQueryParserTest {

    /**
     * Test method for {@link DatastoreQueryParser#parse(Reader)}.
     */
    @Test
    public void testparse_Select() {
        Reader source = r(new String[] {
                "SELECT h FROM Hoge h",
        });
        verify(source, new SelectStatement(
            list(name("h")),
            new Source(type("Hoge"), name("h")),
            null,
            null));
    }

    /**
     * Test method for {@link DatastoreQueryParser#parse(Reader)}.
     */
    @Test
    public void testparse_Apply() {
        Reader source = r(new String[] {
                "APPLY function(h) FROM Hoge h",
        });
        verify(source, new ApplyStatement(
            new Procedure(
                name("function"),
                list(name("h")),
                null),
            new Source(type("Hoge"), name("h")),
            null,
            null));
    }

    /**
     * Test method for {@link DatastoreQueryParser#parse(Reader)}.
     */
    @Test
    public void testparse_Filter() {
        Reader source = r(new String[] {
                "SELECT h FROM Hoge h",
                "WHERE h.field == 1",
        });
        verify(source, new SelectStatement(
            list(name("h")),
            new Source(type("Hoge"), name("h")),
            new Filter(
                new Relational(
                    RelationalOperator.EQUAL,
                    new PropertyTerm(
                        name("h"),
                        name("field")),
                    new Literal(LiteralKind.INTEGER, "1"))),
            null));
    }

    /**
     * Test method for {@link DatastoreQueryParser#parse(Reader)}.
     */
    @Test
    public void testparse_Order() {
        Reader source = r(new String[] {
                "SELECT h FROM Hoge h",
                "ORDER BY h.field DESC",
        });
        verify(source, new SelectStatement(
            list(name("h")),
            new Source(type("Hoge"), name("h")),
            null,
            new Order(list(
                new OrderCriterion(
                    OrderDirection.DESC,
                    new PropertyTerm(
                        name("h"),
                        name("field")))))));
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

    private void verify(Reader source, Statement expect) {
        try {
            DatastoreQueryParser parser = new DatastoreQueryParser();
            Statement statement = parser.parse(source);
            assertThat(statement.accept(new Matcher(), expect), is(true));
        }
        finally {
            try {
                source.close();
            }
            catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    private <T> List<T> list(T...elements) {
        return Arrays.asList(elements);
    }

    private Type type(String name) {
        return new Type(name(name));
    }

    private SimpleName name(String identifier) {
        return new SimpleName(identifier);
    }
}
