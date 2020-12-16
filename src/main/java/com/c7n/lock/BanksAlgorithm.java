package com.c7n.lock;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.map.MultiKeyMap;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * 银行家算法（Banker's Algorithm）是一个避免死锁（Deadlock）的著名算法，是由艾兹格·迪杰斯特拉在1965年为T.H.E系统设计的一种避免死锁产生的算法。
 * 它以银行借贷系统的分配策略为基础，判断并保证系统的安全运行。
 *
 * @author jialong.wang
 * @Date on 2020/12/15 3:30 PM
 * @since 1.0
 */
@Log4j2
public class BanksAlgorithm {

    static Process[] processes = new Process[5];
    static Resource[] resources = new Resource[4];

    static int[][] ALLOCATION_RESOURCES = {
            {0,0,3,2},
            {1,0,0,0},
            {1,3,5,4},
            {0,3,3,2},
            {0,0,1,4}
    };

    static int[][] MAX_RESOURCE_REQUIREMENT = {
            {0,0,4,4},
            {2,7,5,0},
            {3,6,10,10},
            {0,9,8,4},
            {0,6,6,10}
    };

    static Map<String, Integer> serialNoMap = new HashMap<>();

    static  {
        processes[0] = new Process("P1");
        processes[1] = new Process("P2");
        processes[2] = new Process("P3");
        processes[3] = new Process("P4");
        processes[4] = new Process("P5");

        serialNoMap.put("P1", 0);
        serialNoMap.put("P2", 1);
        serialNoMap.put("P3", 2);
        serialNoMap.put("P4", 3);
        serialNoMap.put("P5", 4);

        resources[0] = new Resource("A", 3);
        resources[1] = new Resource("B", 12);
        resources[2] = new Resource("C", 14);
        resources[3] = new Resource("D", 14);

        serialNoMap.put("A", 0);
        serialNoMap.put("B", 1);
        serialNoMap.put("C", 2);
        serialNoMap.put("D", 3);
    }

    public static void main(String[] args) {
        registerInitMaxResources();
        registerInitAllocationQuantity();

        int[][] processRequireResource = new int[5][4];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                // 进程还需要的资源数
                processRequireResource[i][j] = MAX_RESOURCE_REQUIREMENT[i][j] - ALLOCATION_RESOURCES[i][j];
            }
        }

        List<String> processSerials1 = Arrays.asList("P1", "P4", "P5", "P2", "P3");
        List<String> processSerials2 = Arrays.asList("P1", "P4", "P2", "P5", "P3");
        List<String> processSerials3 = Arrays.asList("P1", "P4", "P3", "P2", "P5");
        List<String> processSerials4 = Arrays.asList("P1", "P3", "P4", "P5", "P2");
        List<String> processSerials5 = Arrays.asList("P1", "P5", "P4", "P3", "P2");

        safeCheck(processSerials1, processRequireResource);
        safeCheck(processSerials2, processRequireResource);
        safeCheck(processSerials3, processRequireResource);
        safeCheck(processSerials4, processRequireResource);
        safeCheck(processSerials5, processRequireResource);

    }

    private static void registerInitAllocationQuantity() {
        for (int i = 0; i < ALLOCATION_RESOURCES.length; i++) {
            for (int j = 0; j < ALLOCATION_RESOURCES[i].length; j++) {
                AllocationResourceTable.registerAllocatedResource(processes[i], resources[j], ALLOCATION_RESOURCES[i][j]);
            }
        }
    }

    private static void registerInitMaxResources() {
        for (int i = 0; i < MAX_RESOURCE_REQUIREMENT.length; i++) {
            for (int j = 0; j < MAX_RESOURCE_REQUIREMENT[i].length; j++) {
                MaxResourceTable.registerMaxResource(processes[i], resources[j], MAX_RESOURCE_REQUIREMENT[i][j]);
            }
        }
    }

    /**
     * 判断资源获取请求是否是安全的。
     *
     * @param processSerial 请求执行序列，被检查项，是否是安全序列
     * @param processRequireResource 每个进程剩余需要请求的资源列表
     *
     * @return boolean 请求执行序列是否是安全的执行序列。
     */
    static boolean safeCheck(List<String> processSerial, int[][] processRequireResource) {
        log.info("安全检查: {}", processSerial);
        boolean safe = true;
        List<Process> processList = new ArrayList<>();
        for (String processName : processSerial) {
            processList.add(findProcessByName(processName));
        }

        Resource[] remainings = getRemainingResources(resources, ALLOCATION_RESOURCES);

        // 检查每个一进程按顺序是否符合资源需求。
        for (Process p : processList) {
            Integer pSer = serialNoMap.get(p.getUuid());

            for (Resource r : remainings) {
                Integer rSer = serialNoMap.get(r.getId());
                int remain = r.getQuantity().intValue();
                int requireNum = processRequireResource[pSer][rSer];
                log.info("检查进程[{}] 资源[{}, {}] 是否满足要求", p.getUuid(), remain, requireNum);

                if (remain < requireNum) {
                    log.info("执行序列【{}】不安全", processSerial);
                    safe = false;
                    break;
                } else {
                    r.setQuantity(remain + ALLOCATION_RESOURCES[pSer][rSer]);
                }
            }

            if (!safe) {
                break;
            } else {
            }
        }

        log.info("安全检查结果, {}", safe);
        return safe;
    }

    private static Resource[] getRemainingResources(Resource[] resources, int[][] allocationResources) {
        Resource[] results = new Resource[resources.length];
        for (int i = 0; i < resources.length; i++) {
            Resource r = resources[i];
            final Integer serial = serialNoMap.get(r.getId());

            int allocatedSum = 0;
            for (int j = 0; j < allocationResources.length; j++) {
                allocatedSum += allocationResources[j][serial];
            }

            results[i] = new Resource(r.getId(), r.getQuantity().intValue() - allocatedSum);
        }
        return results;
    }

    @Nonnull
    private static Process findProcessByName(String name) {
        for (Process p : processes) {
            if (p.getUuid().equals(name)) {
                return p;
            }
        }
        throw new RuntimeException("未找到Process：" + name);
    }
}

/**
 * 需求最大资源表
 */
class MaxResourceTable {

    /**
     * [process, resource] => Max Resource Requirement
     */
    private static MultiKeyMap MAX_RESOURCE_MATRIX = new MultiKeyMap();

    public static void registerMaxResource(Process process, Resource resource, Integer max) {
        MAX_RESOURCE_MATRIX.put(process, resource, max);
    }
}

class AllocationResourceTable {

    /**
     * [process, resource] => allocated resource
     */
    private static MultiKeyMap ALLOCATED_RESOURCE_MATRIX = new MultiKeyMap();

    public static void registerAllocatedResource(Process process, Resource resource, Integer allocatedQty) {
        ALLOCATED_RESOURCE_MATRIX.put(process, resource, allocatedQty);
    }

}

@Data
class Process {

    private static int autoGenerated = 1;

    private int id = autoGenerated++;

    private String uuid = UUID.randomUUID().toString();

    private Map<Resource, Integer> resourcesRequired = new HashMap<>();

    public Process(String uuid) {
        this.uuid = uuid;
    }
}