package audiofilters

/**
 * N-Order IIR Filter Assumes inputs are normalized to [-1, 1]
 * Based on the difference equation from
 * <a href="https://en.wikipedia.org/wiki/Infinite_impulse_response">Infinite Impulse Response</a>.
 *
 * @param order The filter's order.
 * @throws IllegalArgumentException If order is zero or less.
 */
class IIRFilter(val order: Int) {

    private val coeffsA = DoubleArray(order + 1)
    private val coeffsB = DoubleArray(order + 1)

    private val historyX = DoubleArray(order)
    private val historyY = DoubleArray(order)

    init {
        if (order < 1) {
            throw IllegalArgumentException("order must be greater than zero")
        }


        // Sane defaults
        coeffsA[0] = 1.0
        coeffsB[0] = 1.0
    }

    /**
     * Set coefficients.
     *
     * @param aCoeffs Denominator coefficients.
     * @param bCoeffs Numerator coefficients.
     * @throws IllegalArgumentException if [aCoeffs] or [bCoeffs] is
     * not of size [order], or if `aCoeffs[0]` is 0.0.
     */
    @Throws(IllegalArgumentException::class)
    fun setCoeffs(aCoeffs: DoubleArray, bCoeffs: DoubleArray) {
        if (aCoeffs.size != order)
            throw IllegalArgumentException("aCoeffs must be of size $order, but got ${aCoeffs.size}")

        if (aCoeffs[0] == 0.0)
            throw IllegalArgumentException("aCoeffs.get(0) must not be zero")

        if (bCoeffs.size != order)
            throw IllegalArgumentException("bCoeffs must be of size $order, but got ${bCoeffs.size}")

        for (i in 0..order) {
            coeffsA[i] = aCoeffs[i]
            coeffsB[i] = bCoeffs[i]
        }
    }

    /**
     * Process a single sample
     *
     * @param sample the sample to process
     * @return the processed sample
     */
    fun process(sample: Double): Double {
        var result = 0.0


        // Process
        for (i in 1..order) {
            result += (coeffsB[i] * historyX[i - 1] - coeffsA[i] * historyY[i - 1])
        }
        result = (result + coeffsB[0] * sample) / coeffsA[0]


        // Feedback
        for (i in order - 1 downTo 1) {
            historyX[i] = historyX[i - 1]
            historyY[i] = historyY[i - 1]
        }

        historyX[0] = sample
        historyY[0] = result

        return result


    }

}