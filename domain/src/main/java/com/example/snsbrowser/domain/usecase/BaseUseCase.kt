package com.example.snsbrowser.domain.usecase

abstract class BaseUseCase<in PARAMETER, out RESPONSE> {
    protected abstract fun execute(parameter: PARAMETER) : RESPONSE
    operator fun invoke(parameter: PARAMETER) = execute(parameter)
}