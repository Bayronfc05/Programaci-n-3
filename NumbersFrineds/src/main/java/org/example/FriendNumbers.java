package org.example;
import java.util.HashMap;
import java.util.Map;

class FriendNumbers {
    private int less;
    private int high;
    private Map<Integer, Integer> friends;

    public FriendNumbers(int less, int high) {
        this.less = less;
        this.high = high;
        this.friends = new HashMap<>();
    }

    public int getLess() {
        return less;
    }

    public int getHigh() {
        return high;
    }

    public void addFriend(int number, int friend) {
        friends.put(number, friend);
    }

    public synchronized Map<Integer, Integer> getFriends() {
        return friends;
    }

    public int sumDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
