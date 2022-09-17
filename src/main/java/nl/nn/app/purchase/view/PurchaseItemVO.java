/*
 * MIT License
 *
 * Copyright (c) 2022 Tiago Couto.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package nl.nn.app.purchase.view;

import java.util.Objects;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nl.nn.app.core.view.ViewObject;

/**
 * PurchaseItem View Object
 */
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class PurchaseItemVO extends ViewObject {
    private UUID itemId;

    private Double amount;

    private Double discount;

    private Double purchaseValue;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;
        if (!(o instanceof PurchaseItemVO i))
            return false;
        return Objects.equals(getItemId(), i.getItemId()) &&
                Objects.equals(getAmount(), i.getAmount()) &&
                Objects.equals(getDiscount(), i.getDiscount()) &&
                Objects.equals(getPurchaseValue(), i.getPurchaseValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                            getItemId(),
                            getAmount(),
                            getDiscount(),
                            getPurchaseValue());
    }
}
