package com.wallet.transactions_ms.infra.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleMessageNotReadable(ex: Exception, request: WebRequest): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(TrasactionNotFoundException::class)
    fun handleNotFound(ex: Exception, request: WebRequest): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }

//    @ExceptionHandler(Exception::class)
//    fun handleException(ex: Exception, request: WebRequest): ResponseEntity<String> {
//        return ResponseEntity("UNEXPECTED", HttpStatus.INTERNAL_SERVER_ERROR)
//    }
}