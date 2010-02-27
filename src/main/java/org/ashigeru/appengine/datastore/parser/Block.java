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
 * 制約ブロックを表すクラス。
 * @author Suguru ARAKAWA
 */
public final class Block extends Constraint {

    /**
     * 制約。
     */
    public final Constraint constraint;

    /**
     * このクラスのインスタンスを生成する。
     * @param constraint 制約
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Block(
            Constraint constraint
            ) {
        if (constraint == null) {
            throw new IllegalArgumentException("constraint");
        }
        this.constraint = constraint;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitBlock(Block,Object) visitBlock(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitBlock(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "Block'{'constraint:{0}'}'",
            constraint
            );
    }
}
