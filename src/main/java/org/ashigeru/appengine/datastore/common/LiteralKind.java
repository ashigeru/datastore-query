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
package org.ashigeru.appengine.datastore.common;

/**
 * リテラルの種類。
 * @author ashigeru
 */
public enum LiteralKind {

    /**
     * 整数リテラルを表す。
     */
    INTEGER,

    /**
     * 実数リテラルを表す。
     */
    REAL_NUMBER,

    /**
     * 論理リテラルを表す。
     */
    BOOLEAN,

    /**
     * 文字列リテラルを表す。
     */
    STRING,

    /**
     * {@code null}リテラルを表す。
     */
    NULL,
}
