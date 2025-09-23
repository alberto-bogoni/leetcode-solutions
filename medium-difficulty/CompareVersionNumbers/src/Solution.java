public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int i1 = 0;
        int i2 = 0;
        while (i1 < split1.length || i2 < split2.length) {
            int v1 = 0;
            if (i1 < split1.length) {
                v1 = Integer.valueOf(split1[i1++]);
            }
            int v2 = 0;
            if (i2 < split2.length) {
                v2 = Integer.valueOf(split2[i2++]);
            }

            if (v1 < v2) return -1;
            else if (v1 > v2) return 1;
        }

        return 0;
    }
}