package com.gyvacha.shift_test.utils

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems

fun <T : Any> LazyListScope.pagingItems(
    items: LazyPagingItems<T>,
    key: ((T) -> Any)? = null,
    itemContent: @Composable (T?) -> Unit
) {
    items(
        count = items.itemCount,
        key = { index ->
            val peek = items.peek(index)
            when {
                peek != null && key != null -> key(peek)
                peek != null -> peek.hashCode()
                else -> "placeholder_$index"
            }
        }
    ) { index ->
        itemContent(items[index])
    }
}