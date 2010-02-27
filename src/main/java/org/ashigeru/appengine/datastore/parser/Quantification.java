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
 * 量化制約を表すクラス。
 * @author Suguru ARAKAWA
 */
public final class Quantification extends Constraint {

    /**
     * 個々の項を束縛するシンボルの名前。
     */
    public final SimpleName parameter;

    /**
     * 量化対象の項。
     */
    public final Term target;

    /**
     * 量化する制約。
     */
    public final Constraint constraint;

    /**
     * このクラスのインスタンスを生成する。
     * @param parameter 個々の項を束縛するシンボルの名前
     * @param target 量化対象の項
     * @param constraint 量化する制約
     * @throws IllegalArgumentException 引数に{@code null}が含まれる場合
     */
    public Quantification(
            SimpleName parameter,
            Term target,
            Constraint constraint
            ) {
        if (parameter == null) {
            throw new IllegalArgumentException("parameter");
        }
        if (target == null) {
            throw new IllegalArgumentException("target");
        }
        if (constraint == null) {
            throw new IllegalArgumentException("constraint");
        }
        this.parameter = parameter;
        this.target = target;
        this.constraint = constraint;
    }

    /**
     * 指定のビジタを受け入れ、
     * {@link Visitor#visitQuantification(Quantification,Object) visitQuantification(this, context)}
     * に処理を委譲する。
     */
    @Override
    public <R, C, E extends Throwable> R accept(
            Visitor<R, C, E> visitor, C context) throws E {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor");
        }
        return visitor.visitQuantification(this, context);
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(
            "Quantification'{'parameter:{0}, target:{1}, constraint:{2}'}'",
            parameter,
            target,
            constraint
            );
    }
}
