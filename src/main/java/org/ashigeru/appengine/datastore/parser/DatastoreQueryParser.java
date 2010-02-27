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

import java.io.Reader;

/**
 * TODO DatastoreQueryParser
 * @author ashigeru
 */
public class DatastoreQueryParser {

    /**
     * 指定のストリームからデータストアクエリを読み出して、解析して返す。
     * @param reader 対象のストリーム
     * @return 解析結果の構文木
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Statement parse(Reader reader) {
        if (reader == null) {
            throw new IllegalArgumentException("reader is null"); //$NON-NLS-1$
        }
        DatastoreQueryParser0 engine = new DatastoreQueryParser0(reader);
        try {
            return engine.parse();
        }
        catch (ParseException e) {
            throw new AssertionError(e);
        }
    }
}
