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
 * {@link Node}を渡り歩くビジタ。
 * <p>
 * この実装では、すべてのメソッドが何も行わずに{@code null}を返す。
 * </p>
 * @param <R> 戻り値の型
 * @param <C> コンテキストオブジェクトの型
 * @param <E> 例外の型
 * @author Suguru ARAKAWA
 */
public abstract class Visitor<R, C, E extends Throwable> {

    /**
     * {@link SelectStatement#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link SelectStatement#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitSelectStatement(
            SelectStatement elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link ApplyStatement#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link ApplyStatement#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitApplyStatement(
            ApplyStatement elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link Procedure#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link Procedure#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitProcedure(
            Procedure elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link Source#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link Source#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitSource(
            Source elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link Filter#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link Filter#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitFilter(
            Filter elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link Order#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link Order#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitOrder(
            Order elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link OrderCriterion#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link OrderCriterion#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitOrderCriterion(
            OrderCriterion elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link OrConstraint#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link OrConstraint#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitOrConstraint(
            OrConstraint elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link AndConstraint#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link AndConstraint#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitAndConstraint(
            AndConstraint elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link NotConstraint#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link NotConstraint#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitNotConstraint(
            NotConstraint elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link Relational#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link Relational#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitRelational(
            Relational elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link Block#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link Block#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitBlock(
            Block elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link Quantification#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link Quantification#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitQuantification(
            Quantification elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link BinaryTerm#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link BinaryTerm#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitBinaryTerm(
            BinaryTerm elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link UnaryTerm#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link UnaryTerm#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitUnaryTerm(
            UnaryTerm elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link ParenthesizedTerm#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link ParenthesizedTerm#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitParenthesizedTerm(
            ParenthesizedTerm elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link ListTerm#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link ListTerm#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitListTerm(
            ListTerm elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link PropertyTerm#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link PropertyTerm#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitPropertyTerm(
            PropertyTerm elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link ConstructTerm#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link ConstructTerm#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitConstructTerm(
            ConstructTerm elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link Literal#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link Literal#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitLiteral(
            Literal elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link Type#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link Type#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitType(
            Type elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link SimpleName#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link SimpleName#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitSimpleName(
            SimpleName elem,
            C context) throws E {
        return null;
    }

    /**
     * {@link QualifiedName#accept(Visitor,Object)}
     * が呼び出された際にコールバックされる。
     * @param elem 
     *     {@link QualifiedName#accept(Visitor,Object)}
     *     が呼び出されたオブジェクト。
     * @param context コンテキストオブジェクト(省略可)
     * @return このビジタの実行結果
     * @throws E この処理中に例外が発生した場合
     */
    public R visitQualifiedName(
            QualifiedName elem,
            C context) throws E {
        return null;
    }
}
