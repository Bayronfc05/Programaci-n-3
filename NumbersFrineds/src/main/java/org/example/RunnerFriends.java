package org.example;

class RunnerFriends implements Runnable {
    private FriendNumbers friendNumbers;
    private int start;
    private int end;

    public RunnerFriends(FriendNumbers friendNumbers, int start, int end) {
        this.friendNumbers = friendNumbers;
        this.start = start;
        this.end = end;
    }

    public FriendNumbers getFriendNumbers() {
        return friendNumbers;
    }

    @Override
    public void run() {
        for (int number = start; number <= end; number++) {
            int sum1 = friendNumbers.sumDivisors(number);
            if (sum1 > number && sum1 <= friendNumbers.getHigh()) {
                int sum2 = friendNumbers.sumDivisors(sum1);
                if (sum2 == number) {
                    friendNumbers.addFriend(number, sum1);
                }
            }
        }
    }
}

