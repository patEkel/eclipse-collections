/*******************************************************************************
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/

package org.eclipse.collections.test.bag.mutable.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.junit.runners.Java8Runner;
import org.junit.runner.RunWith;

@RunWith(Java8Runner.class)
public class TreeBagNoIteratorTest implements MutableSortedBagTestCase, OrderedIterableNoIteratorTest
{
    @SafeVarargs
    @Override
    public final <T> MutableSortedBag<T> newWith(T... elements)
    {
        return new TreeBagNoIterator<>(Comparators.reverseNaturalOrder(), Arrays.asList(elements));
    }

    @Override
    public void Iterable_remove()
    {
        OrderedIterableNoIteratorTest.super.Iterable_remove();
    }

    @Override
    public void RichIterable_iterator_iterationOrder()
    {
        OrderedIterableNoIteratorTest.super.RichIterable_iterator_iterationOrder();
    }

    public static class TreeBagNoIterator<T> extends TreeBag<T>
    {
        public TreeBagNoIterator()
        {
            // For serialization
        }

        public TreeBagNoIterator(Comparator<? super T> comparator, Iterable<? extends T> iterable)
        {
            super(comparator, iterable);
        }

        @Override
        public Iterator<T> iterator()
        {
            throw new AssertionError("No iteration patterns should delegate to iterator()");
        }
    }
}
