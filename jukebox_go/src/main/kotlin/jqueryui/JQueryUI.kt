@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
package jqueryui

import jquery.JQuery
import jquery.JQueryEasingFunction
import jquery.JQueryEventObject
import jquery.JQueryXHR
import kotlin.js.*
import kotlin.js.Json
import org.w3c.dom.*
import org.w3c.dom.events.*

external interface AccordionOptions : AccordionEvents {
    var active: Any? get() = definedExternally; set(value) = definedExternally
    var animate: Any? get() = definedExternally; set(value) = definedExternally
    var collapsible: Boolean? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var event: String? get() = definedExternally; set(value) = definedExternally
    var header: String? get() = definedExternally; set(value) = definedExternally
    var heightStyle: String? get() = definedExternally; set(value) = definedExternally
    var icons: Any? get() = definedExternally; set(value) = definedExternally
}
external interface AccordionUIParams {
    var newHeader: JQuery
    var oldHeader: JQuery
    var newPanel: JQuery
    var oldPanel: JQuery
}
external interface AccordionEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: AccordionUIParams)
}
external interface AccordionEvents {
    var activate: AccordionEvent? get() = definedExternally; set(value) = definedExternally
    var beforeActivate: AccordionEvent? get() = definedExternally; set(value) = definedExternally
    var create: AccordionEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Accordion : Widget, AccordionOptions
external interface AutocompleteOptions : AutocompleteEvents {
    var appendTo: Any? get() = definedExternally; set(value) = definedExternally
    var autoFocus: Boolean? get() = definedExternally; set(value) = definedExternally
    var delay: Number? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var minLength: Number? get() = definedExternally; set(value) = definedExternally
    var position: Any? get() = definedExternally; set(value) = definedExternally
    var source: Any? get() = definedExternally; set(value) = definedExternally
    var classes: AutocompleteClasses? get() = definedExternally; set(value) = definedExternally
}
external interface AutocompleteClasses
external interface AutocompleteUIParams {
    var item: Any? get() = definedExternally; set(value) = definedExternally
    var content: Any? get() = definedExternally; set(value) = definedExternally
}
external interface AutocompleteEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: AutocompleteUIParams)
}
external interface AutocompleteEvents {
    var change: AutocompleteEvent? get() = definedExternally; set(value) = definedExternally
    var close: AutocompleteEvent? get() = definedExternally; set(value) = definedExternally
    var create: AutocompleteEvent? get() = definedExternally; set(value) = definedExternally
    var focus: AutocompleteEvent? get() = definedExternally; set(value) = definedExternally
    var open: AutocompleteEvent? get() = definedExternally; set(value) = definedExternally
    var response: AutocompleteEvent? get() = definedExternally; set(value) = definedExternally
    var search: AutocompleteEvent? get() = definedExternally; set(value) = definedExternally
    var select: AutocompleteEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Autocomplete : Widget, AutocompleteOptions {
    var escapeRegex: (value: String) -> String
    var filter: (array: Any, term: String) -> Any
}
external interface ButtonOptions {
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var icons: Any? get() = definedExternally; set(value) = definedExternally
    var label: String? get() = definedExternally; set(value) = definedExternally
    var text: dynamic /* String | Boolean */ get() = definedExternally; set(value) = definedExternally
    var click: ((event: Event? /*= null*/) -> Unit)? get() = definedExternally; set(value) = definedExternally
}
external interface Button : Widget, ButtonOptions
external interface DatepickerOptions {
    var altField: Any? get() = definedExternally; set(value) = definedExternally
    var altFormat: String? get() = definedExternally; set(value) = definedExternally
    var appendText: String? get() = definedExternally; set(value) = definedExternally
    var autoSize: Boolean? get() = definedExternally; set(value) = definedExternally
    var beforeShow: ((input: Element, inst: Any) -> DatepickerOptions)? get() = definedExternally; set(value) = definedExternally
    var beforeShowDay: ((date: Date) -> Array<Any>)? get() = definedExternally; set(value) = definedExternally
    var buttonImage: String? get() = definedExternally; set(value) = definedExternally
    var buttonImageOnly: Boolean? get() = definedExternally; set(value) = definedExternally
    var buttonText: String? get() = definedExternally; set(value) = definedExternally
    var calculateWeek: ((date: Date) -> String)? get() = definedExternally; set(value) = definedExternally
    var changeMonth: Boolean? get() = definedExternally; set(value) = definedExternally
    var changeYear: Boolean? get() = definedExternally; set(value) = definedExternally
    var closeText: String? get() = definedExternally; set(value) = definedExternally
    var constrainInput: Boolean? get() = definedExternally; set(value) = definedExternally
    var currentText: String? get() = definedExternally; set(value) = definedExternally
    var dateFormat: String? get() = definedExternally; set(value) = definedExternally
    var dayNames: Array<String>? get() = definedExternally; set(value) = definedExternally
    var dayNamesMin: Array<String>? get() = definedExternally; set(value) = definedExternally
    var dayNamesShort: Array<String>? get() = definedExternally; set(value) = definedExternally
    var defaultDate: Any? get() = definedExternally; set(value) = definedExternally
    var duration: String? get() = definedExternally; set(value) = definedExternally
    var firstDay: Number? get() = definedExternally; set(value) = definedExternally
    var gotoCurrent: Boolean? get() = definedExternally; set(value) = definedExternally
    var hideIfNoPrevNext: Boolean? get() = definedExternally; set(value) = definedExternally
    var isRTL: Boolean? get() = definedExternally; set(value) = definedExternally
    var maxDate: Any? get() = definedExternally; set(value) = definedExternally
    var minDate: Any? get() = definedExternally; set(value) = definedExternally
    var monthNames: Array<String>? get() = definedExternally; set(value) = definedExternally
    var monthNamesShort: Array<String>? get() = definedExternally; set(value) = definedExternally
    var navigationAsDateFormat: Boolean? get() = definedExternally; set(value) = definedExternally
    var nextText: String? get() = definedExternally; set(value) = definedExternally
    var numberOfMonths: Any? get() = definedExternally; set(value) = definedExternally
    var onChangeMonthYear: ((year: Number, month: Number, inst: Any) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var onClose: ((dateText: String, inst: Any) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var onSelect: ((dateText: String, inst: Any) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var prevText: String? get() = definedExternally; set(value) = definedExternally
    var selectOtherMonths: Boolean? get() = definedExternally; set(value) = definedExternally
    var shortYearCutoff: Any? get() = definedExternally; set(value) = definedExternally
    var showAnim: String? get() = definedExternally; set(value) = definedExternally
    var showButtonPanel: Boolean? get() = definedExternally; set(value) = definedExternally
    var showCurrentAtPos: Number? get() = definedExternally; set(value) = definedExternally
    var showMonthAfterYear: Boolean? get() = definedExternally; set(value) = definedExternally
    var showOn: String? get() = definedExternally; set(value) = definedExternally
    var showOptions: Any? get() = definedExternally; set(value) = definedExternally
    var showOtherMonths: Boolean? get() = definedExternally; set(value) = definedExternally
    var showWeek: Boolean? get() = definedExternally; set(value) = definedExternally
    var stepMonths: Number? get() = definedExternally; set(value) = definedExternally
    var weekHeader: String? get() = definedExternally; set(value) = definedExternally
    var yearRange: String? get() = definedExternally; set(value) = definedExternally
    var yearSuffix: String? get() = definedExternally; set(value) = definedExternally
    var autohide: Boolean? get() = definedExternally; set(value) = definedExternally
    var endDate: Date? get() = definedExternally; set(value) = definedExternally
}
external interface DatepickerFormatDateOptions {
    var dayNamesShort: Array<String>? get() = definedExternally; set(value) = definedExternally
    var dayNames: Array<String>? get() = definedExternally; set(value) = definedExternally
    var monthNamesShort: Array<String>? get() = definedExternally; set(value) = definedExternally
    var monthNames: Array<String>? get() = definedExternally; set(value) = definedExternally
}
external interface Datepicker : Widget, DatepickerOptions {
    var regional: Json
    fun setDefaults(defaults: DatepickerOptions)
    fun formatDate(format: String, date: Date, settings: DatepickerFormatDateOptions? = definedExternally /* null */): String
    fun parseDate(format: String, date: String, settings: DatepickerFormatDateOptions? = definedExternally /* null */): Date
    fun iso8601Week(date: Date): Number
    fun noWeekends(date: Date): Array<Any>
}
external interface `T$0` {
    @nativeGetter
    operator fun get(buttonText: String): ((event: Event? /*= null*/) -> Unit)?
    @nativeSetter
    operator fun set(buttonText: String, value: (event: Event? /*= null*/) -> Unit)
}
external interface DialogOptions : DialogEvents {
    var autoOpen: Boolean? get() = definedExternally; set(value) = definedExternally
    var buttons: dynamic /* `T$0` | Array<DialogButtonOptions> */ get() = definedExternally; set(value) = definedExternally
    var closeOnEscape: Boolean? get() = definedExternally; set(value) = definedExternally
    var classes: DialogClasses? get() = definedExternally; set(value) = definedExternally
    var closeText: String? get() = definedExternally; set(value) = definedExternally
    var appendTo: String? get() = definedExternally; set(value) = definedExternally
    var dialogClass: String? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
    var height: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var hide: dynamic /* String | Number | Boolean | DialogShowHideOptions */ get() = definedExternally; set(value) = definedExternally
    var maxHeight: Number? get() = definedExternally; set(value) = definedExternally
    var maxWidth: Number? get() = definedExternally; set(value) = definedExternally
    var minHeight: Number? get() = definedExternally; set(value) = definedExternally
    var minWidth: Number? get() = definedExternally; set(value) = definedExternally
    var modal: Boolean? get() = definedExternally; set(value) = definedExternally
    var position: Any? get() = definedExternally; set(value) = definedExternally
    var resizable: Boolean? get() = definedExternally; set(value) = definedExternally
    var show: dynamic /* String | Number | Boolean | DialogShowHideOptions */ get() = definedExternally; set(value) = definedExternally
    var stack: Boolean? get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var width: Any? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
    override var open: DialogEvent? get() = definedExternally; set(value) = definedExternally
    override var close: DialogEvent? get() = definedExternally; set(value) = definedExternally
}
external interface DialogClasses
external interface DialogButtonOptions {
    var icons: Any? get() = definedExternally; set(value) = definedExternally
    var showText: dynamic /* String | Boolean */ get() = definedExternally; set(value) = definedExternally
    var text: String? get() = definedExternally; set(value) = definedExternally
    var click: ((eventObject: JQueryEventObject) -> Any)? get() = definedExternally; set(value) = definedExternally
    @nativeGetter
    operator fun get(attr: String): Any?
    @nativeSetter
    operator fun set(attr: String, value: Any)
}
external interface DialogShowHideOptions {
    var effect: String
    var delay: Number? get() = definedExternally; set(value) = definedExternally
    var duration: Number? get() = definedExternally; set(value) = definedExternally
    var easing: String? get() = definedExternally; set(value) = definedExternally
}
external interface DialogUIParams
external interface DialogEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: DialogUIParams)
}
external interface DialogEvents {
    var beforeClose: DialogEvent? get() = definedExternally; set(value) = definedExternally
    var close: DialogEvent? get() = definedExternally; set(value) = definedExternally
    var create: DialogEvent? get() = definedExternally; set(value) = definedExternally
    var drag: DialogEvent? get() = definedExternally; set(value) = definedExternally
    var dragStart: DialogEvent? get() = definedExternally; set(value) = definedExternally
    var dragStop: DialogEvent? get() = definedExternally; set(value) = definedExternally
    var focus: DialogEvent? get() = definedExternally; set(value) = definedExternally
    var open: DialogEvent? get() = definedExternally; set(value) = definedExternally
    var resize: DialogEvent? get() = definedExternally; set(value) = definedExternally
    var resizeStart: DialogEvent? get() = definedExternally; set(value) = definedExternally
    var resizeStop: DialogEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Dialog : Widget, DialogOptions
external interface `T$1` {
    var top: Number
    var left: Number
}
external interface DraggableEventUIParams {
    var helper: JQuery
    var position: `T$1`
    var offset: `T$1`
}
external interface DraggableEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: DraggableEventUIParams)
}
external interface DraggableOptions : DraggableEvents {
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var addClasses: Boolean? get() = definedExternally; set(value) = definedExternally
    var appendTo: Any? get() = definedExternally; set(value) = definedExternally
    var axis: String? get() = definedExternally; set(value) = definedExternally
    var cancel: String? get() = definedExternally; set(value) = definedExternally
    var connectToSortable: dynamic /* String | JQuery | Element | Array<Element> */ get() = definedExternally; set(value) = definedExternally
    var containment: Any? get() = definedExternally; set(value) = definedExternally
    var cursor: String? get() = definedExternally; set(value) = definedExternally
    var cursorAt: Any? get() = definedExternally; set(value) = definedExternally
    var delay: Number? get() = definedExternally; set(value) = definedExternally
    var distance: Number? get() = definedExternally; set(value) = definedExternally
    var grid: Array<Number>? get() = definedExternally; set(value) = definedExternally
    var handle: Any? get() = definedExternally; set(value) = definedExternally
    var helper: Any? get() = definedExternally; set(value) = definedExternally
    var iframeFix: Any? get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
    var refreshPositions: Boolean? get() = definedExternally; set(value) = definedExternally
    var revert: Any? get() = definedExternally; set(value) = definedExternally
    var revertDuration: Number? get() = definedExternally; set(value) = definedExternally
    var scope: String? get() = definedExternally; set(value) = definedExternally
    var scroll: Boolean? get() = definedExternally; set(value) = definedExternally
    var scrollSensitivity: Number? get() = definedExternally; set(value) = definedExternally
    var scrollSpeed: Number? get() = definedExternally; set(value) = definedExternally
    var snap: Any? get() = definedExternally; set(value) = definedExternally
    var snapMode: String? get() = definedExternally; set(value) = definedExternally
    var snapTolerance: Number? get() = definedExternally; set(value) = definedExternally
    var stack: String? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}
external interface DraggableEvents {
    var create: DraggableEvent? get() = definedExternally; set(value) = definedExternally
    var start: DraggableEvent? get() = definedExternally; set(value) = definedExternally
    var drag: DraggableEvent? get() = definedExternally; set(value) = definedExternally
    var stop: DraggableEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Draggable : Widget, DraggableOptions,
    DraggableEvent
external interface DroppableEventUIParam {
    var draggable: JQuery
    var helper: JQuery
    var position: `T$1`
    var offset: `T$1`
}
external interface DroppableEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: DroppableEventUIParam)
}
external interface DroppableOptions : DroppableEvents {
    var accept: Any? get() = definedExternally; set(value) = definedExternally
    var activeClass: String? get() = definedExternally; set(value) = definedExternally
    var addClasses: Boolean? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var greedy: Boolean? get() = definedExternally; set(value) = definedExternally
    var hoverClass: String? get() = definedExternally; set(value) = definedExternally
    var scope: String? get() = definedExternally; set(value) = definedExternally
    var tolerance: String? get() = definedExternally; set(value) = definedExternally
}
external interface DroppableEvents {
    var create: DroppableEvent? get() = definedExternally; set(value) = definedExternally
    var activate: DroppableEvent? get() = definedExternally; set(value) = definedExternally
    var deactivate: DroppableEvent? get() = definedExternally; set(value) = definedExternally
    var over: DroppableEvent? get() = definedExternally; set(value) = definedExternally
    var out: DroppableEvent? get() = definedExternally; set(value) = definedExternally
    var drop: DroppableEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Droppable : Widget, DroppableOptions
external interface MenuOptions : MenuEvents {
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var icons: Any? get() = definedExternally; set(value) = definedExternally
    var menus: String? get() = definedExternally; set(value) = definedExternally
    var position: Any? get() = definedExternally; set(value) = definedExternally
    var role: String? get() = definedExternally; set(value) = definedExternally
}
external interface MenuUIParams {
    var item: JQuery? get() = definedExternally; set(value) = definedExternally
}
external interface MenuEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: MenuUIParams)
}
external interface MenuEvents {
    var blur: MenuEvent? get() = definedExternally; set(value) = definedExternally
    var create: MenuEvent? get() = definedExternally; set(value) = definedExternally
    var focus: MenuEvent? get() = definedExternally; set(value) = definedExternally
    var select: MenuEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Menu : Widget, MenuOptions
external interface ProgressbarOptions : ProgressbarEvents {
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var value: dynamic /* Number | Boolean */ get() = definedExternally; set(value) = definedExternally
    var max: Number? get() = definedExternally; set(value) = definedExternally
}
external interface ProgressbarUIParams
external interface ProgressbarEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: ProgressbarUIParams)
}
external interface ProgressbarEvents {
    var change: ProgressbarEvent? get() = definedExternally; set(value) = definedExternally
    var complete: ProgressbarEvent? get() = definedExternally; set(value) = definedExternally
    var create: ProgressbarEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Progressbar : Widget, ProgressbarOptions
external interface ResizableOptions : ResizableEvents {
    var alsoResize: Any? get() = definedExternally; set(value) = definedExternally
    var animate: Boolean? get() = definedExternally; set(value) = definedExternally
    var animateDuration: Any? get() = definedExternally; set(value) = definedExternally
    var animateEasing: String? get() = definedExternally; set(value) = definedExternally
    var aspectRatio: Any? get() = definedExternally; set(value) = definedExternally
    var autoHide: Boolean? get() = definedExternally; set(value) = definedExternally
    var cancel: String? get() = definedExternally; set(value) = definedExternally
    var containment: Any? get() = definedExternally; set(value) = definedExternally
    var delay: Number? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var distance: Number? get() = definedExternally; set(value) = definedExternally
    var ghost: Boolean? get() = definedExternally; set(value) = definedExternally
    var grid: Any? get() = definedExternally; set(value) = definedExternally
    var handles: Any? get() = definedExternally; set(value) = definedExternally
    var helper: String? get() = definedExternally; set(value) = definedExternally
    var maxHeight: Number? get() = definedExternally; set(value) = definedExternally
    var maxWidth: Number? get() = definedExternally; set(value) = definedExternally
    var minHeight: Number? get() = definedExternally; set(value) = definedExternally
    var minWidth: Number? get() = definedExternally; set(value) = definedExternally
}
external interface ResizableUIParams {
    var element: JQuery
    var helper: JQuery
    var originalElement: JQuery
    var originalPosition: Any
    var originalSize: Any
    var position: Any
    var size: Any
}
external interface ResizableEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: ResizableUIParams)
}
external interface ResizableEvents {
    var resize: ResizableEvent? get() = definedExternally; set(value) = definedExternally
    var start: ResizableEvent? get() = definedExternally; set(value) = definedExternally
    var stop: ResizableEvent? get() = definedExternally; set(value) = definedExternally
    var create: ResizableEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Resizable : Widget, ResizableOptions
external interface SelectableOptions : SelectableEvents {
    var autoRefresh: Boolean? get() = definedExternally; set(value) = definedExternally
    var cancel: String? get() = definedExternally; set(value) = definedExternally
    var delay: Number? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var distance: Number? get() = definedExternally; set(value) = definedExternally
    var filter: String? get() = definedExternally; set(value) = definedExternally
    var tolerance: String? get() = definedExternally; set(value) = definedExternally
}
external interface `T$2` {
    var selected: Element? get() = definedExternally; set(value) = definedExternally
}
external interface `T$3` {
    var selecting: Element? get() = definedExternally; set(value) = definedExternally
}
external interface `T$4` {
    var unselected: Element
}
external interface `T$5` {
    var unselecting: Element
}
external interface SelectableEvents {
    val selected: ((event: Event, ui: `T$2`) -> Unit)? get() = definedExternally
    val selecting: ((event: Event, ui: `T$3`) -> Unit)? get() = definedExternally
    val start: ((event: Event, ui: Any) -> Unit)? get() = definedExternally
    val stop: ((event: Event, ui: Any) -> Unit)? get() = definedExternally
    val unselected: ((event: Event, ui: `T$4`) -> Unit)? get() = definedExternally
    val unselecting: ((event: Event, ui: `T$5`) -> Unit)? get() = definedExternally
}
external interface Selectable : Widget, SelectableOptions
external interface SelectMenuOptions : SelectMenuEvents {
    var appendTo: String? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var icons: Any? get() = definedExternally; set(value) = definedExternally
    var position: JQueryPositionOptions? get() = definedExternally; set(value) = definedExternally
    var width: Number? get() = definedExternally; set(value) = definedExternally
}
external interface SelectMenuUIParams {
    var item: JQuery? get() = definedExternally; set(value) = definedExternally
}
external interface SelectMenuEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: SelectMenuUIParams)
}
external interface SelectMenuEvents {
    var change: SelectMenuEvent? get() = definedExternally; set(value) = definedExternally
    var close: SelectMenuEvent? get() = definedExternally; set(value) = definedExternally
    var create: SelectMenuEvent? get() = definedExternally; set(value) = definedExternally
    var focus: SelectMenuEvent? get() = definedExternally; set(value) = definedExternally
    var open: SelectMenuEvent? get() = definedExternally; set(value) = definedExternally
    var select: SelectMenuEvent? get() = definedExternally; set(value) = definedExternally
}
external interface SelectMenu : Widget, SelectMenuOptions
external interface SliderOptions : SliderEvents {
    var animate: Any? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var max: Number? get() = definedExternally; set(value) = definedExternally
    var min: Number? get() = definedExternally; set(value) = definedExternally
    var orientation: String? get() = definedExternally; set(value) = definedExternally
    var range: Any? get() = definedExternally; set(value) = definedExternally
    var step: Number? get() = definedExternally; set(value) = definedExternally
    var value: Number? get() = definedExternally; set(value) = definedExternally
    var values: Array<Number>? get() = definedExternally; set(value) = definedExternally
    var highlight: Boolean? get() = definedExternally; set(value) = definedExternally
    var classes: SliderClasses? get() = definedExternally; set(value) = definedExternally
}
external interface SliderClasses
external interface SliderUIParams {
    var handle: JQuery? get() = definedExternally; set(value) = definedExternally
    var value: Number? get() = definedExternally; set(value) = definedExternally
    var values: Array<Number>? get() = definedExternally; set(value) = definedExternally
}
external interface SliderEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: SliderUIParams)
}
external interface SliderEvents {
    var change: SliderEvent? get() = definedExternally; set(value) = definedExternally
    var create: SliderEvent? get() = definedExternally; set(value) = definedExternally
    var slide: SliderEvent? get() = definedExternally; set(value) = definedExternally
    var start: SliderEvent? get() = definedExternally; set(value) = definedExternally
    var stop: SliderEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Slider : Widget, SliderOptions
external interface SortableOptions : SortableEvents {
    var appendTo: Any? get() = definedExternally; set(value) = definedExternally
    var attribute: String? get() = definedExternally; set(value) = definedExternally
    var axis: String? get() = definedExternally; set(value) = definedExternally
    var cancel: Any? get() = definedExternally; set(value) = definedExternally
    var connectWith: Any? get() = definedExternally; set(value) = definedExternally
    var containment: Any? get() = definedExternally; set(value) = definedExternally
    var cursor: String? get() = definedExternally; set(value) = definedExternally
    var cursorAt: Any? get() = definedExternally; set(value) = definedExternally
    var delay: Number? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var distance: Number? get() = definedExternally; set(value) = definedExternally
    var dropOnEmpty: Boolean? get() = definedExternally; set(value) = definedExternally
    var forceHelperSize: Boolean? get() = definedExternally; set(value) = definedExternally
    var forcePlaceholderSize: Boolean? get() = definedExternally; set(value) = definedExternally
    var grid: Array<Number>? get() = definedExternally; set(value) = definedExternally
    var helper: dynamic /* String | (event: Event, element: Sortable) -> Element */ get() = definedExternally; set(value) = definedExternally
    var handle: Any? get() = definedExternally; set(value) = definedExternally
    var items: Any? get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
    var placeholder: String? get() = definedExternally; set(value) = definedExternally
    var revert: Any? get() = definedExternally; set(value) = definedExternally
    var scroll: Boolean? get() = definedExternally; set(value) = definedExternally
    var scrollSensitivity: Number? get() = definedExternally; set(value) = definedExternally
    var scrollSpeed: Number? get() = definedExternally; set(value) = definedExternally
    var tolerance: String? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}
external interface SortableUIParams {
    var helper: JQuery
    var item: JQuery
    var offset: Any
    var position: Any
    var originalPosition: Any
    var sender: JQuery
    var placeholder: JQuery
}
external interface SortableEvent {
    @nativeInvoke
    operator fun invoke(event: JQueryEventObject, ui: SortableUIParams)
}
external interface SortableEvents {
    var activate: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var beforeStop: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var change: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var deactivate: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var out: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var over: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var receive: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var remove: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var sort: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var start: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var stop: SortableEvent? get() = definedExternally; set(value) = definedExternally
    var update: SortableEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Sortable : Widget, SortableOptions,
    SortableEvents
external interface SpinnerOptions : SpinnerEvents {
    var culture: String? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var icons: Any? get() = definedExternally; set(value) = definedExternally
    var incremental: Any? get() = definedExternally; set(value) = definedExternally
    var max: Any? get() = definedExternally; set(value) = definedExternally
    var min: Any? get() = definedExternally; set(value) = definedExternally
    var numberFormat: String? get() = definedExternally; set(value) = definedExternally
    var page: Number? get() = definedExternally; set(value) = definedExternally
    var step: Any? get() = definedExternally; set(value) = definedExternally
}
external interface SpinnerUIParam {
    var value: Number
}
external interface SpinnerEvent<T> {
    @nativeInvoke
    operator fun invoke(event: Event, ui: T)
}
external interface SpinnerEvents {
    var change: SpinnerEvent<Any>? get() = definedExternally; set(value) = definedExternally
    var create: SpinnerEvent<Any>? get() = definedExternally; set(value) = definedExternally
    var spin: SpinnerEvent<SpinnerUIParam>? get() = definedExternally; set(value) = definedExternally
    var start: SpinnerEvent<Any>? get() = definedExternally; set(value) = definedExternally
    var stop: SpinnerEvent<Any>? get() = definedExternally; set(value) = definedExternally
}
external interface Spinner : Widget, SpinnerOptions
external interface TabsOptions : TabsEvents {
    var active: Any? get() = definedExternally; set(value) = definedExternally
    var classes: TabClasses? get() = definedExternally; set(value) = definedExternally
    var collapsible: Boolean? get() = definedExternally; set(value) = definedExternally
    var disabled: Any? get() = definedExternally; set(value) = definedExternally
    var event: String? get() = definedExternally; set(value) = definedExternally
    var heightStyle: String? get() = definedExternally; set(value) = definedExternally
    var hide: Any? get() = definedExternally; set(value) = definedExternally
    var show: Any? get() = definedExternally; set(value) = definedExternally
}
external interface TabClasses
external interface TabsActivationUIParams {
    var newTab: JQuery
    var oldTab: JQuery
    var newPanel: JQuery
    var oldPanel: JQuery
}
external interface TabsBeforeLoadUIParams {
    var tab: JQuery
    var panel: JQuery
    var jqXHR: JQueryXHR
    var ajaxSettings: Any
}
external interface TabsCreateOrLoadUIParams {
    var tab: JQuery
    var panel: JQuery
}
external interface TabsEvent<UI> {
    @nativeInvoke
    operator fun invoke(event: Event, ui: UI)
}
external interface TabsEvents {
    var activate: TabsEvent<TabsActivationUIParams>? get() = definedExternally; set(value) = definedExternally
    var beforeActivate: TabsEvent<TabsActivationUIParams>? get() = definedExternally; set(value) = definedExternally
    var beforeLoad: TabsEvent<TabsBeforeLoadUIParams>? get() = definedExternally; set(value) = definedExternally
    var load: TabsEvent<TabsCreateOrLoadUIParams>? get() = definedExternally; set(value) = definedExternally
    var create: TabsEvent<TabsCreateOrLoadUIParams>? get() = definedExternally; set(value) = definedExternally
}
external interface Tabs : Widget, TabsOptions
external interface TooltipOptions : TooltipEvents {
    var content: Any? get() = definedExternally; set(value) = definedExternally
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var hide: Any? get() = definedExternally; set(value) = definedExternally
    var items: String? get() = definedExternally; set(value) = definedExternally
    var position: Any? get() = definedExternally; set(value) = definedExternally
    var show: Any? get() = definedExternally; set(value) = definedExternally
    var tooltipClass: String? get() = definedExternally; set(value) = definedExternally
    var track: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface TooltipUIParams
external interface TooltipEvent {
    @nativeInvoke
    operator fun invoke(event: Event, ui: TooltipUIParams)
}
external interface TooltipEvents {
    var close: TooltipEvent? get() = definedExternally; set(value) = definedExternally
    var open: TooltipEvent? get() = definedExternally; set(value) = definedExternally
}
external interface Tooltip : Widget, TooltipOptions
external interface EffectOptions {
    var effect: String
    var easing: String? get() = definedExternally; set(value) = definedExternally
    var duration: Number? get() = definedExternally; set(value) = definedExternally
    var complete: Function<*>
}
external interface BlindEffect {
    var direction: String? get() = definedExternally; set(value) = definedExternally
}
external interface BounceEffect {
    var distance: Number? get() = definedExternally; set(value) = definedExternally
    var times: Number? get() = definedExternally; set(value) = definedExternally
}
external interface ClipEffect {
    var direction: Number? get() = definedExternally; set(value) = definedExternally
}
external interface DropEffect {
    var direction: Number? get() = definedExternally; set(value) = definedExternally
}
external interface ExplodeEffect {
    var pieces: Number? get() = definedExternally; set(value) = definedExternally
}
external interface FadeEffect
external interface FoldEffect {
    var size: Any? get() = definedExternally; set(value) = definedExternally
    var horizFirst: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface HighlightEffect {
    var color: String? get() = definedExternally; set(value) = definedExternally
}
external interface PuffEffect {
    var percent: Number? get() = definedExternally; set(value) = definedExternally
}
external interface PulsateEffect {
    var times: Number? get() = definedExternally; set(value) = definedExternally
}
external interface ScaleEffect {
    var direction: String? get() = definedExternally; set(value) = definedExternally
    var origin: Array<String>? get() = definedExternally; set(value) = definedExternally
    var percent: Number? get() = definedExternally; set(value) = definedExternally
    var scale: String? get() = definedExternally; set(value) = definedExternally
}
external interface ShakeEffect {
    var direction: String? get() = definedExternally; set(value) = definedExternally
    var distance: Number? get() = definedExternally; set(value) = definedExternally
    var times: Number? get() = definedExternally; set(value) = definedExternally
}
external interface SizeEffect {
    var to: Any? get() = definedExternally; set(value) = definedExternally
    var origin: Array<String>? get() = definedExternally; set(value) = definedExternally
    var scale: String? get() = definedExternally; set(value) = definedExternally
}
external interface SlideEffect {
    var direction: String? get() = definedExternally; set(value) = definedExternally
    var distance: Number? get() = definedExternally; set(value) = definedExternally
}
external interface TransferEffect {
    var className: String? get() = definedExternally; set(value) = definedExternally
    var to: String? get() = definedExternally; set(value) = definedExternally
}
external interface JQueryPositionOptions {
    var my: String? get() = definedExternally; set(value) = definedExternally
    var at: String? get() = definedExternally; set(value) = definedExternally
    var of: Any? get() = definedExternally; set(value) = definedExternally
    var collision: String? get() = definedExternally; set(value) = definedExternally
    var using: Function<*>? get() = definedExternally; set(value) = definedExternally
    var within: Any? get() = definedExternally; set(value) = definedExternally
}
external interface MouseOptions {
    var cancel: String? get() = definedExternally; set(value) = definedExternally
    var delay: Number? get() = definedExternally; set(value) = definedExternally
    var distance: Number? get() = definedExternally; set(value) = definedExternally
}
external interface KeyCode {
    var BACKSPACE: Number
    var COMMA: Number
    var DELETE: Number
    var DOWN: Number
    var END: Number
    var ENTER: Number
    var ESCAPE: Number
    var HOME: Number
    var LEFT: Number
    var NUMPAD_ADD: Number
    var NUMPAD_DECIMAL: Number
    var NUMPAD_DIVIDE: Number
    var NUMPAD_ENTER: Number
    var NUMPAD_MULTIPLY: Number
    var NUMPAD_SUBTRACT: Number
    var PAGE_DOWN: Number
    var PAGE_UP: Number
    var PERIOD: Number
    var RIGHT: Number
    var SPACE: Number
    var TAB: Number
    var UP: Number
}
external interface UI {
    fun mouse(method: String): JQuery
    fun mouse(options: MouseOptions): JQuery
    fun mouse(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    fun mouse(optionLiteral: String, optionValue: Any): Any
    var accordion: Accordion
    var autocomplete: Autocomplete
    var button: Button
    var buttonset: Button
    var datepicker: Datepicker
    var dialog: Dialog
    var keyCode: KeyCode
    var menu: Menu
    var progressbar: Progressbar
    var selectmenu: SelectMenu
    var slider: Slider
    var spinner: Spinner
    var tabs: Tabs
    var tooltip: Tooltip
    var version: String
}
external interface WidgetOptions {
    var disabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var hide: Any? get() = definedExternally; set(value) = definedExternally
    var show: Any? get() = definedExternally; set(value) = definedExternally
}
external interface WidgetCommonProperties {
    var element: JQuery
    var defaultElement: String
    var document: Document
    var namespace: String
    var uuid: String
    var widgetEventPrefix: String
    var widgetFullName: String
    var window: Window
}
external interface Widget {
    @nativeInvoke
    operator fun invoke(methodName: String): JQuery
    @nativeInvoke
    operator fun invoke(options: WidgetOptions): JQuery
    @nativeInvoke
    operator fun invoke(options: AccordionOptions): JQuery
    @nativeInvoke
    operator fun invoke(optionLiteral: String, optionName: String): Any
    @nativeInvoke
    operator fun invoke(optionLiteral: String, options: WidgetOptions): Any
    @nativeInvoke
    operator fun invoke(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    @nativeInvoke
    operator fun <T> invoke(name: String, prototype: T /* T & ThisType<T /* T & WidgetCommonProperties */> */): JQuery
    @nativeInvoke
    operator fun <T> invoke(name: String, base: Function<*>, prototype: T /* T & ThisType<T /* T & WidgetCommonProperties */> */): JQuery
}

external interface `T$6` {
    @nativeInvoke
    operator fun invoke(): JQuery
    @nativeInvoke
    operator fun invoke(methodName: String /* "blur" */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "collapse" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "collapseAll" */, event: JQueryEventObject? = definedExternally /* null */, all: Boolean? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "destroy" */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "disable" */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "enable" */)
    @nativeInvoke
    operator fun invoke(methodName: String, event: JQueryEventObject, item: JQuery)
    @nativeInvoke
    operator fun invoke(methodName: String /* "focus" */, event: JQueryEventObject, item: JQuery)
    @nativeInvoke
    operator fun invoke(methodName: String /* "isFirstItem" */): Boolean
    @nativeInvoke
    operator fun invoke(methodName: String /* "isLastItem" */): Boolean
    @nativeInvoke
    operator fun invoke(methodName: String /* "next" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "nextPage" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "previous" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "previousPage" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "refresh" */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "select" */, event: JQueryEventObject? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(methodName: String /* "widget" */): JQuery
    @nativeInvoke
    operator fun invoke(methodName: String): JQuery
    @nativeInvoke
    operator fun invoke(options: MenuOptions): JQuery
    @nativeInvoke
    operator fun invoke(optionLiteral: String, optionName: String): Any
    @nativeInvoke
    operator fun invoke(optionLiteral: String, options: MenuOptions): Any
    @nativeInvoke
    operator fun invoke(optionLiteral: String, optionName: String, optionValue: Any): JQuery
    var active: Boolean
}
external interface `T$7` {
    var attribute: String? get() = definedExternally; set(value) = definedExternally
}
external interface `T$8` {
    var key: String? get() = definedExternally; set(value) = definedExternally
    var attribute: String? get() = definedExternally; set(value) = definedExternally
    var expression: RegExp? get() = definedExternally; set(value) = definedExternally
}

external interface JQueryEasingFunctions {
    var easeInQuad: JQueryEasingFunction
    var easeOutQuad: JQueryEasingFunction
    var easeInOutQuad: JQueryEasingFunction
    var easeInCubic: JQueryEasingFunction
    var easeOutCubic: JQueryEasingFunction
    var easeInOutCubic: JQueryEasingFunction
    var easeInQuart: JQueryEasingFunction
    var easeOutQuart: JQueryEasingFunction
    var easeInOutQuart: JQueryEasingFunction
    var easeInQuint: JQueryEasingFunction
    var easeOutQuint: JQueryEasingFunction
    var easeInOutQuint: JQueryEasingFunction
    var easeInExpo: JQueryEasingFunction
    var easeOutExpo: JQueryEasingFunction
    var easeInOutExpo: JQueryEasingFunction
    var easeInSine: JQueryEasingFunction
    var easeOutSine: JQueryEasingFunction
    var easeInOutSine: JQueryEasingFunction
    var easeInCirc: JQueryEasingFunction
    var easeOutCirc: JQueryEasingFunction
    var easeInOutCirc: JQueryEasingFunction
    var easeInElastic: JQueryEasingFunction
    var easeOutElastic: JQueryEasingFunction
    var easeInOutElastic: JQueryEasingFunction
    var easeInBack: JQueryEasingFunction
    var easeOutBack: JQueryEasingFunction
    var easeInOutBack: JQueryEasingFunction
    var easeInBounce: JQueryEasingFunction
    var easeOutBounce: JQueryEasingFunction
    var easeInOutBounce: JQueryEasingFunction
}

var SliderEvents.changeFunc: ((event: Event, ui: SliderUIParams) -> Unit)?
    get() = change?.let { it::invoke }
    set(value) { change = value?.let(::sliderEventFor) }
var SliderEvents.createFunc: ((event: Event, ui: SliderUIParams) -> Unit)?
    get() = create?.let { it::invoke }
    set(value) { create = value?.let(::sliderEventFor) }
var SliderEvents.slideFunc: ((event: Event, ui: SliderUIParams) -> Unit)?
    get() = slide?.let { it::invoke }
    set(value) { slide = value?.let(::sliderEventFor) }
var SliderEvents.startFunc: ((event: Event, ui: SliderUIParams) -> Unit)?
    get() = start?.let { it::invoke }
    set(value) { start = value?.let(::sliderEventFor) }
var SliderEvents.stopFunc: ((event: Event, ui: SliderUIParams) -> Unit)?
    get() = stop?.let { it::invoke }
    set(value) { stop = value?.let(::sliderEventFor) }

var DialogEvents.closeFunc: ((event: Event, ui: DialogUIParams) -> Unit)?
    get() = close?.let { it::invoke }
    set(value) { close = value?.let(::dialogEventFor) }

fun sliderEventFor(func: (event: Event, ui: SliderUIParams) -> Unit): SliderEvent =
    object : SliderEvent {
        override fun invoke(event: Event, ui: SliderUIParams) = func.invoke(event, ui)
    }

fun dialogEventFor(func: (event: Event, ui: DialogUIParams) -> Unit): DialogEvent =
    object: DialogEvent {
        override fun invoke(event: Event, ui: DialogUIParams) = func.invoke(event, ui)
    }