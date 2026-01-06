package mohamed.arfa.problemsolving.complextiyReports

data class TestResult(
    val testName: String,
    val className: String,
    val executionTimeMs: Long,
    val executionTimeNs: Long,
    val status: String,
    val timestamp: String,
    val memoryUsed: Long
)

data class ComplexityMetric(
    val methodName: String,
    val timeComplexity: String,
    val spaceComplexity: String,
    val inputSize: Int,
    val executionTimeMs: Double,
    val memoryUsedKB: Long,
    val testCaseNumber: Int
)

data class SolutionStat(
    val name: String,
    val avgTime: Double,
    val complexity: String,
    val passedTests: Int,
    val metrics: List<ComplexityMetric>
)