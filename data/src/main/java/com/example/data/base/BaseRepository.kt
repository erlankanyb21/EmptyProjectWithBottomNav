package com.example.data.base

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import com.example.domain.either.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


abstract class BaseRepository {
    /**
     * [makeNetworkRequest] выполняет запрос в сеть и возвращает ответ в
     * виде Either<String, T> - либо правильный ответ типа T, либо строку с ошибкой. Она принимает
     * параметр request, который является suspend-функцией, выполняющей запрос в сеть. Кроме того,
     * есть возможность передать анонимную функцию [gatherIfSucceed], которая вызывается после успешного выполнения
     * запроса и передает в нее ответ типа T.
     */
    internal fun <T> makeNetworkRequest(
        gatherIfSucceed: ((T) -> Unit)? = null, request: suspend () -> T
    ) = flow<Either<String, T>> {
        request().also {
            gatherIfSucceed?.invoke(it)
            emit(Either.Right(value = it))
        }
    }.flowOn(Dispatchers.IO).catch { exception ->
        emit(Either.Left(value = exception.localizedMessage ?: "Error Occurred!"))
    }

    /**
     * [makePagingRequest] создает объект Pager с конфигурацией PagingConfig и возвращает объект
     * Flow<PagingData<Value>>, который представляет пагинированные данные. Она принимает параметры:
     * @param pagingSource представляет источник данных для пагинации.
     * @param pageSize: размер страницы.
     * @param prefetchDistance: расстояние, на котором должен начаться предварительный запрос следующей страницы.
     * @param enablePlaceholders: показывает, должны ли быть включены заглушки.
     * @param initialLoadSize: начальная загрузка данных в пагинационном источнике.
     * @param maxSize: максимальный размер списка.
     * @param jumpThreshold: пороговое значение для перехода на конкретную страницу в списке.
     */
    protected fun <Value : Any> makePagingRequest(
        pagingSource: PagingSource<Int, Value>,
        pageSize: Int = 20,
        prefetchDistance: Int = pageSize,
        enablePlaceholders: Boolean = true,
        initialLoadSize: Int = pageSize * 3,
        maxSize: Int = Int.MAX_VALUE,
        jumpThreshold: Int = Int.MIN_VALUE,
    ) = Pager(config = PagingConfig(
        pageSize, prefetchDistance, enablePlaceholders, initialLoadSize, maxSize, jumpThreshold
    ), pagingSourceFactory = {
        pagingSource
    }).flow
}