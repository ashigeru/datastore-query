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


/**
 * 選言制約を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class OrConstraint extends Constraint {

    /**
     * 1つ目の制約。
     */
    public final Constraint left;

    /**
     * 2つ目の制約。
     */
    public final Constraint right;

    /**
     * このクラスのインスタンスを生成する。
     * @param left 1つ目の制約
     * @param right 2つ目の制約
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public OrConstraint(
            Constraint left,
            Constraint right
            ) {
        if (left == null) {
            throw new IllegalArgumentException("left");
        }
        if (right == null) {
            throw new IllegalArgumentException("right");
        }
        this.left = left;
        this.right = right;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitOrConstraint(OrConstraint,Object) visitOrConstraint(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitOrConstraint(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "OrConstraint'{'left:{0}, right:{1}'}'",
            left,
            right
            );
    }
}
