/*
 * Copyright 2015 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gs.collections.kata;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.api.set.MutableSet;
import com.gs.collections.impl.list.mutable.FastList;
import com.gs.collections.impl.set.mutable.UnifiedSet;
import com.gs.collections.impl.test.Verify;

import org.junit.Assert;
import org.junit.Test;

public class Exercise3Test extends CompanyDomainForKata
{
    /**
     * Improve {@link Company#getOrders()} without breaking this test.
     */
    @Test
    public void improveGetOrders()
    {
   
        Verify.assertSize(5, this.company.getOrders());
    }

    /**
     * Get all items that have been ordered by anybody.
     */
    @Test
    public void findItemNames()
    {
        MutableList<LineItem> allOrderedLineItems =FastList.newList() ;
        MutableSet<String> actualItemNames=UnifiedSet.newSet(); 
        for (Order order : this.company.getOrders())
        {
            allOrderedLineItems.addAll(order.getLineItems());
            for( LineItem item: order.getLineItems()){
            	actualItemNames.add(item.getName());
            }
        }
       
       
        

        Verify.assertInstanceOf(MutableSet.class, actualItemNames);
        Verify.assertInstanceOf(String.class, actualItemNames.getFirst());

        MutableSet<String> expectedItemNames = UnifiedSet.newSetWith(
                "shed", "big shed", "bowl", "cat", "cup", "chair", "dog",
                "goldfish", "gnome", "saucer", "sofa", "table");
        Assert.assertEquals(expectedItemNames, actualItemNames);
    }

    @Test
    public void findCustomerNames()
    {
        MutableList<String> names = this.company.getCustomers().collect(Customer.TO_NAME);
       

        MutableList<String> expectedNames = FastList.newListWith("Fred", "Mary", "Bill");
        Assert.assertEquals(expectedNames, names);
    }
}
