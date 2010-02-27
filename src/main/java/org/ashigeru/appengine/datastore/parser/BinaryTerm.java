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

import org.ashigeru.appengine.datastore.common.BinaryTermOperator;

/**
 * 二項演算を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class BinaryTerm extends Term {

    /**
     * 演算子。
     */
    public final BinaryTermOperator operator;

    /**
     * 被演算数。
     */
    public final Term left;

    /**
     * 演算数。
     */
    public final Term right;

    /**
     * このクラスのインスタンスを生成する。
     * @param operator 演算子
     * @param left 被演算数
     * @param right 演算数
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public BinaryTerm(
            BinaryTermOperator operator,
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
     * {@link Visitor#visitBinaryTerm(BinaryTerm,Object) visitBinaryTerm(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitBinaryTerm(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "BinaryTerm'{'operator:{0}, left:{1}, right:{2}'}'",
            operator,
            left,
            right
            );
    }
}
