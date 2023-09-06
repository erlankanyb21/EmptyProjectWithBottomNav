package com.example.data.remote.paging.base

import androidx.paging.PagingSource
import androidx.paging.PagingState

/**
 * Базовый класс, реализующий общие методы для постраничной загрузки данных с использованием Paging 3.
 * @param Key Тип ключа, используемого для идентификации страниц.
 * @param Value Тип элементов, которые будут загружены.
 *
 * @author Erlan
 * @since 1.0v
 */
abstract class BasePagingSource<Key : Any, Value : Any> : PagingSource<Key, Value>() {
    /**
     * Абстрактный метод, реализующий загрузку элементов на указанной странице.
     * @param params Параметры загрузки элементов.
     * @return Список элементов на текущей странице.
     */
    abstract suspend fun fetchData(params: LoadParams<Key>): List<Value>

    /**
     * Метод, вызываемый при загрузке новой страницы данных.
     * @param params Параметры загрузки элементов.
     * @return Результат загрузки.
     */
    override suspend fun load(params: LoadParams<Key>): LoadResult<Key, Value> {
        val key = params.key ?: initialKey
        val data = fetchData(params)
        val prevKey = getPrevKey(key!!, data)
        val nextKey = getNextKey(key, data)

        return LoadResult.Page(data, prevKey, nextKey)
    }

    /**
     * Метод, вызываемый для определения ключа, который следует использовать при обновлении списка элементов.
     * @param state Состояние пейджера.
     * @return Ключ, который следует использовать для обновления списка элементов.
     */

    override fun getRefreshKey(state: PagingState<Key, Value>): Key? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.let { item ->
                getKey(item)
            }
        }
    }

    /**
     * Начальный ключ для первой загружаемой страницы.
     */
    open val initialKey: Key? = null

    /**
     * [getPrevKey] - Метод для определения ключа предыдущей страницы данных.
     * @param key Ключ текущей страницы данных.
     * @param data Список элементов на текущей странице.
     * @return Ключ предыдущей страницы данных.
     */
    open fun getPrevKey(key: Key, data: List<Value>): Key? = null

    /**
     * [getNextKey] - Метод  для определения ключа следующей страницы данных.
     * @param key Ключ текущей страницы данных.
     * @param data Список элементов на текущей странице.
     * @return Ключ следующей страницы данных.
     */
    open fun getNextKey(key: Key, data: List<Value>): Key? = null

    /**
     * [getKey] - Метод для получения ключа элемента.
     * @param item Элемент списка.
     * @return Ключ элемента.
     */
    abstract fun getKey(item: Value): Key
}