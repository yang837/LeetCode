package leetcode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {



    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int uniquePaths(int m, int n) {
        // dp[m - 1][n - 1]为m*n网格从左上角到右下角位置路径数
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        if (nums[0] == 0) {
            return false;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] - 1);
            if (i + dp[i] >= nums.length - 1) {
                return true;
            }
            if (dp[i] == 0) {
                return false;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length - 1;
            int mid;

            while (left <= right) {
                mid = (left + right) >> 1;
                if (target == matrix[i][mid]) {
                    return true;
                } else if (target > matrix[i][mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左侧有序
            if (nums[left] <= nums[mid]) {
                // 在左端
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右侧有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(new int[]{l, r});
            } else {
                res.get(i - 1)[1] = Math.max(res.get(i - 1)[1], r);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }

    public int[] searchRange(int[] nums, int target) {
        int first = search(nums, target, true);
        int second = search(nums, target, false) - 1;

        if (first <= second && nums[first] == target && nums[second] == target) {
            return new int[]{first, second};
        }

        return new int[]{-1, -1};
    }
    public int search(int[] nums, int target, boolean lower) {
        int res = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    // 快速排序
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }
    public int partition(int[] nums, int left, int right) {
        int pivotValue = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivotValue) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivotValue) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivotValue;
        return left;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> res = new PriorityQueue<>();
        for (int num : nums) {
            res.add(num);
            if (res.size() > k) {
                res.poll();
            }
        }
        return res.peek();
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet()) {
            priorityQueue.add(new int[]{key, map.get(key)});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }

    // 冒泡排序
    public void bubbleSort(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] - nums[j];
        nums[j] = nums[i] + nums[j];
        nums[i] = nums[j] - nums[i];
    }

    // 插入排序
    public void InsertSort(int[] nums) {
        int cur;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i];

            int j = i;
            while (j > 0 && nums[j - 1] > cur) {
                nums[j] = nums[j - 1];
                j--;
            }

            nums[j] = cur;
        }
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int row, int col, int cur, char[][] board, String word) {
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 ||
                board[row][col] != word.charAt(cur)) {
            return false;
        }

        if (cur == word.length() - 1) {
            return true;
        }

        char temp = board[row][col];

        board[row][col] = '.';

        boolean res = dfs(row + 1, col, cur + 1, board, word) ||
                dfs(row - 1, col, cur + 1, board, word) ||
                dfs(row, col + 1, cur + 1, board, word) ||
                dfs(row, col - 1, cur + 1, board, word);

        board[row][col] = temp;

        return res;
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }
    public void dfs(List<String> res, int left, int right, String curStr) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        if (left < 0) {
            return;
        }
        if (right < left) {
            return;
        }
        dfs(res, left - 1, right, curStr + "(");
        dfs(res, left, right - 1, curStr + ")");
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, res, new ArrayList<>(), nums);
        return res;
    }
    public void backtrack(int start, List<List<Integer>> res, List<Integer> path, int[] nums) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(i + 1, res, path, nums);
            path.remove(path.size() - 1);
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            dfs(res, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new LinkedList<>();
        }
        List<String> res = new LinkedList<>();
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        dfs(res, digits, tab, 0, "");
        return res;
    }
    public void dfs(List<String> res, String digits, char[][] tab, int depth, String path) {
        if (depth == digits.length()) {
            res.add(path);
            return;
        }
        char[] temp = tab[digits.charAt(path.length()) - '2'];
        for (char ch : temp) {
            dfs(res, digits, tab, depth + 1, path + ch);
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // 存在岛屿
                    res++;
                    // 寻找连着的岛屿，只算一个
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }
    public void dfs(char[][] grid, int i, int j) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if (i < 0 || j < 0 || i >=rowLen || j >= colLen || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        // 递归上下左右的岛屿
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public int kthSmallest(TreeNode root, int k) {
        int leftCount = count(root.left);

        if (leftCount < k - 1) {
            return kthSmallest(root.right, k - leftCount - 1);
        } else if (leftCount > k - 1) {
            return kthSmallest(root.left, k);
        } else {
            return root.val;
        }
    }
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                if (i != len - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        for (int i = 0; i < preorder.length; i++) {
            pre.add(preorder[i]);
            in.add(inorder[i]);
        }

        return build(pre, in);
    }

    public TreeNode build(List<Integer> preorder, List<Integer> inorder) {
        if (inorder.size() == 0) {
            return null;
        }

        int rootVal = preorder.remove(0);
        TreeNode root = new TreeNode(rootVal);

        int mid = inorder.indexOf(rootVal);

        root.left = build(preorder, inorder.subList(0, mid));
        root.right = build(preorder, inorder.subList(mid + 1, inorder.size()));

        return root;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;

        if (root == null) {
            return new ArrayList<>();
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    // 奇数层顺序返回
                    temp.add(node.val);
                } else {
                    // 偶数层逆序返回
                    temp.add(0, node.val);
                }
                // 子节点入队
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;
            res.add(temp);
        }

        return res;
    }

    // morris
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        TreeNode pre = null;

        while (root != null) {
            if (root.left != null) {
                pre = root.left;
                // 成环
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                } else {
                    ret.add(root.val);
                    pre.right = null;
                    root = root.right;
                }
            } else {
                ret.add(root.val);
                root = root.right;
            }
        }

        return ret;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddCur = head;
        ListNode evenCur = head.next;
        ListNode evenHead = evenCur;

        while (evenCur != null && evenCur.next != null) {
            oddCur.next = oddCur.next.next;
            evenCur.next = evenCur.next.next;

            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode r = ret;
        int carry  = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode s = new ListNode(sum % 10);
            r.next = s;
            r = s;

            carry = sum / 10;
        }
        r.next = null;
        return ret.next;
    }

    /**
     * 递增的三元子序列
     * @param nums 整数数组
     * @return t or f
     */
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 最长回文子串
     * 暴力解
     *
     * @param s 给定字符串
     * @return s最长回文子串
     */
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i < end - start) {
                    continue;
                }
                if (isPalindrome(s, i, j)) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * s子串是否为回文
     *
     * @param s     aaa
     * @param start 0
     * @param end   2
     * @return true || false
     */
    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 无重复字符的最长子串
     *
     * @param s 给定字符串
     * @return 长度
     */
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 存在重复，j从重复字符的下一个重新开始，但不能往回走
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            ret = Math.max(ret, i - j + 1);
        }
        return ret;
    }

    // 判断字串是否存在重复字符
    public boolean isRepeat(String s) {
        List<Character> ret = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!ret.contains(s.charAt(i))) {
                ret.add(s.charAt(i));
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 字母异位词分组
     * 将字母异位词组合在一起
     *
     * @param strs 字符串数组
     * @return 按任意顺序返回结果列表
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<String, List<String>> ret = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);

            if (!ret.containsKey(key)) {
                ret.put(key, new ArrayList<>());
            }
            // 将自己放进去
            ret.get(key).add(strs[i]);
        }

        return new ArrayList<>(ret.values());
    }

    /**
     * 矩阵置零
     * 一个元素为 0，将其所在行和列的所有元素都设为 0
     *
     * @param matrix m x n 的矩阵
     */
    public void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean col = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row = true;
                    }
                    if (j == 0) {
                        col = true;
                    }
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * 三数之和
     * 判断 nums 中是否存在三个元素 a，b，c，使得 a + b + c = 0
     *
     * @param nums 包含 n 个整数的数组 nums
     * @return 所有和为 0 且不重复的三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int l = i + 1;
            int r = len - 1;
            int sum;
            int t = -nums[i];
            while (l < r) {
                sum = nums[l] + nums[r];
                if (sum == t) {
                    ret.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < t) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ret;
    }

}