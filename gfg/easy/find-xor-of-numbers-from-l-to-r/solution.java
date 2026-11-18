
class Solution {
    int xorUpto(int n) {
        if (n < 0) {
            return 0;
        }

        switch (n % 4) {
            case 0:
                return n;
            case 1:
                return 1;
            case 2:
                return n + 1;
            default:
                return 0;
        }
    }

    public int findXOR(int l, int r) {
        return xorUpto(r) ^ xorUpto(l - 1);
    }
}
