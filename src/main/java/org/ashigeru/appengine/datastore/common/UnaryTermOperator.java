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
 * 単項演算子。
 * @author ashigeru
 */
public enum UnaryTermOperator implements Operator {

    /**
     * 単項プラス。
     */
    PLUS("+"),

    /**
     * 単項マイナス。
     */
    MINUS("-"),
    ;

    private String symbol;

    private UnaryTermOperator(String symbol) {
        assert symbol != null;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
