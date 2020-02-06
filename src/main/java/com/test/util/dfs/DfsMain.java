package com.test.util.dfs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author nanzhang
 * @date 2020/2/4
 */
public class DfsMain {

    static class Location {
        Location(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        Integer x;
        Integer y;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            ;
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Location location = (Location) o;
            return Objects.equals(x, location.x) &&
                    Objects.equals(y, location.y);
        }

        @Override
        public int hashCode() {
            return SIZE * x + SIZE * SIZE * y;
        }
    }

    static class State {

        State(Integer[][] status, Location location) {
            this.status = status;
            this.location = location;
        }

        Integer[][] status;
        Location location;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return arrayEqual(status, state.status) && Objects.equals(location, state.location);
        }

        @Override
        public int hashCode() {
            int result = location.hashCode();
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    result += (status[i][j] * SIZE * SIZE);
                }
            }
            return result;
        }
    }

    private static final Integer SIZE = 3;

    private static Set<State> visited = new HashSet<>();

    private static Set<Integer> hashSet = new HashSet<>();

    private static List<State> trace = new ArrayList<>();

    /**
     * 最终要达到的状态
     */
    private static Integer[][] finalStatus = new Integer[SIZE][SIZE];

    public static void main(String[] args) {
        Integer[][] initStatus = {
                {3, 2, 4},
                {5, 8, 6},
                {1, 7, 0}
        };

        Integer[][] finalStatus = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        List<State> result = dfs(initStatus, finalStatus);
        System.out.println("result: " + result.size());
    }

    private static List<State> dfs(Integer[][] initStatus, Integer[][] finalStatus) {
        DfsMain.finalStatus = finalStatus;
        State state = null;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (initStatus[i][j].equals(0)) {
                    state = new State(initStatus, new Location(i, j));
                }
            }
        }
        recursion(state);
        return trace;
    }

    private static boolean recursion(State state) {
        visited.add(state);
        hashSet.add(state.hashCode());
        trace.add(state);
        if (check(state.status)) {
            return true;
        }
        System.out.println("recursion: " + trace.size());
        for (int i = 0; i < SIZE; i++) {
            System.out.println("recursion: " + Arrays.toString(state.status[i]));
        }

        for (Location toLocation : adj(state)) {
            State adjState = move(state, toLocation);
            if (!visited(adjState)) {
                if (recursion(adjState)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取临界点
     *
     * @param state state
     * @return 临界点列表
     */
    private static List<Location> adj(State state) {
        return Stream.of(
                new Location(state.location.x - 1, state.location.y),
                new Location(state.location.x + 1, state.location.y),
                new Location(state.location.x, state.location.y - 1),
                new Location(state.location.x, state.location.y + 1)
        )
                .filter(loc -> loc.x < SIZE && loc.x > -1 && loc.y < SIZE && loc.y > -1)
                .collect(Collectors.toList());
    }

    private static State move(State from, Location to) {
        int temp = from.status[from.location.x][from.location.y];
        Integer[][] status = new Integer[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            status[i] = Arrays.copyOf(from.status[i], SIZE);
        }
        status[from.location.x][from.location.y] = status[to.x][to.y];
        status[to.x][to.y] = temp;
        return new State(status, to);
    }

    /**
     * 根据需求定制的 检查是否达到目标需求的逻辑
     *
     * @param status status
     * @return boolean
     */
    private static boolean check(Integer[][] status) {
        return arrayEqual(status, finalStatus);
    }

    private static boolean arrayEqual(Integer[][] array1, Integer[][] array2) {
        if (array1 == null && array2 == null) {
            return true;
        } else if (array1 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].length != array2[i].length) {
                return false;
            }
            for (int j = 0; j < array1[i].length; j++) {
                if (!array1[i][j].equals(array2[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断节点是否被遍历过
     *
     * @param state state
     * @return boolean
     */
    private static boolean visited(State state) {
        for (State state1 : visited) {
            if (state.equals(state1)) {
                return true;
            }
        }
        return false;
    }
}
