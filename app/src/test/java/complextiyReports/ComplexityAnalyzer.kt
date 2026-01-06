package mohamed.arfa.problemsolving.complextiyReports

import kotlin.system.measureNanoTime

class ComplexityAnalyzer {

    companion object {
        private val extension = ComplexityAnalysisExtension()
        private val testCaseCounters = mutableMapOf<String, Int>()
    }

    fun <T> analyzeComplexity(
        methodName: String,
        inputSize: Int,
        operation: () -> T
    ): Pair<T, Double> {
        val runtime = Runtime.getRuntime()
        System.gc()
        Thread.sleep(10)

        val memBefore = runtime.totalMemory() - runtime.freeMemory()

        var result: T? = null
        val executionTime = measureNanoTime {
            result = operation()
        }

        val memAfter = runtime.totalMemory() - runtime.freeMemory()
        val memUsed = (memAfter - memBefore) / 1024 // KB

        val detectedComplexity = estimateTimeComplexity(inputSize, executionTime / 1_000_000.0)

        val testCaseNumber = testCaseCounters.getOrPut(methodName) { 0 } + 1
        testCaseCounters[methodName] = testCaseNumber

        val metric = ComplexityMetric(
            methodName = methodName,
            timeComplexity = detectedComplexity,
            spaceComplexity = estimateSpaceComplexity(inputSize, memUsed),
            inputSize = inputSize,
            executionTimeMs = executionTime / 1_000_000.0,
            memoryUsedKB = memUsed,
            testCaseNumber = testCaseNumber
        )

        extension.addComplexityMetric(metric)

        return Pair(result!!, executionTime / 1_000_000.0)
    }

    private fun estimateTimeComplexity(inputSize: Int, timeMs: Double): String {
        if (inputSize == 0) return "O(1)"

        val timePerElement = timeMs / inputSize

        return when {
            timePerElement < 0.001 -> "O(1)"
            timePerElement < 0.01 -> "O(log n)"
            timePerElement < 0.1 -> "O(n)"
            timePerElement < 1.0 -> "O(n log n)"
            else -> "O(n²)"
        }
    }

    private fun estimateSpaceComplexity(inputSize: Int, memUsed: Long): String {
        if (inputSize == 0) return "O(1)"
        if (memUsed <= 100) return "O(1)"

        val ratio = memUsed.toDouble() / inputSize
        return when {
            ratio < 2 -> "O(1)"
            ratio < inputSize * 0.5 -> "O(n)"
            else -> "O(n²)"
        }
    }
}