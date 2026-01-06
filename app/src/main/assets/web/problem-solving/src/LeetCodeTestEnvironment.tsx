import './index.css'
import { StrictMode } from 'react'
import React, { useState } from 'react';
import { createRoot } from 'react-dom/client'
import { Play, CheckCircle, XCircle, Clock, Code } from 'lucide-react';

const LeetCodeTestEnvironment = () => {
  const [activeTab, setActiveTab] = useState('js');
  const [testResults, setTestResults] = useState(null);
  const [isRunning, setIsRunning] = useState(false);

  // Test cases for the problem
  const testCases = [
    { input: [8, 1, 2, 2, 3], expected: [4, 0, 1, 1, 3] },
    { input: [6, 5, 4, 8], expected: [2, 1, 0, 3] },
    { input: [7, 7, 7, 7], expected: [0, 0, 0, 0] },
    { input: [0, 0], expected: [0, 0] },
    { input: [5, 0, 10, 0, 10, 6], expected: [2, 0, 4, 0, 4, 3] },
    { input: [1, 2, 3, 4, 5], expected: [0, 1, 2, 3, 4] },
    { input: [5, 4, 3, 2, 1], expected: [4, 3, 2, 1, 0] },
    { input: [100, 0, 50], expected: [2, 0, 1] }
  ];

  // JavaScript Solutions
  const jsSolutions = {
    solution0: {
      name: "Solution 0: Two Loops - O(n²)",
      code: `function smallerNumbersThanCurrent(nums) {
  const result = [];
  for (let i = 0; i < nums.length; i++) {
    let count = 0;
    for (let j = 0; j < nums.length; j++) {
      if (j !== i && nums[j] < nums[i]) {
        count++;
      }
    }
    result.push(count);
  }
  return result;
}`,
      func: function(nums) {
        const result = [];
        for (let i = 0; i < nums.length; i++) {
          let count = 0;
          for (let j = 0; j < nums.length; j++) {
            if (j !== i && nums[j] < nums[i]) {
              count++;
            }
          }
          result.push(count);
        }
        return result;
      }
    },
    solution1: {
      name: "Solution 1: Sorting - O(n log n)",
      code: `function smallerNumbersThanCurrent(nums) {
  const sorted = [...nums].sort((a, b) => a - b);
  const map = new Map();

  for (let i = 0; i < sorted.length; i++) {
    if (!map.has(sorted[i])) {
      map.set(sorted[i], i);
    }
  }

  return nums.map(num => map.get(num));
}`,
      func: function(nums) {
        const sorted = [...nums].sort((a, b) => a - b);
        const map = new Map();

        for (let i = 0; i < sorted.length; i++) {
          if (!map.has(sorted[i])) {
            map.set(sorted[i], i);
          }
        }

        return nums.map(num => map.get(num));
      }
    }
  };

  // TypeScript Solutions
  const tsSolutions = {
    solution0: {
      name: "Solution 0: Two Loops - O(n²)",
      code: `function smallerNumbersThanCurrent(nums: number[]): number[] {
  const result: number[] = [];
  for (let i = 0; i < nums.length; i++) {
    let count = 0;
    for (let j = 0; j < nums.length; j++) {
      if (j !== i && nums[j] < nums[i]) {
        count++;
      }
    }
    result.push(count);
  }
  return result;
}`,
      func: function(nums) {
        const result = [];
        for (let i = 0; i < nums.length; i++) {
          let count = 0;
          for (let j = 0; j < nums.length; j++) {
            if (j !== i && nums[j] < nums[i]) {
              count++;
            }
          }
          result.push(count);
        }
        return result;
      }
    },
    solution1: {
      name: "Solution 1: Sorting - O(n log n)",
      code: `function smallerNumbersThanCurrent(nums: number[]): number[] {
  const sorted = [...nums].sort((a, b) => a - b);
  const map = new Map<number, number>();

  for (let i = 0; i < sorted.length; i++) {
    if (!map.has(sorted[i])) {
      map.set(sorted[i], i);
    }
  }

  return nums.map(num => map.get(num)!);
}`,
      func: function(nums) {
        const sorted = [...nums].sort((a, b) => a - b);
        const map = new Map();

        for (let i = 0; i < sorted.length; i++) {
          if (!map.has(sorted[i])) {
            map.set(sorted[i], i);
          }
        }

        return nums.map(num => map.get(num));
      }
    }
  };

  const arraysEqual = (a, b) => {
    if (a.length !== b.length) return false;
    for (let i = 0; i < a.length; i++) {
      if (a[i] !== b[i]) return false;
    }
    return true;
  };

  const runTests = () => {
    setIsRunning(true);
    const solutions = activeTab === 'js' ? jsSolutions : tsSolutions;
    const results = [];

    Object.entries(solutions).forEach(([key, solution]) => {
      testCases.forEach((testCase, index) => {
        const startTime = performance.now();
        try {
          const result = solution.func([...testCase.input]);
          const endTime = performance.now();
          const passed = arraysEqual(result, testCase.expected);

          results.push({
            solutionName: solution.name,
            testCase: index + 1,
            input: testCase.input,
            expected: testCase.expected,
            actual: result,
            passed,
            time: (endTime - startTime).toFixed(3)
          });
        } catch (error) {
          results.push({
            solutionName: solution.name,
            testCase: index + 1,
            input: testCase.input,
            expected: testCase.expected,
            actual: null,
            passed: false,
            error: error.message,
            time: 0
          });
        }
      });
    });

    setTimeout(() => {
      setTestResults(results);
      setIsRunning(false);
    }, 500);
  };

  const getStatusIcon = (passed) => {
    return passed ? (
      <CheckCircle className="w-5 h-5 text-green-500" />
    ) : (
      <XCircle className="w-5 h-5 text-red-500" />
    );
  };

  const solutions = activeTab === 'js' ? jsSolutions : tsSolutions;

  return (
    <div className="min-h-screen bg-gray-50 p-6">
      <div className="max-w-7xl mx-auto">
        {/* Header */}
        <div className="bg-white rounded-lg shadow-md p-6 mb-6">
          <h1 className="text-3xl font-bold text-gray-800 mb-2">
            How Many Numbers Are Smaller Than the Current Number
          </h1>
          <p className="text-gray-600 mb-4">
            Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
          </p>
          <div className="bg-blue-50 border-l-4 border-blue-500 p-4 mb-4">
            <h3 className="font-semibold text-blue-900 mb-2">Problem Description:</h3>
            <p className="text-blue-800 text-sm">
              For each nums[i] you have to count the number of valid j's such that j != i and nums[j] &lt; nums[i].
            </p>
          </div>
          <div className="text-sm text-gray-500">
            <strong>Constraints:</strong> 2 ≤ nums.length ≤ 500, 0 ≤ nums[i] ≤ 100
          </div>
        </div>

        {/* Language Tabs */}
        <div className="bg-white rounded-lg shadow-md mb-6">
          <div className="flex border-b">
            <button
              onClick={() => setActiveTab('js')}
              className={`flex-1 py-3 px-6 font-semibold transition-colors ${
                activeTab === 'js'
                  ? 'bg-yellow-50 text-yellow-700 border-b-2 border-yellow-500'
                  : 'text-gray-600 hover:bg-gray-50'
              }`}
            >
              <Code className="inline w-5 h-5 mr-2" />
              JavaScript
            </button>
            <button
              onClick={() => setActiveTab('ts')}
              className={`flex-1 py-3 px-6 font-semibold transition-colors ${
                activeTab === 'ts'
                  ? 'bg-blue-50 text-blue-700 border-b-2 border-blue-500'
                  : 'text-gray-600 hover:bg-gray-50'
              }`}
            >
              <Code className="inline w-5 h-5 mr-2" />
              TypeScript
            </button>
          </div>

          {/* Solutions Display */}
          <div className="p-6">
            {Object.entries(solutions).map(([key, solution]) => (
              <div key={key} className="mb-6">
                <h3 className="text-lg font-semibold text-gray-800 mb-3">
                  {solution.name}
                </h3>
                <pre className="bg-gray-900 text-gray-100 p-4 rounded-lg overflow-x-auto text-sm">
                  <code>{solution.code}</code>
                </pre>
              </div>
            ))}
          </div>
        </div>

        {/* Run Tests Button */}
        <div className="mb-6">
          <button
            onClick={runTests}
            disabled={isRunning}
            className="w-full bg-green-600 hover:bg-green-700 disabled:bg-gray-400 text-white font-semibold py-4 px-6 rounded-lg shadow-md transition-colors flex items-center justify-center"
          >
            <Play className="w-5 h-5 mr-2" />
            {isRunning ? 'Running Tests...' : 'Run All Tests'}
          </button>
        </div>

        {/* Test Results */}
        {testResults && (
          <div className="bg-white rounded-lg shadow-md p-6">
            <h2 className="text-2xl font-bold text-gray-800 mb-4">Test Results</h2>

            {/* Summary */}
            <div className="bg-gray-50 rounded-lg p-4 mb-6">
              <div className="flex justify-between items-center">
                <span className="text-lg font-semibold">
                  Passed: {testResults.filter(r => r.passed).length} / {testResults.length}
                </span>
                <span className="text-sm text-gray-600">
                  {activeTab === 'js' ? 'JavaScript' : 'TypeScript'} Solutions
                </span>
              </div>
            </div>

            {/* Tree View */}
            <div className="space-y-2">
              <div className="font-mono text-sm">
                <div className="text-gray-600 mb-2">└─ root</div>
                <div className="ml-4 text-gray-600 mb-2">
                  └─ SmallerNumbersThanCurrent
                </div>
                <div className="ml-8 text-gray-600 mb-2">
                  └─ testAllSolutions
                </div>

                {Object.keys(solutions).map((solutionKey) => {
                  const solutionResults = testResults.filter(
                    r => r.solutionName === solutions[solutionKey].name
                  );

                  return (
                    <div key={solutionKey} className="ml-12 mb-4">
                      {solutionResults.map((result, idx) => (
                        <div
                          key={idx}
                          className="flex items-start mb-2 hover:bg-gray-50 p-2 rounded"
                        >
                          <span className="mr-2">└─</span>
                          {getStatusIcon(result.passed)}
                          <div className="ml-2 flex-1">
                            <div className="flex items-center gap-2">
                              <span className={result.passed ? 'text-green-700' : 'text-red-700'}>
                                {result.solutionName}: Test Case {result.testCase}
                              </span>
                              <span className="text-xs text-gray-500 flex items-center">
                                <Clock className="w-3 h-3 mr-1" />
                                {result.time}ms
                              </span>
                            </div>
                            <div className="text-xs text-gray-600 mt-1">
                              <div>Input: [{result.input.join(', ')}]</div>
                              <div>Expected: [{result.expected.join(', ')}]</div>
                              {!result.passed && result.actual && (
                                <div className="text-red-600">
                                  Actual: [{result.actual.join(', ')}]
                                </div>
                              )}
                              {result.error && (
                                <div className="text-red-600">Error: {result.error}</div>
                              )}
                            </div>
                          </div>
                        </div>
                      ))}
                    </div>
                  );
                })}
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default LeetCodeTestEnvironment;
