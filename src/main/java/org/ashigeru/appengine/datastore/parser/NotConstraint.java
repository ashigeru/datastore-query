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
 * 否定制約を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class NotConstraint extends Constraint {

    /**
     * 否定する対象の制約。
     */
    public final Constraint operand;

    /**
     * このクラスのインスタンスを生成する。
     * @param operand 否定する対象の制約
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public NotConstraint(
            Constraint operand
            ) {
        if (operand == null) {
            throw new IllegalArgumentException("operand");
        }
        this.operand = operand;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitNotConstraint(NotConstraint,Object) visitNotConstraint(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitNotConstraint(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "NotConstraint'{'operand:{0}'}'",
            operand
            );
    }
}
