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
 * 二項演算子。
 * @author ashigeru
 */
public enum BinaryTermOperator implements Operator {

    /**
     * 加算を表す。
     */
    ADD("+"),

    /**
     * 減算を表す。
     */
    SUBTRACT("-"),

    /**
     * 乗算を表す。
     */
    MULTIPLY("*"),

    /**
     * 除算を表す。
     */
    DIVIDE("/"),

    /**
     * 剰余を表す。
     */
    REMAINDER("%"),
    ;

    private String symbol;

    private BinaryTermOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
