package com.sagarganatra.mvpkotlinmovielist.base

interface IBasePresenter<V: IBaseView> {
    fun setView(view: V)
    fun onAttach()
    fun onDetach()
}