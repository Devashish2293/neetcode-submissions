class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtrack(result, current, 0, 0, n);
        return result;
    }

    public void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
        // Base case: used all pairs
        if (open == n && close == n) {
            result.add(current.toString());
            return;
        }

        // Add '(' if we haven't used all opening brackets
        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }

        // Add ')' if closing won't exceed openings
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}