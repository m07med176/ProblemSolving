#include "connection.h"
#include <jni.h>
#include <vector>

std::vector<int> getConcatenation(const std::vector<int>& nums) {
    std::vector<int> ans;
    ans.reserve(nums.size() * 2);

    for (int num : nums) {
        ans.push_back(num); // first copy
    }
    for (int num : nums) {
        ans.push_back(num); // second copy
    }

    return ans;
}
