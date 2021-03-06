/*
 * Copyright 2016 Ross Binden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rpkit.core.web

import javax.servlet.http.HttpServlet

/**
 * Represents a servlet to be used by the RPK web component.
 * In addition to ordinary [HttpServlet] functionality, this includes the relative URL at which the servlet will be displayed.
 */
abstract class RPKServlet: HttpServlet() {

    /**
     * The relative URL at which the servlet will be displayed.
     */
    abstract val url: String

}