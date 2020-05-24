package test.oj;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @since 2020/5/11
 */
public class MainOj {

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());

        int nodeNum = cin.nextInt();
        int nonLeafNodeNum = cin.nextInt();
        int targetCapacity = cin.nextInt();

        int[] capacitys = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            capacitys[i] = cin.nextInt();
        }

        NonLeafNode[] nonLeafNodes = new NonLeafNode[nonLeafNodeNum];
        for (int i = 0; i < nonLeafNodeNum; i++) {
            int nodeId = cin.nextInt();
            int subNodeNum = cin.nextInt();
            nonLeafNodes[i] = new NonLeafNode(nodeId, subNodeNum);
            for (int j = 0; j < subNodeNum; j++) {
                nonLeafNodes[i].subNodeIds[j] = cin.nextInt();
            }
        }
        cin.close();

        String[] paths = getPathOfCapacity(capacitys, nonLeafNodes, targetCapacity);
        if (paths != null) {
            for (String path : paths) {
                System.out.println(path);
            }
        }
    }

    static class NonLeafNode {
        int nodeId;
        int[] subNodeIds;

        NonLeafNode(int nodeId, int subNodeNum) {
            this.nodeId = nodeId;
            this.subNodeIds = new int[subNodeNum];
        }
    }

    /**
     * 输入
     * 20 9 24
     * 10 2 4 3 5 10 2 18 9 7 2 2 1 3 12 1 8 6 2 2
     * 00 4 01 02 03 04
     * 02 1 05
     * 04 2 06 07
     * 03 3 11 12 13
     * 06 1 09
     * 07 2 08 10
     * 16 1 15
     * 13 3 14 16 17
     * 17 2 18 19
     *
     * 答案：
     * 10 5 2 7
     * 10 4 10
     * 10 3 3 6 2
     * 10 3 3 6 2
     */
    static String[] getPathOfCapacity(int[] capacitys, NonLeafNode[] nonLeafNodes, int targetCapacity) {
        Map<Integer, NonLeafNode> nonLeafNodeMap = new HashMap<>(nonLeafNodes.length);
        for (NonLeafNode nonLeafNode : nonLeafNodes) {
            nonLeafNodeMap.put(nonLeafNode.nodeId, nonLeafNode);
        }
        NonLeafNode root = nonLeafNodes[0];
        LinkedList<Integer> temp = new LinkedList();
        temp.add(root.nodeId);
        int target = targetCapacity - capacitys[root.nodeId];
        List<String> result = new ArrayList<>();

        NonLeafNode node = nonLeafNodes[0];
        NonLeafNode parent;
        int j = 0;
        LinkedList<Integer> tempJ = new LinkedList<>();
        while (j < node.subNodeIds.length) {
            int subNodeId = node.subNodeIds[j];
            // 如果为叶子节点
            if (!nonLeafNodeMap.containsKey(subNodeId)) {
                if (target == capacitys[subNodeId]) {
                    temp.addLast(subNodeId);
                    StringBuilder s = new StringBuilder();
                    for (int i = 0; i < temp.size(); i++) {
                        s.append(capacitys[temp.get(i)]).append(" ");
                    }
                    result.add(s.toString());
                    temp.removeLast();
                }
                tempJ.addLast(j);
                parent = getParent(nonLeafNodes, subNodeId);
                if (parent != null) {
                    node = parent;
                    if (tempJ.size() > 0) {
                        j = tempJ.removeLast();
                    }
                    j++;
                    while (node != null && node.subNodeIds.length <= j) {
                        node = getParent(nonLeafNodes, node.nodeId);
                        target += capacitys[temp.removeLast()];
                        if (tempJ.size() > 0) {
                            j = tempJ.removeLast();
                        }
                        j++;
                    }
                }
                continue;
            }

            // 非叶子节点
            if (target - capacitys[subNodeId] > 0) {
                temp.addLast(subNodeId);
                target = target - capacitys[subNodeId];
                node = nonLeafNodeMap.get(subNodeId);
                tempJ.addLast(j);
                j = 0;
            } else {
                j++;
            }
        }
        Collections.sort(result, (a,b)->{
            if (a.compareTo(b) > 0) {
                return -1;
            } else if (a.compareTo(b) == 0) {
                return 0;
            }
            return 1;
        });
        return result.toArray(new String[0]);
    }

    public static NonLeafNode getParent(NonLeafNode[] array, int id) {
        for (NonLeafNode nonLeafNode : array) {
            for (int subNodeId : nonLeafNode.subNodeIds) {
                if (id == subNodeId) {
                    return nonLeafNode;
                }
            }
        }
        return null;
    }
    /**
     * 题目描述
     * 现有一树形网络，每个结点是一个设备，每个设备具有一个设备编号和一个管理容量值。
     *
     * 你的任务是：找出从根节点到叶节点的管理容量之和等于给定数值的所有路径。
     *
     * 如下图，横线上的2位数是设备编号，横线下的为管理容量值。
     *
     *
     *
     * 解答要求
     * 时间限制: 1000ms, 内存限制: 256MB
     * 输入
     * 第一行分别为结点个数 N(<100)、非叶子结点的个数 M(<N)、给定的总管理容量 S(<2^30)；
     * 第二行按结点编号顺序给出 N 个结点的管理容量；
     * 随后 M 行，每行按以下格式给出：
     * ID K ID[1] ID[2] ... ID[K]
     * 其中 ID 是一个非叶结点的 2 位数编号，K 是其子结点的个数，后面K个数字是一系列子结点的编号。
     * 输入中出现的数值均为正整数。
     * 为简单起见，我们固定根结点的编号为 00。
     *
     * 输出
     * 找出所有管理容量之和为 S 的路径，并按非递增序输出。注：用例保证至少会有一条路径满足要求
     * 每条路径占一行，输出从根结点到叶结点每个结点的管理容量。数字间以一个空格分隔。
     * 行首尾不得有多余空格
     *
     * 样例
     * 输入样例1复制
     * 20 9 24
     * 10 2 4 3 5 10 2 18 9 7 2 2 1 3 12 1 8 6 2 2
     * 00 4 01 02 03 04
     * 02 1 05
     * 04 2 06 07
     * 03 3 11 12 13
     * 06 1 09
     * 07 2 08 10
     * 16 1 15
     * 13 3 14 16 17
     * 17 2 18 19
     * 输出样例1
     * 10 5 2 7
     * 10 4 10
     * 10 3 3 6 2
     * 10 3 3 6 2
     * 提示
     * 示例解释：
     * 合计有4条可以满足总容量为24的要求，按照非递增排序：
     * 1）10 5 2 7的5大于10 4 10的4所以排第一个；同理，10 4 10排第二个
     * 2）10 3 3 6 2最后的2是18号节点或19号节点，不分先后，但是两个都要输出。
     */

    /**
     * main入口由OJ平台调用
     */
    public static void main2(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        List<String> bitStream = new LinkedList<>();
        // while (cin.hasNext()) {
        //     bitStream.add(cin.next());
        // }
        String s = cin.nextLine();
        bitStream = Arrays.asList(s.split(" "));
        cin.close();

        System.out.println(parseTLV(bitStream));
    }

    /**
     * 题目描述
     * TLV 是一种简单实用的数据组织方案，包括三个部分：类型(T)、长度(L)和值(V)。
     * <p>
     * 某业务模块约定TLV规则如下：
     * <p>
     * 码流数据以字符串表达时，每字节用2位十六进制数字表达，其中a-f均小写，单个空格分隔
     * 码流数据中，类型(T)占 2 字节，长度(L)占 4 字节，后续为值(V)；类型与长度均为大端序
     * 例如某个码流数据，其字符串表达为 01 01 00 00 00 01 6f，其中：
     * <p>
     * 类型(T) 是 01 02，解析成数字 258
     * 长度(L) 是 00 00 00 01，解析成数字 1
     * 内容(V) 是 6f
     * 请解析包含单个 TLV 的字符串表达，按要求输出相关信息。
     * <p>
     * 解答要求
     * 时间限制: 1000ms, 内存限制: 256MB
     * 输入
     * 输入为单行字符串，包含若干单个空格分割的2位十六进数。如：
     * 00 01 00 00 00 01 6f：
     * <p>
     * 用例涉及数据码流字节长度范围为 [6, 300]，即包含最多300个2位十六进制数
     * 用例保证格式正确，无非法输入
     * 输出
     * 解码后输出成单行字符串，格式为 :
     * {T:<type>,L:<len>,V:<letter-cnt>}
     * 其中:
     *
     * <type> 为解析后的类型(T)，十进制
     * <len> 为解析后的长度(L)，十进制
     * <letter-cnt> 为合法内容(V)中，包含所有ascii码为英文字母的数量，忽略大小写。
     * 所谓合法内容，指解析长度(L)范围内的内容(V)，范围外的内容不参与字母统计；如果实际内容(V)长度不足，则<letter-cnt>输出为 -1
     * <p>
     * 样例
     * 输入样例1复制
     * 00 00 00 00 00 0a 68 65 6c 4c 6f 20 77 6f 72 64 64
     * 输出样例1
     * {T:0,L:10,V:9}
     * 输入样例2复制
     * 00 00 00 00 00 0a 68 65 6c 6c 6f 20 77 6f 72
     * 输出样例2
     * {T:0,L:10,V:-1}
     * 提示
     * 样例 1 中:
     * 长度为 10，内容为 “helLo wordd”，11个字符（如：字符’h’的ascii码为0x68，其他类推），忽略掉超出长度的字母’d’后，其合法内容为”helLo word”，其中英文字母个数为 9，所以V域输出9
     * 样例 2 中，长度为 10，内容为 “hello wor”，长度小于 10，非法，所以V域输出为 -1
     *
     * @param bitStream
     * @return
     */
    static String parseTLV(List<String> bitStream) {
        int bitSize = bitStream.size();
        if (bitSize < 2) {
            String s = "";
            for (int i = 0; i < bitStream.size(); i++) {
                s += bitStream.get(i);
            }
            int t = Integer.parseInt(s, 16);
            return "{T:" + t + ",L:0,V:-1}";
        }
        int t = Integer.parseInt(bitStream.get(0) + bitStream.get(1), 16);
        int len = Integer.parseInt(bitStream.get(2) + bitStream.get(3) + bitStream.get(4) + bitStream.get(5), 16);
        StringBuilder result = new StringBuilder("{T:").append(t).append(",L:").append(len).append(",V:");
        int v = 0;
        int size = len + 6;
        if (bitStream.size() < size) {
            v = -1;
            result.append(v).append("}");
            return result.toString();
        }

        for (int i = 6; i < size; i++) {
            int c = Integer.parseInt(bitStream.get(i), 16);
            System.out.printf("%c", c);
            if (c >= 0x41 && c <= 0x7a) {
                v++;
            }
        }
        System.out.println();
        result.append(v).append("}");
        return result.toString();
    }

    /**
     * 字符串转换成为16进制(无需Unicode编码)
     *
     * @param str
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main1(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int incompatibleNum = cin.nextInt();
        int containerNum = cin.nextInt();

        int[][] incompatibility = new int[incompatibleNum][];
        for (int i = 0; i < incompatibleNum; i++) {
            int cargoId1 = cin.nextInt();
            int cargoId2 = cin.nextInt();
            incompatibility[i] = new int[]{cargoId1, cargoId2};
        }

        List<Integer>[] containers = new List[containerNum];
        for (int i = 0; i < containerNum; i++) {
            int cargoNum = cin.nextInt();
            containers[i] = new ArrayList<>(cargoNum);
            for (int j = 0; j < cargoNum; j++) {
                containers[i].add(cin.nextInt());
            }
        }
        cin.close();

        boolean[] results = isSecure(incompatibility, containers);
        if (results != null) {
            for (boolean result : results) {
                System.out.println(result ? "Yes" : "No");
            }
        }
    }

    /**
     * 题目描述
     * 我们不能把不相容的货物装在同一集装箱里运输，如氧化剂绝对不能跟易燃液体同箱，否则很容易造成爆炸或其他危险。
     * 现给一张不相容物品的清单，及每一个集装箱货物运输清单。请你判断每个集装箱是否安全。
     * <p>
     * 解答要求
     * 时间限制: 1000ms, 内存限制: 256MB
     * 输入
     * 首行两个正整数：分别代表不相容货物对的数量N(0,10000]和集装箱货品清单的数量M(0,100]
     * 接下来输入N行，每一行是一对不相容货物编号；编号都是5位数，编号对之间是空格。
     * 然后输入M行，每一行包含一个集装箱货物总数[1,1000]与货物编号明细。
     * 输出
     * 对每箱货物清单，判断是否可以安全运输；按照输入顺序，安全则输出 Yes，否则输出 No，每行以换行结束
     * <p>
     * 样例
     * 输入样例1复制
     * 6 3
     * 20001 20002
     * 20003 20004
     * 20005 20006
     * 20003 20001
     * 20005 20004
     * 20004 20006
     * 4 00001 20004 00002 20003
     * 5 98823 20002 20003 20006 10010
     * 3 12345 67890 23333
     * 输出样例1
     * No
     * Yes
     * Yes
     * 提示
     * 样例1解释
     * 输入6对不相容物品，以及3个运输集装箱；
     * 不相容物品分别为：20001 20002、… 20004 20006，共6对；
     * 第1个集装箱中，装有4个货物，分别为00001、20004、00002、20003，其中货物20004和20003属于不相容物品，因此输出No并换行;
     * 第2个集装箱中，装有5个货物，不存在不相容货物，因此输出Yes并换行
     * 第3个集装箱中，装有3个货物，不存在不相容货物，输出Yes并换行
     * 说明
     * 输入会保证内容合法，包括如：不会输入自身和自身不相容。
     * 不相容物品对最大有10000，实现时需要考虑效率问题，另：性能用例占比低。
     */
    static boolean[] isSecure(int[][] incompatibility, List<Integer>[] containers) {
        // TODO 在此补充你的代码
        boolean[] result = new boolean[containers.length];
        Set con;
        int i = 0;
        for (List<Integer> container : containers) {
            con = new HashSet(container.size());
            con.addAll(container);
            result[i] = true;
            for (int[] ints : incompatibility) {
                if (con.contains(ints[0]) && con.contains(ints[1])) {
                    result[i] = false;
                    break;
                }
            }
            i++;
        }
        return result;
    }
}
