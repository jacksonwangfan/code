package com.wf.code.架构算法;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

//无虚拟节点，容易出现数据倾斜
public class 一致性哈希 {
    //待添加入Hash环的服务器列表
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    //对应的虚拟节点的个数
    private Integer virtualServer;

    //存储真实节点的集合
    private List<Node> realServer;

    //存储虚拟节点的集合
    private SortedMap<Integer, Node> circle;

    public 一致性哈希(int virtualServer, List<Node> realServer, SortedMap<Integer, Node> circle) {
        this.virtualServer = virtualServer;
        this.realServer = realServer;
        this.circle = circle;
        for (String server : servers) {
            circle.put(getHash(server),new Node(server,server));
        }
    }


    //添加真实节点
    public void addServer(Node node) {
        if (node == null) {
            return;
        }
        circle.put(getHash(node.getIp()), node);
    }

    //删除真实节点
    public void deleteServer(Node node) {
        if (node == null || circle.containsKey(getHash(node.getIp()))) {
            return;
        }
        circle.remove(getHash(node.getIp()));
    }

    public Node getServer(String ip) {
        int hash = getHash(ip);
        if (circle.containsKey(hash)) {
            return circle.get(hash);
        }
        SortedMap<Integer, Node> integerNodeSortedMap = circle.tailMap(hash);
        int key = integerNodeSortedMap.isEmpty() ? circle.firstKey() : integerNodeSortedMap.firstKey();
        return circle.get(key);
    }

    public static void main(String[] args) {
        一致性哈希 一致性哈希 = new 一致性哈希(10, new ArrayList<>(), new TreeMap<>());
        Node server = 一致性哈希.getServer("192.168.1.1");
        Node server1 = 一致性哈希.getServer("192.168.1.2");
        Node server2 = 一致性哈希.getServer("192.148.1.1");
        Node server3 = 一致性哈希.getServer("192.167.4.1");

        System.out.println(server.getIp());
        System.out.println(server1.getIp());
        System.out.println(server2.getIp());
        System.out.println(server3.getIp());

    }


    //使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }


}

class Node {
    private String ip;
    private String name;

    public Node(String ip, String name) {
        this.ip = ip;
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setName(String name) {
        this.name = name;
    }
}
