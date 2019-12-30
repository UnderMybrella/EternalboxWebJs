@file:Suppress("UNCHECKED_CAST")

import kotlin.js.Json

data class EternalboxAnalysis(
    val bars: Array<Bar>,
    val beats: Array<Beat>,
    val tatums: Array<Tatum>,
    val sections: Array<Section>,
    val segments: Array<Segment>,
    val duration: Double
) {
    constructor(json: Json) : this(
        (json["bars"] as Array<Json>).mapArray(::Bar),
        (json["beats"] as Array<Json>).mapArray(::Beat),
        (json["tatums"] as Array<Json>).mapArray(::Tatum),
        (json["sections"] as Array<Json>).mapArray(::Section),
        (json["segments"] as Array<Json>).mapArray(::Segment),
        (json["duration"] as Number).toDouble()
    )

    data class Bar(val start: Double, val duration: Double, val confidence: Double) {
        constructor(json: Json): this(
            (json["start"] as Number).toDouble(),
            (json["duration"] as Number).toDouble(),
            (json["confidence"] as Number).toDouble()
        )
    }
    data class Beat(val start: Double, val duration: Double, val confidence: Double) {
        constructor(json: Json): this(
            (json["start"] as Number).toDouble(),
            (json["duration"] as Number).toDouble(),
            (json["confidence"] as Number).toDouble()
        )
    }
    data class Tatum(val start: Double, val duration: Double, val confidence: Double) {
        constructor(json: Json): this(
            (json["start"] as Number).toDouble(),
            (json["duration"] as Number).toDouble(),
            (json["confidence"] as Number).toDouble()
        )
    }
    data class Section(
        val start: Double,
        val duration: Double,
        val confidence: Double,
        val loudness: Double,
        val tempo: Double,
        val tempoConfidence: Double,
        val key: Int,
        val keyConfidence: Double,
        val mode: Int,
        val modeConfidence: Double,
        val timeSignature: Int,
        val timeSignatureConfidence: Double
    ) {
        constructor(json: Json): this(
            (json["start"] as Number).toDouble(),
            (json["duration"] as Number).toDouble(),
            (json["confidence"] as Number).toDouble(),
            (json["loudness"] as Number).toDouble(),
            (json["tempo"] as Number).toDouble(),
            (json["tempo_confidence"] as Number).toDouble(),
            (json["key"] as Number).toInt(),
            (json["key_confidence"] as Number).toDouble(),
            (json["mode"] as Number).toInt(),
            (json["mode_confidence"] as Number).toDouble(),
            (json["time_signature"] as Number).toInt(),
            (json["time_signature_confidence"] as Number).toDouble()
        )
    }

    data class Segment(
        val start: Double,
        val duration: Double,
        val confidence: Double,
        val loudnessStart: Double,
        val loudnessMaxTime: Double,
        val loudnessMax: Double,
        val pitches: DoubleArray,
        val timbre: DoubleArray
    ) {
        constructor(json: Json): this(
            (json["start"] as Number).toDouble(),
            (json["duration"] as Number).toDouble(),
            (json["confidence"] as Number).toDouble(),
            (json["loudness_start"] as Number).toDouble(),
            (json["loudness_max_time"] as Number).toDouble(),
            (json["loudness_max"] as Number).toDouble(),
            (json["pitches"] as Array<Number>).toDoubleArray(),
            (json["timbre"] as Array<Number>).toDoubleArray()
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class.js != other::class.js) return false

        other as EternalboxAnalysis

        if (!bars.contentEquals(other.bars)) return false
        if (!beats.contentEquals(other.beats)) return false
        if (!tatums.contentEquals(other.tatums)) return false
        if (!sections.contentEquals(other.sections)) return false
        if (!segments.contentEquals(other.segments)) return false
        if (duration != other.duration) return false

        return true
    }

    override fun hashCode(): Int {
        var result = bars.contentHashCode()
        result = 31 * result + beats.contentHashCode()
        result = 31 * result + tatums.contentHashCode()
        result = 31 * result + sections.contentHashCode()
        result = 31 * result + segments.contentHashCode()
        result = 31 * result + duration.hashCode()
        return result
    }
}