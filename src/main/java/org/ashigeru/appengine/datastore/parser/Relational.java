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

import org.ashigeru.appengine.datastore.common.RelationalOperator;

/**
 * 比較制約を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class Relational extends Constraint {

    /**
     * 比較演算子。
     */
    public final RelationalOperator operator;

    /**
     * 比較される項。
     */
    public final Term left;

    /**
     * 比較する項。
     */
    public final Term right;

    /**
     * このクラスのインスタンスを生成する。
     * @param operator 比較演算子
     * @param left 比較される項
     * @param right 比較する項
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Relational(
            RelationalOperator operator,
            Term left,
            Term right
            ) {
        if (operator == null) {
            throw new IllegalArgumentException("operator");
        }
        if (left == null) {
            throw new IllegalArgumentException("left");
        }
        if (right == null) {
            throw new IllegalArgumentException("right");
        }
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitRelational(Relational,Object) visitRelational(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitRelational(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "Relational'{'operator:{0}, left:{1}, right:{2}'}'",
            operator,
            left,
            right
            );
    }
}
