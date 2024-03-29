package com.denailry.activitylifecycle.loginhandler

import com.denailry.activitylifecycle.account.Account

abstract class LoginHandler {
    protected var nextHandler: LoginHandler? = null

    companion object {
        fun instance() : LoginHandler {
            return InvalidHandler()
        }
    }

    abstract fun handle(username: String, password: String) : Account?

    fun addHandler(handler: LoginHandler) : LoginHandler {
        handler.nextHandler = this
        return handler
    }

    private class InvalidHandler : LoginHandler() {
        override  fun handle(username: String, password: String) : Account? {
            return null
        }
    }
}