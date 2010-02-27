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
 * 比較演算子。
 * @author ashigeru
 */
public enum RelationalOperator implements Operator {

    /**
     * 同値を表す。
     */
    EQUAL("=="),

    /**
     * 同値でないことを表す。
     */
    NOT_EQUAL("!="),

    /**
     * より小さいを表す。
     */
    LESS_THAN("<"),

    /**
     * より大きいを表す。
     */
    GREATER_THAN(">"),

    /**
     * より小さいか同値を表す。
     */
    LESS_THAN_OR_EQUAL("<="),

    /**
     * より大きいか同値を表す。
     */
    GREATER_THAN_OR_EQUAL(">="),

    /**
     * パターン一致を表す。
     */
    LIKE("LIKE"),

    /**
     * 包含関係を表す。
     */
    IN("IN"),
    ;

    private String symbol;

    private RelationalOperator(String symbol) {
        assert symbol != null;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
