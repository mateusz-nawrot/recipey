package com.nawrot.mateusz.recipey.domain.base.usecase

import com.nawrot.mateusz.recipey.domain.base.SchedulersProvider
import io.reactivex.Completable


abstract class CompletableUseCase<in P> (private val schedulersProvider: SchedulersProvider) {

    private lateinit var completable: Completable

    fun execute(param: P): Completable {
        completable = createUseCaseCompletable(param).compose(schedulersProvider.completableTransformer())
        return completable
    }

    protected abstract fun createUseCaseCompletable(param: P): Completable
}