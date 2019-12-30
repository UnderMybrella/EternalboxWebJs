@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external interface BoundingBox {
    var x: Number
    var y: Number
    var x2: Number
    var y2: Number
    var width: Number
    var height: Number
}
external interface RaphaelAnimation {
    fun delay(delay: Number): RaphaelAnimation
    fun repeat(repeat: Number): RaphaelAnimation
}
external interface RaphaelFont {
    var w: Number
    var face: Any
    var glyphs: Any
}
external interface `T$0` {
    var width: Number? get() = definedExternally; set(value) = definedExternally
    var fill: Boolean? get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
    var offsetx: Number? get() = definedExternally; set(value) = definedExternally
    var offsety: Number? get() = definedExternally; set(value) = definedExternally
    var color: String? get() = definedExternally; set(value) = definedExternally
}
external interface `T$1` {
    var anim: RaphaelAnimation
    var status: Number
}
external interface RaphaelElement {
    fun animate(params: Json, ms: Number, easing: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): RaphaelElement
    fun animate(animation: RaphaelAnimation): RaphaelElement
    fun animateWith(el: RaphaelElement, anim: RaphaelAnimation, params: Any, ms: Number, easing: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): RaphaelElement
    fun animateWith(el: RaphaelElement, anim: RaphaelAnimation, animation: RaphaelAnimation): RaphaelElement
    fun attr(attrName: String, value: Any): RaphaelElement
    fun attr(attrName: String): Any
    fun attr(attrNames: Array<String>): Array<Any>
    fun attr(params: Any): RaphaelElement
    fun click(handler: Function<*>): RaphaelElement
    fun clone(): RaphaelElement
    fun data(key: String): Any
    fun data(key: String, value: Any): RaphaelElement
    fun dblclick(handler: Function<*>): RaphaelElement
    fun drag(onmove: (dx: Number, dy: Number, x: Number, y: Number, event: DragEvent) -> Any, onstart: (x: Number, y: Number, event: DragEvent) -> Any, onend: (DragEvent: Any) -> Any, mcontext: Any? = definedExternally /* null */, scontext: Any? = definedExternally /* null */, econtext: Any? = definedExternally /* null */): RaphaelElement
    fun getBBox(isWithoutTransform: Boolean? = definedExternally /* null */): BoundingBox
    fun glow(glow: `T$0`? = definedExternally /* null */): RaphaelSet
    fun hide(): RaphaelElement
    fun hover(f_in: Function<*>, f_out: Function<*>, icontext: Any? = definedExternally /* null */, ocontext: Any? = definedExternally /* null */): RaphaelElement
    var id: String
    fun insertAfter(el: RaphaelElement): RaphaelElement
    fun insertBefore(el: RaphaelElement): RaphaelElement
    fun isPointInside(x: Number, y: Number): Boolean
    fun isVisible(): Boolean
    var matrix: RaphaelMatrix
    fun mousedown(handler: Function<*>): RaphaelElement
    fun mousemove(handler: Function<*>): RaphaelElement
    fun mouseout(handler: Function<*>): RaphaelElement
    fun mouseover(handler: Function<*>): RaphaelElement
    fun mouseup(handler: Function<*>): RaphaelElement
    var next: RaphaelElement
    var node: SVGElement
    fun onDragOver(f: Function<*>): RaphaelElement
    var paper: RaphaelPaper
    fun pause(anim: RaphaelAnimation? = definedExternally /* null */): RaphaelElement
    var prev: RaphaelElement
    var raphael: RaphaelStatic
    fun remove()
    fun removeData(key: String? = definedExternally /* null */): RaphaelElement
    fun resume(anim: RaphaelAnimation? = definedExternally /* null */): RaphaelElement
    fun rotate(deg: Number, cx: Number? = definedExternally /* null */, cy: Number? = definedExternally /* null */): RaphaelElement
    fun setTime(anim: RaphaelAnimation)
    fun setTime(anim: RaphaelAnimation, value: Number): RaphaelElement
    fun show(): RaphaelElement
    fun status(): Array<`T$1`>
    fun status(anim: RaphaelAnimation): Number
    fun status(anim: RaphaelAnimation, value: Number): RaphaelElement
    fun stop(anim: RaphaelAnimation? = definedExternally /* null */): RaphaelElement
    fun toBack(): RaphaelElement
    fun toFront(): RaphaelElement
    fun touchcancel(handler: Function<*>): RaphaelElement
    fun touchend(handler: Function<*>): RaphaelElement
    fun touchmove(handler: Function<*>): RaphaelElement
    fun touchstart(handler: Function<*>): RaphaelElement
    fun transform(): String
    fun transform(tstr: String): RaphaelElement
    fun unclick(handler: Function<*>): RaphaelElement
    fun undblclick(handler: Function<*>): RaphaelElement
    fun undrag(): RaphaelElement
    fun unhover(): RaphaelElement
    fun unhover(f_in: Function<*>, f_out: Function<*>): RaphaelElement
    fun unmousedown(handler: Function<*>): RaphaelElement
    fun unmousemove(handler: Function<*>): RaphaelElement
    fun unmouseout(handler: Function<*>): RaphaelElement
    fun unmouseover(handler: Function<*>): RaphaelElement
    fun unmouseup(handler: Function<*>): RaphaelElement
    fun untouchcancel(handler: Function<*>): RaphaelElement
    fun untouchend(handler: Function<*>): RaphaelElement
    fun untouchmove(handler: Function<*>): RaphaelElement
    fun untouchstart(handler: Function<*>): RaphaelElement
}
external interface `T$2` {
    var x: Number
    var y: Number
    var alpha: Number
}
external interface RaphaelPath : RaphaelElement {
    fun getPointAtLength(length: Number): `T$2`
    fun getSubpath(from: Number, to: Number): String
    fun getTotalLength(): Number
}
external interface RaphaelSet {
    fun clear()
    fun exclude(element: RaphaelElement): Boolean
    fun forEach(callback: Function<*>, thisArg: Any? = definedExternally /* null */): RaphaelSet
    fun pop(): RaphaelElement
    fun push(vararg RaphaelElement: Any): RaphaelSet
    fun splice(index: Number, count: Number): RaphaelSet
    fun splice(index: Number, count: Number, vararg insertion: RaphaelElement): RaphaelSet
    var length: Number
    @nativeGetter
    operator fun get(key: Number): RaphaelElement?
    @nativeSetter
    operator fun set(key: Number, value: RaphaelElement)
    fun animate(params: Json, ms: Number, easing: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): RaphaelSet
    fun animate(animation: RaphaelAnimation): RaphaelSet
    fun animateWith(el: RaphaelElement, anim: RaphaelAnimation, params: Any, ms: Number, easing: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): RaphaelSet
    fun animateWith(el: RaphaelElement, anim: RaphaelAnimation, animation: RaphaelAnimation): RaphaelSet
    fun attr(attrName: String, value: Any): RaphaelSet
    fun attr(params: Json): RaphaelSet
    fun attr(attrName: String): Any
    fun attr(attrNames: Array<String>): Array<Any>
    fun click(handler: Function<*>): RaphaelSet
    fun clone(): RaphaelSet
    fun data(key: String): Any
    fun data(key: String, value: Any): RaphaelSet
    fun dblclick(handler: Function<*>): RaphaelSet
    fun drag(onmove: (dx: Number, dy: Number, x: Number, y: Number, event: DragEvent) -> Any, onstart: (x: Number, y: Number, event: DragEvent) -> Any, onend: (DragEvent: Any) -> Any, mcontext: Any? = definedExternally /* null */, scontext: Any? = definedExternally /* null */, econtext: Any? = definedExternally /* null */): RaphaelSet
    fun getBBox(isWithoutTransform: Boolean? = definedExternally /* null */): BoundingBox
    fun glow(glow: `T$0`? = definedExternally /* null */): RaphaelSet
    fun hide(): RaphaelSet
    fun hover(f_in: Function<*>, f_out: Function<*>, icontext: Any? = definedExternally /* null */, ocontext: Any? = definedExternally /* null */): RaphaelSet
    var id: String
    fun insertAfter(el: RaphaelElement): RaphaelSet
    fun insertBefore(el: RaphaelElement): RaphaelSet
    fun isPointInside(x: Number, y: Number): Boolean
    fun isVisible(): Boolean
    var matrix: RaphaelMatrix
    fun mousedown(handler: Function<*>): RaphaelSet
    fun mousemove(handler: Function<*>): RaphaelSet
    fun mouseout(handler: Function<*>): RaphaelSet
    fun mouseover(handler: Function<*>): RaphaelSet
    fun mouseup(handler: Function<*>): RaphaelSet
    var next: RaphaelSet
    fun onDragOver(f: Function<*>): RaphaelSet
    var paper: RaphaelPaper
    fun pause(anim: RaphaelAnimation? = definedExternally /* null */): RaphaelSet
    var prev: RaphaelSet
    var raphael: RaphaelStatic
    fun remove()
    fun removeData(key: String? = definedExternally /* null */): RaphaelSet
    fun resume(anim: RaphaelAnimation? = definedExternally /* null */): RaphaelSet
    fun setTime(anim: RaphaelAnimation)
    fun setTime(anim: RaphaelAnimation, value: Number): RaphaelSet
    fun show(): RaphaelSet
    fun status(): Array<`T$1`>
    fun status(anim: RaphaelAnimation): Number
    fun status(anim: RaphaelAnimation, value: Number): RaphaelSet
    fun stop(anim: RaphaelAnimation? = definedExternally /* null */): RaphaelSet
    fun toBack(): RaphaelSet
    fun toFront(): RaphaelSet
    fun touchcancel(handler: Function<*>): RaphaelSet
    fun touchend(handler: Function<*>): RaphaelSet
    fun touchmove(handler: Function<*>): RaphaelSet
    fun touchstart(handler: Function<*>): RaphaelSet
    fun transform(): String
    fun transform(tstr: String): RaphaelSet
    fun unclick(handler: Function<*>): RaphaelSet
    fun undblclick(handler: Function<*>): RaphaelSet
    fun undrag(): RaphaelSet
    fun unhover(): RaphaelSet
    fun unhover(f_in: Function<*>, f_out: Function<*>): RaphaelSet
    fun unmousedown(handler: Function<*>): RaphaelSet
    fun unmousemove(handler: Function<*>): RaphaelSet
    fun unmouseout(handler: Function<*>): RaphaelSet
    fun unmouseover(handler: Function<*>): RaphaelSet
    fun unmouseup(handler: Function<*>): RaphaelSet
    fun untouchcancel(handler: Function<*>): RaphaelSet
    fun untouchend(handler: Function<*>): RaphaelSet
    fun untouchmove(handler: Function<*>): RaphaelSet
    fun untouchstart(handler: Function<*>): RaphaelSet
}
external interface `T$3` {
    var dx: Number
    var dy: Number
    var scalex: Number
    var scaley: Number
    var shear: Number
    var rotate: Number
    var isSimple: Boolean
}
external interface RaphaelMatrix {
    fun add(a: Number, b: Number, c: Number, d: Number, e: Number, f: Number, matrix: RaphaelMatrix): RaphaelMatrix
    fun clone(): RaphaelMatrix
    fun invert(): RaphaelMatrix
    fun rotate(a: Number, x: Number, y: Number)
    fun scale(x: Number, y: Number? = definedExternally /* null */, cx: Number? = definedExternally /* null */, cy: Number? = definedExternally /* null */)
    fun split(): `T$3`
    fun toTransformString(): String
    fun translate(x: Number, y: Number)
    fun x(x: Number, y: Number): Number
    fun y(x: Number, y: Number): Number
}
external interface RaphaelPaper {
    fun add(JSON: Any): RaphaelSet
    var bottom: RaphaelElement
    var canvas: SVGSVGElement
    fun circle(x: Number, y: Number, r: Number): RaphaelElement
    fun clear()
    var defs: SVGDefsElement
    fun ellipse(x: Number, y: Number, rx: Number, ry: Number): RaphaelElement
    fun forEach(callback: (el: RaphaelElement) -> Boolean, thisArg: Any? = definedExternally /* null */): RaphaelPaper
    fun getById(id: Number): RaphaelElement
    fun getElementByPoint(x: Number, y: Number): RaphaelElement
    fun getElementsByPoint(x: Number, y: Number): RaphaelSet
    fun getFont(family: String, weight: String? = definedExternally /* null */, style: String? = definedExternally /* null */, stretch: String? = definedExternally /* null */): RaphaelFont
    fun getFont(family: String, weight: Number? = definedExternally /* null */, style: String? = definedExternally /* null */, stretch: String? = definedExternally /* null */): RaphaelFont
    var height: Number
    fun image(src: String, x: Number, y: Number, width: Number, height: Number): RaphaelElement
    fun path(pathString: String? = definedExternally /* null */): RaphaelPath
    fun path(pathString: Array<dynamic /* String | Number */>? = definedExternally /* null */): RaphaelPath
    fun print(x: Number, y: Number, str: String, font: RaphaelFont, size: Number? = definedExternally /* null */, origin: String? = definedExternally /* null */, letter_spacing: Number? = definedExternally /* null */): RaphaelPath
    fun rect(x: Number, y: Number, width: Number, height: Number, r: Number? = definedExternally /* null */): RaphaelElement
    fun remove()
    fun renderfix()
    fun safari()
    fun set(elements: Array<RaphaelElement>? = definedExternally /* null */): RaphaelSet
    fun setFinish(): RaphaelSet
    fun setSize(width: Number, height: Number)
    fun setStart()
    fun setViewBox(x: Number, y: Number, w: Number, h: Number, fit: Boolean)
    fun text(x: Number, y: Number, text: String): RaphaelElement
    var top: RaphaelElement
    var width: Number
    fun getFont(family: String): RaphaelFont
    fun path(): RaphaelPath
}
external interface `T$4` {
    var x: Number
    var y: Number
}
external interface `T$5` {
    var min: `T$4`
    var max: `T$4`
}
external interface `T$6` {
    var r: Number
    var g: Number
    var b: Number
    var hex: String
    var error: Boolean
    var h: Number
    var s: Number
    var v: Number
    var l: Number
}
external interface `T$7` {
    var x: Number
    var y: Number
    var m: `T$4`
    var n: `T$4`
    var start: `T$4`
    var end: `T$4`
    var alpha: Number
}
external interface `T$8` {
    @nativeInvoke
    operator fun invoke(value: Number? = definedExternally /* null */): String
    fun reset()
}
external interface `T$9` {
    var r: Number
    var g: Number
    var b: Number
    var hex: String
    var error: Boolean
}
external interface `T$10` {
    var r: Number
    var g: Number
    var b: Number
    var hex: String
}
external interface `T$11` {
    var x: Number
    var y: Number
    var t1: Number
    var t2: Number
    var segment1: Number
    var segment2: Number
    var bez1: Array<Any>
    var bez2: Array<Any>
}
external interface `T$12` {
    var h: Number
    var s: Number
    var b: Number
}
external interface `T$13` {
    var h: Number
    var s: Number
    var l: Number
}
external interface RaphaelStatic {
    @nativeInvoke
    operator fun invoke(container: HTMLElement, width: Number, height: Number, callback: Function<*>? = definedExternally /* null */): RaphaelPaper
    @nativeInvoke
    operator fun invoke(container: String, width: Number, height: Number, callback: Function<*>? = definedExternally /* null */): RaphaelPaper
    @nativeInvoke
    operator fun invoke(x: Number, y: Number, width: Number, height: Number, callback: Function<*>? = definedExternally /* null */): RaphaelPaper
    @nativeInvoke
    operator fun invoke(all: Array<Any>, callback: Function<*>? = definedExternally /* null */): RaphaelPaper
    @nativeInvoke
    operator fun invoke(onReadyCallback: Function<*>? = definedExternally /* null */): RaphaelPaper
    fun angle(x1: Number, y1: Number, x2: Number, y2: Number, x3: Number? = definedExternally /* null */, y3: Number? = definedExternally /* null */): Number
    fun animation(params: Any, ms: Number, easing: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): RaphaelAnimation
    fun bezierBBox(p1x: Number, p1y: Number, c1x: Number, c1y: Number, c2x: Number, c2y: Number, p2x: Number, p2y: Number): `T$5`
    fun bezierBBox(bez: Array<Any>): `T$5`
    fun color(clr: String): `T$6`
    fun createUUID(): String
    fun deg(deg: Number): Number
    var easing_formulas: Any
    var el: Any
    fun findDotsAtSegment(p1x: Number, p1y: Number, c1x: Number, c1y: Number, c2x: Number, c2y: Number, p2x: Number, p2y: Number, t: Number): `T$7`
    var fn: Any
    fun format(token: String, vararg parameters: Any): String
    fun fullfill(token: String, json: JSON): String
    var getColor: `T$8`
    fun getPointAtLength(path: String, length: Number): `T$2`
    fun getRGB(colour: String): `T$9`
    fun getSubpath(path: String, from: Number, to: Number): String
    fun getTotalLength(path: String): Number
    fun hsb(h: Number, s: Number, b: Number): String
    fun hsb2rgb(h: Number, s: Number, v: Number): `T$10`
    fun hsl(h: Number, s: Number, l: Number): String
    fun hsl2rgb(h: Number, s: Number, l: Number): `T$10`
    fun `is`(o: Any, type: String): Boolean
    fun isBBoxIntersect(bbox1: String, bbox2: String): Boolean
    fun isPointInsideBBox(bbox: String, x: Number, y: Number): Boolean
    fun isPointInsidePath(path: String, x: Number, y: Number): Boolean
    fun matrix(a: Number, b: Number, c: Number, d: Number, e: Number, f: Number): RaphaelMatrix
    fun ninja()
    fun parsePathString(pathString: String): Array<String>
    fun parsePathString(pathString: Array<String>): Array<String>
    fun parseTransformString(TString: String): Array<String>
    fun parseTransformString(TString: Array<String>): Array<String>
    fun path2curve(pathString: String): Array<String>
    fun path2curve(pathString: Array<String>): Array<String>
    fun pathBBox(path: String): BoundingBox
    fun pathIntersection(path1: String, path2: String): Array<`T$11`>
    fun pathToRelative(pathString: String): Array<String>
    fun pathToRelative(pathString: Array<String>): Array<String>
    fun rad(deg: Number): Number
    fun registerFont(font: RaphaelFont): RaphaelFont
    fun rgb(r: Number, g: Number, b: Number): String
    fun rgb2hsb(r: Number, g: Number, b: Number): `T$12`
    fun rgb2hsl(r: Number, g: Number, b: Number): `T$13`
    fun setWindow(newwin: Window)
    fun snapTo(values: Number, value: Number, tolerance: Number? = definedExternally /* null */): Number
    fun snapTo(values: Array<Number>, value: Number, tolerance: Number? = definedExternally /* null */): Number
    var st: Any
    var svg: Boolean
    fun toMatrix(path: String, transform: String): RaphaelMatrix
    fun toMatrix(path: String, transform: Array<String>): RaphaelMatrix
    fun transformPath(path: String, transform: String): String
    fun transformPath(path: String, transform: Array<String>): String
    var type: String
    var vml: Boolean
}
@JsModule("raphael")
external val Raphael: RaphaelStatic = definedExternally