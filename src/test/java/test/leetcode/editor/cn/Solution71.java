package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @since 2022/6/28
 */
public class Solution71 {
    @Test
    public void should_return_a_b_when_a_b_normal() {
        Assertions.assertEquals("/a/b", simplifyPath("/a/b/"));
    }

    @Test
    public void should_return_a_b_c_when_contain_point() {
        Assertions.assertEquals("/a/b/c", simplifyPath("/a/b/./c"));
    }

    @Test
    public void should_return_a_c_when_contain_two_point() {
        Assertions.assertEquals("/a/c", simplifyPath("/a/b/../c"));
    }

    @Test
    public void should_return_slash_when_is_root() {
        Assertions.assertEquals("/", simplifyPath("/a/b/../c/../.."));
    }

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        LinkedList<String> result = handlePath(split);
        if (result.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        result.forEach(s -> builder.append("/").append(s));
        return builder.toString();
    }

    private LinkedList<String> handlePath(String[] split) {
        LinkedList<String> result = new LinkedList<>();
        for (String s : split) {
            if ("".equals(s)) {
                continue;
            }
            if (".".equals(s)) {
                continue;
            }
            if ("..".equals(s)) {
                if (!result.isEmpty()) {
                    result.removeLast();
                }
            } else {
                result.add(s);
            }
        }
        return result;
    }
}