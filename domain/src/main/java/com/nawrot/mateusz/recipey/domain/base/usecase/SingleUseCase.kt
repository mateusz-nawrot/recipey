package com.nawrot.mateusz.recipey.domain.base.usecase

import com.nawrot.mateusz.recipey.domain.base.SchedulersProvider
import io.reactivex.Single


abstract class SingleUseCase<in P, R>(private val schedulersProvider: SchedulersProvider) {

    private lateinit var observable: Single<R>

    fun execute(param: P): Single<R> {
        observable = createUseCaseSingle(param).compose(schedulersProvider.singleTransformer())
        return observable
    }

    protected abstract fun createUseCaseSingle(param: P): Single<R>

}