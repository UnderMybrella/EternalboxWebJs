// Generated using ts2kt(https://github.com/Kotlin/ts2kt)
// from https://github.com/DefinitelyTyped/DefinitelyTyped/tree/56ce1312c8afcb526adfe93a09c9f1005644a02a/types/jquery/v2/index.d.ts
//
// Original copyrights:
//
// Type definitions for jQuery 2.0
// Project: http://jquery.com/
// Definitions by: Boris Yankov <https://github.com/borisyankov/>
//                 Christian Hoffmeister <https://github.com/choffmeister>
//                 Steve Fenton <https://github.com/Steve-Fenton>
//                 Diullei Gomes <https://github.com/Diullei>
//                 Tass Iliopoulos <https://github.com/tasoili>
//                 Jason Swearingen <https://github.com/jasons-novaleaf>
//                 Sean Hill <https://github.com/seanski>
//                 Guus Goossens <https://github.com/Guuz>
//                 Kelly Summerlin <https://github.com/ksummerlin>
//                 Basarat Ali Syed <https://github.com/basarat>
//                 Nicholas Wolverson <https://github.com/nwolverson>
//                 Derek Cicerone <https://github.com/derekcicerone>
//                 Andrew Gaspar <https://github.com/AndrewGaspar>
//                 Seikichi Kondo <https://github.com/seikichi>
//                 Benjamin Jackman <https://github.com/benjaminjackman>
//                 Poul Sorensen <https://github.com/s093294>
//                 Josh Strobl <https://github.com/JoshStrobl>
//                 John Reilly <https://github.com/johnnyreilly/>
//                 Dick van den Brink <https://github.com/DickvdBrink>
//                 Thomas Schulz <https://github.com/King2500>
//                 Leonard Thieu <https://github.com/leonard-thieu>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped

/* *****************************************************************************
Copyright (c) Microsoft Corporation. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License"); you may not use
this file except in compliance with the License. You may obtain a copy of the
License at http://www.apache.org/licenses/LICENSE-2.0

THIS CODE IS PROVIDED *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION ANY IMPLIED
WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A PARTICULAR PURPOSE,
MERCHANTABLITY OR NON-INFRINGEMENT.

See the Apache Version 2.0 License for specific language governing permissions
and limitations under the License.
***************************************************************************** */

@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package jquery

import jqueryui.*
import org.w3c.dom.*
import org.w3c.dom.events.Event
import org.w3c.dom.events.MouseEvent
import org.w3c.xhr.XMLHttpRequest
import kotlin.js.*

