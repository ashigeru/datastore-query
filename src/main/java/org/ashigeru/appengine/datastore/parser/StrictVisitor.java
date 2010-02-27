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
 * 未実装のものに対して例外をスローする{@link Visitor}の骨格実装。
 * <p>
 * この実装では、すべてのメソッドが何も行わずに{@link UnsupportedOperationException}をスローする。
 * </p>
 * @param <R> 戻り値の型
 * @param <C> コンテキストオブジェクトの型
 * @param <E> 例外の型
 * @author ashigeru
 */
public abstract class StrictVisitor<R, C, E extends Throwable>
        extends Visitor<R, C, E> {

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitSelectStatement(
            SelectStatement elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitSelectStatement is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitApplyStatement(
            ApplyStatement elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitApplyStatement is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitProcedure(
            Procedure elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitProcedure is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitSource(
            Source elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitSource is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitFilter(
            Filter elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitFilter is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitOrder(
            Order elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitOrder is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitOrderCriterion(
            OrderCriterion elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitOrderCriterion is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitOrConstraint(
            OrConstraint elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitOrConstraint is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitAndConstraint(
            AndConstraint elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitAndConstraint is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitNotConstraint(
            NotConstraint elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitNotConstraint is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitRelational(
            Relational elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitRelational is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitBlock(
            Block elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitBlock is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitQuantification(
            Quantification elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitQuantification is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitBinaryTerm(
            BinaryTerm elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitBinaryTerm is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitUnaryTerm(
            UnaryTerm elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitUnaryTerm is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitParenthesizedTerm(
            ParenthesizedTerm elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitParenthesizedTerm is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitListTerm(
            ListTerm elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitListTerm is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitPropertyTerm(
            PropertyTerm elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitPropertyTerm is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitConstructTerm(
            ConstructTerm elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitConstructTerm is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitLiteral(
            Literal elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitLiteral is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitType(
            Type elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitType is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitSimpleName(
            SimpleName elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitSimpleName is not overridden (elem={0}, context={1})",
            elem, context));
    }

    /**
     * @throws E この処理中に例外が発生した場合
     */
    @Override
    public R visitQualifiedName(
            QualifiedName elem,
            C context) throws E {
        throw new UnsupportedOperationException(java.text.MessageFormat.format(
            "visitQualifiedName is not overridden (elem={0}, context={1})",
            elem, context));
    }
}
