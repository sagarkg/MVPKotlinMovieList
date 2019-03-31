package com.sagarganatra.mvpkotlinmovielist.base

interface IBasePresenter<V: IBaseView> {
    fun onAttach()
    fun onDetach()
}