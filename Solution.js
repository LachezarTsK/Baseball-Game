
/**
 * @param {string[]} operations
 * @return {number}
 */
var calPoints = function (operations) {

    const MAX_NUMBER_OF_OPERATIONS = 1000;
    const scores = new Array(MAX_NUMBER_OF_OPERATIONS);
    let index = 0;

    for (let operation of operations) {
        if (operation === "+") {
            scores[index] = scores[index - 1] + scores[index - 2];
        } else if (operation === "C") {
            scores[index - 1] = 0;
            index -= 2;
        } else if (operation === "D") {
            scores[index] = 2 * scores[index - 1];
        } else {
            scores[index] = Number(operation);
        }
        ++index;
    }
    scores.splice(index);
    return scores.reduce((x, y) => x + y);
};
