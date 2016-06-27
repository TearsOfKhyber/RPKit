package com.seventh_root.elysium.api.chat.exception

open class ChatChannelMessageProcessingException : Exception {

    constructor() {
    }

    constructor(s: String) : super(s) {
    }

    constructor(s: String, throwable: Throwable) : super(s, throwable) {
    }

    constructor(throwable: Throwable) : super(throwable) {
    }

    constructor(s: String, throwable: Throwable, b: Boolean, b1: Boolean) : super(s, throwable, b, b1) {
    }

}