external interface JQueryAjaxSettings {
    var accepts: Any? get() = definedExternally; set(value) = definedExternally
    var async: Boolean? get() = definedExternally; set(value) = definedExternally
    val beforeSend: ((jqXHR: JQueryXHR, settings: JQueryAjaxSettings) -> Any)? get() = definedExternally
    var cache: Boolean? get() = definedExternally; set(value) = definedExternally
    val complete: ((jqXHR: JQueryXHR, textStatus: String) -> Any)? get() = definedExternally
    var contents: Json? get() = definedExternally; set(value) = definedExternally
    var contentType: Any? get() = definedExternally; set(value) = definedExternally
    var context: Any? get() = definedExternally; set(value) = definedExternally
    var converters: Json? get() = definedExternally; set(value) = definedExternally
    var crossDomain: Boolean? get() = definedExternally; set(value) = definedExternally
    var data: Any? get() = definedExternally; set(value) = definedExternally
    val dataFilter: ((data: Any, ty: Any) -> Any)? get() = definedExternally
    var dataType: String? get() = definedExternally; set(value) = definedExternally
    val error: ((jqXHR: JQueryXHR, textStatus: String, errorThrown: String) -> Any)? get() = definedExternally
    var global: Boolean? get() = definedExternally; set(value) = definedExternally
    var headers: Json? get() = definedExternally; set(value) = definedExternally
    var ifModified: Boolean? get() = definedExternally; set(value) = definedExternally
    var isLocal: Boolean? get() = definedExternally; set(value) = definedExternally
    var jsonp: Any? get() = definedExternally; set(value) = definedExternally
    var jsonpCallback: Any? get() = definedExternally; set(value) = definedExternally
    var method: String? get() = definedExternally; set(value) = definedExternally
    var mimeType: String? get() = definedExternally; set(value) = definedExternally
    var password: String? get() = definedExternally; set(value) = definedExternally
    var processData: Boolean? get() = definedExternally; set(value) = definedExternally
    var scriptCharset: String? get() = definedExternally; set(value) = definedExternally
    var statusCode: Json? get() = definedExternally; set(value) = definedExternally
    val success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? get() = definedExternally
    var timeout: Number? get() = definedExternally; set(value) = definedExternally
    var traditional: Boolean? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
    var url: String? get() = definedExternally; set(value) = definedExternally
    var username: String? get() = definedExternally; set(value) = definedExternally
    var xhr: Any? get() = definedExternally; set(value) = definedExternally
    var xhrFields: Json? get() = definedExternally; set(value) = definedExternally
}
external interface JQueryXHR : XMLHttpRequest, JQueryPromise<Any> {
    override fun overrideMimeType(mimeType: String): Any
    fun abort(statusText: String? = definedExternally)
    fun <R> then(doneCallback: (data: Any, textStatus: String, jqXHR: JQueryXHR) -> dynamic /* R | JQueryPromise<R> */, failCallback: ((jqXHR: JQueryXHR, textStatus: String, errorThrown: Any) -> Unit)? = definedExternally): JQueryPromise<R>
    var responseJSON: Any? get() = definedExternally; set(value) = definedExternally
    fun error(xhr: JQueryXHR, textStatus: String, errorThrown: String)
}
external interface JQueryCallback {
    fun add(callbacks: Function<*>): JQueryCallback
    fun add(callbacks: Array<Function<*>>): JQueryCallback
    fun disable(): JQueryCallback
    fun disabled(): Boolean
    fun empty(): JQueryCallback
    fun fire(vararg arguments: Any): JQueryCallback
    fun fired(): Boolean
    fun fireWith(context: Any? = definedExternally, args: Array<Any>? = definedExternally): JQueryCallback
    fun has(callback: Function<*>): Boolean
    fun lock(): JQueryCallback
    fun locked(): Boolean
    fun remove(callbacks: Function<*>): JQueryCallback
    fun remove(callbacks: Array<Function<*>>): JQueryCallback
}
external interface JQueryGenericPromise<T> {
    fun <U> then(doneFilter: (value: T? /*= null*/, values: Any) -> dynamic /* U | JQueryPromise<U> */, failFilter: ((reasons: Any) -> Any)? = definedExternally, progressFilter: ((progression: Any) -> Any)? = definedExternally): JQueryPromise<U>
    fun then(doneFilter: (value: T? /*= null*/, values: Any) -> Unit, failFilter: ((reasons: Any) -> Any)? = definedExternally, progressFilter: ((progression: Any) -> Any)? = definedExternally): JQueryPromise<Unit>
}
external interface JQueryPromiseCallback<T> {
    @nativeInvoke
    operator fun invoke(value: T? = definedExternally, vararg args: Any)
}
external interface JQueryPromiseOperator<T, U> {
    @nativeInvoke
    operator fun invoke(callback1: JQueryPromiseCallback<T>, vararg callbacksN: JQueryPromiseCallback<Any>): JQueryPromise<U>
    @nativeInvoke
    operator fun invoke(callback1: JQueryPromiseCallback<T>, vararg callbacksN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<U>
    @nativeInvoke
    operator fun invoke(callback1: Array<JQueryPromiseCallback<T>>, vararg callbacksN: JQueryPromiseCallback<Any>): JQueryPromise<U>
    @nativeInvoke
    operator fun invoke(callback1: Array<JQueryPromiseCallback<T>>, vararg callbacksN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<U>
}
external interface JQueryPromise<T> : JQueryGenericPromise<T> {
    fun state(): String
    fun always(alwaysCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg alwaysCallbackN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun always(alwaysCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg alwaysCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun always(alwaysCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg alwaysCallbackN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun always(alwaysCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg alwaysCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun done(doneCallback1: JQueryPromiseCallback<T>? = definedExternally, vararg doneCallbackN: JQueryPromiseCallback<T>): JQueryPromise<T>
    fun done(doneCallback1: JQueryPromiseCallback<T>? = definedExternally, vararg doneCallbackN: Array<JQueryPromiseCallback<T>>): JQueryPromise<T>
    fun done(doneCallback1: Array<JQueryPromiseCallback<T>>? = definedExternally, vararg doneCallbackN: JQueryPromiseCallback<T>): JQueryPromise<T>
    fun done(doneCallback1: Array<JQueryPromiseCallback<T>>? = definedExternally, vararg doneCallbackN: Array<JQueryPromiseCallback<T>>): JQueryPromise<T>
    fun fail(failCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg failCallbackN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun fail(failCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg failCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun fail(failCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg failCallbackN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun fail(failCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg failCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun progress(progressCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg progressCallbackN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun progress(progressCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg progressCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun progress(progressCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg progressCallbackN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun progress(progressCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg progressCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun pipe(doneFilter: ((x: Any) -> Any)? = definedExternally, failFilter: ((x: Any) -> Any)? = definedExternally, progressFilter: ((x: Any) -> Any)? = definedExternally): JQueryPromise<Any>
    fun promise(target: Any? = definedExternally): JQueryPromise<T>
}
external interface JQueryDeferred<T> : JQueryGenericPromise<T> {
    fun state(): String
    fun always(alwaysCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg alwaysCallbackN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun always(alwaysCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg alwaysCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun always(alwaysCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg alwaysCallbackN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun always(alwaysCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg alwaysCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun done(doneCallback1: JQueryPromiseCallback<T>? = definedExternally, vararg doneCallbackN: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun done(doneCallback1: JQueryPromiseCallback<T>? = definedExternally, vararg doneCallbackN: Array<JQueryPromiseCallback<T>>): JQueryDeferred<T>
    fun done(doneCallback1: Array<JQueryPromiseCallback<T>>? = definedExternally, vararg doneCallbackN: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun done(doneCallback1: Array<JQueryPromiseCallback<T>>? = definedExternally, vararg doneCallbackN: Array<JQueryPromiseCallback<T>>): JQueryDeferred<T>
    fun fail(failCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg failCallbackN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun fail(failCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg failCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun fail(failCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg failCallbackN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun fail(failCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg failCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun progress(progressCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg progressCallbackN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun progress(progressCallback1: JQueryPromiseCallback<Any>? = definedExternally, vararg progressCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun progress(progressCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg progressCallbackN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun progress(progressCallback1: Array<JQueryPromiseCallback<Any>>? = definedExternally, vararg progressCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun notify(value: Any? = definedExternally, vararg args: Any): JQueryDeferred<T>
    fun notifyWith(context: Any, args: Array<Any>? = definedExternally): JQueryDeferred<T>
    fun reject(value: Any? = definedExternally, vararg args: Any): JQueryDeferred<T>
    fun rejectWith(context: Any, args: Array<Any>? = definedExternally): JQueryDeferred<T>
    fun resolve(value: T? = definedExternally, vararg args: Any): JQueryDeferred<T>
    fun resolveWith(context: Any, args: Array<T>? = definedExternally): JQueryDeferred<T>
    fun promise(target: Any? = definedExternally): JQueryPromise<T>
    fun pipe(doneFilter: ((x: Any) -> Any)? = definedExternally, failFilter: ((x: Any) -> Any)? = definedExternally, progressFilter: ((x: Any) -> Any)? = definedExternally): JQueryPromise<Any>
}
external interface BaseJQueryEventObject : Event {
    override var currentTarget: Element
    var data: Any
    var delegateTarget: Element
    fun isDefaultPrevented(): Boolean
    fun isImmediatePropagationStopped(): Boolean
    fun isPropagationStopped(): Boolean
    var namespace: String
    var originalEvent: Event
    override fun preventDefault(): Any
    var relatedTarget: Element
    var result: Any
    override fun stopImmediatePropagation()
    override fun stopPropagation()
    override var target: Element
    var pageX: Number
    var pageY: Number
    var which: Number
    var metaKey: Boolean
}
external interface JQueryInputEventObject : BaseJQueryEventObject {
    var altKey: Boolean
    var ctrlKey: Boolean
    override var metaKey: Boolean
    var shiftKey: Boolean
}
external interface JQueryMouseEventObject : JQueryInputEventObject {
    var button: Number
    var clientX: Number
    var clientY: Number
    var offsetX: Number
    var offsetY: Number
    override var pageX: Number
    override var pageY: Number
    var screenX: Number
    var screenY: Number
}
external interface JQueryKeyEventObject : JQueryInputEventObject {
    var char: Any
    var charCode: Number
    var key: Any
    var keyCode: Number
}
external interface JQueryEventObject : BaseJQueryEventObject,
    JQueryInputEventObject, JQueryMouseEventObject,
    JQueryKeyEventObject
external interface JQuerySupport {
    var ajax: Boolean? get() = definedExternally; set(value) = definedExternally
    var boxModel: Boolean? get() = definedExternally; set(value) = definedExternally
    var changeBubbles: Boolean? get() = definedExternally; set(value) = definedExternally
    var checkClone: Boolean? get() = definedExternally; set(value) = definedExternally
    var checkOn: Boolean? get() = definedExternally; set(value) = definedExternally
    var cors: Boolean? get() = definedExternally; set(value) = definedExternally
    var cssFloat: Boolean? get() = definedExternally; set(value) = definedExternally
    var hrefNormalized: Boolean? get() = definedExternally; set(value) = definedExternally
    var htmlSerialize: Boolean? get() = definedExternally; set(value) = definedExternally
    var leadingWhitespace: Boolean? get() = definedExternally; set(value) = definedExternally
    var noCloneChecked: Boolean? get() = definedExternally; set(value) = definedExternally
    var noCloneEvent: Boolean? get() = definedExternally; set(value) = definedExternally
    var opacity: Boolean? get() = definedExternally; set(value) = definedExternally
    var optDisabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var optSelected: Boolean? get() = definedExternally; set(value) = definedExternally
    val scriptEval: (() -> Boolean)? get() = definedExternally
    var style: Boolean? get() = definedExternally; set(value) = definedExternally
    var submitBubbles: Boolean? get() = definedExternally; set(value) = definedExternally
    var tbody: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface JQueryParam {
    @nativeInvoke
    operator fun invoke(obj: Any): String
    @nativeInvoke
    operator fun invoke(obj: Any, traditional: Boolean): String
}
external interface JQueryEventConstructor {
    @nativeInvoke
    operator fun invoke(name: String, eventProperties: Any? = definedExternally): JQueryEventObject
}
external interface JQueryCoordinates {
    var left: Number
    var top: Number
}
external interface cssPropertySetter {
    @nativeInvoke
    operator fun invoke(index: Number, value: String? = definedExternally): dynamic /* String | Number */
}
external interface JQueryCssProperties {
    @nativeGetter
    operator fun get(propertyName: String): dynamic /* String | Number | cssPropertySetter */
    @nativeSetter
    operator fun set(propertyName: String, value: String)
    @nativeSetter
    operator fun set(propertyName: String, value: Number)
    @nativeSetter
    operator fun set(propertyName: String, value: cssPropertySetter)
}
external interface JQuerySerializeArrayElement {
    var name: String
    var value: String
}
external interface JQueryAnimationOptions {
    var duration: Any? get() = definedExternally; set(value) = definedExternally
    var easing: String? get() = definedExternally; set(value) = definedExternally
    var complete: Function<*>? get() = definedExternally; set(value) = definedExternally
    var step: ((now: Number, tween: Any) -> Any)? get() = definedExternally; set(value) = definedExternally
    var progress: ((animation: JQueryPromise<Any>, progress: Number, remainingMs: Number) -> Any)? get() = definedExternally; set(value) = definedExternally
    var start: ((animation: JQueryPromise<Any>) -> Any)? get() = definedExternally; set(value) = definedExternally
    var done: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? get() = definedExternally; set(value) = definedExternally
    var fail: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? get() = definedExternally; set(value) = definedExternally
    var always: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? get() = definedExternally; set(value) = definedExternally
    var queue: Any? get() = definedExternally; set(value) = definedExternally
    var specialEasing: Any? get() = definedExternally; set(value) = definedExternally
}
external interface JQueryEasingFunction {
    @nativeInvoke
    operator fun invoke(percent: Number): Number
}
external interface JQueryEasingFunctions {
    @nativeGetter
    operator fun get(name: String): JQueryEasingFunction?
    @nativeSetter
    operator fun set(name: String, value: JQueryEasingFunction)
    var linear: JQueryEasingFunction
    var swing: JQueryEasingFunction
}
external interface `T$0` {
    var slow: Number
    var fast: Number
}
external interface `T$1` {
    var tick: () -> Unit
    var interval: Number
    var stop: () -> Unit
    var speeds: `T$0`
    var off: Boolean
    var step: Any
}
external interface JQueryStatic {
    fun ajax(settings: JQueryAjaxSettings): JQueryXHR
    fun ajax(url: String, settings: JQueryAjaxSettings? = definedExternally): JQueryXHR
    fun ajaxPrefilter(dataTypes: String, handler: (opts: Any, originalOpts: JQueryAjaxSettings, jqXHR: JQueryXHR) -> Any)
    fun ajaxPrefilter(handler: (opts: Any, originalOpts: JQueryAjaxSettings, jqXHR: JQueryXHR) -> Any)
    fun ajaxTransport(dataType: String, handler: (opts: Any, originalOpts: JQueryAjaxSettings, jqXHR: JQueryXHR) -> Any)
    var ajaxSettings: JQueryAjaxSettings
    fun ajaxSetup(options: JQueryAjaxSettings)
    fun get(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = definedExternally, dataType: String? = definedExternally): JQueryXHR
    fun get(url: String, data: String? = definedExternally, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = definedExternally, dataType: String? = definedExternally): JQueryXHR
    fun get(url: String, data: Any? = definedExternally, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = definedExternally, dataType: String? = definedExternally): JQueryXHR
    fun get(settings: JQueryAjaxSettings): JQueryXHR
    fun getJSON(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = definedExternally): JQueryXHR
    fun getJSON(url: String, data: String? = definedExternally, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = definedExternally): JQueryXHR
    fun getJSON(url: String, data: Any? = definedExternally, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = definedExternally): JQueryXHR
    fun getScript(url: String, success: ((script: String, textStatus: String, jqXHR: JQueryXHR) -> Any)? = definedExternally): JQueryXHR
    var param: JQueryParam
    fun post(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = definedExternally, dataType: String? = definedExternally): JQueryXHR
    fun post(url: String, data: String? = definedExternally, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = definedExternally, dataType: String? = definedExternally): JQueryXHR
    fun post(url: String, data: Any? = definedExternally, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = definedExternally, dataType: String? = definedExternally): JQueryXHR
    fun post(settings: JQueryAjaxSettings): JQueryXHR
    fun Callbacks(flags: String? = definedExternally): JQueryCallback
    fun holdReady(hold: Boolean)
    @nativeInvoke
    operator fun invoke(selector: String, context: Element? = definedExternally): JQuery
    @nativeInvoke
    operator fun invoke(selector: String, context: JQuery? = definedExternally): JQuery
    @nativeInvoke
    operator fun invoke(element: Element): JQuery
    @nativeInvoke
    operator fun invoke(elementArray: Array<Element>): JQuery
    @nativeInvoke
    operator fun invoke(callback: (jQueryAlias: JQueryStatic? /*= null*/) -> Any): JQuery
    @nativeInvoke
    operator fun invoke(`object`: Any): JQuery
    @nativeInvoke
    operator fun invoke(`object`: JQuery): JQuery
    @nativeInvoke
    operator fun invoke(): JQuery
    @nativeInvoke
    operator fun invoke(html: String, ownerDocument: Document? = definedExternally): JQuery
    @nativeInvoke
    operator fun invoke(html: String, attributes: Any): JQuery
    fun noConflict(removeAll: Boolean? = definedExternally): JQueryStatic
    fun <T> `when`(vararg deferreds: T): JQueryPromise<T>
    fun <T> `when`(vararg deferreds: JQueryPromise<T>): JQueryPromise<T>
    var cssHooks: Json
    var cssNumber: Any
    fun <T> data(element: Element, key: String, value: T): T
    fun data(element: Element, key: String): Any
    fun data(element: Element): Any
    fun dequeue(element: Element, queueName: String? = definedExternally)
    fun hasData(element: Element): Boolean
    fun queue(element: Element, queueName: String? = definedExternally): Array<Any>
    fun queue(element: Element, queueName: String, newQueue: Array<Function<*>>): JQuery
    fun queue(element: Element, queueName: String, callback: Function<*>): JQuery
    fun removeData(element: Element, name: String? = definedExternally): JQuery
    fun <T> Deferred(beforeStart: ((deferred: JQueryDeferred<T>) -> Any)? = definedExternally): JQueryDeferred<T>
    var easing: JQueryEasingFunctions
    var fx: `T$1`
    fun proxy(func: (args: Any) -> Any, context: Any, vararg additionalArguments: Any): Any
    fun proxy(context: Any, name: String, vararg additionalArguments: Any): Any
    var Event: JQueryEventConstructor
    fun error(message: Any): JQuery
    var expr: Any
    var fn: JQuery
    var isReady: Boolean
    var support: JQuerySupport
    fun contains(container: Element, contained: Element): Boolean
    fun <T> each(collection: Array<T>, callback: (indexInArray: Number, valueOfElement: T) -> dynamic /* Boolean | Unit */): Array<T>
    fun <T : Any> each(collection: T, callback: (keyInObject: String, valueOfElement: Any) -> dynamic /* Boolean | Unit */): T
    fun extend(target: Any, object1: Any? = definedExternally, vararg objectN: Any): Any
    fun extend(deep: Boolean, target: Any, object1: Any? = definedExternally, vararg objectN: Any): Any
    fun globalEval(code: String): Any
    fun <T> grep(array: Array<T>, func: (elementOfArray: T? /*= null*/, indexInArray: Number? /*= null*/) -> Boolean, invert: Boolean? = definedExternally): Array<T>
    fun <T> inArray(value: T, array: Array<T>, fromIndex: Number? = definedExternally): Number
    fun isArray(obj: Any): Boolean
    fun isEmptyObject(obj: Any): Boolean
    fun isFunction(obj: Any): Boolean
    fun isNumeric(value: Any): Boolean
    fun isPlainObject(obj: Any): Boolean
    fun isWindow(obj: Any): Boolean
    fun isXMLDoc(node: Node): Boolean
    fun makeArray(obj: Any): Array<Any>
    fun <T, U> map(array: Array<T>, callback: (elementOfArray: T? /*= null*/, indexInArray: Number? /*= null*/) -> U): Array<U>
    fun map(arrayOrObject: Any, callback: (value: Any? /*= null*/, indexOrKey: Any? /*= null*/) -> Any): Any
    fun <T> merge(first: Array<T>, second: Array<T>): Array<T>
    fun noop(): Any
    fun now(): Number
    fun parseJSON(json: String): Any
    fun parseXML(data: String): XMLDocument
    fun trim(str: String): String
    fun type(obj: Any): dynamic /* String | String | String | String | String | String | String | String | String | String | String | String */
    fun <T : Element> unique(array: Array<T>): Array<T>
    fun parseHTML(data: String, context: HTMLElement? = definedExternally, keepScripts: Boolean? = definedExternally): Array<Any>
    fun parseHTML(data: String, context: Document? = definedExternally, keepScripts: Boolean? = definedExternally): Array<Any>
    fun get(url: String): JQueryXHR
    fun getJSON(url: String): JQueryXHR
    fun post(url: String): JQueryXHR
    @nativeInvoke
    operator fun invoke(selector: String): JQuery
    fun parseHTML(data: String): Array<Any>

    /** UI */
    var ui: UI
    var datepicker: Datepicker
    var widget: Widget
    var Widget: Widget
}
external interface `T$2` {
    @nativeGetter
    operator fun get(key: String): ((eventObject: JQueryEventObject, args: Any) -> Any)?
    @nativeSetter
    operator fun set(key: String, value: (eventObject: JQueryEventObject, args: Any) -> Any)
}
external interface `T$3` {
    @nativeGetter
    operator fun get(method: String): ((args: Any) -> Any)?
    @nativeSetter
    operator fun set(method: String, value: (args: Any) -> Any)
}
external interface JQuery {
    fun ajaxComplete(handler: (event: JQueryEventObject, XMLHttpRequest: XMLHttpRequest, ajaxOptions: Any) -> Any): JQuery
    fun ajaxError(handler: (event: JQueryEventObject, jqXHR: JQueryXHR, ajaxSettings: JQueryAjaxSettings, thrownError: Any) -> Any): JQuery
    fun ajaxSend(handler: (event: JQueryEventObject, jqXHR: JQueryXHR, ajaxOptions: JQueryAjaxSettings) -> Any): JQuery
    fun ajaxStart(handler: () -> Any): JQuery
    fun ajaxStop(handler: () -> Any): JQuery
    fun ajaxSuccess(handler: (event: JQueryEventObject, XMLHttpRequest: XMLHttpRequest, ajaxOptions: JQueryAjaxSettings) -> Any): JQuery
    fun load(url: String, data: String? = definedExternally, complete: ((responseText: String, textStatus: String, XMLHttpRequest: XMLHttpRequest) -> Any)? = definedExternally): JQuery
    fun load(url: String, data: Any? = definedExternally, complete: ((responseText: String, textStatus: String, XMLHttpRequest: XMLHttpRequest) -> Any)? = definedExternally): JQuery
    fun serialize(): String
    fun serializeArray(): Array<JQuerySerializeArrayElement>
    fun addClass(func: (index: Number, className: String) -> String): JQuery
    fun addBack(selector: String? = definedExternally): JQuery
    fun attr(attributeName: String): String
    fun attr(attributeName: String, value: String): JQuery
    fun attr(attributeName: String, value: Number): JQuery
    fun attr(attributeName: String, func: (index: Number, attr: String) -> dynamic /* String | Number */): JQuery
    fun attr(attributes: Any): JQuery
    fun hasClass(className: String): Boolean
    fun html(): String
    fun html(htmlString: String): JQuery
    fun html(func: (index: Number, oldhtml: String) -> String): JQuery
    fun prop(propertyName: String): Any
    fun prop(propertyName: String, value: String): JQuery
    fun prop(propertyName: String, value: Number): JQuery
    fun prop(propertyName: String, value: Boolean): JQuery
    fun prop(properties: Any): JQuery
    fun prop(propertyName: String, func: (index: Number, oldPropertyValue: Any) -> Any): JQuery
    fun removeAttr(attributeName: String): JQuery
    fun removeClass(className: String? = definedExternally): JQuery
    fun removeClass(func: (index: Number, className: String) -> String): JQuery
    fun removeProp(propertyName: String): JQuery
    fun toggleClass(className: String, swtch: Boolean? = definedExternally): JQuery
    fun toggleClass(swtch: Boolean? = definedExternally): JQuery
    fun toggleClass(func: (index: Number, className: String, swtch: Boolean) -> String, swtch: Boolean? = definedExternally): JQuery
    fun `val`(): Any
    fun `val`(value: String): JQuery
    fun `val`(value: Number): JQuery
    fun `val`(value: Array<String>): JQuery
    fun `val`(func: (index: Number, value: String) -> String): JQuery
    fun css(propertyName: String): String
    fun css(propertyNames: Array<String>): Any
    fun css(propertyName: String, value: String): JQuery
    fun css(propertyName: String, value: Number): JQuery
    fun css(propertyName: String, value: (index: Number, value: String) -> dynamic /* String | Number */): JQuery
    fun css(properties: JQueryCssProperties): JQuery
    fun height(): Number
    fun height(value: String): JQuery
    fun height(value: Number): JQuery
    fun height(func: (index: Number, height: Number) -> dynamic /* String | Number */): JQuery
    fun innerHeight(): Number
    fun innerHeight(value: String): JQuery
    fun innerHeight(value: Number): JQuery
    fun innerWidth(): Number
    fun innerWidth(value: String): JQuery
    fun innerWidth(value: Number): JQuery
    fun offset(): JQueryCoordinates
    fun offset(coordinates: JQueryCoordinates): JQuery
    fun offset(func: (index: Number, coords: JQueryCoordinates) -> JQueryCoordinates): JQuery
    fun outerHeight(includeMargin: Boolean? = definedExternally): Number
    fun outerHeight(value: String): JQuery
    fun outerHeight(value: Number): JQuery
    fun outerWidth(includeMargin: Boolean? = definedExternally): Number
    fun outerWidth(value: String): JQuery
    fun outerWidth(value: Number): JQuery
    fun position(): JQueryCoordinates
    fun scrollLeft(): Number
    fun scrollLeft(value: Number): JQuery
    fun scrollTop(): Number
    fun scrollTop(value: Number): JQuery
    fun width(): Number
    fun width(value: String): JQuery
    fun width(value: Number): JQuery
    fun width(func: (index: Number, width: Number) -> dynamic /* String | Number */): JQuery
    fun clearQueue(queueName: String? = definedExternally): JQuery
    fun data(key: String, value: Any): JQuery
    fun data(key: String): Any
    fun data(obj: Json): JQuery
    fun data(): Any
    fun dequeue(queueName: String? = definedExternally): JQuery
    fun removeData(name: String): JQuery
    fun removeData(list: Array<String>): JQuery
    fun removeData(): JQuery
    fun promise(type: String? = definedExternally, target: Any? = definedExternally): JQueryPromise<Any>
    fun animate(properties: Any, duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun animate(properties: Any, duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun animate(properties: Any, duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun animate(properties: Any, duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun animate(properties: Any, options: JQueryAnimationOptions): JQuery
    fun delay(duration: Number, queueName: String? = definedExternally): JQuery
    fun fadeIn(duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeIn(duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeIn(duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeIn(duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeIn(options: JQueryAnimationOptions): JQuery
    fun fadeOut(duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeOut(duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeOut(duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeOut(duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeOut(options: JQueryAnimationOptions): JQuery
    fun fadeTo(duration: String, opacity: Number, complete: Function<*>? = definedExternally): JQuery
    fun fadeTo(duration: Number, opacity: Number, complete: Function<*>? = definedExternally): JQuery
    fun fadeTo(duration: String, opacity: Number, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeTo(duration: Number, opacity: Number, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeToggle(duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeToggle(duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeToggle(duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeToggle(duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun fadeToggle(options: JQueryAnimationOptions): JQuery
    fun finish(queue: String? = definedExternally): JQuery
    fun hide(duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun hide(duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun hide(duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun hide(duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun hide(options: JQueryAnimationOptions): JQuery
    fun show(duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun show(duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun show(duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun show(duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun show(options: JQueryAnimationOptions): JQuery
    fun slideDown(duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideDown(duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideDown(duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideDown(duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideDown(options: JQueryAnimationOptions): JQuery
    fun slideToggle(duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideToggle(duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideToggle(duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideToggle(duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideToggle(options: JQueryAnimationOptions): JQuery
    fun slideUp(duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideUp(duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideUp(duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideUp(duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun slideUp(options: JQueryAnimationOptions): JQuery
    fun stop(clearQueue: Boolean? = definedExternally, jumpToEnd: Boolean? = definedExternally): JQuery
    fun stop(queue: String? = definedExternally, clearQueue: Boolean? = definedExternally, jumpToEnd: Boolean? = definedExternally): JQuery
    fun toggle(duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun toggle(duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun toggle(duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun toggle(duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun toggle(options: JQueryAnimationOptions): JQuery
    fun toggle(showOrHide: Boolean): JQuery
    fun bind(eventType: String, eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun bind(eventType: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun bind(eventType: String, eventData: Any, preventBubble: Boolean): JQuery
    fun bind(eventType: String, preventBubble: Boolean): JQuery
    fun bind(events: Any): JQuery
    fun blur(): JQuery
    fun blur(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun blur(eventData: Any? = definedExternally, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    fun change(): JQuery
    fun change(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun change(eventData: Any? = definedExternally, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    fun click(): JQuery
    fun click(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun click(eventData: Any? = definedExternally, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    fun contextmenu(): JQuery
    fun contextmenu(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun contextmenu(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun dblclick(): JQuery
    fun dblclick(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun dblclick(eventData: Any? = definedExternally, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    fun delegate(selector: Any, eventType: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun delegate(selector: Any, eventType: String, eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focus(): JQuery
    fun focus(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focus(eventData: Any? = definedExternally, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    fun focusin(): JQuery
    fun focusin(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusin(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusout(): JQuery
    fun focusout(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusout(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun hover(handlerIn: (eventObject: JQueryEventObject) -> Any, handlerOut: (eventObject: JQueryEventObject) -> Any): JQuery
    fun hover(handlerInOut: (eventObject: JQueryEventObject) -> Any): JQuery
    fun keydown(): JQuery
    fun keydown(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
//    fun keydown(eventData: Any? = definedExternally, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = definedExternally): JQuery
    fun keypress(): JQuery
    fun keypress(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
//    fun keypress(eventData: Any? = definedExternally, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = definedExternally): JQuery
    fun keyup(): JQuery
    fun keyup(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
//    fun keyup(eventData: Any? = definedExternally, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = definedExternally): JQuery
    fun load(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun load(eventData: Any? = definedExternally, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    fun mousedown(): JQuery
    fun mousedown(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousedown(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseenter(): JQuery
    fun mouseenter(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseenter(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseleave(): JQuery
    fun mouseleave(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseleave(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousemove(): JQuery
    fun mousemove(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousemove(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseout(): JQuery
    fun mouseout(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseout(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseover(): JQuery
    fun mouseover(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseover(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseup(): JQuery
    fun mouseup(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseup(eventData: Any, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun off(): JQuery
    fun off(events: String, selector: String? = definedExternally, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    fun off(events: String, handler: (eventObject: JQueryEventObject, args: Any) -> Any): JQuery
    fun off(events: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun off(events: Json, selector: String? = definedExternally): JQuery
    fun on(events: String, handler: (eventObject: JQueryEventObject, args: Any) -> Any): JQuery
    fun on(events: String, data: Any, handler: (eventObject: JQueryEventObject, args: Any) -> Any): JQuery
    fun on(events: String, selector: String, handler: (eventObject: JQueryEventObject, eventData: Any) -> Any): JQuery
    fun on(events: String, selector: String, data: Any, handler: (eventObject: JQueryEventObject, eventData: Any) -> Any): JQuery
    fun on(events: `T$2`, selector: String? = definedExternally, data: Any? = definedExternally): JQuery
    fun on(events: `T$2`, data: Any? = definedExternally): JQuery
    fun one(events: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: String, data: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: String, selector: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: String, selector: String, data: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: Json, selector: String? = definedExternally, data: Any? = definedExternally): JQuery
    fun one(events: Json, data: Any? = definedExternally): JQuery
    fun ready(handler: (jQueryAlias: JQueryStatic? /*= null*/) -> Any): JQuery
    fun resize(): JQuery
    fun resize(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun resize(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun scroll(): JQuery
    fun scroll(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun scroll(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun select(): JQuery
    fun select(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun select(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun submit(): JQuery
    fun submit(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun submit(eventData: Any? = definedExternally, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    fun trigger(eventType: String, extraParameters: Any? = definedExternally): JQuery
    fun trigger(eventType: String, extraParameters: Array<Any>? = definedExternally): JQuery
    fun trigger(event: JQueryEventObject, extraParameters: Any? = definedExternally): JQuery
    fun trigger(event: JQueryEventObject, extraParameters: Array<Any>? = definedExternally): JQuery
    fun triggerHandler(eventType: String, vararg extraParameters: Any): Any
    fun triggerHandler(event: JQueryEventObject, vararg extraParameters: Any): Any
    fun unbind(eventType: String? = definedExternally, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    fun unbind(eventType: String, fls: Boolean): JQuery
    fun unbind(evt: Any): JQuery
    fun undelegate(): JQuery
    fun undelegate(selector: String, eventType: String, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    fun undelegate(selector: String, events: Any): JQuery
    fun undelegate(namespace: String): JQuery
    fun unload(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun unload(eventData: Any? = definedExternally, handler: ((eventObject: JQueryEventObject) -> Any)? = definedExternally): JQuery
    var context: Element
    var jquery: String
    fun error(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun error(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun pushStack(elements: Array<Any>): JQuery
    fun pushStack(elements: Array<Any>, name: String, arguments: Array<Any>): JQuery
    fun after(content1: String, vararg content2: Any): JQuery
    fun after(content1: Array<Any>, vararg content2: Any): JQuery
    fun after(content1: Element, vararg content2: Any): JQuery
    fun after(content1: JQuery, vararg content2: Any): JQuery
    fun after(content1: DocumentFragment, vararg content2: Any): JQuery
    fun after(content1: Text, vararg content2: Any): JQuery
    fun after(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun append(content1: String, vararg content2: Any): JQuery
    fun append(content1: Array<Any>, vararg content2: Any): JQuery
    fun append(content1: Element, vararg content2: Any): JQuery
    fun append(content1: JQuery, vararg content2: Any): JQuery
    fun append(content1: DocumentFragment, vararg content2: Any): JQuery
    fun append(content1: Text, vararg content2: Any): JQuery
    fun append(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun appendTo(target: String): JQuery
    fun appendTo(target: Array<Any>): JQuery
    fun appendTo(target: Element): JQuery
    fun appendTo(target: JQuery): JQuery
    fun before(content1: String, vararg content2: Any): JQuery
    fun before(content1: Array<Any>, vararg content2: Any): JQuery
    fun before(content1: Element, vararg content2: Any): JQuery
    fun before(content1: JQuery, vararg content2: Any): JQuery
    fun before(content1: DocumentFragment, vararg content2: Any): JQuery
    fun before(content1: Text, vararg content2: Any): JQuery
    fun before(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun clone(withDataAndEvents: Boolean? = definedExternally, deepWithDataAndEvents: Boolean? = definedExternally): JQuery
    fun detach(selector: String? = definedExternally): JQuery
    fun empty(): JQuery
    fun insertAfter(target: String): JQuery
    fun insertAfter(target: Array<Any>): JQuery
    fun insertAfter(target: Element): JQuery
    fun insertAfter(target: JQuery): JQuery
    fun insertAfter(target: Text): JQuery
    fun insertBefore(target: String): JQuery
    fun insertBefore(target: Array<Any>): JQuery
    fun insertBefore(target: Element): JQuery
    fun insertBefore(target: JQuery): JQuery
    fun insertBefore(target: Text): JQuery
    fun prepend(content1: String, vararg content2: Any): JQuery
    fun prepend(content1: Array<Any>, vararg content2: Any): JQuery
    fun prepend(content1: Element, vararg content2: Any): JQuery
    fun prepend(content1: JQuery, vararg content2: Any): JQuery
    fun prepend(content1: DocumentFragment, vararg content2: Any): JQuery
    fun prepend(content1: Text, vararg content2: Any): JQuery
    fun prepend(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun prependTo(target: String): JQuery
    fun prependTo(target: Array<Any>): JQuery
    fun prependTo(target: Element): JQuery
    fun prependTo(target: JQuery): JQuery
    fun remove(selector: String? = definedExternally): JQuery
    fun replaceAll(target: String): JQuery
    fun replaceAll(target: Array<Any>): JQuery
    fun replaceAll(target: Element): JQuery
    fun replaceAll(target: JQuery): JQuery
    fun replaceWith(newContent: String): JQuery
    fun replaceWith(newContent: Array<Any>): JQuery
    fun replaceWith(newContent: Element): JQuery
    fun replaceWith(newContent: JQuery): JQuery
    fun replaceWith(newContent: Text): JQuery
    fun replaceWith(func: () -> dynamic /* Element | JQuery */): JQuery
    fun text(): String
    fun text(text: String): JQuery
    fun text(text: Number): JQuery
    fun text(text: Boolean): JQuery
    fun text(func: (index: Number, text: String) -> String): JQuery
    fun toArray(): Array<HTMLElement>
    fun unwrap(): JQuery
    fun wrap(wrappingElement: String): JQuery
    fun wrap(wrappingElement: Element): JQuery
    fun wrap(wrappingElement: JQuery): JQuery
    fun wrap(func: (index: Number) -> dynamic /* String | JQuery */): JQuery
    fun wrapAll(wrappingElement: String): JQuery
    fun wrapAll(wrappingElement: Element): JQuery
    fun wrapAll(wrappingElement: JQuery): JQuery
    fun wrapAll(func: (index: Number) -> String): JQuery
    fun wrapInner(wrappingElement: String): JQuery
    fun wrapInner(wrappingElement: Element): JQuery
    fun wrapInner(wrappingElement: JQuery): JQuery
    fun wrapInner(func: (index: Number) -> String): JQuery
    fun each(func: (index: Number, elem: Element) -> dynamic /* Boolean | Unit */): JQuery
//    fun get(index: Number): HTMLElement
    fun get(): Array<HTMLElement>
    fun index(): Number
    fun index(selector: String): Number
    fun index(selector: Element): Number
    fun index(selector: JQuery): Number
    var length: Number
    var selector: String
    @nativeGetter
    operator fun get(index: Number): HTMLElement?
    @nativeSetter
    operator fun set(index: Number, value: HTMLElement)
    fun add(selector: String, context: Element? = definedExternally): JQuery
    fun add(vararg elements: Element): JQuery
    fun add(html: String): JQuery
    fun add(obj: JQuery): JQuery
    fun children(selector: String? = definedExternally): JQuery
    fun closest(selector: String): JQuery
    fun closest(selector: String, context: Element? = definedExternally): JQuery
    fun closest(obj: JQuery): JQuery
    fun closest(element: Element): JQuery
    fun closest(selectors: Any, context: Element? = definedExternally): Array<Any>
    fun contents(): JQuery
    fun end(): JQuery
    fun eq(index: Number): JQuery
    fun filter(selector: String): JQuery
    fun filter(func: (index: Number, element: Element) -> Boolean): JQuery
    fun filter(element: Element): JQuery
    fun filter(obj: JQuery): JQuery
    fun find(selector: String): JQuery
    fun find(element: Element): JQuery
    fun find(obj: JQuery): JQuery
    fun first(): JQuery
    fun has(selector: String): JQuery
    fun has(contained: Element): JQuery
    fun `is`(selector: String): Boolean
    fun `is`(func: (index: Number, element: Element) -> Boolean): Boolean
    fun `is`(obj: JQuery): Boolean
//    fun `is`(elements: Any): Boolean
    fun last(): JQuery
    fun map(callback: (index: Number, domElement: Element) -> Any): JQuery
    fun next(selector: String? = definedExternally): JQuery
    fun nextAll(selector: String? = definedExternally): JQuery
    fun nextUntil(selector: String? = definedExternally, filter: String? = definedExternally): JQuery
    fun nextUntil(element: Element? = definedExternally, filter: String? = definedExternally): JQuery
    fun nextUntil(obj: JQuery? = definedExternally, filter: String? = definedExternally): JQuery
    fun not(selector: String): JQuery
    fun not(func: (index: Number, element: Element) -> Boolean): JQuery
    fun not(elements: Element): JQuery
    fun not(elements: Array<Element>): JQuery
    fun not(obj: JQuery): JQuery
    fun offsetParent(): JQuery
    fun parent(selector: String? = definedExternally): JQuery
    fun parents(selector: String? = definedExternally): JQuery
    fun parentsUntil(selector: String? = definedExternally, filter: String? = definedExternally): JQuery
    fun parentsUntil(element: Element? = definedExternally, filter: String? = definedExternally): JQuery
    fun parentsUntil(obj: JQuery? = definedExternally, filter: String? = definedExternally): JQuery
    fun prev(selector: String? = definedExternally): JQuery
    fun prevAll(selector: String? = definedExternally): JQuery
    fun prevUntil(selector: String? = definedExternally, filter: String? = definedExternally): JQuery
    fun prevUntil(element: Element? = definedExternally, filter: String? = definedExternally): JQuery
    fun prevUntil(obj: JQuery? = definedExternally, filter: String? = definedExternally): JQuery
    fun siblings(selector: String? = definedExternally): JQuery
    fun slice(start: Number, end: Number? = definedExternally): JQuery
    fun queue(queueName: String? = definedExternally): Array<Any>
    fun queue(newQueue: Array<Function<*>>): JQuery
    fun queue(callback: Function<*>): JQuery
    fun queue(queueName: String, newQueue: Array<Function<*>>): JQuery
    fun queue(queueName: String, callback: Function<*>): JQuery
    fun extend(`object`: `T$3`): JQuery
    fun load(url: String): JQuery
    fun animate(properties: Any): JQuery
    fun fadeIn(): JQuery
    fun fadeOut(): JQuery
    fun fadeTo(duration: String, opacity: Number): JQuery
    fun fadeTo(duration: Number, opacity: Number): JQuery
    fun fadeToggle(): JQuery
    fun hide(): JQuery
    fun show(): JQuery
    fun slideDown(): JQuery
    fun slideToggle(): JQuery
    fun slideUp(): JQuery
    fun stop(): JQuery
    fun toggle(): JQuery
    fun on(events: `T$2`): JQuery
    fun one(events: Json): JQuery
    fun trigger(eventType: String): JQuery
    fun trigger(event: JQueryEventObject): JQuery
    fun nextUntil(): JQuery
    fun parentsUntil(): JQuery
    fun prevUntil(): JQuery

    /** UI */
    fun accordion(): JQuery
    fun accordion(methodName: String)
    fun accordion(methodName: String)
    fun accordion(methodName: String)
    fun accordion(methodName: String)
    fun accordion(methodName: String): JQuery
    fun accordion(methodName: String): JQuery
    fun accordion(options: AccordionOptions): JQuery
    fun accordion(optionLiteral: String, optionName: String): Any
    fun accordion(optionLiteral: String, options: AccordionOptions): Any
    fun accordion(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun autocomplete(): JQuery
    fun autocomplete(methodName: String)
    fun autocomplete(methodName: String)
    fun autocomplete(methodName: String)
    fun autocomplete(methodName: String)
    fun autocomplete(methodName: String, value: String? = definedExternally)
    fun autocomplete(methodName: String): JQuery
    fun autocomplete(methodName: String): JQuery
    fun autocomplete(options: AutocompleteOptions): JQuery
    fun autocomplete(optionLiteral: String, optionName: String): Any
    fun autocomplete(optionLiteral: String, options: AutocompleteOptions): Any
    fun autocomplete(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun button(): JQuery
    fun button(methodName: String)
    fun button(methodName: String)
    fun button(methodName: String)
    fun button(methodName: String)
    fun button(methodName: String): JQuery
    fun button(methodName: String): JQuery
    fun button(options: ButtonOptions): JQuery
    fun button(optionLiteral: String, optionName: String): Any
    fun button(optionLiteral: String, options: ButtonOptions): Any
    fun button(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun buttonset(): JQuery
    fun buttonset(methodName: String)
    fun buttonset(methodName: String)
    fun buttonset(methodName: String)
    fun buttonset(methodName: String)
    fun buttonset(methodName: String): JQuery
    fun buttonset(methodName: String): JQuery
    fun buttonset(options: ButtonOptions): JQuery
    fun buttonset(optionLiteral: String, optionName: String): Any
    fun buttonset(optionLiteral: String, options: ButtonOptions): Any
    fun buttonset(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun datepicker(): JQuery
    fun datepicker(methodName: String): JQuery
    fun datepicker(methodName: String, date: Date, onSelect: (() -> Unit)? = definedExternally, settings: DatepickerOptions? = definedExternally, pos: Array<Number>? = definedExternally): JQuery
    fun datepicker(methodName: String, date: Date, onSelect: (() -> Unit)? = definedExternally, settings: DatepickerOptions? = definedExternally, pos: MouseEvent? = definedExternally): JQuery
    fun datepicker(methodName: String, date: String, onSelect: (() -> Unit)? = definedExternally, settings: DatepickerOptions? = definedExternally, pos: Array<Number>? = definedExternally): JQuery
    fun datepicker(methodName: String, date: String, onSelect: (() -> Unit)? = definedExternally, settings: DatepickerOptions? = definedExternally, pos: MouseEvent? = definedExternally): JQuery
    fun datepicker(methodName: String): Date
    fun datepicker(methodName: String): JQuery
    fun datepicker(methodName: String): Boolean
    fun datepicker(methodName: String): JQuery
    fun datepicker(methodName: String, date: Date): JQuery
    fun datepicker(methodName: String, date: String): JQuery
    fun datepicker(methodName: String): JQuery
    fun datepicker(methodName: String): JQuery
    fun datepicker(methodName: String, optionName: String): Any
    fun datepicker(methodName: String, optionName: String, altFieldValue: String): JQuery
    fun datepicker(methodName: String, optionName: String, altFieldValue: JQuery): JQuery
    fun datepicker(methodName: String, optionName: String, altFieldValue: Element): JQuery
    fun datepicker(methodName: String, optionName: String): String
    fun datepicker(methodName: String, optionName: String, altFormatValue: String): JQuery
    fun datepicker(methodName: String, optionName: String): String
    fun datepicker(methodName: String, optionName: String, appendTextValue: String): JQuery
    fun datepicker(methodName: String, optionName: String): Boolean
    fun datepicker(methodName: String, optionName: String, autoSizeValue: Boolean): JQuery
    fun datepicker(methodName: String, optionName: String): (input: Element, inst: Any) -> DatepickerOptions
    fun datepicker(methodName: String, optionName: String, beforeShowValue: (input: Element, inst: Any) -> DatepickerOptions): JQuery
    fun datepicker(methodName: String, optionName: String): (date: Date) -> Array<Any>
    fun datepicker(methodName: String, optionName: String, beforeShowDayValue: (date: Date) -> Array<Any>): JQuery
    fun datepicker(methodName: String, optionName: String): String
    fun datepicker(methodName: String, optionName: String, buttonImageValue: String): JQuery
    fun datepicker(methodName: String, optionName: String): Boolean
    fun datepicker(methodName: String, optionName: String, buttonImageOnlyValue: Boolean): JQuery
    fun datepicker(methodName: String, optionName: String): String
    fun datepicker(methodName: String, optionName: String): Boolean
    fun datepicker(methodName: String, optionName: String): Date
    fun datepicker(methodName: String, optionName: String, buttonTextValue: String): JQuery
    fun datepicker(methodName: String, optionName: String): (date: Date) -> String
    fun datepicker(methodName: String, optionName: String, calculateWeekValue: (date: Date) -> String): JQuery
    fun datepicker(methodName: String, optionName: String): Boolean
    fun datepicker(methodName: String, optionName: String, changeMonthValue: Boolean): JQuery
    fun datepicker(methodName: String, optionName: String): Boolean
    fun datepicker(methodName: String, optionName: String, changeYearValue: Boolean): JQuery
    fun datepicker(methodName: String, optionName: String): String
    fun datepicker(methodName: String, optionName: String, closeTextValue: String): JQuery
    fun datepicker(methodName: String, optionName: String): Boolean
    fun datepicker(methodName: String, optionName: String, constrainInputValue: Boolean): JQuery
    fun datepicker(methodName: String, optionName: String): String
    fun datepicker(methodName: String, optionName: String, currentTextValue: String): JQuery
    fun datepicker(methodName: String, optionName: String): String
    fun datepicker(methodName: String, optionName: String, dateFormatValue: String): JQuery
    fun datepicker(methodName: String, optionName: String): Array<String>
    fun datepicker(methodName: String, optionName: String, dayNamesValue: Array<String>): JQuery
    fun datepicker(methodName: String, optionName: String): Array<String>
    fun datepicker(methodName: String, optionName: String, dayNamesMinValue: Array<String>): JQuery
    fun datepicker(methodName: String, optionName: String): Array<String>
    fun datepicker(methodName: String, optionName: String, dayNamesShortValue: Array<String>): JQuery
    fun datepicker(methodName: String, optionName: String): Any
    fun datepicker(methodName: String, optionName: String, defaultDateValue: Date): JQuery
    fun datepicker(methodName: String, optionName: String, defaultDateValue: Number): JQuery
    fun datepicker(methodName: String, optionName: String, defaultDateValue: String): JQuery
    fun datepicker(methodName: String, optionName: String): String
    fun datepicker(methodName: String, optionName: String, durationValue: String): JQuery
    fun datepicker(methodName: String, optionName: String): Number
    fun datepicker(methodName: String, optionName: String, firstDayValue: Number): JQuery
    fun datepicker(methodName: String, optionName: String): Boolean
    fun datepicker(methodName: String, optionName: String, gotoCurrentValue: Boolean): JQuery
    fun datepicker(methodName: String, optionName: String): Any
    fun datepicker(methodName: String, optionName: String, vararg otherParams: Any): Any
    fun datepicker(methodName: String, vararg otherParams: Any): Any
    fun datepicker(options: DatepickerOptions): JQuery
    fun dialog(): JQuery
    fun dialog(methodName: String): JQuery
    fun dialog(options: DialogOptions): JQuery
    fun dialog(optionLiteral: String, optionName: String): Any
    fun dialog(optionLiteral: String, options: DialogOptions): Any
    fun dialog(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun draggable(): JQuery
    fun draggable(methodName: String): JQuery
    fun draggable(options: DraggableOptions): JQuery
    fun draggable(optionLiteral: String, optionName: String): Any
    fun draggable(optionLiteral: String, options: DraggableOptions): Any
    fun draggable(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun droppable(): JQuery
    fun droppable(methodName: String): JQuery
    fun droppable(options: DroppableOptions): JQuery
    fun droppable(optionLiteral: String, optionName: String): Any
    fun droppable(optionLiteral: String, options: DraggableOptions): Any
    fun droppable(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    var menu: `T$6`
    fun progressbar(): JQuery
    fun progressbar(methodName: String, value: Number)
    fun progressbar(methodName: String, value: Boolean)
    fun progressbar(methodName: String): JQuery
    fun progressbar(options: ProgressbarOptions): JQuery
    fun progressbar(optionLiteral: String, optionName: String): Any
    fun progressbar(optionLiteral: String, options: ProgressbarOptions): Any
    fun progressbar(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun resizable(): JQuery
    fun resizable(methodName: String): JQuery
    fun resizable(options: ResizableOptions): JQuery
    fun resizable(optionLiteral: String, optionName: String): Any
    fun resizable(optionLiteral: String, options: ResizableOptions): Any
    fun resizable(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun selectable(): JQuery
    fun selectable(methodName: String): JQuery
    fun selectable(options: SelectableOptions): JQuery
    fun selectable(optionLiteral: String, optionName: String): Any
    fun selectable(optionLiteral: String, options: SelectableOptions): Any
    fun selectable(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun selectmenu(): JQuery
    fun selectmenu(methodName: String): JQuery
    fun selectmenu(options: SelectMenuOptions): JQuery
    fun selectmenu(optionLiteral: String, optionName: String): Any
    fun selectmenu(optionLiteral: String, options: SelectMenuOptions): Any
    fun selectmenu(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun slider(): JQuery
    fun slider(methodName: String): JQuery
//    fun slider(methodName: String): Array<Number>
    fun slider(methodName: String, value: Number)
    fun slider(methodName: String, values: Array<Number>)
    fun slider(methodName: String, index: Number, value: Number)
    fun slider(options: SliderOptions): JQuery
    fun slider(optionLiteral: String, optionName: String): Any
    fun slider(optionLiteral: String, options: SliderOptions): Any
    fun slider(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun sortable(): JQuery
    fun sortable(methodName: String)
    fun sortable(methodName: String)
    fun sortable(methodName: String)
    fun sortable(methodName: String): JQuery
    fun sortable(methodName: String, options: `T$7`? = definedExternally): Array<String>
    fun sortable(methodName: String): JQuery
    fun sortable(options: SortableOptions): JQuery
    fun sortable(optionLiteral: String, optionName: String): Any
    fun sortable(methodName: String, options: `T$8`? = definedExternally): String
    fun sortable(optionLiteral: String, options: SortableOptions): Any
    fun sortable(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun spinner(): JQuery
    fun spinner(methodName: String)
    fun spinner(methodName: String)
    fun spinner(methodName: String)
    fun spinner(methodName: String, pages: Number? = definedExternally)
    fun spinner(methodName: String, pages: Number? = definedExternally)
    fun spinner(methodName: String, steps: Number? = definedExternally)
    fun spinner(methodName: String, steps: Number? = definedExternally)
    fun spinner(methodName: String): Number
    fun spinner(methodName: String, value: Number)
    fun spinner(methodName: String): JQuery
    fun spinner(methodName: String): JQuery
    fun spinner(options: SpinnerOptions): JQuery
    fun spinner(optionLiteral: String, optionName: String): Any
    fun spinner(optionLiteral: String, options: SpinnerOptions): Any
    fun spinner(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun tabs(): JQuery
    fun tabs(methodName: String)
    fun tabs(methodName: String)
    fun tabs(methodName: String, index: Number)
    fun tabs(methodName: String)
    fun tabs(methodName: String, index: Number)
    fun tabs(methodName: String, index: Number)
    fun tabs(methodName: String)
    fun tabs(methodName: String): JQuery
    fun tabs(methodName: String, index: Number): JQuery
    fun tabs(methodName: String): JQuery
    fun tabs(options: TabsOptions): JQuery
    fun tabs(optionLiteral: String, optionName: String): Any
    fun tabs(optionLiteral: String, options: TabsOptions): Any
    fun tabs(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun tooltip(): JQuery
    fun tooltip(methodName: String)
    fun tooltip(methodName: String)
    fun tooltip(methodName: String)
    fun tooltip(methodName: String)
    fun tooltip(methodName: String)
    fun tooltip(methodName: String): JQuery
    fun tooltip(methodName: String): JQuery
    fun tooltip(options: TooltipOptions): JQuery
    fun tooltip(optionLiteral: String, optionName: String): Any
    fun tooltip(optionLiteral: String, options: TooltipOptions): Any
    fun tooltip(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun addClass(classNames: String, speed: Number? = definedExternally, callback: Function<*>? = definedExternally): JQuery
    fun addClass(classNames: String, speed: String? = definedExternally, callback: Function<*>? = definedExternally): JQuery
    fun addClass(classNames: String, speed: Number? = definedExternally, easing: String? = definedExternally, callback: Function<*>? = definedExternally): JQuery
    fun addClass(classNames: String, speed: String? = definedExternally, easing: String? = definedExternally, callback: Function<*>? = definedExternally): JQuery
    fun removeClass(classNames: String, speed: Number? = definedExternally, callback: Function<*>? = definedExternally): JQuery
    fun removeClass(classNames: String, speed: String? = definedExternally, callback: Function<*>? = definedExternally): JQuery
    fun removeClass(classNames: String, speed: Number? = definedExternally, easing: String? = definedExternally, callback: Function<*>? = definedExternally): JQuery
    fun removeClass(classNames: String, speed: String? = definedExternally, easing: String? = definedExternally, callback: Function<*>? = definedExternally): JQuery
    fun switchClass(removeClassName: String, addClassName: String, duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun switchClass(removeClassName: String, addClassName: String, duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun toggleClass(className: String, duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun toggleClass(className: String, duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun toggleClass(className: String, aswitch: Boolean? = definedExternally, duration: Number? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun toggleClass(className: String, aswitch: Boolean? = definedExternally, duration: String? = definedExternally, easing: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun effect(options: Any): JQuery
    fun effect(effect: String, options: Any? = definedExternally, duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun effect(effect: String, options: Any? = definedExternally, duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun hide(options: Any): JQuery
    fun hide(effect: String, options: Any? = definedExternally, duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun hide(effect: String, options: Any? = definedExternally, duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun show(options: Any): JQuery
    fun show(effect: String, options: Any? = definedExternally, duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun show(effect: String, options: Any? = definedExternally, duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun toggle(options: Any): JQuery
    fun toggle(effect: String, options: Any? = definedExternally, duration: Number? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun toggle(effect: String, options: Any? = definedExternally, duration: String? = definedExternally, complete: Function<*>? = definedExternally): JQuery
    fun position(options: JQueryPositionOptions): JQuery
    fun enableSelection(): JQuery
    fun disableSelection(): JQuery
    fun focus(delay: Number, callback: Function<*>? = definedExternally): JQuery
    fun uniqueId(): JQuery
    fun removeUniqueId(): JQuery
    fun scrollParent(): JQuery
    fun zIndex(): Number
    fun zIndex(zIndex: Number): JQuery
    var widget: Widget
    var jQuery: JQueryStatic
    fun datepicker(methodName: String, date: Date): JQuery
    fun datepicker(methodName: String, date: String): JQuery
    fun addClass(classNames: String): JQuery
    fun removeClass(classNames: String): JQuery
    fun switchClass(removeClassName: String, addClassName: String): JQuery
    fun toggleClass(className: String): JQuery
    fun effect(effect: String): JQuery
    fun hide(effect: String): JQuery
    fun show(effect: String): JQuery
    fun toggle(effect: String): JQuery
}
external var jQuery: JQueryStatic = definedExternally
@JsModule("")
external val `$`: JQueryStatic = definedExternally

fun JQueryXHR.done(callback: (data: Any, textStatus: String, jqXHR: JQueryXHR) -> dynamic) = then<Any>(callback, { _, _, _ -> })

fun ajax(builder: JQueryAjaxSettings.() -> Unit) = jQuery.ajax((object :
    JQueryAjaxSettings {}).apply(builder))
fun JQuery.dialog(builder: DialogOptions.() -> Unit) = dialog((object:
    DialogOptions {}).apply(builder))
fun JQuery.slider(builder: SliderOptions.() -> Unit) = slider((object:
    SliderOptions {}).apply(builder))