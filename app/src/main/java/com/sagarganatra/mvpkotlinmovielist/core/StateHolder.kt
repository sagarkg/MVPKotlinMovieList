package com.sagarganatra.mvpkotlinmovielist.core

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject


class StateHolder<T>(state: T) {
    private val stateSubject = BehaviorSubject.createDefault(state)

    var state: T = state
        set(value) {
            field = value
            stateSubject.onNext(value)
        }

    inline fun setState(mutator: (T) -> T) {
        state = mutator(state)
    }

    fun asObservable(): Observable<T> = stateSubject.hide()
}