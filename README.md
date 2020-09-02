# Algorithm-LeetCode
LeetCode算法题整理



## 题目归类：

### 图：

* #133. 克隆图：考察图遍历（深度优先/广度优先）
* #733. 图像渲染：DFS
* #529.扫雷游戏：DFS
  * 0~9int转char：(char)(i+'0')
  * HashMap与HashSet根据对象的HashCode判断是否相等，所以如果存入两个值相等的对象，不一定会起到去重的效果
* #332. 重新安排行程：欧拉图
* #841. 钥匙和房间：图遍历



### 树：

* #226. 翻转二叉树：DFS
* #110. 平衡二叉树
* #104. 二叉树的最大深度：分而治之思想
* #111. 二叉树的最小深度：同上



### 位运算：

* #461. 汉明距离：计算二进制串中1的个数（内置计数器、移位、布赖恩·克尼根算法）

* #136. 只出现一次的数字：考察异或运算符($a\oplus a = 0$, $a \oplus 0 = 0$, $(a \oplus b)\oplus c$, $a\oplus(b\oplus c)$)

* #201. 数字范围按位与（移位、布赖恩·克尼根算法）

  * 布赖恩·克尼根算法（Brian Kernighan）：清除二进制数最右边的1：n = n & (n-1);

  



### 递归：

* #167. 合并二叉树

* #104. 二叉树的最大深度：分而治之思想

* #111. 二叉树的最小深度

* #109. 有序链表转换二叉搜索树：分治，快慢指针，中序遍历

  * BST中序遍历的结果与有序链表一致，所以可以先构建树，再使用中序遍历进行快速填充

  * 使用快慢指针可以在不破坏链表结构的情形下，找到链表的中间元素

  * 对于一个确定不再改变的链表，可以将链表转化成ArrayList，这样只需要对链表遍历一次，之后所有的访问都可以一步到位

    ==但是这么做，速度貌似不如快慢指针（我猜用例比较少，无法显示这种方法的优势）==



### 数学：

* #43. 字符串乘法：模拟竖式，实现大数相乘



### 栈：

* #20. 有效的括号



### 动态规划：

* #546. 移动盒子：难，有空研究研究



### 链表：

* #206. 反转链表：递归（栈）、迭代
* #2. 两数相加
* #160. 相交链表



### 字符串：

* #647. 回文子串：递归
* #459. 重复的子字符串
* #657. 机器人能否回到原点
* #214. 最短回文串：字符串哈希
* #557. 反转字符串中的单词 III



### 回溯：

* #679. 24点游戏
* #17. 电话号码的字母组合



### 数组：

* #283. 移动0: 将所有的0移动到末尾，不改变原有非0数的顺序
  * 遍历数组，直接用非0数对原数组进行覆盖，用计数器记录非0数个数，然后统一将后面的元素改为0
* #448. 找到所有数组中消失的数字
  * 遍历数组，将遍历所得的值对应位置的值标记为其相反数，最后将所有正数记录下来，即为消失的数
* #491. 递增子序列：DFS，穷举



### 自动机：

* 剑指Offer-20

