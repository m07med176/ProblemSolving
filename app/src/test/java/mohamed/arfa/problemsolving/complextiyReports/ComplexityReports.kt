package mohamed.arfa.problemsolving.complextiyReports

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ComplexityReports(
    val testResults: MutableList<TestResult>,
    val complexityMetrics: MutableMap<String, MutableList<ComplexityMetric>>
) {
    fun generateReport() {
        val reportDir = File("build/reports/custom-test-reports")
        reportDir.mkdirs()

        val reportFile = File(reportDir, "test-analysis-${System.currentTimeMillis()}.html")
        val htmlReport = generateHtmlReport(testResults, complexityMetrics)

        reportFile.writeText(htmlReport)
        println("\n✅ Custom report generated: ${reportFile.absolutePath}")

        // Also generate JSON report
        val jsonFile = File(reportDir, "test-analysis-${System.currentTimeMillis()}.json")
        jsonFile.writeText(generateJsonReport(testResults, complexityMetrics))
    }

    private fun generateJsonReport(
        results: List<TestResult>,
        metrics: Map<String, MutableList<ComplexityMetric>>
    ): String {
        return """
{
  "summary": {
    "total": ${results.size},
    "passed": ${results.count { it.status == "PASSED" }},
    "failed": ${results.count { it.status == "FAILED" }},
    "totalTimeMs": ${results.sumOf { it.executionTimeMs }},
    "totalSolutions": ${metrics.size}
  },
  "tests": [
    ${results.joinToString(",\n    ") { result ->
            """
    {
      "name": "${result.testName}",
      "class": "${result.className}",
      "status": "${result.status}",
      "executionTimeMs": ${result.executionTimeMs},
      "memoryUsedKB": ${result.memoryUsed},
      "timestamp": "${result.timestamp}"
    }
        """.trimIndent()
        }}
  ],
  "solutions": [
    ${metrics.entries.joinToString(",\n    ") { (method, metricsList) ->
            """
    {
      "name": "$method",
      "passedTests": ${metricsList.size},
      "avgTimeMs": ${metricsList.map { it.executionTimeMs }.average()},
      "timeComplexity": "${metricsList.firstOrNull()?.timeComplexity ?: "Unknown"}",
      "spaceComplexity": "${metricsList.firstOrNull()?.spaceComplexity ?: "Unknown"}",
      "testCases": [
        ${metricsList.joinToString(",\n        ") { metric ->
                """
        {
          "inputSize": ${metric.inputSize},
          "executionTimeMs": ${metric.executionTimeMs},
          "memoryUsedKB": ${metric.memoryUsedKB}
        }
            """.trimIndent()
            }}
      ]
    }
        """.trimIndent()
        }}
  ]
}
        """.trimIndent()
    }

    private fun generateHtmlReport(
        results: List<TestResult>,
        metrics: Map<String, MutableList<ComplexityMetric>>
    ): String {
        val passed = results.count { it.status == "PASSED" }
        val failed = results.count { it.status == "FAILED" }
        val totalTime = results.sumOf { it.executionTimeMs }

        // Calculate solution statistics
        val solutionStats = metrics.map { (method, metricsList) ->
            val avgTime = metricsList.map { it.executionTimeMs }.average()
            val complexity = metricsList.firstOrNull()?.timeComplexity ?: "Unknown"
            val passedTests = metricsList.size
            SolutionStat(method, avgTime, complexity, passedTests, metricsList)
        }.sortedBy { it.avgTime }

        val bestSolution = solutionStats.firstOrNull()

        return """
<!DOCTYPE html>
<html>
<head>
    <title>Test Analysis Report</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js"></script>
    <style>
        * { box-sizing: border-box; }
        body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif; margin: 0; background: #f5f7fa; }
        .container { max-width: 1400px; margin: 0 auto; padding: 20px; }
        h1 { color: #2c3e50; border-bottom: 4px solid #3498db; padding-bottom: 15px; margin-bottom: 30px; font-size: 2.5em; }
        h2 { color: #34495e; margin-top: 40px; font-size: 1.8em; border-left: 5px solid #3498db; padding-left: 15px; }
        .summary { display: grid; grid-template-columns: repeat(auto-fit, minmax(200px, 1fr)); gap: 20px; margin: 30px 0; }
        .card { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 25px; border-radius: 12px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); transition: transform 0.2s; }
        .card:hover { transform: translateY(-5px); box-shadow: 0 6px 12px rgba(0,0,0,0.15); }
        .card.green { background: linear-gradient(135deg, #11998e 0%, #38ef7d 100%); }
        .card.red { background: linear-gradient(135deg, #eb3349 0%, #f45c43 100%); }
        .card.blue { background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%); }
        .card h3 { margin: 0 0 10px 0; font-size: 14px; opacity: 0.9; text-transform: uppercase; letter-spacing: 1px; }
        .card .value { font-size: 36px; font-weight: bold; }
        .solution-section { background: white; padding: 30px; margin: 30px 0; border-radius: 12px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        .solution-header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; border-bottom: 2px solid #ecf0f1; padding-bottom: 15px; }
        .solution-header h3 { margin: 0; color: #2c3e50; font-size: 1.5em; }
        .complexity-badges { display: flex; gap: 10px; flex-wrap: wrap; }
        .complexity { display: inline-block; padding: 8px 16px; border-radius: 20px; font-size: 14px; font-weight: 600; }
        .o-1 { background: #2ecc71; color: white; }
        .o-logn { background: #27ae60; color: white; }
        .o-n { background: #f39c12; color: white; }
        .o-nlogn { background: #e67e22; color: white; }
        .o-n2 { background: #e74c3c; color: white; }
        .stats-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(150px, 1fr)); gap: 15px; margin: 20px 0; }
        .stat-box { background: #ecf0f1; padding: 15px; border-radius: 8px; text-align: center; }
        .stat-box .label { font-size: 12px; color: #7f8c8d; text-transform: uppercase; margin-bottom: 5px; }
        .stat-box .value { font-size: 24px; font-weight: bold; color: #2c3e50; }
        .chart-container { position: relative; height: 300px; margin: 20px 0; }
        .best-solution { background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%); color: white; padding: 30px; border-radius: 12px; margin: 30px 0; box-shadow: 0 4px 12px rgba(0,0,0,0.2); }
        .best-solution h2 { color: white; border-left-color: white; margin-top: 0; }
        .best-solution .reason { font-size: 16px; line-height: 1.6; margin-top: 15px; }
        table { width: 100%; border-collapse: collapse; margin: 20px 0; background: white; }
        th, td { padding: 12px 15px; text-align: left; border-bottom: 1px solid #ecf0f1; }
        th { background: #34495e; color: white; font-weight: 600; text-transform: uppercase; font-size: 12px; letter-spacing: 0.5px; }
        tr:hover { background: #f8f9fa; }
        .badge { display: inline-block; padding: 4px 10px; border-radius: 12px; font-size: 11px; font-weight: 600; }
        .badge.passed { background: #d4edda; color: #155724; }
        .badge.failed { background: #f8d7da; color: #721c24; }
        .trophy { font-size: 40px; margin-bottom: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>&#128202; Test Analysis Report</h1>
        <p style="color: #7f8c8d; font-size: 14px;">Generated: ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy 'at' HH:mm:ss"))}</p>
        
        <div class="summary">
            <div class="card green">
                <h3>Passed Tests</h3>
                <div class="value">$passed</div>
            </div>
            <div class="card red">
                <h3>Failed Tests</h3>
                <div class="value">$failed</div>
            </div>
            <div class="card blue">
                <h3>Total Solutions</h3>
                <div class="value">${metrics.size}</div>
            </div>
            <div class="card">
                <h3>Total Time</h3>
                <div class="value">${totalTime}ms</div>
            </div>
        </div>
        
        ${if (bestSolution != null) """
        <div class="best-solution">
            <div class="trophy"> &#x1F3C6; </div>
            <h2>Best Solution: ${bestSolution.name}</h2>
            <div class="reason">
                <strong>Why it's the best:</strong><br>
                &bull; Fastest average execution time: <strong>${String.format("%.3f", bestSolution.avgTime)}ms</strong><br>
                &bull; Time Complexity: <strong>${formatComplexity(bestSolution.complexity)}</strong><br>
                &bull; All ${bestSolution.passedTests} test cases passed<br>
                &bull; ${getBestSolutionReason(bestSolution, solutionStats)}
            </div>
        </div>
        """ else ""}
        
        <h2>Solution Comparison</h2>
        ${generateSolutionComparison(solutionStats)}
        
        <h2>Detailed Analysis by Solution</h2>
        ${solutionStats.mapIndexed { index, stat ->
            generateSolutionSection(stat, index + 1, solutionStats.size)
        }.joinToString("\n")}
        
        <h2>All Test Results</h2>
        <table>
            <thead>
                <tr>
                    <th>Test Name</th>
                    <th>Class</th>
                    <th>Status</th>
                    <th>Time (ms)</th>
                    <th>Memory (KB)</th>
                </tr>
            </thead>
            <tbody>
                ${results.joinToString("\n") { result ->
            """
                <tr>
                    <td>${result.testName}</td>
                    <td>${result.className}</td>
                    <td><span class="badge ${result.status.lowercase()}">${result.status}</span></td>
                    <td>${result.executionTimeMs}</td>
                    <td>${result.memoryUsed}</td>
                </tr>
                    """.trimIndent()
        }}
            </tbody>
        </table>
    </div>
</body>
</html>
        """.trimIndent()
    }

    private fun getBestSolutionReason(best: SolutionStat, all: List<SolutionStat>): String {
        if (all.size == 1) return "Only solution tested"

        val secondBest = all.getOrNull(1)
        if (secondBest != null) {
            val improvement = ((secondBest.avgTime - best.avgTime) / secondBest.avgTime * 100)
            return String.format("%.1f%% faster than the next best solution", improvement)
        }
        return "Optimal performance across all test cases"
    }

    private fun generateSolutionComparison(stats: List<SolutionStat>): String {
        val chartId = "comparisonChart_${System.currentTimeMillis()}"
        val labels = stats.map { "\"${it.name}\"" }.joinToString(",")
        val data = stats.map { String.format("%.3f", it.avgTime) }.joinToString(",")
        val colors = stats.mapIndexed { index, _ ->
            when (index) {
                0 -> "'rgba(46, 204, 113, 0.8)'" // Green for best
                stats.size - 1 -> "'rgba(231, 76, 60, 0.8)'" // Red for worst
                else -> "'rgba(52, 152, 219, 0.8)'" // Blue for middle
            }
        }.joinToString(",")

        return """
        <div class="chart-container">
            <canvas id="$chartId"></canvas>
        </div>
        <script>
            new Chart(document.getElementById('$chartId'), {
                type: 'bar',
                data: {
                    labels: [$labels],
                    datasets: [{
                        label: 'Average Execution Time (ms)',
                        data: [$data],
                        backgroundColor: [$colors],
                        borderColor: [$colors],
                        borderWidth: 2
                    }]
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: false,
                    plugins: {
                        legend: { display: false },
                        title: {
                            display: true,
                            text: 'Performance Comparison - Lower is Better',
                            font: { size: 16, weight: 'bold' }
                        }
                    },
                    scales: {
                        y: {
                            beginAtZero: true,
                            title: { display: true, text: 'Time (ms)' }
                        }
                    }
                }
            });
        </script>
        """.trimIndent()
    }

    private fun generateSolutionSection(stat: SolutionStat, rank: Int, total: Int): String {
        val chartId = "chart_${stat.name.replace(" ", "_")}_${System.currentTimeMillis()}"
        val inputSizes = stat.metrics.map { it.inputSize }.joinToString(",")
        val times = stat.metrics.joinToString(",") { String.format("%.3f", it.executionTimeMs) }

        return """
        <div class="solution-section">
            <div class="solution-header">
                <h3>&#x2705; ${stat.name}</h3>
                <div class="complexity-badges">
                    <span class="complexity ${getComplexityClass(stat.complexity)}">${formatComplexity(stat.complexity)}</span>
                    <span class="complexity ${getComplexityClass(stat.metrics.firstOrNull()?.spaceComplexity ?: "")}">${formatComplexity(stat.metrics.firstOrNull()?.spaceComplexity ?: "")}</span>
                </div>
            </div>
            
            <div class="stats-grid">
                <div class="stat-box">
                    <div class="label">Passed Tests</div>
                    <div class="value">${stat.passedTests}</div>
                </div>
                <div class="stat-box">
                    <div class="label">Avg Time</div>
                    <div class="value">${String.format("%.3f", stat.avgTime)}ms</div>
                </div>
                <div class="stat-box">
                    <div class="label">Min Time</div>
                    <div class="value">${String.format("%.3f", stat.metrics.minOf { it.executionTimeMs })}ms</div>
                </div>
                <div class="stat-box">
                    <div class="label">Max Time</div>
                    <div class="value">${String.format("%.3f", stat.metrics.maxOf { it.executionTimeMs })}ms</div>
                </div>
                <div class="stat-box">
                    <div class="label">Rank</div>
                    <div class="value">$rank/$total</div>
                </div>
            </div>
            
            <div class="chart-container">
                <canvas id="$chartId"></canvas>
            </div>
            <script>
                new Chart(document.getElementById('$chartId'), {
                    type: 'line',
                    data: {
                        labels: [$inputSizes],
                        datasets: [{
                            label: 'Execution Time (ms)',
                            data: [$times],
                            borderColor: 'rgba(102, 126, 234, 1)',
                            backgroundColor: 'rgba(102, 126, 234, 0.1)',
                            borderWidth: 3,
                            fill: true,
                            tension: 0.4,
                            pointRadius: 5,
                            pointHoverRadius: 7
                        }]
                    },
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        plugins: {
                            legend: { display: false },
                            title: {
                                display: true,
                                text: 'Complexity Analysis: ${formatComplexity(stat.complexity)}',
                                font: { size: 14, weight: 'bold' }
                            }
                        },
                        scales: {
                            x: { title: { display: true, text: 'Input Size (n)' } },
                            y: { 
                                beginAtZero: true,
                                title: { display: true, text: 'Time (ms)' }
                            }
                        }
                    }
                });
            </script>
            
            <table>
                <thead>
                    <tr>
                        <th>Test Case</th>
                        <th>Input Size</th>
                        <th>Execution Time</th>
                        <th>Memory Used</th>
                    </tr>
                </thead>
                <tbody>
                    ${stat.metrics.joinToString("\n") { metric ->
            """
                    <tr>
                        <td>Case ${metric.testCaseNumber}</td>
                        <td>${metric.inputSize}</td>
                        <td>${String.format("%.3f", metric.executionTimeMs)}ms</td>
                        <td>${metric.memoryUsedKB} KB</td>
                    </tr>
                        """.trimIndent()
        }}
                </tbody>
            </table>
        </div>
        """.trimIndent()
    }

    private fun getComplexityClass(complexity: String): String {
        return when {
            complexity.contains("O(1)") -> "o-1"
            complexity.contains("log n") && !complexity.contains("n log n") -> "o-logn"
            complexity.contains("n log n") -> "o-nlogn"
            complexity.contains("n²") || complexity.contains("n^2") -> "o-n2"
            complexity.contains("O(n)") -> "o-n"
            else -> "o-n"
        }
    }

    private fun formatComplexity(complexity: String): String {
        return complexity
            .replace("O(1)", "O(1)")
            .replace("O(n)", "O(n)")
            .replace("O(n²)", "O(n&sup2;)")
            .replace("O(n^2)", "O(n&sup2;)")
            .replace("O(log n)", "O(log n)")
            .replace("O(n log n)", "O(n log n)")
    }
}