package mohamed.arfa.problemsolving.complextiyReports

import org.junit.jupiter.api.extension.*
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ComplexityAnalysisExtension : BeforeEachCallback, AfterEachCallback, AfterAllCallback {

    companion object {
        private val testResults = mutableListOf<TestResult>()
        private val complexityMetrics = mutableMapOf<String, MutableList<ComplexityMetric>>()
    }

    override fun beforeEach(context: ExtensionContext) {
        // Force garbage collection before test
        System.gc()
        Thread.sleep(10)
    }

    override fun afterEach(context: ExtensionContext) {
        val runtime = Runtime.getRuntime()
        val usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / 1024 // KB

        val testName = context.displayName
        val className = context.testClass.map { it.simpleName }.orElse("Unknown")
        val executionTime = context.getStore(ExtensionContext.Namespace.GLOBAL)
            .get("executionTime", Long::class.java) ?: 0L

        val result = TestResult(
            testName = testName,
            className = className,
            executionTimeMs = executionTime,
            executionTimeNs = executionTime * 1_000_000,
            status = if (context.executionException.isPresent) "FAILED" else "PASSED",
            timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
            memoryUsed = usedMemory
        )

        testResults.add(result)
    }

    override fun afterAll(context: ExtensionContext) {
        val reports = ComplexityReports(
            testResults = testResults,
            complexityMetrics = complexityMetrics
        )
        reports.generateReport()
    }

    fun addComplexityMetric(metric: ComplexityMetric) {
        complexityMetrics.getOrPut(metric.methodName) { mutableListOf() }.add(metric)
    }
}