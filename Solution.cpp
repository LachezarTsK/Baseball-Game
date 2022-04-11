
#include <string>
#include <numeric>
#include <vector>
#include <array>
using namespace std;

class Solution {
    
public:
    
    int calPoints(vector<string>& operations) {

        const size_t MAX_NUMBER_OF_OPERATIONS = 1000;
        array<int, MAX_NUMBER_OF_OPERATIONS> scores{};
        int index = 0;

        for (const auto& operation : operations) {
            if (operation == "+") {
                scores[index] = scores[index - 1] + scores[index - 2];
            } else if (operation == "C") {
                scores[index - 1] = 0;
                index -= 2;
            } else if (operation == "D") {
                scores[index] = 2 * scores[index - 1];
            } else {
                scores[index] = stoi(operation);
            }
            ++index;
        }

        return accumulate(scores.begin(), scores.begin() + index, 0);
    }
};
